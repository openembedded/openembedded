/*
 * Video driver for PXA 27x Overlay 2, in conjunction with kernel driver
 * by Tim Chick <tim (DOT) chick (AT) csr (DOT) com>
 * (C) 2007
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

#include "config.h"
#include "video_out.h"
#include "video_out_internal.h"
#include "sub.h"
#include "aspect.h"
#include "mp_msg.h"
#include "subopt-helper.h"

#include "vo_pxa.h"

static vo_info_t info = {
	"PXA 27x Framebuffer",
	"pxa",
	"Tim Chick <tim (DOT) chick (AT) csr (DOT) com>",
	"For Sharp Zaurus SL-C1000 etc"
};

LIBVO_EXTERN(pxa);

static pxa_priv_t st_pxa_priv;

/*****************************************************************************
 * preinit
 *
 * Preinitializes driver
 *   arg - currently it's vo_subdevice
 *   returns: zero on successful initialization, non-zero on error.
 *
 ****************************************************************************/
static int preinit(const char *vo_subdevice)
{
    pxa_priv_t *priv = &st_pxa_priv;
    int rc;
    
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: preinit() was called\n");

    /* fill pxa_priv_t information */
    memset(priv, 0, sizeof(*priv));
    priv->fd = -1;
    
    /* We need to open the base framebuffer device, to change and restore modes */
    priv->base_fd = open( "/dev/fb0", O_RDWR );
    
    if( priv->base_fd < 0 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: Could not open base framebuffer device\n");
        return -1;
    }
    
    /* Get the base fb var data, so we can restore if we change video modes */
    rc = ioctl( priv->base_fd, FBIOGET_VSCREENINFO, &(priv->base_orig_fb_var) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: FBIOGET_VSCREENINFO preinit base_fd failed %d\n",
                errno );
        
        /* If this failed, close down the FD so we don't try to set this again */
        close( priv->base_fd );
        priv->base_fd = -1;
        
        return -1;
    }
    
    return 0;
}


/*****************************************************************************
 * config
 *
 * Config the display driver.
 * params:
 *   src_width,srcheight: image source size
 *   dst_width,dst_height: size of the requested window size, just a hint
 *   fullscreen: flag, 0=windowd 1=fullscreen, just a hint
 *   title: window title, if available
 *   format: fourcc of pixel format
 * returns : zero on successful initialization, non-zero on error.
 *
 ****************************************************************************/
