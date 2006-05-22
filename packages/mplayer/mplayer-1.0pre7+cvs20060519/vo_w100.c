/*
 * Video driver for ATI Imageon 100 (w100)
 * by AGAWA Koji <i (AT) atty (DOT) jp>
 * (C) 2004
 */
/* English in this source code is written by machine translation.
   Meaning also not leading, permitting. */

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

#include "vo_w100_api.h"
#include "vo_w100_fb.h"

#define UNUSED(v) ((void)(v))

static vo_info_t info = {
	"ATI Imageon 100",
	"w100",
	"AGAWA Koji <i (AT) atty (DOT) jp>",
	"for Sharp Linux Zaurus SL-C700/750/760/860"
};

LIBVO_EXTERN(w100);

// ----------------------------------------------------------------
#define MAX_FRAMES 20
typedef struct vidix_yuv_s
{
	unsigned y,u,v;
}vidix_yuv_t;

typedef struct vidix_rect_s
{
	unsigned x,y,w,h;	/* in pixels */
	vidix_yuv_t pitch;	/* line-align in bytes */
}vidix_rect_t;

typedef struct w100_yuv_planes_s {
	uint8_t *y;
	uint8_t *u;
	uint8_t *v;
} w100_yuv_planes_t;

typedef struct w100_priv_s {
    uint32_t format;
    int src_width;
    int src_height;
    int nframes;		/* total num of frames */
    int current_frame;		/* current frame to display */
    int rotate;
    int current_rotate;

    /* w100 info */
    int vram_size[2];		/*  */
    void *vram_addr[2];		/* address */
    w100_yuv_planes_t frame_addrs[MAX_FRAMES];
    w100_yuv_planes_t frame_offsets[MAX_FRAMES];
    int is_graphic_window_enabled;
    int eq_brightness;		/* for mplayer */
    int display_brightness;	/* for w100 */

    /* overlay info */
    uint16_t overlay_handle;
    ATI_OVERLAYPROP overlay_prop;
    int overlay_pos_x;
    int overlay_pos_y;
    int overlay_expand_h;
    int overlay_expand_v;
    int overlay_pitch_y;
    int overlay_pitch_u;
    int overlay_pitch_v;
    video_y_offset_u video_y_offset;
    video_u_offset_u video_u_offset;
    video_v_offset_u video_v_offset;
} w100_priv_t;

static w100_priv_t st_w100_priv;
static vidix_yuv_t dstrides;

static int test_rotate(int *arg)
{
    if ((*arg < -1) || (*arg > 3))
	return 0;
    return 1;
}

static opt_t subopts[] = {
    { "rotate", OPT_ARG_INT, &st_w100_priv.rotate, (opt_test_f)test_rotate },
    { NULL }
};

static void draw_alpha(int x0,int y0, int w,int h,
		       unsigned char* src, unsigned char *srca, int stride)
{
    w100_priv_t *priv = &st_w100_priv;
    uint8_t *psrc, *psrca, *pdst;
    pdst = priv->frame_addrs[priv->current_frame].y;
    pdst += (x0 * priv->overlay_prop.SrcPitch) + (priv->overlay_prop.SrcPitch - 1 - y0);
    psrc = src;
    psrca = srca;
    while (h--) {
	int j;
	for (j = 0; j < w; ++j) {
	    if (psrca[j])
		pdst[j * priv->overlay_prop.SrcPitch] =
		    ((pdst[j * priv->overlay_prop.SrcPitch] * psrca[j]) >> 8) + psrc[j];
	}
	psrc += stride;
	psrca += stride;
	pdst -= 1;
    }
#if 0
    w100_priv_t *priv = &st_w100_priv;
    uint32_t apitch, bespitch;
    void *lvo_mem;
    lvo_mem = priv->frame_addrs[priv->current_frame].y;
    apitch = priv->overlay_pitch_y - 1;
    switch (priv->format) {
    case IMGFMT_YV12:
    case IMGFMT_IYUV:
    case IMGFMT_I420:
    case IMGFMT_YVU9:
    case IMGFMT_IF09:
    case IMGFMT_Y8:
    case IMGFMT_Y800:
	bespitch = (priv->src_width + apitch) & (~apitch);
	vo_draw_alpha_yv12(w,h,src,srca,stride,lvo_mem+bespitch*y0+x0,bespitch);
	break;
    case IMGFMT_YUY2:
	bespitch = (priv->src_width*2 + apitch) & (~apitch);
	vo_draw_alpha_yuy2(w,h,src,srca,stride,lvo_mem+bespitch*y0+2*x0,bespitch);
	break;
    case IMGFMT_UYVY:
	bespitch = (priv->src_width*2 + apitch) & (~apitch);
	vo_draw_alpha_yuy2(w,h,src,srca,stride,lvo_mem+bespitch*y0+2*x0+1,bespitch);
	break;
    case IMGFMT_RGB32:
    case IMGFMT_BGR32:
	bespitch = (priv->src_width*4 + apitch) & (~apitch);
	vo_draw_alpha_rgb32(w,h,src,srca,stride,lvo_mem+y0*bespitch+4*x0,bespitch);
	break;
    case IMGFMT_RGB24:
    case IMGFMT_BGR24:
	bespitch = (priv->src_width*3 + apitch) & (~apitch);
	vo_draw_alpha_rgb24(w,h,src,srca,stride,lvo_mem+y0*bespitch+3*x0,bespitch);
	break;
    case IMGFMT_RGB16:
    case IMGFMT_BGR16:
	bespitch = (priv->src_width*2 + apitch) & (~apitch);
	vo_draw_alpha_rgb16(w,h,src,srca,stride,lvo_mem+y0*bespitch+2*x0,bespitch);
	break;
    case IMGFMT_RGB15:
    case IMGFMT_BGR15:
	bespitch = (priv->src_width*2 + apitch) & (~apitch);
	vo_draw_alpha_rgb15(w,h,src,srca,stride,lvo_mem+y0*bespitch+2*x0,bespitch);
	break;
    default:
	return;
    }
#endif
}

