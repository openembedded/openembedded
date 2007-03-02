/*
 * Video driver for PXA 27x Overlay 2, in conjunction with kernel driver
 * by Tim Chick <tim (DOT) chick (AT) csr (DOT) com>
 * (C) 2007
 */

#include <linux/fb.h>

#include <sys/ioctl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <fcntl.h>

typedef struct pxa_priv_s {
    uint8_t *fb_mem_base;
    int fd;
    int base_fd;
    struct fb_var_screeninfo my_fb_var;
    struct fb_fix_screeninfo my_fb_fix;
    struct fb_var_screeninfo base_orig_fb_var;
    int vm;
    uint32_t format;
    int src_width;
    int src_height;
} pxa_priv_t;

#define UNUSED(v) ((void)(v))

/* Internal API */
static int vo_pxa_query_format( uint32_t format );