static int config(uint32_t src_width, uint32_t src_height,
                  uint32_t dst_width, uint32_t dst_height, uint32_t flags,
                  char *title, uint32_t format)
{
    pxa_priv_t *priv = &st_pxa_priv;
    int rc;
    int i;
    
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: config() src_width:%d, src_height:%d, dst_width:%d, dst_height:%d\n",
	   src_width, src_height, dst_width, dst_height);

    /* Check format */
    if( !vo_pxa_query_format(format) )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: unsupported fourcc for this driver: %x (%s)\n",
                format, vo_format_name(format) );
        goto err_out;
    }
    priv->format = format;
    
    /* Change resolution? */
    priv->vm = flags & VOFLAG_MODESWITCHING;
    if( priv->vm )
    {
        priv->my_fb_var = priv->base_orig_fb_var;
        
        /* Hard coded values suck, never mind */
        priv->my_fb_var.xres = 240;
        priv->my_fb_var.yres = 320;
        priv->my_fb_var.pixclock = 134617;
        priv->my_fb_var.left_margin = 20;
        priv->my_fb_var.right_margin = 46;
        priv->my_fb_var.upper_margin = 1;
        priv->my_fb_var.lower_margin = 0;
        priv->my_fb_var.hsync_len = 20;
        priv->my_fb_var.vsync_len = 2;
    
        rc = ioctl( priv->base_fd, FBIOPUT_VSCREENINFO, &(priv->my_fb_var) );
        
        if( rc == -1 )
        {
            mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: config() Set FBIOPUT_VSCREENINFO on base_fd failed %d\n",
                    errno );
            priv->vm = 0;
            goto err_out;
        }
        
        /* We need this sleep, to make the change in resolution actually happen, before we open the overlay */
        sleep(1);
    }
 
   
    /* Open up the overlay fbdev */
    priv->fd = open( "/dev/fb2", O_RDWR );

    if( priv->fd < 0 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: Could not open /dev/fb2: %d\n", errno );
        goto err_out;
    }
    
    /* Read in fb var data */
    rc = ioctl( priv->fd, FBIOGET_VSCREENINFO, &(priv->my_fb_var) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: config() FBIOGET_VSCREENINFO from fd failed %d\n",
                errno );
        goto err_out;
    }
    
    /* Store away the source dimensions, so we can place in centre of screen later in vm mode */
    priv->src_width = src_width;
    priv->src_height = src_height;
    
    /* Set up the buffer */
    if( priv->vm )
    {
        /* Ignore size, as the rest of the screen is toast. Use max size */
        priv->my_fb_var.xres = 240;
        priv->my_fb_var.yres = 320;

        /* Do we need to rotate? */
        if( priv->src_width > priv->src_height )
        {
            /* Yes */
            priv->rotate = 1;
        }

        priv->width  = 240;
        priv->height = 320;
    }
    else
    {
        priv->my_fb_var.xres = src_width;
        priv->my_fb_var.yres = src_height;
        priv->width = src_width;
        priv->height = src_height;
    }
    
    priv->my_fb_var.nonstd = ( 4 << 20)  /* Format YV12 */
                           | ( 0 <<  0)  /* x position */
                           | ( 0 << 10); /* y position */ 
    /* We have to set the bits per pixel to a valid value, even though it is
     * incorrect for YV12
     */
    priv->my_fb_var.bits_per_pixel = 16;
    
    rc = ioctl( priv->fd, FBIOPUT_VSCREENINFO, &(priv->my_fb_var) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: config() FBIOPUT_VSCREENINFO to fd failed: %d\n",
                errno );
        goto err_out;
    }
        
    /* Next get the fixed fbvars, so we can mmap the data for all 3 planes */
    rc = ioctl( priv->fd, FBIOGET_FSCREENINFO, &(priv->my_fb_fix) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: config() FBIOGET_FSCREENINFO from fd failed: %d\n", 
                errno );
        goto err_out;
    }
    
    priv->fb_mem_base = mmap( NULL, priv->my_fb_fix.smem_len, (PROT_READ | PROT_WRITE ),
                        MAP_SHARED,
                        priv->fd,
                        0 );

    if( priv->fb_mem_base == MAP_FAILED )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: mmap fd buffer failed: %d\n", errno );
        goto err_out;
    }

    /* Finally, find the offsets of each plane by getting the var data again */
    rc = ioctl( priv->fd, FBIOGET_VSCREENINFO, &(priv->my_fb_var) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: config() FBIOGET_VSCREENINFO from fd (2) failed %d\n", 
                errno );
        goto err_out;
    }
    
    /* Fill the overlay with black */
    memset( priv->fb_mem_base + priv->my_fb_var.red.offset, 16, priv->my_fb_var.red.length );
    memset( priv->fb_mem_base + priv->my_fb_var.green.offset, 128, priv->my_fb_var.green.length );
    memset( priv->fb_mem_base + priv->my_fb_var.blue.offset, 128, priv->my_fb_var.blue.length );
    
    /* Now open the OSD overlay - overlay 1, and fill with transparent */
    sleep( 1 );
    
    priv->overlay_fd = open( "/dev/fb1", O_RDWR );

    if( priv->overlay_fd < 0 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: Could not open /dev/fb1: %d\n", errno );
        goto err_out;
    }
    
    /* Read in fb var data */
    rc = ioctl( priv->overlay_fd, FBIOGET_VSCREENINFO, &(priv->osd_fb_var) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: config() FBIOGET_VSCREENINFO from overlay_fd failed; %d\n",
                errno );
        goto err_out;
    }

    priv->osd_fb_var.xres = priv->width;
    priv->osd_fb_var.yres = priv->height;
    priv->osd_fb_var.nonstd = ( 0 <<  0)  /* x position */
                            | ( 0 << 10); /* y position */
    /* Use 15 bit mode, with top bit transparency */
    priv->osd_fb_var.bits_per_pixel = 16;
    
    rc = ioctl( priv->overlay_fd, FBIOPUT_VSCREENINFO, &(priv->osd_fb_var) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: config() FBIOPUT_VSCREENINFO to overlay_fd failed: %d\n",
                errno );
        goto err_out;
    }
        
    /* Next get the fixed fbvars, so we can mmap the data */
    rc = ioctl( priv->overlay_fd, FBIOGET_FSCREENINFO, &(priv->osd_fb_fix) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: config() FBIOGET_FSCREENINFO from overlay_fd failed %d\n",
                errno );
        goto err_out;
    }
    
    priv->osd_mem_base = mmap( NULL, priv->osd_fb_fix.smem_len, (PROT_READ | PROT_WRITE ),
                               MAP_SHARED,
                               priv->overlay_fd,
                               0 );

    if( priv->osd_mem_base == MAP_FAILED )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: mmap osd_mem_base failed: %d\n", errno );
        goto err_out;
    }
    
    /* Fill the overlay with transparent */
    vo_pxa_clear_osd( priv->osd_mem_base, priv->osd_fb_fix.smem_len );

    /* We are good to go! */
    mp_msg( MSGT_VO, MSGL_V, "vo_pxa: Opened video overlay %d x %d fourcc %s\n",
            priv->my_fb_var.xres,
            priv->my_fb_var.yres,
            vo_format_name(format) );
    
    return 0;
    
    err_out:

    /* Don't do anything here for the moment */
    return -1;
}