static uint32_t w100_draw_slice_420(uint8_t *image[], int stride[],
				     int w, int h, int x, int y)
{
    w100_priv_t *priv = &st_w100_priv;
    uint8_t *src;
    uint8_t *dest;
    int i;

    /* Plane Y */
    dest = priv->frame_addrs[priv->current_frame].y;
    dest += dstrides.y * y + x;
    src = image[0];
    for (i = 0; i < h; ++i) {
	memcpy(dest, src, w);
	src += stride[0];
	dest += dstrides.y;
    }

    /* Plane V */
    dest = priv->frame_addrs[priv->current_frame].u;
    dest += dstrides.v * y / 4 + x;
    src = image[1];
    for (i = 0; i < h / 2; ++i) {
	memcpy(dest, src, w / 2);
	src += stride[1];
	dest += dstrides.v / 2;
    }

    /* Plane U */
    dest = priv->frame_addrs[priv->current_frame].v;
    dest += dstrides.u * y / 4 + x;
    src = image[2];
    for (i = 0; i < h / 2; ++i) {
	memcpy(dest, src, w / 2);
	src += stride[2];
	dest += dstrides.u / 2;
    }

    return 0;
}

/*
  w must be multiple of 8
 */
static uint32_t w100_draw_slice_420_rotate3(uint8_t *image[], int stride[],
					    int w, int h, int x, int y)
{
    w100_priv_t *priv = &st_w100_priv;
    void *src, *dest;
    int i, dpitch2, h_;

    h_ = h;

    for (i = 0; i < 3; ++i) {
	src = image[i];
	switch (i) {
	case 0:
	    dest = priv->frame_addrs[priv->current_frame].y;
	    dest += dstrides.y * x + dstrides.y - y;
	    dpitch2 = dstrides.y << 1;
	    break;
	case 1:
	    dest = priv->frame_addrs[priv->current_frame].u;
	    dest += (dstrides.y >> 1) * (x >> 1) + (dstrides.y >> 1) - (y >> 1);
	    dpitch2 = dstrides.y;
	    h = h_ >> 1;
	    w >>= 1;
	    break;
	case 2:
	    dest = priv->frame_addrs[priv->current_frame].v;
	    dest += (dstrides.y >> 1) * (x >> 1) + (dstrides.y >> 1) - (y >> 1);
	    h = h_ >> 1;
	    dpitch2 = dstrides.y;
	    break;
	}

	__asm__ __volatile__ (
	    "1:					\n\t"
	    "mov	r8, %[w]			\n\t"
	    "sub	%[dest], %[dest], #1		\n\t"
	    "mov	r4, %[dest]			\n\t"
	    "add	r5, %[dest], %[dpitch2], lsr #1			\n\t"

	    "2:					\n\t"
	    "ldrb	r0, [%[src]]			\n\t"
	    "ldrb	r1, [%[src], #1]		\n\t"
	    "add	%[src], %[src], #2		\n\t"
	    "strb	r0, [r4]			\n\t"
	    "strb	r1, [r5]			\n\t"
	    "add	r4, r4, %[dpitch2]		\n\t"
	    "add	r5, r5, %[dpitch2]		\n\t"
	    "ldrb	r0, [%[src]]			\n\t"
	    "ldrb	r1, [%[src], #1]		\n\t"
	    "add	%[src], %[src], #2		\n\t"
	    "strb	r0, [r4]			\n\t"
	    "strb	r1, [r5]			\n\t"
	    "add	r4, r4, %[dpitch2]		\n\t"
	    "add	r5, r5, %[dpitch2]		\n\t"
	    "subs	r8, r8, #4			\n\t"
	    "bne	2b				\n\t"

	    "add	%[src], %[src], %[srcdiff]	\n\t"
	    "subs	%[h], %[h], #1			\n\t"
	    "bne	1b				\n\t"
	    : [src]"+r"(src), [dest]"+r"(dest), [h]"+r"(h)
	    : [dpitch2]"r"(dpitch2), [w]"r"(w), [srcdiff]"r"(stride[i] - w)
	    : "memory", "r0", "r1", "r4", "r5", "r8");
    }
}

