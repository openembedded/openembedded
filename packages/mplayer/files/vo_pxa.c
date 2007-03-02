/*
 * Video driver for PXA 27x Overlay 2, in conjunction with kernel driver
 * by Tim Chick <tim (DOT) chick (AT) csr (DOT) com>
 * (C) 2007
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: FBIOGET_VSCREENINFO line %d failed\n", __LINE__ );
        
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
    
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: config() was called\n");
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: src_width:%d, src_height:%d, dst_width:%d, dst_height:%d\n",
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
            mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: Set of base fb failed\n");
            priv->vm = 0;
            goto err_out;
        }
    }
 
    /* We need these sleeps, to make the change in resolution actually happen, before we open the overlay */
    sleep(2);
   
    /* Open up the overlay fbdev */
    priv->fd = open( "/dev/fb2", O_RDWR );

    if( priv->fd < 0 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: Could not open framebuffer device\n");
        goto err_out;
    }
    
    /* Read in fb var data */
    rc = ioctl( priv->fd, FBIOGET_VSCREENINFO, &(priv->my_fb_var) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: FBIOGET_VSCREENINFO line %d failed\n", __LINE__ );
        goto err_out;
    }
    
    /* Set up the buffer */
    priv->my_fb_var.xres = src_width;
    priv->my_fb_var.yres = src_height;
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
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: FBIOPUT_VSCREENINFO line %d failed\n", __LINE__ );
        goto err_out;
    }
        
    /* Next get the fixed fbvars, so we can mmap the data for all 3 planes */
    rc = ioctl( priv->fd, FBIOGET_FSCREENINFO, &(priv->my_fb_fix) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: FBIOGET_FSCREENINFO line %d failed\n", __LINE__ );
        goto err_out;
    }
    
    priv->fb_mem_base = mmap( NULL, priv->my_fb_fix.smem_len, (PROT_READ | PROT_WRITE ),
                        MAP_SHARED,
                        priv->fd,
                        0 );

    if( priv->fb_mem_base == MAP_FAILED )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: mmap buffer failed\n" );
        goto err_out;
    }

    /* Finally, find the offsets of each plane by getting the var data again */
    rc = ioctl( priv->fd, FBIOGET_VSCREENINFO, &(priv->my_fb_var) );
    
    if( rc == -1 )
    {
        mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: FBIOGET_VSCREENINFO line %d failed\n", __LINE__ );
        goto err_out;
    }
    
    /* We are good to go! */
    mp_msg( MSGT_VO, MSGL_V, "vo_pxa: FOpened screen %d x %d fourcc %s\n",
            priv->my_fb_var.xres,
            priv->my_fb_var.yres,
            vo_format_name(format) );
    
    return 0;
    
    err_out:
    
    if( priv->fb_mem_base != MAP_FAILED )
    {
        munmap( priv->fb_mem_base, priv->my_fb_fix.smem_len );
        priv->fb_mem_base = MAP_FAILED;
    }
            
    if( priv->fd >= 0 )
    {
        close( priv->fd );
        priv->fd = -1;
    }
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
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: dummy draw_frame() was called\n");
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
    uint8_t *my_src;
    uint8_t *dest;
    size_t length;
    int i;
    
    /* This routine is only display routine actually implimented */
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: draw_slice() was called\n");
    
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
    
    return 0;
}

static void draw_osd(void)
{
    mp_msg(MSGT_VO, MSGL_V, "vo_pxa: draw_osd() was called\n");
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

    if( priv->fb_mem_base != MAP_FAILED )
    {
        munmap( priv->fb_mem_base, priv->my_fb_fix.smem_len );
        priv->fb_mem_base = MAP_FAILED;
    }
            
    if( priv->fd >= 0 )
    {
        close( priv->fd );
        priv->fd = -1;
    }

    /* We need these sleeps, to make the change in resolution actually happen */
    sleep(1);
 
    if( priv->vm )
    {
        /* Restore original resolution */
        if( priv->base_fd >= 0 )
        {
            mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: Try to restore original video mode\n", __LINE__ );

            rc = ioctl( priv->base_fd, FBIOPUT_VSCREENINFO, &(priv->base_orig_fb_var) );
    
            if( rc == -1 )
            {
                mp_msg( MSGT_VO, MSGL_ERR, "vo_pxa: FBIOPUT_VSCREENINFO line %d failed\n", __LINE__ );
            }
        }
        
    }
    
    /* We need these sleeps, to make the change in resolution actually happen */
    /* For some reason, if we change the reolution the overlay buffer never gets deleted? */
    sleep(1);

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

    if( IMGFMT_IS_RGB(format) )
    {
	/* RGB/BGR Formats not supported yet */
	return 0;
    } 
    else 
    {
	/* Planar YUV Formats */
	switch (format) {
            /* Warning! dropthrough */
            case IMGFMT_YV12:
            case IMGFMT_IYUV:
            case IMGFMT_I420:
                return( VFCAP_CSP_SUPPORTED | VFCAP_CSP_SUPPORTED_BY_HW
                        | VFCAP_HWSCALE_UP | VFCAP_HWSCALE_DOWN | VFCAP_OSD
                        | VFCAP_ACCEPT_STRIDE );
                break;
	}
    }

    return 0;
}