/*****************************************************************************
 *
 * control
 *
 * Control display
 *
 ****************************************************************************/
static int control(uint32_t request, void *data, ...)
{
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: control %08x\n", request );
    
    switch( request )
    {
        case VOCTRL_QUERY_FORMAT:
            return( vo_pxa_query_format( *(uint32_t *)data ) );
            break;
    }
    
    return VO_NOTIMPL;
}


/*****************************************************************************
 *
 * draw_frame
 *
 * Display a new RGB/BGR frame of the video to the screen.
 * params:
 *   src[0] - pointer to the image
 *
 ****************************************************************************/
int draw_frame(uint8_t *src[])
{
    /* This is not implimented */
    mp_msg(MSGT_VO, MSGL_ERR, "vo_pxa: dummy draw_frame() was called\n");
    return -1;
}


/*****************************************************************************
 *
 * draw_slice
 *
 * Draw a planar YUV slice to the buffer:
 * params:
 *   src[3] = source image planes (Y,U,V)
 *   stride[3] = source image planes line widths (in bytes)
 *   w,h = width*height of area to be copied (in Y pixels)
 *   x,y = position at the destination image (in Y pixels)
 *
 ****************************************************************************/
int draw_slice(uint8_t *src[], int stride[], int w,int h, int x,int y)
{
    pxa_priv_t *priv = &st_pxa_priv;
    
    /* This routine is only display routine actually implimented */
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: draw_slice() w %d h %d x %d y %d stride %d %d %d\n",
           w, h, x, y, stride[0], stride[1], stride[2] );
    
    /* It would be faster to check if source and dest have same geometry and copy
     * whole block
     * For the moment we just copy a line at a time
     */

    /* In vm mode rotate if wider than long */
    if( priv->vm )
    {
        /* Do we nee to rotate? */
        if( priv->rotate )
        {
            /* Yes, rotated version */
            int dst_x_offset = 0;
            int dst_y_offset = 0;
            int src_x_offset = 0;
            int src_y_offset = 0;
        
            /* Figure out  dst offset */
            if( priv->src_width < 320 )
            {
                dst_x_offset = ( ( 320 -  priv->src_width ) / 2 );
                /* Make it a multiple of 16 */
                dst_x_offset &= ~(0xf);
            }
        
            if( priv->src_height < 240 )
            {
                dst_y_offset = ( ( 240 -  priv->src_height ) / 2 );
                /* Make it a multiple of 16 */
                dst_y_offset &= ~(0xf);
            }
        
            dst_x_offset += x;
            dst_y_offset += y;
        
            if( ( dst_x_offset >= 320 ) || ( dst_y_offset >= 240 ) )
            {
                /* Nothing to do - drawing off the screen! */
                return( 0 );
            }
        
            /* Limit to drawable area */
            if( ( w + dst_x_offset ) > 320 )
            {
                w = ( 320 - dst_x_offset );
            }
        
            if( ( h + dst_y_offset ) > 240 )
            {
                h = ( 240 - dst_y_offset );
            }
            
            /* And source offset */
            if( priv->src_width > 320 )
            {
                src_x_offset = ( ( priv->src_width - 320 ) / 2 );
                /* Make it a multiple of 16 */
                src_x_offset &= ~(0xf);
            }
        
            if( priv->src_height > 240 )
            {
                src_y_offset = ( ( priv->src_height - 240 ) / 2 );
                /* Make it a multiple of 16 */
                src_y_offset &= ~(0xf);
            }
            
        
            /* Y first */
            vo_pxa_copy_and_rotate( src[0] + src_x_offset + (src_y_offset * stride[0]), stride[0],
                                    priv->fb_mem_base + priv->my_fb_var.red.offset  + (240 * dst_x_offset) + (240 - dst_y_offset - h),
                                    w, h, 240 );
            /* Now U */
            vo_pxa_copy_and_rotate( src[1] + src_x_offset/2 + (src_y_offset/2 * stride[1]), stride[1],
                                    priv->fb_mem_base + priv->my_fb_var.green.offset + (120 * dst_x_offset/2) + (120 - dst_y_offset/2 - h/2),
                                    w/2, h/2, 120 );
            vo_pxa_copy_and_rotate( src[2] + src_x_offset/2 + (src_y_offset/2 * stride[2]), stride[2],
                                    priv->fb_mem_base + priv->my_fb_var.blue.offset + (120 * dst_x_offset/2) + (120 - dst_y_offset/2 - h/2),
                                    w/2, h/2, 120 );
        }
        else
        {
            /* Don't rotate */
            int i;
            uint8_t *my_src;
            uint8_t *dest;
            int dst_x_offset = 0;
            int dst_y_offset = 0;
            int src_x_offset = 0;
            int src_y_offset = 0;
        
            /* Figure out  dst offset */
            if( priv->src_width < 240 )
            {
                dst_x_offset = ( ( 240 -  priv->src_width ) / 2 );
                /* Make it a multiple of 16 */
                dst_x_offset &= ~(0xf);
            }
        
            if( priv->src_height < 320 )
            {
                dst_y_offset = ( ( 320 -  priv->src_height ) / 2 );
                /* Make it a multiple of 16 */
                dst_y_offset &= ~(0xf);
            }
        
            dst_x_offset += x;
            dst_y_offset += y;
        
            if( ( dst_x_offset >= 240 ) || ( dst_y_offset >= 320 ) )
            {
                /* Nothing to do - drawing off the screen! */
                return( 0 );
            }
        
            /* Limit to drawable area */
            if( ( w + dst_x_offset ) > 240 )
            {
                w = ( 240 - dst_x_offset );
            }
        
            if( ( h + dst_y_offset ) > 320 )
            {
                h = ( 320 - dst_y_offset );
            }

            /* And source offset */
            if( priv->src_width > 240 )
            {
                src_x_offset = ( ( priv->src_width - 240 ) / 2 );
                /* Make it a multiple of 16 */
                src_x_offset &= ~(0xf);
            }
        
            if( priv->src_height > 320 )
            {
                src_y_offset = ( ( priv->src_height - 320 ) / 2 );
                /* Make it a multiple of 16 */
                src_y_offset &= ~(0xf);
            }
            
            /* First Y */
            for( i = 0; i<h; i++ )
            {
                dest = priv->fb_mem_base + 
                    priv->my_fb_var.red.offset + 
                    ( (dst_y_offset+i) * priv->my_fb_fix.line_length ) +
                    dst_x_offset;
                my_src = src[0] + src_x_offset + (stride[0] * (i+src_y_offset));
                memcpy( dest, my_src, w );
            }

            /* Now U */
            for( i = 0; i<(h/2); i++ )
            {
                dest = priv->fb_mem_base + 
                    priv->my_fb_var.green.offset + 
                    ( ((dst_y_offset/2)+i) * (priv->my_fb_fix.line_length/2) ) +
                    dst_x_offset/2;
                my_src = src[1] + src_x_offset/2 + (stride[1] * (i+(src_y_offset/2)));
                memcpy( dest, my_src, w/2 );
            }
    
            /* Finaly V */
            for( i = 0; i<(h/2); i++ )
            {
                dest = priv->fb_mem_base + 
                    priv->my_fb_var.blue.offset + 
                    ( ((dst_y_offset/2)+i) * (priv->my_fb_fix.line_length/2) ) +
                    dst_x_offset/2;
                my_src = src[2] + src_x_offset/2 + (stride[2] * (i+(src_y_offset/2)));
                memcpy( dest, my_src, w/2 );
            }
            
        }
    }
    else
    {
        /* Not full screen mode */
        uint8_t *my_src;
        uint8_t *dest;
        size_t length;
        int i;
        
        /* It would be faster to check if source and dest have same geometry and copy
         * whole block
         * For the moment we just copy a line at a time
         */

        /* Limit area written to */
        if( x >= priv->my_fb_fix.line_length )
        {
            return 0;
        }
    
        if( w + x > priv->my_fb_fix.line_length )
        {
            w = priv->my_fb_fix.line_length - x;
        }
    
        if( y>= priv->my_fb_var.yres )
        {
            return 0;
        }
    
        if( h + y > priv->my_fb_var.yres )
        {
            h = priv->my_fb_var.yres - y;
        }
    
        /* First Y */
        for( i = 0; i<h; i++ )
        {
            dest = priv->fb_mem_base + 
                priv->my_fb_var.red.offset + 
                ( (y+i) * priv->my_fb_fix.line_length ) +
                x;
            my_src = src[0] + stride[0] * i;
            memcpy( dest, my_src, w );
        }

        /* Now U */
        for( i = 0; i<(h/2); i++ )
        {
            dest = priv->fb_mem_base + 
                priv->my_fb_var.green.offset + 
                ( ((y/2)+i) * (priv->my_fb_fix.line_length/2) ) +
                x;
            my_src = src[1] + stride[1] * i;
            memcpy( dest, my_src, w/2 );
        }
    
        /* Finaly V */
        for( i = 0; i<(h/2); i++ )
        {
            dest = priv->fb_mem_base + 
                priv->my_fb_var.blue.offset + 
                ( ((y/2)+i) * (priv->my_fb_fix.line_length/2) ) +
                x;
            my_src = src[2] + stride[2] * i;
            memcpy( dest, my_src, w/2 );
        }
    }
    return 0;
}