static uint32_t w100_draw_slice_packed(uint8_t *image[], int stride[],
					int w, int h, int x, int y)
{
#if 0
    uint8_t *src;
    uint8_t *dest;
    int i;

    dest = st_w100_mem + vidix_play.offsets[st_next_frame] + vidix_play.offset.y;
    dest += dstrides.y * y + x;
    src = image[0];
    for (i = 0; i < h; ++i) {
	memcpy(dest, src, w * st_image_bpp);
	src += stride[0];
	dest += dstrides.y;
    }
#endif
    return 0;
}

static uint32_t w100_get_image(mp_image_t *mpi)
{
#if 0
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: w100_get_image called.\n");

    if (mpi->type == MP_IMGTYPE_STATIC && st_num_frames > 1)
	return VO_FALSE;
    if (mpi->flags & MP_IMGFLAG_READABLE)
	return VO_FALSE; /* slow video ram */
    if (((mpi->stride[0] == dstrides.y &&
	  (!(mpi->flags & MP_IMGFLAG_PLANAR) ||
	   (mpi->stride[1] == dstrides.u && mpi->stride[2]==dstrides.v)))
	 || (mpi->flags & (MP_IMGFLAG_ACCEPT_STRIDE | MP_IMGFLAG_ACCEPT_WIDTH))) &&
	(!(vidix_play.flags & VID_PLAY_INTERLEAVED_UV))) {
	if (mpi->flags & MP_IMGFLAG_ACCEPT_WIDTH) {
	    // check if only width is enough to represent strides:
	    if (mpi->flags & MP_IMGFLAG_PLANAR) {
		if ((dstrides.y >> 1) != dstrides.v || dstrides.v != dstrides.u)
		    return VO_FALSE;
	    } else {
		if (dstrides.y % (mpi->bpp / 8))
		    return VO_FALSE;
	    }
	}
	mpi->planes[0] = st_w100_mem + vidix_play.offsets[st_next_frame]
	    + vidix_play.offset.y;
	mpi->width = mpi->stride[0] = dstrides.y;
	if (mpi->flags & MP_IMGFLAG_PLANAR) {
	    mpi->planes[1] = st_w100_mem + vidix_play.offsets[st_next_frame]
		+ vidix_play.offset.v;
	    mpi->stride[1] = dstrides.v >> mpi->chroma_x_shift;
	    mpi->planes[2] = st_w100_mem + vidix_play.offsets[st_next_frame]
		+ vidix_play.offset.u;
	    mpi->stride[2] = dstrides.u >> mpi->chroma_x_shift;
	} else
	    mpi->width /= mpi->bpp / 8;
	mpi->flags |= MP_IMGFLAG_DIRECT;
	return VO_TRUE;
    }
#endif
    return VO_FALSE;
}

static void w100_set_yuv_addrs(w100_priv_t *priv, w100_yuv_planes_t *offsets)
{
    uint32_t val;

    priv->video_y_offset.f.y_offset = GetRealMemAddr((uint32_t)offsets->y);
    priv->video_u_offset.f.u_offset = GetRealMemAddr((uint32_t)offsets->u);
    priv->video_v_offset.f.v_offset = GetRealMemAddr((uint32_t)offsets->v);
    AtiCore_WriteReg(mmVIDEO_Y_OFFSET, (uint32_t *)&priv->video_y_offset);
    AtiCore_WriteReg(mmVIDEO_U_OFFSET, (uint32_t *)&priv->video_u_offset);
    AtiCore_WriteReg(mmVIDEO_V_OFFSET, (uint32_t *)&priv->video_v_offset);

    val = 0x7B;
    AtiCore_WriteReg(mmDISP_DB_BUF_CNTL, &val);
}

