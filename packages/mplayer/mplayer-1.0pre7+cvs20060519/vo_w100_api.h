/* -*- mode: c++; tab-width: 4 -*- */

/* $Id$ */

/*
 * Copyright (C) 2003-2004 AGAWA Koji <i (AT) atty (DOT) jp>
 *
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
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

/**
 * @file w100api.h
 * @brief 
 *
 * 
 *
 * @author AGAWA Koji
 * @date $Date$
 * @version $Revision$
 */

#ifndef W100API_H_INCLUDED
#define W100API_H_INCLUDED

#ifdef __cplusplus
# define EXTERN_C_BEGIN extern "C" {
# define EXTERN_C_END }
#else
# define EXTERN_C_BEGIN
# define EXTERN_C_END
#endif

EXTERN_C_BEGIN

#include <inttypes.h>

typedef int8_t s8;
typedef int16_t s16;
typedef int32_t s32;
typedef uint8_t u8;
typedef uint16_t u16;
typedef uint32_t u32;

#include "vo_w100_fb.h"

// DP_GUI_MASTER_CNTL.GMC_Dst_DataType
// DP_DATATYPE.Dp_Dst_DataType
/* #define DSTTYPE_8BPP            2       // 8 bpp grey scale */
/* #define DSTTYPE_16BPP_1555      3       //16 bpp aRGB 1555 */
/* #define DSTTYPE_16BPP_444       5       //16 bpp aRGB 4444 */
#define DSTTYPE_8BPP            1

// DP_GUI_MASTER_CNTL.GMC_Src_DataType
// DP_DATATYPE.Dp_Src_DataType
#define SRCTYPE_1BPP_OPA        0       //mono (expanded to frgd, bkgd)
#define SRCTYPE_1BPP_TRA        1       //mono (expanded to frgd, leave_alone)
#define SRCTYPE_EQU_DST         3       //color (same as DST)
#define SRCTYPE_SOLID_COLOR_BLT 4       //solid color for Blt (use frgd)
#define SRCTYPE_4BPP            5       //4 bpp
#define SRCTYPE_12BPP_PACKED    6       //12 bpp packed

#define ROP3_SRCCOPY            0xCC

#define OVLTYPE_YUV420          0x07

#define INTERNAL_VRAM 0
#define EXTERNAL_VRAM 1

#define VRAM_OFFSET_INTERNAL 0x00000000
#define VRAM_OFFSET_EXTERNAL 0x0F000000

typedef struct {
    /* 順序と型が未確定 */
    int16_t XCoord;
    int16_t YCoord;
} ATI_POINT;

typedef struct {
    /* 順序と型が未確定 */
    int16_t XCoord;
    int16_t YCoord;
    int16_t Width;
    int16_t Height;
} ATI_RECT;

typedef struct {
    /* 順序と型が未確定 */
    uint32_t Count;                        /* +0 */
    uint8_t ScaleXFactor;                 /* +4 確定 */
    uint8_t ScaleYFactor;                 /* +5 確定 */
    uint8_t BlendOn;                      /* +6 確定 */
    uint8_t dummy1;
} ATI_STRETCH;                          /* 8bytes? */

typedef struct {
    uint32_t *lpSrcBitmap;
    uint16_t XCoord;                      /* +4  確定 */
    uint16_t YCoord;                      /* +6  確定 */
    uint16_t SrcPitch;                    /* +8  確定 */
    uint16_t SrcHeight;                   /* +10 確定 */
    uint16_t OverlayWidth;
    uint16_t OverlayHeight;
    uint16_t *lpOverlayKey;                /* +16 確定 */
	// uint16_t key[2] へのポインタ
    uint8_t OverlayFormat;               /* +20 確定 */
    uint8_t dummy1;
    uint16_t dummy2;
} ATI_OVERLAYPROP;                      /* 24bytes? */

typedef struct {
    int HInvert;
    int VInvert;
} ATI_EXTVIDEOPROP;

typedef struct {
    ATI_EXTVIDEOPROP ExtVideoProp;
} ATI_UNKNOWN1;

typedef struct {
	ATI_UNKNOWN1 u1;			// こっち？
	uint8_t HExpansion;                   /* +8  確定 */
    uint8_t VExpansion;                   /* +9  確定 */
    uint8_t RConversion;                  /* +12 確定 */
/*     ATI_UNKNOWN1 x; */
} ATI_EXTENDEDOVERLAYPROP;              /* 16byte? */

/**
 * アクセラレーションの利用を開始する。
 *
 * @return              1:success, 0:fail
 */
int AtiCore_ProcessAttach(void);
int AtiCore_ProcessAttachSpecialMode(uint32_t);

/**
 * アクセラレーションの利用を終了する。
 *
 * @return              *不明*
 */
int AtiCore_ProcessDetach(void);

/**
 * サーフェスをビデオメモリ上に作成する。
 *
 * @arg     handle      (返値)サーフェスのハンドル
 * @arg     offset      (返値)サーフェスのオフセット
 * @arg     size        サーフェスのサイズ
 * @arg     direction   (0:低位から高位へ, 1:高位から低位へ)向かって確保
 * @return              1:success, 0:fail
 */
