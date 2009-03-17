/*
 
Copyright (C) 2008 Gregoire Gentil <gregoire@gentil.com>
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

extern void yuv420_to_yuv422(uint8_t *yuv, uint8_t *y, uint8_t *u, uint8_t *v, int w, int h, int yw, int cw, int dw);
static struct fb_var_screeninfo sinfo_p0;
static struct fb_var_screeninfo sinfo;
static struct omapfb_mem_info minfo;
static struct omapfb_plane_info pinfo;
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


/**
 * Function that controls fullscreen state for x11 window
 * action = 1 (set fullscreen)
 * action = 0 (set windowed mode)
 */
static void x11_set_fullscreen_state(Display *display, Window window, int action)
{
    XEvent xev;

    /* init X event structure for _NET_WM_FULLSCREEN client msg */
    xev.xclient.type = ClientMessage;
    xev.xclient.serial = 0;
    xev.xclient.send_event = True;
    xev.xclient.message_type = XInternAtom(display, "_NET_WM_STATE", False);
    xev.xclient.window = window;
    xev.xclient.format = 32;
    xev.xclient.data.l[0] = action;
    xev.xclient.data.l[1] = XInternAtom(display, "_NET_WM_STATE_FULLSCREEN", False);
    xev.xclient.data.l[2] = 0;
    xev.xclient.data.l[3] = 0;
    xev.xclient.data.l[4] = 0;

    /* finally send that damn thing */
    if (!XSendEvent(display, DefaultRootWindow(display), False, SubstructureRedirectMask | SubstructureNotifyMask, &xev)) {
        mp_msg(MSGT_VO, MSGL_ERR, "[omapfb] failure in x11_set_fullscreen_state\n");
        exit(1);
    }
    XSync(display, False);
}


XClassHint classhint = {"mediaplayer-ui", "mediaplayer-ui"};


/**
 * Initialize x11 window (it is used to allocate some screen area for framebuffer overlay)
 */
static void x11_init()
{
    display = XOpenDisplay(getenv("DISPLAY"));
    if (display == NULL) {
        mp_msg(MSGT_VO, MSGL_ERR, "[omapfb] failure in x11_init, can't open display\n");
        exit(1);
    }

    screen_num = DefaultScreen(display);

    if (WinID > 0)
    {
        Window root;
        Window *child;
        unsigned int n_children;

        win = WinID;

        /* Query window tree information */
        XQueryTree(display, win, &root, &parent, &child, &n_children);
        if (n_children)
            XFree(child);

        XUnmapWindow(display, win);
        if (parent)
            XSelectInput(display, parent, StructureNotifyMask);
        XMapWindow(display, win);

        wm_delete_window = XInternAtom(display, "WM_DELETE_WINDOW", False);
        XSetWMProtocols(display, win, &wm_delete_window, 1);
    } else {
        win = XCreateSimpleWindow(display, RootWindow(display, screen_num),
                                  sinfo_p0.xres / 2 - sinfo.xres / 2, sinfo_p0.yres / 2 - sinfo.yres / 2, sinfo.xres, sinfo.yres, 0,
                                  WhitePixel(display, screen_num),
                                  TRANSPARENT_COLOR_KEY);

        XSetClassHint(display, win, &classhint);

        XStoreName(display, win, "MPlayer");
        XMapWindow(display, win);

        /* Set WM_DELETE_WINDOW atom in WM_PROTOCOLS property (to get window_delete requests).  */
        wm_delete_window = XInternAtom(display, "WM_DELETE_WINDOW", False);
        XSetWMProtocols(display, win, &wm_delete_window, 1);
        XSelectInput(display, win, StructureNotifyMask | KeyPressMask);
    }
}


void print_properties(Window win2)
{
	Atom *p;
	int num, j;
	char *aname;
	Atom type;
	int format;
	unsigned long nitems, bytes_after;
	unsigned char *ret = NULL;

	p = XListProperties(display, win2, &num);
	printf("found %d properties for window %d\n", num, (int)win2);
	for (j = 0; j < num; j++) {
		aname = XGetAtomName(display, p[j]);
		if (aname) {
			if(Success == XGetWindowProperty(display, win2, XInternAtom(display, aname, False),
						0L, ~0L, False, XA_STRING,
						&type, &format, &nitems,
						&bytes_after, &ret))
			{
/*				printf("format = %d, nitems = %d, bytes_after = %d\n", format, nitems, bytes_after);*/
				printf("%s = %s\n", aname, ret);
				XFree(ret);
			}
			XFree(aname);
		} else printf("NULL\n");
	}
	XFree(p);
}