static void w100_set_overlay_expand(w100_priv_t *priv, int exp_h, int exp_v)
{
    video_ctrl_u video_ctrl;

    priv->overlay_expand_h = exp_h;
    priv->overlay_expand_v = exp_v;

    AtiCore_ReadReg(mmVIDEO_CTRL, (uint32_t *)&video_ctrl);
    video_ctrl.f.video_hor_exp = exp_h;
    video_ctrl.f.video_ver_exp = exp_v;
    AtiCore_WriteReg(mmVIDEO_CTRL, (uint32_t *)&video_ctrl);
}

static int w100_setup(w100_priv_t *priv)
{
    if (!AtiCore_AllocOverlay(&priv->overlay_handle)) {
	mp_msg(MSGT_VO, MSGL_FATAL,
	       "vo_w100: AtiCore_AllocOverlay failed.\n");
	return 0;
    }
    if (!AtiCore_SetupOverlay(priv->overlay_handle, &priv->overlay_prop)) {
	mp_msg(MSGT_VO, MSGL_FATAL,
	       "vo_w100: AtiCore_SetupOverlay failed.\n");
	return 0;
    }
    AtiCore_SetOverlayPos(priv->overlay_handle,
			  priv->overlay_pos_x, priv->overlay_pos_y);
    AtiCore_SetOverlayOnOff(priv->overlay_handle, 1);
    w100_set_yuv_addrs(priv, &priv->frame_offsets[priv->current_frame]);
    w100_set_overlay_expand(priv, priv->overlay_expand_h, priv->overlay_expand_v);
    AtiCore_SetDisplayBrightness(priv->display_brightness);
    AtiCore_SetGraphicWindowOnOff(priv->is_graphic_window_enabled);

/* 	graphic_ctrl_t gc; */
/* 	AtiCore_ReadReg(mmGRAPHIC_CTRL, &gc); */
/* 	gc.low_power_on = 0; */
/* 	AtiCore_WriteReg(mmGRAPHIC_CTRL, &gc); */

    return 1;
}

static void *w100_offset2addr(uint32_t offset)
{
    void *addr;
    AtiCore_SetupMemoryTransfer((uint32_t)offset, &addr);
    AtiCore_TerminateMemoryTransfer();
    return addr;
}

// ---------------------------------------------------------------- interfaces
/*
 * Preinitializes driver (real INITIALIZATION)
 *   arg - currently it's vo_subdevice
 *   returns: zero on successful initialization, non-zero on error.
 */
static int preinit(const char *vo_subdevice)
{
    w100_priv_t *priv = &st_w100_priv;

    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: preinit() was called\n");

    if (!AtiCore_ProcessAttach())
	return -1;

    /* fill w100_priv_t information */
    memset(priv, 0, sizeof(*priv));
    priv->rotate = -1;

    if (subopt_parse(vo_subdevice, subopts) != 0) {
	return -1;
    }

    priv->is_graphic_window_enabled = 1;
    priv->eq_brightness = 0;	/* FIXME */

    GetAvailableVideoMem(&priv->vram_size[INTERNAL_VRAM],
			 &priv->vram_size[EXTERNAL_VRAM]);
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: VRAM size %dKB/%dKB\n",
	   priv->vram_size[INTERNAL_VRAM] / 1024,
	   priv->vram_size[EXTERNAL_VRAM] / 1024);

    priv->vram_addr[INTERNAL_VRAM] = w100_offset2addr(VRAM_OFFSET_INTERNAL);
    priv->vram_addr[EXTERNAL_VRAM] = w100_offset2addr(VRAM_OFFSET_EXTERNAL);
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: VRAM address 0x%08x/0x%08x\n",
	   priv->vram_addr[INTERNAL_VRAM], priv->vram_addr[EXTERNAL_VRAM]);

    lcd_background_color_u lbc;
    lbc.f.lcd_bg_red = 0;
    lbc.f.lcd_bg_green = 0;
    lbc.f.lcd_bg_blue = 0;
    AtiCore_WriteReg(mmLCD_BACKGROUND_COLOR, &lbc);

    return 0;
}

/*
 * Initialize (means CONFIGURE) the display driver.
 * params:
 *   src_width,srcheight: image source size
 *   dst_width,dst_height: size of the requested window size, just a hint
 *   fullscreen: flag, 0=windowd 1=fullscreen, just a hint
 *   title: window title, if available
 *   format: fourcc of pixel format
 * returns : zero on successful initialization, non-zero on error.
 */
