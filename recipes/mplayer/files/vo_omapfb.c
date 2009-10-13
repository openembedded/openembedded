/*
 
Copyright (C) 2008 Gregoire Gentil <gregoire@gentil.com>
Portions Copyright (C) 2009 Howard Chu <hyc@symas.com>
This file adds an optimized vo output to mplayer for the OMAP platform. This is a first pass and an attempt to help to improve
media playing on the OMAP platform. The usual disclaimer comes here: this code is provided without any warranty.
Many bugs and issues still exist. Feed-back is welcome.

This output uses the yuv420_to_yuv422 conversion from Mans Rullgard, and is heavily inspired from the work of Siarhei Siamashka.
I would like to thank those two persons here, without them this code would certainly not exist.

Two options of the output are available:
fb_overlay_only (disabled by default): only the overlay is drawn. X11 stuff is ignored.
dbl_buffer (disabled by default): add double buffering. Some tearsync flags are probably missing in the code.

Syntax is the following:
mplayer -ao alsa -vo omapfb /test.avi
mplayer -nosound -vo omapfb:fb_overlay_only:dbl_buffer /test.avi

You need to have two planes on your system. On beagleboard, it means something like: video=omapfb:vram:2M,vram:4M

Known issues:
1) A green line or some vertical lines (if mplayer decides to draw bands instead of frame) may appear.
It's an interpolation bug in the color conversion that needs to be fixed

2) The color conversion accepts only 16-pixel multiple for width and height.

3) The scaling down is disabled as the scaling down kernel patch for the OMAP3 platform doesn't seem to work yet.

 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
*/
 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>

#include <sys/mman.h>
#include <sys/ioctl.h>
#include <linux/fb.h>

#include "config.h"
#include "video_out.h"
#include "video_out_internal.h"
#include "fastmemcpy.h"
#include "sub.h"
#include "mp_msg.h"
#include "omapfb.h"
#include "x11_common.h"

#include "libswscale/swscale.h"
#include "libmpcodecs/vf_scale.h"
#include "libavcodec/avcodec.h"

#include "aspect.h"

#include "subopt-helper.h"

#include <X11/Xlib.h>
#include <X11/Xutil.h>
#include <X11/Xatom.h>
#include "wskeys.h"

static vo_info_t info = {
	"omapfb video driver",
	"omapfb",
	"",
	""
};

LIBVO_EXTERN(omapfb)

static int fb_overlay_only = 0; // if set, we need only framebuffer overlay, but do not need any x11 code
static int dbl_buffer = 0;
static int fullscreen_flag = 0;
static int plane_ready = 0;
static uint32_t drwX, drwY;

extern void yuv420_to_yuv422(uint8_t *yuv, uint8_t *y, uint8_t *u, uint8_t *v, int w, int h, int yw, int cw, int dw);
static struct fb_var_screeninfo sinfo_p0;
static struct fb_var_screeninfo sinfo;
static struct fb_var_screeninfo sinfo2;
static struct fb_fix_screeninfo finfo;
static struct omapfb_mem_info minfo;
static struct omapfb_plane_info pinfo;
static int xoff, yoff;

static struct {
    unsigned x;
    unsigned y;
    uint8_t *buf;
} fb_pages[2];
static int dev_fd = -1;
static int fb_page_flip = 0;
static int page = 0;
static void omapfb_update(int x, int y, int out_w, int out_h, int show);

extern void mplayer_put_key( int code );
#include "osdep/keycodes.h"

#define TRANSPARENT_COLOR_KEY 0xff0

static Display *display = NULL; // pointer to X Display structure.
static int screen_num; // number of screen to place the window on.
static Window win = 0;
static Window parent = 0; // pointer to the newly created window.

/* This is used to intercept window closing requests.  */
static Atom wm_delete_window;