static void draw_osd(void)
{
    pxa_priv_t *priv = &st_pxa_priv;
    int osd_has_changed;

    /* This gets called every frame, so systems which do the OSD without a
     * seperate overlay can mix in the image. We need to find out if the osd
     * has actually been updated!
     */
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: draw_osd() was called\n");
    
    osd_has_changed = vo_update_osd( priv->width, priv->height);

    if(osd_has_changed)
    {
        int i;
        
        mp_msg(MSGT_VO, MSGL_V, "vo_pxa: Clear and update OSD\n");
        
        /* Fill with transparent */
        vo_pxa_clear_osd( priv->osd_mem_base, priv->osd_fb_fix.smem_len );
        
        priv->osd_cleared = 1;
        
        /* now update */
        if( priv->rotate )
        {
            vo_draw_text( priv->width, priv->height, vo_pxa_draw_alpha_with_rotate );
        }
        else
        {
            vo_draw_text( priv->width, priv->height, vo_pxa_draw_alpha );
        }
    }
}

/*****************************************************************************
 *
 * flip_page
 *
 * Blit/Flip buffer to the screen. Must be called after each frame!
 *
 *
 ****************************************************************************/
static void flip_page(void)
{
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: flip_page() was called\n");
}

/*****************************************************************************
 *
 * check_events
 *
 *
 ****************************************************************************/