static int config(uint32_t src_width, uint32_t src_height,
		       uint32_t dst_width, uint32_t dst_height, uint32_t flags,
		       char *title, uint32_t format)
{
    w100_priv_t *priv = &st_w100_priv;
    int fs = flags & VOFLAG_FULLSCREEN;
    int vm = flags & VOFLAG_MODESWITCHING;
    int zoom = flags & VOFLAG_SWSCALE;
    int y_pitch, uv_pitch;
    int x_res = 480, y_res = 640;
    uint32_t apitch;
    int i;
    uint32_t plane_flags = 0;

    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: config() was called\n");
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: src_width:%d, src_height:%d, dst_width:%d, dst_height:%d\n",
	   src_width, src_height, dst_width, dst_height);

    if (!query_format(format)) {
	printf("vo_w100: unsupported fourcc for this w100 driver: %x (%s)\n",
	       format, vo_format_name(format));
	return -1;
    }
    priv->format = format;

    // rotate
    if (priv->rotate < 0) {
	if (src_width > src_height) {
	    priv->current_rotate = 3;
	} else {
	    priv->current_rotate = 0;
	}
    } else
	priv->current_rotate = priv->rotate;
    if (priv->current_rotate != 0 && priv->current_rotate != 3) {
	mp_msg(MSGT_VO, MSGL_FATAL, "vo_w100: Rotate %d not supported\n", priv->current_rotate);
	return -1;
    }

    if (priv->current_rotate == 1 || priv->current_rotate == 3) {
	i = src_width;
	src_width = src_height;
	src_height = i;
    }

    dst_width = src_width;
    dst_height = src_height;

    if (fs) {
	int arg[] = { 0, 0, 1, 1, 2, 2, 2, 2, 3 };
	int arg2[] = { 1, 2, 4, 8 };
	int hor_exp = x_res / src_width;
	int ver_exp = y_res / (src_height - 32);
	int expand;
	mp_msg(MSGT_VO, MSGL_V, "vo_w100: hor_exp:%d, ver_exp:%d\n",
	       hor_exp, ver_exp);
	if ((hor_exp > 0 && hor_exp <= 8 && arg[hor_exp] >= 0) &&
	    (ver_exp > 0 && ver_exp <= 8 && arg[ver_exp] >= 0)) {
	    if (arg[hor_exp] > arg[ver_exp])
		expand = arg[ver_exp];
	    else
		expand = arg[hor_exp];
	}
	priv->overlay_expand_h = priv->overlay_expand_v = expand;
	dst_width *= arg2[expand];
	dst_height *= arg2[expand];
	if (dst_height > y_res)
	    dst_height = y_res;
    }

    // 表示領域をセンタリング
    priv->overlay_pos_x = (x_res - dst_width) / 2;
    priv->overlay_pos_y = (y_res - dst_height) / 2;

    // Hardware scaling
    geometry(&priv->overlay_pos_x, &priv->overlay_pos_y,
	     &dst_width, &dst_height, x_res, y_res);
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: overlay pos(%d, %d)\n",
	   priv->overlay_pos_x, priv->overlay_pos_y);
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: src size(%dx%d), dst size(%dx%d)\n",
	   src_width, src_height, dst_width, dst_height);

    /* select first frame */
    priv->current_frame = 0;

    priv->src_width = src_width;
    priv->src_height = src_height;
    priv->overlay_pitch_y = 16;
    priv->overlay_pitch_u = 16;
    priv->overlay_pitch_v = 16;

    switch (format) {
    case IMGFMT_YV12:
    case IMGFMT_IYUV:
    case IMGFMT_I420:
    case IMGFMT_YVU9:
    case IMGFMT_IF09:
    case IMGFMT_Y8:
    case IMGFMT_Y800:
	y_pitch = (src_width + 15) & ~15;
	uv_pitch = ((src_width / 2) + 7) & ~7;
	break;
    default:
	return -1;
    }

    /* サーフェイスが内蔵VRAMに収まらない場合は、V-Planeを外部VRAMに追い出す。 */
    if (y_pitch * src_height + uv_pitch * src_height > priv->vram_size[INTERNAL_VRAM])
	plane_flags = 4;

    if (vo_doublebuffering) {
	if (y_pitch * src_height + uv_pitch * src_height * 2> priv->vram_size[INTERNAL_VRAM])
	    plane_flags = 4;
    }

    /* 外部VRAMにプレーンを置いた場合は、Graphic windowを切らないと画像が乱れる */