static int x11_check_events()
{
    if (!display) {
        mp_msg(MSGT_VO, MSGL_ERR, "[omapfb] 'x11_check_events' called out of sequence\n");
        exit(1);
    }

    int ret = 0;
    XEvent Event;
    while (XPending(display)) {
        XNextEvent(display, &Event);
        if (Event.type == UnmapNotify)
            omapfb_update(0, 0, 0, 0, 0);
        else if ((Event.type == MapNotify) || (Event.type == ConfigureNotify))
            omapfb_update(0, 0, 0, 0, 1);
        else if (Event.type == KeyPress) {
            int key;
            KeySym keySym = XKeycodeToKeysym(display, Event.xkey.keycode, 0);
            key = ((keySym & 0xff00) != 0 ? ((keySym & 0x00ff) + 256) : (keySym));
            ret |= VO_EVENT_KEYPRESS;
            vo_x11_putkey(key);
        } else if (Event.type == ClientMessage) {
            if ((Atom)Event.xclient.data.l[0] == wm_delete_window) {
                mplayer_put_key(KEY_ESC);
            }
        }
    }
    return ret;
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

    dev_fd = open("/dev/fb0", O_RDWR);

    if (dev_fd == -1) {
        mp_msg(MSGT_VO, MSGL_FATAL, "[omapfb] Error /dev/fb0\n");
        return -1;
    }

    ioctl(dev_fd, FBIOGET_VSCREENINFO, &sinfo_p0);
    close(dev_fd);

    dev_fd = open("/dev/fb1", O_RDWR);

    if (dev_fd == -1) {
        mp_msg(MSGT_VO, MSGL_FATAL, "[omapfb] Error /dev/fb1\n");
        return -1;
    }

    ioctl(dev_fd, FBIOGET_VSCREENINFO, &sinfo);
    ioctl(dev_fd, OMAPFB_QUERY_PLANE, &pinfo);
    ioctl(dev_fd, OMAPFB_QUERY_MEM, &minfo);

    if (!fb_overlay_only)
        x11_init();

    return 0;
}


static void omapfb_update(int x, int y, int out_w, int out_h, int show)
{
    if (!fb_overlay_only)
        x11_get_window_abs_position(display, win, &x, &y, &out_w, &out_h);

    if ((x < 0) || (y < 0)

// If you develop the right scaling-down patch in kernel, uncomment the line below and comment the next one
//        || (out_w < sinfo.xres / 4) || (out_h < sinfo.yres / 4)
        || (out_w < sinfo.xres) || (out_h < sinfo.yres)

// If you don't have the right scaling-up patch in kernel, comment the line below and uncomment the next one
/* Kernel patch to enable scaling up on the omap3
======================================================
--- a/drivers/video/omap/dispc.c	2008-11-01 20:08:04.000000000 -0700
+++ b/drivers/video/omap/dispc.c	2008-11-01 20:09:02.000000000 -0700
@@ -523,9 +523,6 @@
 	if ((unsigned)plane > OMAPFB_PLANE_NUM)
 		return -ENODEV;
 
-	if (out_width != orig_width || out_height != orig_height)
-		return -EINVAL;
-
 	enable_lcd_clocks(1);
 	if (orig_width < out_width) {
 		/*
======================================================
*/
        || (out_w > sinfo.xres * 8) || (out_h > sinfo.yres * 8)
//        || (out_w > sinfo.xres) || (out_h > sinfo.yres)

        || (x + out_w > sinfo_p0.xres) || (y + out_h > sinfo_p0.yres)) {
        pinfo.enabled = 0;
        pinfo.pos_x = 0;
        pinfo.pos_y = 0;
        ioctl(dev_fd, OMAPFB_SETUP_PLANE, &pinfo);
        return;
    }

    pinfo.enabled = show;
    pinfo.pos_x = x;
    pinfo.pos_y = y;
    pinfo.out_width  = out_w;
    pinfo.out_height = out_h;
    ioctl(dev_fd, OMAPFB_SETUP_PLANE, &pinfo);
}


static int config(uint32_t width, uint32_t height, uint32_t d_width,
		uint32_t d_height, uint32_t flags, char *title,
		uint32_t format)
{
    uint8_t *fbmem;
    int i;
    struct omapfb_color_key color_key;

    fullscreen_flag = flags & VOFLAG_FULLSCREEN;

    fbmem = mmap(NULL, minfo.size, PROT_READ|PROT_WRITE, MAP_SHARED, dev_fd, 0);
    if (fbmem == MAP_FAILED) {
        mp_msg(MSGT_VO, MSGL_FATAL, "[omapfb] Error mmap\n");
        return -1;
    }

    for (i = 0; i < minfo.size / 4; i++)
        ((uint32_t*)fbmem)[i] = 0x80008000;

    sinfo.xres = FFMIN(sinfo_p0.xres, width)  & ~15;
    sinfo.yres = FFMIN(sinfo_p0.yres, height) & ~15;
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

    if (WinID <= 0) {
        if (fullscreen_flag) {
            if (!fb_overlay_only)
                x11_set_fullscreen_state(display, win, 1);
            omapfb_update(0, 0, sinfo_p0.xres, sinfo_p0.yres, 1);
        } else {
            if (!fb_overlay_only)
                x11_set_fullscreen_state(display, win, 0);
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
    vo_draw_alpha_yuy2(w, h, src, srca, stride, fb_pages[page].buf + sinfo.xres * y0 * 2 + x0 * 2, sinfo.xres);
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

    yuv420_to_yuv422(fb_pages[page].buf + 2 * sinfo.xres * y, src[0], src[1], src[2], w & ~15, h, stride[0], stride[1], 2 * sinfo.xres_virtual);

    return 0;
}


static void flip_page(void)
{
    if (fb_page_flip) {
        sinfo.xoffset = fb_pages[page].x;
        sinfo.yoffset = fb_pages[page].y;
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
                    x11_set_fullscreen_state(display, win, 0);
                fullscreen_flag = 0;
                omapfb_update(sinfo_p0.xres / 2 - sinfo.xres / 2, sinfo_p0.yres / 2 - sinfo.yres / 2, sinfo.xres, sinfo.yres, 1);
            } else {
                if (!fb_overlay_only)
                    x11_set_fullscreen_state(display, win, 1);
                fullscreen_flag = 1;
                omapfb_update(0, 0, sinfo_p0.xres, sinfo_p0.yres, 1);
            }
            return VO_TRUE;
        }
    }
    return VO_NOTIMPL;
}


static void check_events(void)
{
    if (!fb_overlay_only)
        x11_check_events();
}