static void check_events(void)
{
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: check_events() was called\n");
}

/*****************************************************************************
 *
 * uninit
 *
 *
 ****************************************************************************/
static void uninit(void)
{
    pxa_priv_t *priv = &st_pxa_priv;
    int rc;

    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: uninit() was called\n");
    
    if( priv->vm )
    {
        /* We need these sleeps, to make the change in resolution actually happen */
        sleep(1);

        /* Restore original resolution */
        if( priv->base_fd >= 0 )
        {
            rc = ioctl( priv->base_fd, FBIOPUT_VSCREENINFO, &(priv->base_orig_fb_var) );
    
            if( rc == -1 )
            {
                mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: uninit() FBIOPUT_VSCREENINFO to base_fd failed %d\n",
                        errno );
            }
        }
        /* We need these sleeps, to make the change in resolution actually happen */
        /* For some reason, if we change the reolution the overlay buffer never gets deleted? */
        sleep(1);
    }
    

    /* We need to force the overlays to be really disabled, otherwise they
     * will come back as zombies after suspend, resume
     * This trick seems to work, but will not be needed once kernel driver
     * is fixed
     */
    if( priv->fd >= 0 )
    {
        rc = ioctl( priv->fd, FBIOGET_VSCREENINFO, &(priv->my_fb_var) );

        if( rc == -1 )
        {
            mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: uninit() FBIOGET_VSCREENINFO from fd failed %d\n",
                    errno );
        }
	priv->my_fb_var.bits_per_pixel = 0;

        rc = ioctl( priv->fd, FBIOPUT_VSCREENINFO, &(priv->my_fb_var) );

        if( rc == -1 )
        {
            mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: uninit() FBIOPUT_VSCREENINFO from fd failed %d\n",
                    errno );
        }
    }

    if( priv->overlay_fd >= 0 )
    {
        rc = ioctl( priv->overlay_fd, FBIOGET_VSCREENINFO, &(priv->my_fb_var) );

        if( rc == -1 )
        {
            mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: uninit() FBIOGET_VSCREENINFO from overlay_fd failed %d\n",
                    errno );
        }
        priv->my_fb_var.bits_per_pixel = 0;

        rc = ioctl( priv->overlay_fd, FBIOPUT_VSCREENINFO, &(priv->my_fb_var) );

        if( rc == -1 )
        {
            mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: uninit() FBIOPUT_VSCREENINFO from overlay_fd failed %d\n",
                    errno );
        }
    }

    if( priv->base_fd >= 0 )
    {
        close( priv->base_fd );
        priv->base_fd = -1;
    }
}