/*     priv->is_graphic_window_enabled = (plane_flags != 0) ? 0 : 1; */
    priv->is_graphic_window_enabled = 0;

    uint32_t p[2] = {
	VRAM_OFFSET_INTERNAL,
	VRAM_OFFSET_EXTERNAL + 640 * 480 * 2
    };
    i = 0;
    while (i < MAX_FRAMES) {
	int sel, j;
	/* Y-plane */
	sel = plane_flags & 1 ? EXTERNAL_VRAM : INTERNAL_VRAM;
	priv->frame_offsets[i].y = (void *)p[sel];
	priv->frame_addrs[i].y = w100_offset2addr(p[sel]);
	p[sel] += y_pitch * src_height;
	/* U-plane */
	sel = plane_flags & 2 ? EXTERNAL_VRAM : INTERNAL_VRAM;
	priv->frame_offsets[i].u = (void *)p[sel];
	priv->frame_addrs[i].u = w100_offset2addr(p[sel]);
	p[sel] += uv_pitch * (src_height / 2);
	/* V-plane */
	sel = plane_flags & 4 ? EXTERNAL_VRAM : INTERNAL_VRAM;
	priv->frame_offsets[i].v = (void *)p[sel];
	priv->frame_addrs[i].v = w100_offset2addr(p[sel]);
	p[sel] += uv_pitch * (src_height / 2);
	if ((p[INTERNAL_VRAM] - VRAM_OFFSET_INTERNAL >= priv->vram_size[INTERNAL_VRAM]) ||
	    (p[EXTERNAL_VRAM] - VRAM_OFFSET_EXTERNAL >= priv->vram_size[EXTERNAL_VRAM]))
	    break;
	mp_msg(MSGT_VO, MSGL_V, "vo_w100: frame_offsets[%d].y = 0x%08x\n", i, priv->frame_offsets[i].y);
	mp_msg(MSGT_VO, MSGL_V, "vo_w100: frame_offsets[%d].u = 0x%08x\n", i, priv->frame_offsets[i].u);
	mp_msg(MSGT_VO, MSGL_V, "vo_w100: frame_offsets[%d].v = 0x%08x\n", i, priv->frame_offsets[i].v);
	++i;
    }
    priv->nframes = i;
    if (priv->nframes > MAX_FRAMES)
	priv->nframes = MAX_FRAMES;
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: nframes = %d\n", priv->nframes);

    priv->overlay_prop.lpSrcBitmap = (void *)(priv->frame_offsets[0].y);
    priv->overlay_prop.XCoord = 0;
    priv->overlay_prop.YCoord = 0;
    priv->overlay_prop.SrcPitch = y_pitch;
    priv->overlay_prop.SrcHeight = src_height;
    priv->overlay_prop.OverlayWidth = dst_width;
    priv->overlay_prop.OverlayHeight = dst_height;
    priv->overlay_prop.lpOverlayKey = 0;
    priv->overlay_prop.OverlayFormat = OVLTYPE_YUV420;

    priv->display_brightness = 127;

    w100_set_yuv_addrs(priv, &priv->frame_offsets[0]);

    /* clear every frame */
    memset(priv->vram_addr[INTERNAL_VRAM], 0, priv->vram_size[INTERNAL_VRAM]);
    memset(priv->vram_addr[EXTERNAL_VRAM] + 640 * 480 * 2, 0,
	   priv->vram_size[EXTERNAL_VRAM] - 640 * 480 * 2);

    switch (format) {
    case IMGFMT_YV12:
    case IMGFMT_I420:
    case IMGFMT_IYUV:
    case IMGFMT_YVU9:
    case IMGFMT_IF09:
    case IMGFMT_Y800:
    case IMGFMT_Y8:
	apitch = priv->overlay_pitch_y - 1;
	dstrides.y = (src_width + apitch) & ~apitch;
	apitch = priv->overlay_pitch_v - 1;
	dstrides.v = (src_width + apitch) & ~apitch;
	apitch = priv->overlay_pitch_u - 1;
	dstrides.u = (src_width + apitch) & ~apitch;
/* 	st_image_bpp = 1; */
	break;
    case IMGFMT_RGB32:
    case IMGFMT_BGR32:
	apitch = priv->overlay_pitch_y - 1;
	dstrides.y = (src_width * 4 + apitch) & ~apitch;
	dstrides.u = dstrides.v = 0;
/* 	st_image_bpp = 4; */
	break;
    case IMGFMT_RGB24:
    case IMGFMT_BGR24:
	apitch = priv->overlay_pitch_y - 1;
	dstrides.y = (src_width * 3 + apitch) & ~apitch;
	dstrides.u = dstrides.v = 0;
/* 	st_image_bpp = 3; */
	break;
    default:
	apitch = priv->overlay_pitch_y - 1;
	dstrides.y = (src_width * 2 + apitch) & ~apitch;
	dstrides.u = dstrides.v = 0;
/* 	st_image_bpp = 2; */
	break;
    }

    if (format == IMGFMT_YV12 || format == IMGFMT_I420 || format == IMGFMT_IYUV) {
	switch (priv->current_rotate) {
	case 0:
	    video_out_w100.draw_slice = w100_draw_slice_420;
	    break;
	case 1:
	    break;
	case 2:
	    break;
	case 3:
	    video_out_w100.draw_slice = w100_draw_slice_420_rotate3;
	    break;
	default:
	    video_out_w100.draw_slice = w100_draw_slice_420;
	    break;
	}
    }
    /* 	else if (format == IMGFMT_YVU9 || format == IMGFMT_IF09) */
    /* 	    vo_server->draw_slice = w100_draw_slice_410; */
    else
	video_out_w100.draw_slice = w100_draw_slice_packed;

    if (!w100_setup(priv))
	return -1;

    return 0;
}