int AtiCore_AllocateSurface(uint16_t *handle, uint32_t *offset,
							uint32_t size, uint32_t direction);

/**
 * サーフェスを破棄する。
 *
 * @arg     handle      サーフェスのハンドル
 * @return              1:success, 0:fail
 */
int AtiCore_DestroySurface(uint16_t handle);

/*8
 * @param   rop         8ビットのフラグと思われる
 */
int AtiCore_SetRopOperation(uint32_t rop);

int AtiCore_SetDstType(uint32_t);
int AtiCore_SetSrcType(uint32_t);
int AtiCore_SetSrcClippingRect(ATI_CLIPRECT *cliprect);
int AtiCore_SetDstClippingRect(ATI_CLIPRECT *cliprect);
int AtiCore_SetSrcPitchOffset(int pitch, int offset);
int AtiCore_SetDstPitchOffset(int pitch, int offset);

int AtiCore_BitBltFilpRotate(int blt090Rotate,
                             ATI_RECT *dstRect, ATI_RECT *srcRect);
int AtiCore_StretchBlt(ATI_STRETCH *option,
                       ATI_POINT *point, ATI_RECT *srcRect);


/**
 * (BitBltなどの)処理が完了するのを待つ。
 *
 * @param   nsec        ウェイト時間(msec)
 * @return              1:処理が完了した, 0:処理はまだ終わっていない
 */
int AtiCore_WaitComplete(int msec);

/**
 * オーバレイを作成する。
 *
 * @param   handle      (返値)オーバレイのハンドル
 * @return              1:success, 0:fail
 */
int AtiCore_AllocOverlay(uint16_t *handle);

int AtiCore_ReleaseOverlay(uint16_t handle);

/**
 * @return              1:success, 0:fail
 */
int AtiCore_SetupOverlay(uint16_t handle, ATI_OVERLAYPROP *prop);

int AtiCore_SetupOverlayExtended(uint16_t handle, ATI_EXTENDEDOVERLAYPROP *prop);

/**
 * @return              1:success, 0:fail
 */
int AtiCore_SetOverlayOnOff(uint16_t handle, int isEnable);

int AtiCore_SetOverlayPos(uint16_t handle, uint16_t x, uint16_t y);

int AtiCore_SetupMemoryTransfer(uint32_t offset, void **regdata);
int AtiCore_TerminateMemoryTransfer(void);

int AtiCore_GetFrontBufferPitchOffset(uint32_t *pitch, uint32_t *offset);

/**
 * @return              1:success, 0:fail
 */
int AtiCore_SetDisplayBrightness(int brightness);

/**
 * @return              1:success, 0:fail
 */
int GetAvailableVideoMem(uint32_t *internal, uint32_t *external);

/*
 * 1 ; 0
 */
int AtiCore_SetGraphicWindowOnOff(int );

int AtiCore_ReadReg(uint32_t reg, void *val);
int AtiCore_WriteReg(uint32_t reg, void *val);

uint32_t GetRealMemAddr(uint32_t offset);

int AtiCore_SetBkgColour(uint32_t);

/* ================================================================ */
/* from libqte.so.2.3.2 */
/*
AtiCore_AlphaBlend
AtiCore_BitBlt
AtiCore_BrushType
AtiCore_CursorOnOff
AtiCore_DrawPixel
AtiCore_Flush
AtiCore_GammaCorrection
AtiCore_GetCRC
AtiCore_GetCursorPos
AtiCore_GetDeviceInfo
AtiCore_GetGPIO_Data
AtiCore_GetGraphicExtended
AtiCore_GetGraphicWindowPos
AtiCore_GetLargestVideoMemBlock
AtiCore_GetLastError
AtiCore_GetMultiCRC
AtiCore_GetOverlayPos
AtiCore_GetPitchOffsetProperty
AtiCore_Host
AtiCore_LoadCursorBitMap
AtiCore_PaintRect
AtiCore_PolyScanline
AtiCore_Polyline
AtiCore_ProcessAttachMinimal
AtiCore_ProcessAttachSpecialMode
AtiCore_ProcessDetachMinimal
AtiCore_ProcessDetachSpecialMode
AtiCore_ReadCfgReg
AtiCore_ScanlineShading
AtiCore_SetApertures
AtiCore_SetBkgColour
AtiCore_SetBytePixelOrder
AtiCore_SetCursorPos
AtiCore_SetDisplayParameters
AtiCore_SetDriverBehaviour
AtiCore_SetFrgColour
AtiCore_SetFrontBuffer
AtiCore_SetGPIO_Data
AtiCore_SetGraphicWindowPos
AtiCore_SetOverlayPosUsingGraphicWindowXY
AtiCore_SetPartialCursor
AtiCore_SetupGraphicExtended
AtiCore_SetupGraphicWindow
AtiCore_SetupPM4
AtiCore_SmallText
AtiCore_SubmitPM4Packet
AtiCore_TransBitBlt
AtiCore_WriteCfgReg
 */

EXTERN_C_END

#endif /* W100API_H_INCLUDED */