void vo_calc_drwXY(uint32_t *drwX, uint32_t *drwY)
{
    *drwX = *drwY = 0;
    if (vo_fs) {
        aspect(&vo_dwidth, &vo_dheight, A_ZOOM);
        vo_dwidth  = FFMIN(vo_dwidth, vo_screenwidth);
        vo_dheight = FFMIN(vo_dheight, vo_screenheight);
        *drwX      = (vo_screenwidth - vo_dwidth) / 2;
        *drwY      = (vo_screenheight - vo_dheight) / 2;
        mp_msg(MSGT_VO, MSGL_V, "[vo-fs] dx: %d dy: %d dw: %d dh: %d\n",
               *drwX, *drwY, vo_dwidth, vo_dheight);
    } else if (WinID == 0) {
        *drwX = vo_dx;
        *drwY = vo_dy;
    }
}

static void getPrimaryPlaneInfo()
{
    int dev_fd = open("/dev/fb0", O_RDWR);

    if (dev_fd == -1) {
        mp_msg(MSGT_VO, MSGL_FATAL, "[omapfb] Error /dev/fb0\n");
        return -1;
    }

    ioctl(dev_fd, FBIOGET_VSCREENINFO, &sinfo_p0);
    close(dev_fd);
}

/**
 * Function to get the offset to be used when in windowed mode
 * or when using -wid option
 */
static void x11_get_window_abs_position(Display *display, Window window,
                                             int *wx, int *wy, int *ww, int *wh)
{
    Window root, parent;
    Window *child;
    unsigned int n_children;
    XWindowAttributes attribs;

    /* Get window attributes */
    XGetWindowAttributes(display, window, &attribs);

    /* Get relative position of given window */
    *wx = attribs.x;
    *wy = attribs.y;
    if (ww)
        *ww = attribs.width;
    if (wh)
        *wh = attribs.height;

    /* Query window tree information */
    XQueryTree(display, window, &root, &parent, &child, &n_children);
    if (parent)
    {
      int x, y;
      /* If we have a parent we must go there and discover his position*/
      x11_get_window_abs_position(display, parent, &x, &y, NULL, NULL);
      *wx += x;
      *wy += y;
    }

    /* If we had children, free it */
    if(n_children)
        XFree(child);
}

static void x11_check_events(void)
{
    int e = vo_x11_check_events(mDisplay);

    if (e & VO_EVENT_RESIZE)
        vo_calc_drwXY(&drwX, &drwY);

    if (e & VO_EVENT_EXPOSE || e & VO_EVENT_RESIZE)
    {
        vo_xv_draw_colorkey(drwX, drwY, vo_dwidth - 1, vo_dheight - 1);
        omapfb_update(0, 0, 0, 0, 1);
    }
}

static void x11_uninit()
{
    if (display) {
        XCloseDisplay(display);
        display = NULL;
    }
}

/**
 * Initialize framebuffer
 */
static int preinit(const char *arg)
{
    opt_t subopts[] = {
        {"fb_overlay_only", OPT_ARG_BOOL, &fb_overlay_only, NULL},
        {"dbl_buffer", OPT_ARG_BOOL, &dbl_buffer, NULL},
        {NULL}
    };

    if (subopt_parse(arg, subopts) != 0) {
        mp_msg(MSGT_VO, MSGL_FATAL, "[omapfb] unknown suboptions: %s\n", arg);
        return -1;
    }

    getPrimaryPlaneInfo();
    dev_fd = open("/dev/fb1", O_RDWR);

    if (dev_fd == -1) {
        mp_msg(MSGT_VO, MSGL_FATAL, "[omapfb] Error /dev/fb1\n");
        return -1;
    }

    ioctl(dev_fd, FBIOGET_VSCREENINFO, &sinfo);
    ioctl(dev_fd, OMAPFB_QUERY_PLANE, &pinfo);
    ioctl(dev_fd, OMAPFB_QUERY_MEM, &minfo);

    if (!fb_overlay_only && !vo_init())
    {
        mp_msg(MSGT_VO, MSGL_FATAL, "[omapfb] Could not open X, overlay only...\n");        
        fb_overlay_only = 1;
    }

    return 0;
}