/*
 * Control interface
 */
static int control(uint32_t request, void *data, ...)
{
    w100_priv_t *priv = &st_w100_priv;
    switch (request) {
    case VOCTRL_GET_IMAGE:
	return w100_get_image(data);
    case VOCTRL_QUERY_FORMAT:
	return query_format(*((uint32_t *)data));
    case VOCTRL_SET_EQUALIZER:
      {
	va_list ap;
	int value;

	va_start(ap, data);
	value = va_arg(ap, int);
	va_end(ap);

	if (!strcasecmp(data, "brightness")) {
	    int br;
	    priv->eq_brightness = value * 10;
	    br = (priv->eq_brightness + 1000) * 127 / 2000;
	    if (br < 0)
		br = 0;
	    if (br > 127)
		br = 127;
	    if (br > 64)
		br -= 64;
	    else
		br += 64;
	    priv->display_brightness = br;

	    mp_msg(MSGT_VO, MSGL_V,
		   "vo_w100: control(VOCTRL_SET_EQUALIZER) %d %d\n",
		   value, br);

	    if (AtiCore_SetDisplayBrightness(priv->display_brightness))
		return VO_TRUE;
	    else
		return VO_FALSE;
	}
      }
    case VOCTRL_GET_EQUALIZER:
      {
	va_list ap;
	int *value;

	va_start(ap, data);
	value = va_arg(ap, int*);
	va_end(ap);

	if (!strcasecmp(data, "brightness")) {
	    *value = priv->eq_brightness;
	    return VO_TRUE;
	} else
	    return VO_FALSE;
      }
    }

    return VO_NOTIMPL;
}

/*
 * Display a new RGB/BGR frame of the video to the screen.
 * params:
 *   src[0] - pointer to the image
 */
int draw_frame(uint8_t *src[])
{
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: dummy draw_frame() was called\n");
    return -1;
}

/*
 * Draw a planar YUV slice to the buffer:
 * params:
 *   src[3] = source image planes (Y,U,V)
 *   stride[3] = source image planes line widths (in bytes)
 *   w,h = width*height of area to be copied (in Y pixels)
 *   x,y = position at the destination image (in Y pixels)
 */
int draw_slice(uint8_t *src[], int stride[], int w,int h, int x,int y)
{
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: dummy draw_slice() was called\n");
    return -1;
}


/*
 * Draws OSD to the screen buffer
 */
static void draw_osd(void)
{
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: draw_osd() was called\n");
    vo_draw_text(st_w100_priv.src_height, st_w100_priv.src_width, draw_alpha);
}

/*
 * Blit/Flip buffer to the screen. Must be called after each frame!
 */
void flip_page(void)
{
    w100_priv_t *priv = &st_w100_priv;

    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: flip_page() was called\n");
    if (vo_doublebuffering) {
	w100_set_yuv_addrs(priv, &priv->frame_offsets[priv->current_frame]);
	priv->current_frame = (priv->current_frame + 1) % priv->nframes;
    }
}

/*
 * This func is called after every frames to handle keyboard and
 * other events. It's called in PAUSE mode too!
 */
