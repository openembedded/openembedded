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
    uint16_t *osd_mem_base;
    
    int fd;
    int base_fd;
    int overlay_fd;
    struct fb_var_screeninfo my_fb_var;
    struct fb_fix_screeninfo my_fb_fix;
    struct fb_var_screeninfo base_orig_fb_var;
    struct fb_var_screeninfo osd_fb_var;
    struct fb_fix_screeninfo osd_fb_fix;   
    int vm;
    uint32_t format;
    int src_width;
    int src_height;
    int width;
    int height;
    int rotate;
    int osd_cleared;
} pxa_priv_t;

typedef struct vo_pxa_pixel_data8 {
    unsigned int a,b;
} Vo_Pxa_Pixel_Data8;

#define UNUSED(v) ((void)(v))

/* Internal API */
static int vo_pxa_query_format( uint32_t format );
static void vo_pxa_copy_and_rotate( uint8_t *src, int stride, uint8_t *dst, int w, int h, int dst_stride );
static void vo_pxa_draw_alpha( int x, int y, int w, int h, unsigned char *src,
                               unsigned char *srca, int stride );
static void vo_pxa_draw_alpha_with_rotate( int x, int y, int w, int h, unsigned char *src,
                                           unsigned char *srca, int stride );

static void vo_pxa_clear_osd( uint16_t *mem_base, int len );