static void omapfb_update(int x, int y, int out_w, int out_h, int show)
{
    int xres, yres;
    if (!fb_overlay_only)
        x11_get_window_abs_position(mDisplay, vo_window, &x, &y, &out_w, &out_h);

    /* Check for new screen rotation */
    ioctl(dev_fd, FBIOGET_VSCREENINFO, &sinfo2);
    if (sinfo2.rotate != sinfo_p0.rotate)
        getPrimaryPlaneInfo();

    if ( (!x && !y && !out_w && !out_h) ||
        (out_w < sinfo.xres_virtual / 4) || (out_h < sinfo.yres_virtual / 4) ||  /* HW can't scale down by more than 4x */
        (out_w > sinfo.xres_virtual * 8) || (out_h > sinfo.yres_virtual * 8) ) { /* HW can't scale up by more than 8x */
        pinfo.enabled = 0;
        pinfo.pos_x = 0;
        pinfo.pos_y = 0;
        ioctl(dev_fd, OMAPFB_SETUP_PLANE, &pinfo);
        return;
    }

    xres = sinfo.xres_virtual;
    yres = sinfo.yres_virtual;

    /* Handle clipping: if the left or top edge of the window goes
     * offscreen, clamp the overlay to the left or top edge of the
     * screen, and set the difference into the frame offset. Also
     * decrease the overlay size by the offset. The offset must
     * take window scaling into account as well.
     *
     * Likewise, if the right or bottom edge of the window goes
     * offscreen, clamp the overlay to the right or bottom edge of
     * the screen, and decrease the overlay size accordingly. The
     * hardware will truncate the output accordingly, so no offset
     * is needed. Also take window scaling into account.  -- hyc
     */
    if (x < 0) {
        /* clamp to left edge */
        xoff = -x;
        if (out_w != sinfo.xres_virtual) {
            /* account for scaling */
            xoff *= sinfo.xres_virtual;
            xoff /= out_w;
        }
        xres -= xoff;
        out_w += x;
        x = 0;
    } else {
        xoff = 0;
        if (x + out_w > sinfo_p0.xres) {
            /* clamp to right edge */
            int diff = sinfo_p0.xres - x;
            if (out_w != sinfo.xres_virtual) {
                /* account for scaling */
                xres = diff * sinfo.xres_virtual;
                xres /= out_w;
            } else {
                xres = diff;
            }
            out_w = diff;
        }
    }

    if (y < 0) {
        /* clamp to top edge - this seldom occurs since the window
         * titlebar is usually forced to stay visible
         */
        yoff = -y;
        if (out_h != sinfo.yres_virtual) {
            /* account for scaling */
            yoff *= sinfo.yres_virtual;
            yoff /= out_h;
        }
        yres -= yoff;
        out_h += y;
        y = 0;
    } else {
        yoff = 0;
        if (y + out_h > sinfo_p0.yres) {
            /* clamp to bottom edge */
            int diff = sinfo_p0.yres - y;
            if (out_h != sinfo.yres_virtual) {
                /* account for scaling */
                yres = diff * sinfo.yres_virtual;
                yres /= out_h;
            } else {
                yres = diff;
            }
            out_h = diff;
        }
    }

    if (xoff & 1)
        xoff++;
    if (xres & 1)
        xres--;

    pinfo.enabled = show;
    pinfo.pos_x = x;
    pinfo.pos_y = y;
    pinfo.out_width  = out_w;
    pinfo.out_height = out_h;

    sinfo.xoffset = fb_pages[page].x + xoff;
    sinfo.yoffset = fb_pages[page].y + yoff;
    /* If we had to change the overlay dimensions, update it */
    if (xres != sinfo2.xres || yres != sinfo2.yres ||
        sinfo.xoffset != sinfo2.xoffset ||
        sinfo.yoffset != sinfo2.yoffset) {
        sinfo.xres = xres;
        sinfo.yres = yres;
        sinfo.rotate = sinfo2.rotate;
        ioctl(dev_fd, FBIOPUT_VSCREENINFO, &sinfo);
    }

    ioctl(dev_fd, OMAPFB_SETUP_PLANE, &pinfo);
}