extern int g_sigcont;
void check_events(void)
{
    w100_priv_t *priv = &st_w100_priv;

    if (g_sigcont) {
	mp_msg(MSGT_VO, MSGL_INFO, "vo_w100: SIGCONT recived.\n");

	/* Immediately after resuming, because kernel modifies the register, it
	   waits for that. */
	usleep(1000 * 1000);

	/* re-attach */
#if 0
	/* Hmm... With respect to of context is necessary, but really it
	   fails. It does not release and also there is no problem. */
	if (!AtiCore_ReleaseOverlay(priv->overlay_handle)) {
	    mp_msg(MSGT_VO, MSGL_FATAL,
		   "vo_w100: AtiCore_ReleaseOverlay failed.\n");
	    exit_player(NULL);
	}
#endif
	if (!AtiCore_ProcessDetach()) {
	    mp_msg(MSGT_VO, MSGL_FATAL,
		   "vo_w100: AtiCore_ProcessDetach failed.\n");
	    exit_player(NULL);
	}
	if (!AtiCore_ProcessAttach()) {
	    mp_msg(MSGT_VO, MSGL_FATAL,
		   "vo_w100: AtiCore_ProcessAttach failed.\n");
	    exit_player(NULL);
	}

	/* re-setup */
	if (!w100_setup(priv))
	    exit_player(NULL);

	g_sigcont = 0;
    }
}

/*
 * Closes driver. Should restore the original state of the system.
 */
static void uninit(void)
{
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: uninit() was called\n");

    AtiCore_SetOverlayOnOff(st_w100_priv.overlay_handle, 0);
    AtiCore_ReleaseOverlay(st_w100_priv.overlay_handle);
    AtiCore_SetGraphicWindowOnOff(1);
    AtiCore_ProcessDetach();
}


// ----------------------------------------------------------------
static int query_format(uint32_t format)
{
    mp_msg(MSGT_VO, MSGL_V, "vo_w100: query_format was called: %x (%s)\n",
	   format, vo_format_name(format));

    if (IMGFMT_IS_RGB(format)) {
	/* RGB/BGR Formats */
	// TODO
	return 0;

	switch (IMGFMT_RGB_DEPTH(format)) {
	case 16:
	    return VFCAP_CSP_SUPPORTED | VFCAP_CSP_SUPPORTED_BY_HW
		| VFCAP_HWSCALE_UP | VFCAP_HWSCALE_DOWN | VFCAP_OSD | VFCAP_ACCEPT_STRIDE;
	    break;
	}
    } else {
	/* Planar YUV Formats */
	switch (format) {
	case IMGFMT_YV12:
	case IMGFMT_IYUV:
	case IMGFMT_I420:
	case IMGFMT_YVU9:
	case IMGFMT_IF09:
	case IMGFMT_Y8:
	case IMGFMT_Y800:
	    return VFCAP_CSP_SUPPORTED | VFCAP_CSP_SUPPORTED_BY_HW
		| VFCAP_HWSCALE_UP | VFCAP_HWSCALE_DOWN | VFCAP_OSD | VFCAP_ACCEPT_STRIDE;
	    break;
	}
    }

    return 0;
}

static void dump_vo_info(void)
{
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: ================================\n");
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_flags:%x\n", vo_flags);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_depthonscreen:%d\n", vo_depthonscreen);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_screenwidth:%d\n", vo_screenwidth);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_screenheight:%d\n", vo_screenheight);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_dx:%d\n", vo_dx);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_dy:%d\n", vo_dy);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_dwidth:%d\n", vo_dwidth);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_dheight:%d\n", vo_dheight);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_dbpp:%d\n", vo_dbpp);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_grabpointer:%d\n", vo_grabpointer);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_doublebuffering:%d\n", vo_doublebuffering);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_directrendering:%d\n", vo_directrendering);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_vsync:%d\n", vo_vsync);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_fs:%d\n", vo_fs);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_fsmode:%d\n", vo_fsmode);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_panscan:%f\n", vo_panscan);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_adapter_num:%d\n", vo_adapter_num);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_refresh_rate:%d\n", vo_refresh_rate);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_gamma_brightness:%d\n", vo_gamma_brightness);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_gamma_saturation:%d\n", vo_gamma_saturation);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_gamma_contrast:%d\n", vo_gamma_contrast);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_gamma_hue:%d\n", vo_gamma_hue);
/*     mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_gamma_red_intensity:%d\n", vo_gamma_red_intensity); */
/*     mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_gamma_green_intensity:%d\n", vo_gamma_green_intensity); */
/*     mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_gamma_blue_intensity:%d\n", vo_gamma_blue_intensity); */
/*     mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_mouse_timer_const:%d\n", vo_mouse_timer_const); */
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_nomouse_input:%d\n", vo_nomouse_input);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_pts:%d\n", vo_pts);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_fps:%f\n", vo_fps);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: vo_colorkey:%d\n", vo_colorkey);
    mp_msg(MSGT_VO, MSGL_DBG2, "vo_w100: ================================\n");
}