/*****************************************************************************
 *
 * Internal functions, not part of mplayer API
 *
 ****************************************************************************/

static int vo_pxa_query_format( uint32_t format )
{
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: vo_pxa_query_format was called: %x (%s)\n",
	   format, vo_format_name(format));

    switch (format)
    {
        /* Planar YUV Formats */
        /* Warning! dropthrough */
        case IMGFMT_YV12:
        case IMGFMT_IYUV:
        case IMGFMT_I420:
            return( VFCAP_CSP_SUPPORTED | VFCAP_CSP_SUPPORTED_BY_HW
                    | VFCAP_HWSCALE_UP | VFCAP_HWSCALE_DOWN | VFCAP_OSD
                    | VFCAP_ACCEPT_STRIDE );
            break;
    }
        
    return 0;
}

static void vo_pxa_copy_and_rotate( uint8_t *src, int stride, uint8_t *dst, int w, int h, int dst_stride )
{
    int i,j;
    uint8_t *my_src, *my_dst;
    Vo_Pxa_Pixel_Data8 *img_dst_pixel_data8;                       
        
    /* Loop so writing consectuive data in rotated image */
    /* This produces some pretty good assembler - better than the handcoded stuff in w100 */
    for( j=0; j<w; j++ )
    {
        my_src = src + j + ( stride * (h - 1) );

        img_dst_pixel_data8 = (Vo_Pxa_Pixel_Data8 *)dst;
        
        /* Allow for src not multiple of 8 by running off the end a little. Should not matter */
        for( i=0; i<((h+7)/8); i++ )
        {
            register Vo_Pxa_Pixel_Data8 build_pixels;
                
            build_pixels.a = *my_src;
            my_src -= stride;
            build_pixels.a |= (*my_src<<8);
            my_src -= stride;
            build_pixels.a |= (*my_src<<16);
            my_src -= stride;
            build_pixels.a |= (*my_src<<24);
            my_src -= stride;

            build_pixels.b = *my_src;
            my_src -= stride;
            build_pixels.b |= (*my_src<<8);
            my_src -= stride;
            build_pixels.b |= (*my_src<<16);
            my_src -= stride;
            build_pixels.b |= (*my_src<<24);
            my_src -= stride;
                
            *img_dst_pixel_data8++ = build_pixels;
        }
        
        /* Allow source not as big as dest */
        dst += dst_stride;
    }   
}