static int config(uint32_t width, uint32_t height, uint32_t d_width,
		uint32_t d_height, uint32_t flags, char *title,
		uint32_t format)
{
    uint8_t *fbmem;
    int i;
    struct omapfb_color_key color_key;

    XVisualInfo vinfo;
    XSetWindowAttributes xswa;
    XWindowAttributes attribs;
    unsigned long xswamask;
    int depth;

    Window root, parent;
    Window *child;
    unsigned int n_children;

    fullscreen_flag = flags & VOFLAG_FULLSCREEN;
    if (!fb_overlay_only)
    {
        if (!title)
            title = "MPlayer OMAPFB (X11/FB) render";

        XGetWindowAttributes(mDisplay, mRootWin, &attribs);
        depth = attribs.depth;
        if (depth != 15 && depth != 16 && depth != 24 && depth != 32)
            depth = 24;
        XMatchVisualInfo(mDisplay, mScreen, depth, TrueColor, &vinfo);

        xswa.border_pixel = 0;
        xswa.background_pixel = xv_colorkey = TRANSPARENT_COLOR_KEY;

        xswamask = CWBackPixel | CWBorderPixel;
        xv_ck_info.method = CK_METHOD_BACKGROUND;

        vo_x11_create_vo_window(&vinfo, vo_dx, vo_dy, vo_dwidth, vo_dheight,
                                flags, CopyFromParent, "omapfb", title);
        XChangeWindowAttributes(mDisplay, vo_window, xswamask, &xswa);

        /* Need to receive events on the parent window -- so when it is
           moved / resized / etc., we know. */
        if(WinID > 0)
        {
            /* Query window tree information */
            XQueryTree(mDisplay, vo_window, &root, &parent, &child, &n_children);
            if (n_children)
                XFree(child);

            XUnmapWindow(mDisplay, vo_window);
            if (parent)
                XSelectInput(mDisplay, parent, StructureNotifyMask);
            XMapWindow(mDisplay, vo_window);
        }

        vo_calc_drwXY(&drwX, &drwY);
        vo_xv_draw_colorkey(drwX, drwY, vo_dwidth - 1, vo_dheight - 1);
    }

    fbmem = mmap(NULL, minfo.size, PROT_READ|PROT_WRITE, MAP_SHARED, dev_fd, 0);
    if (fbmem == MAP_FAILED) {
        mp_msg(MSGT_VO, MSGL_FATAL, "[omapfb] Error mmap\n");
        return -1;
    }

    for (i = 0; i < minfo.size / 4; i++)
        ((uint32_t*)fbmem)[i] = 0x80008000;

    sinfo.xres = width & ~15;
    sinfo.yres = height & ~15;
    sinfo.xoffset = 0;
    sinfo.yoffset = 0;
    sinfo.nonstd = OMAPFB_COLOR_YUY422;

    fb_pages[0].x = 0;
    fb_pages[0].y = 0;
    fb_pages[0].buf = fbmem;

    if (dbl_buffer && minfo.size >= sinfo.xres * sinfo.yres * 2) {
        sinfo.xres_virtual = sinfo.xres;
        sinfo.yres_virtual = sinfo.yres * 2;
        fb_pages[1].x = 0;
        fb_pages[1].y = sinfo.yres;
        fb_pages[1].buf = fbmem + sinfo.xres * sinfo.yres * 2;
        fb_page_flip = 1;
    } else {
        sinfo.xres_virtual = sinfo.xres;
        sinfo.yres_virtual = sinfo.yres;
        fb_page_flip = 0;
    }

    ioctl(dev_fd, FBIOPUT_VSCREENINFO, &sinfo);
    ioctl(dev_fd, FBIOGET_FSCREENINFO, &finfo);

    if (WinID <= 0) {
        if (fullscreen_flag) {
            omapfb_update(0, 0, sinfo_p0.xres, sinfo_p0.yres, 1);
        } else {
            omapfb_update(sinfo_p0.xres / 2 - sinfo.xres / 2, sinfo_p0.yres / 2 - sinfo.yres / 2, sinfo.xres, sinfo.yres, 1);
        }
    }

    color_key.channel_out = OMAPFB_CHANNEL_OUT_LCD;
    color_key.background = 0x0;
    color_key.trans_key = TRANSPARENT_COLOR_KEY;
    if (fb_overlay_only)
        color_key.key_type = OMAPFB_COLOR_KEY_DISABLED;
    else
        color_key.key_type = OMAPFB_COLOR_KEY_GFX_DST;
    ioctl(dev_fd, OMAPFB_SET_COLOR_KEY, &color_key);

    plane_ready = 1;
    return 0;
}

static void draw_alpha(int x0, int y0, int w, int h, unsigned char *src, unsigned char *srca, int stride)
{
    vo_draw_alpha_yuy2(w, h, src, srca, stride, fb_pages[page].buf + y0 * finfo.line_length + x0 * 2, finfo.line_length);
}

static void draw_osd(void)
{
    vo_draw_text(sinfo.xres, sinfo.yres, draw_alpha);
}

static int draw_frame(uint8_t *src[])
{
    return 1;
}

static int draw_slice(uint8_t *src[], int stride[], int w, int h, int x, int y)
{
    if (x!=0)
        return 0;

    if (!plane_ready)
        return 0;

    ioctl(dev_fd, OMAPFB_SYNC_GFX);

    yuv420_to_yuv422(fb_pages[page].buf + y * finfo.line_length, src[0], src[1], src[2], w & ~15, h, stride[0], stride[1], finfo.line_length);
    return 0;
}

static void flip_page(void)
{
    if (fb_page_flip) {
        sinfo.xoffset = fb_pages[page].x + xoff;
        sinfo.yoffset = fb_pages[page].y + yoff;
        ioctl(dev_fd, FBIOPAN_DISPLAY, &sinfo);
        page ^= fb_page_flip;
    }
}

static int query_format(uint32_t format)
{
    // For simplicity pretend that we can only do YV12, support for
    // other formats can be added quite easily if/when needed
    if (format != IMGFMT_YV12)
        return 0;

    return VFCAP_CSP_SUPPORTED | VFCAP_CSP_SUPPORTED_BY_HW | VFCAP_OSD | VFCAP_SWSCALE | VFCAP_ACCEPT_STRIDE;
}


/**
 * Uninitialize framebuffer
 */
static void uninit()
{
    pinfo.enabled = 0;
    ioctl(dev_fd, OMAPFB_SETUP_PLANE, &pinfo);

    if (!fb_overlay_only) {
        struct omapfb_color_key color_key;
        color_key.channel_out = OMAPFB_CHANNEL_OUT_LCD;
        color_key.key_type = OMAPFB_COLOR_KEY_DISABLED;
        ioctl(dev_fd, OMAPFB_SET_COLOR_KEY, &color_key);
    }

    close(dev_fd);

    if (!fb_overlay_only)
        x11_uninit();
}


static int control(uint32_t request, void *data, ...)
{
    switch (request) {
        case VOCTRL_QUERY_FORMAT:
            return query_format(*((uint32_t*)data));
        case VOCTRL_FULLSCREEN: {
            if (WinID > 0) return VO_FALSE;
            if (fullscreen_flag) {
                if (!fb_overlay_only)
                    vo_x11_fullscreen();
                fullscreen_flag = 0;
                omapfb_update(sinfo_p0.xres / 2 - sinfo.xres / 2, sinfo_p0.yres / 2 - sinfo.yres / 2, sinfo.xres, sinfo.yres, 1);
            } else {
                if (!fb_overlay_only)
                    vo_x11_fullscreen();
                fullscreen_flag = 1;
                omapfb_update(0, 0, sinfo_p0.xres, sinfo_p0.yres, 1);
            }
            return VO_TRUE;
        }
        case VOCTRL_UPDATE_SCREENINFO:
            update_xinerama_info();
            return VO_TRUE;
    }
    return VO_NOTIMPL;
}


static void check_events(void)
{
    if (!fb_overlay_only)
        x11_check_events();
}