static void vo_pxa_draw_alpha( int x, int y, int w, int h, unsigned char *src,
                               unsigned char *srca, int stride )
{
    /* Dump data into our 15bit buffer with transparency */
    pxa_priv_t *priv = &st_pxa_priv;
    int i,j;
    unsigned char *src_ptr = src;
    unsigned char *a_ptr = srca;
    unsigned short *out_ptr;
    
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: vo_pxa_draw_alpha() w %d y %d w %d h %d\n", x, y, w, h );
    
    /* We ignore the alpha channel, other than off or on */
    for( i=0; i<h; i++ )
    {
        out_ptr = priv->osd_mem_base + x + ( priv->width * ( y + i ) );
        src_ptr = src + ( i * stride );
        a_ptr = srca + ( i * stride );
            
        for( j=0; j<w; j++ )
        {
            /* The srca is a 0-255 transpaency level, where 0 is transparent.
             * We only support transparent on or off
             */
            if( *a_ptr++ )
            {
                unsigned int grey;
                /* The src is a greylevel from 0 - 255 */
                /* We may as well use this value */
                grey = *src_ptr++ >> 3;
                *out_ptr++ = grey | (grey << 5) | (grey<<10);                
            }
            else
            {                
                *out_ptr++ = 0x8000;
                src_ptr++;
            }
            
        }
    }
}

static void vo_pxa_draw_alpha_with_rotate( int x, int y, int w, int h, unsigned char *src,
                                           unsigned char *srca, int stride )
{
    /* Dump data into our 15bit buffer with transparency */
    pxa_priv_t *priv = &st_pxa_priv;
    int i,j;
    unsigned char *src_ptr = src;
    unsigned char *a_ptr = srca;
    unsigned short *out_ptr;
    
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: vo_pxa_draw_alpha_with_rotate() x %d y %d w %d h %d\n", x, y, w, h );
        
    if( x >= 320 )
    {
        /* Off the screen */
        return;
    }

    /* Limit to size of screen/memory */
    if( ( w + x ) > 320 )
    {
        w = 320 - x;
    }
    
    if( y >= 240 )
    {
        /* Off the screen */
        return;
    }
    
    /* Limit to size of screen/memory */
    if( ( y + h ) > 240 )
    {
        h = 240 - y;
    }
    
    
    /* We ignore the alpha channel, other than off or on */
    for( i=0; i<w; i++ )
    {
        out_ptr = priv->osd_mem_base + y + ( priv->width * ( x + i ) );
        src_ptr = src + i + ( stride * (h - 1));
        a_ptr = srca + i + ( stride * (h - 1));
            
        for( j=0; j<h; j++ )
        {
            /* The srca is a 0-255 transpaency level, where 0 is transparent.
             * We only support transparent on or off
             */
            if( *a_ptr )
            {
                unsigned int grey;
                /* The src is a greylevel from 0 - 255 */
                /* We may as well use this value */
                grey = *src_ptr >> 3;
                *out_ptr++ = grey | (grey << 5) | (grey<<10);                
            }
            else
            {                
                *out_ptr++ = 0x8000;
                src_ptr;
            }
            a_ptr -= stride;
            src_ptr -= stride;
        }
    }
}

static void vo_pxa_clear_osd( uint16_t *mem_base, int len )
{
    /* fill whole area with 0x8000 -> trsnaparent.
     * assume area is word aligned, and a mulitple of 16 bytes in length
     * However I tried I could not get the compiler to generate this.
     * It always wanted to  to do ldmia 4 words from stack followed by
     * stmia 4 words. This seems odd!
     */
    __asm__ __volatile__ (
        "mov        r4, %0         \n\t"
        "mov        r5, %1, lsr #4      \n\t"
        "subs       r5, r5, #1\n\t"
        "mov	r0, #0x80000000         \n\t"
        "orr	r0, r0, #0x00008000     \n\t"
        "mov	r1, r0                  \n\t"
        "mov	r2, r0                  \n\t"
        "mov	r3, r0                  \n\t"
        "1:					\n\t"
        "subs       r5, r5, #1\n\t"
        "stmia      r4!, {r0, r1, r2, r3} \n\t"
        "bne        1b \n\t"
        : 
        : "r"(mem_base), "r"(len)
        : "memory", "r0", "r1", "r2", "r3", "r4", "r5", "cc" );
}
