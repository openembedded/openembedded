/*
 * linux/drivers/video/w100fb.h
 *
 * Frame Buffer Device for ATI w100 (Wallaby)
 *
 * Copyright (C) 2002, ATI Corp.
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
 * ChangeLog:
 *
 */

#if !defined (_W100FB_H)
#define _W100FB_H

/* Block CIF Start: */
#define mmCHIP_ID                                                    0x0000
#define mmREVISION_ID                                                0x0004
#define mmWRAP_BUF_A                                                 0x0008
#define mmWRAP_BUF_B                                                 0x000C
#define mmWRAP_TOP_DIR                                               0x0010
#define mmWRAP_START_DIR                                             0x0014
#define mmCIF_CNTL                                                   0x0018
#define mmCFGREG_BASE                                                0x001C
#define mmCIF_IO                                                     0x0020
#define mmCIF_READ_DBG                                               0x0024
#define mmCIF_WRITE_DBG                                              0x0028
#define cfgIND_ADDR_A_0                                              0x0000
#define cfgIND_ADDR_A_1                                              0x0001
#define cfgIND_ADDR_A_2                                              0x0002
#define cfgIND_DATA_A                                                0x0003
#define cfgREG_BASE                                                  0x0004
#define cfgINTF_CNTL                                                 0x0005
#define cfgSTATUS                                                    0x0006
#define cfgCPU_DEFAULTS                                              0x0007
#define cfgIND_ADDR_B_0                                              0x0008
#define cfgIND_ADDR_B_1                                              0x0009
#define cfgIND_ADDR_B_2                                              0x000A
#define cfgIND_DATA_B                                                0x000B
#define cfgPM4_RPTR                                                  0x000C
#define cfgSCRATCH                                                   0x000D
#define cfgPM4_WRPTR_0                                               0x000E
#define cfgPM4_WRPTR_1                                               0x000F
/* Block CIF End: */

/* Block CP Start: */
#define mmCP_RB_CNTL                                                 0x0210
#define mmCP_RB_BASE                                                 0x0214
#define mmCP_RB_RPTR_ADDR                                            0x0218
#define mmCP_RB_RPTR                                                 0x021C
#define mmCP_RB_RPTR_WR                                              0x02F8
#define mmCP_RB_WPTR                                                 0x0220
#define mmCP_IB_BASE                                                 0x0228
#define mmCP_IB_BUFSZ                                                0x022C
#define mmCP_CSQ_CNTL                                                0x0230
#define mmCP_CSQ_APER_PRIMARY                                        0x0300
#define mmCP_CSQ_APER_INDIRECT                                       0x0340
#define mmCP_ME_CNTL                                                 0x0240
#define mmCP_ME_RAM_ADDR                                             0x0244
#define mmCP_ME_RAM_RADDR                                            0x0248
#define mmCP_ME_RAM_DATAH                                            0x024C
#define mmCP_ME_RAM_DATAL                                            0x0250
#define mmCP_DEBUG                                                   0x025C
#define mmSCRATCH_REG0                                               0x0260
#define mmSCRATCH_REG1                                               0x0264
#define mmSCRATCH_REG2                                               0x0268
#define mmSCRATCH_REG3                                               0x026C
#define mmSCRATCH_REG4                                               0x0270
#define mmSCRATCH_REG5                                               0x0274
#define mmSCRATCH_UMSK                                               0x0280
#define mmSCRATCH_ADDR                                               0x0284
#define mmCP_CSQ_ADDR                                                0x02E4
#define mmCP_CSQ_DATA                                                0x02E8
#define mmCP_CSQ_STAT                                                0x02EC
#define mmCP_STAT                                                    0x02F0
#define mmGEN_INT_CNTL                                               0x0200
#define mmGEN_INT_STATUS                                             0x0204
/* Block CP End: */

/* Block DISPLAY Start: */
#define mmLCD_FORMAT                                                 0x0410
#define mmGRAPHIC_CTRL                                               0x0414
#define mmGRAPHIC_OFFSET                                             0x0418
#define mmGRAPHIC_PITCH                                              0x041C
#define mmCRTC_TOTAL                                                 0x0420
#define mmACTIVE_H_DISP                                              0x0424
#define mmACTIVE_V_DISP                                              0x0428
#define mmGRAPHIC_H_DISP                                             0x042C
#define mmGRAPHIC_V_DISP                                             0x0430
#define mmVIDEO_CTRL                                                 0x0434
#define mmGRAPHIC_KEY                                                0x0438
#define mmVIDEO_Y_OFFSET                                             0x043C
#define mmVIDEO_Y_PITCH                                              0x0440
#define mmVIDEO_U_OFFSET                                             0x0444
#define mmVIDEO_U_PITCH                                              0x0448
#define mmVIDEO_V_OFFSET                                             0x044C
#define mmVIDEO_V_PITCH                                              0x0450
#define mmVIDEO_H_POS                                                0x0454
#define mmVIDEO_V_POS                                                0x0458
#define mmBRIGHTNESS_CNTL                                            0x045C
#define mmCURSOR1_OFFSET                                             0x0460
#define mmCURSOR1_H_POS                                              0x0464
#define mmCURSOR1_V_POS                                              0x0468
#define mmCURSOR1_COLOR0                                             0x046C
#define mmCURSOR1_COLOR1                                             0x0470
#define mmCURSOR2_OFFSET                                             0x0474
#define mmCURSOR2_H_POS                                              0x0478
#define mmCURSOR2_V_POS                                              0x047C
#define mmCURSOR2_COLOR0                                             0x0480
#define mmCURSOR2_COLOR1                                             0x0484
#define mmDISP_INT_CNTL                                              0x0488
#define mmCRTC_SS                                                    0x048C
#define mmCRTC_LS                                                    0x0490
#define mmCRTC_REV                                                   0x0494
#define mmCRTC_DCLK                                                  0x049C
#define mmCRTC_GS                                                    0x04A0
#define mmCRTC_VPOS_GS                                               0x04A4
#define mmCRTC_GCLK                                                  0x04A8
#define mmCRTC_GOE                                                   0x04AC
#define mmCRTC_FRAME                                                 0x04B0
#define mmCRTC_FRAME_VPOS                                            0x04B4
#define mmGPIO_DATA                                                  0x04B8
#define mmGPIO_CNTL1                                                 0x04BC
#define mmGPIO_CNTL2                                                 0x04C0
#define mmLCDD_CNTL1                                                 0x04C4
#define mmLCDD_CNTL2                                                 0x04C8
#define mmGENLCD_CNTL1                                               0x04CC
#define mmGENLCD_CNTL2                                               0x04D0
#define mmDISP_DEBUG                                                 0x04D4
#define mmDISP_DB_BUF_CNTL                                           0x04D8
#define mmDISP_CRC_SIG                                               0x04DC
#define mmCRTC_DEFAULT_COUNT                                         0x04E0
#define mmLCD_BACKGROUND_COLOR                                       0x04E4
#define mmCRTC_PS2                                                   0x04E8
#define mmCRTC_PS2_VPOS                                              0x04EC
#define mmCRTC_PS1_ACTIVE                                            0x04F0
#define mmCRTC_PS1_NACTIVE                                           0x04F4
#define mmCRTC_GCLK_EXT                                              0x04F8
#define mmCRTC_ALW                                                   0x04FC
#define mmCRTC_ALW_VPOS                                              0x0500
#define mmCRTC_PSK                                                   0x0504
#define mmCRTC_PSK_HPOS                                              0x0508
#define mmCRTC_CV4_START                                             0x050C
#define mmCRTC_CV4_END                                               0x0510
#define mmCRTC_CV4_HPOS                                              0x0514
#define mmCRTC_ECK                                                   0x051C
#define mmREFRESH_CNTL                                               0x0520
#define mmGENLCD_CNTL3                                               0x0524
#define mmGPIO_DATA2                                                 0x0528
#define mmGPIO_CNTL3                                                 0x052C
#define mmGPIO_CNTL4                                                 0x0530
#define mmCHIP_STRAP                                                 0x0534
#define mmDISP_DEBUG2                                                0x0538
#define mmDEBUG_BUS_CNTL                                             0x053C
#define mmGAMMA_VALUE1                                               0x0540
#define mmGAMMA_VALUE2                                               0x0544
#define mmGAMMA_SLOPE                                                0x0548
#define mmGEN_STATUS                                                 0x054C
#define mmHW_INT                                                     0x0550
/* Block DISPLAY End: */

/* Block GFX Start: */
#define mmDST_OFFSET                                                 0x1004
#define mmDST_PITCH                                                  0x1008
#define mmDST_PITCH_OFFSET                                           0x102C
#define mmDST_X                                                      0x101C
#define mmDST_Y                                                      0x1020
#define mmDST_X_Y                                                    0x1194
#define mmDST_Y_X                                                    0x1038
#define mmDST_WIDTH                                                  0x100C
#define mmDST_HEIGHT                                                 0x1010
#define mmDST_WIDTH_HEIGHT                                           0x1198
#define mmDST_HEIGHT_WIDTH                                           0x103C
#define mmDST_HEIGHT_WIDTH_8                                         0x118C
#define mmDST_HEIGHT_Y                                               0x11A0
#define mmDST_WIDTH_X                                                0x1188
#define mmDST_WIDTH_X_INCY                                           0x119C
#define mmDST_LINE_START                                             0x1090
#define mmDST_LINE_END                                               0x1094
#define mmBRUSH_OFFSET                                               0x108C
#define mmBRUSH_Y_X                                                  0x1074
#define mmDP_BRUSH_FRGD_CLR                                          0x107C
#define mmDP_BRUSH_BKGD_CLR                                          0x1078
#define mmSRC2_OFFSET                                                0x1060
#define mmSRC2_PITCH                                                 0x1064
#define mmSRC2_PITCH_OFFSET                                          0x1068
#define mmSRC2_X                                                     0x1050
#define mmSRC2_Y                                                     0x1054
#define mmSRC2_X_Y                                                   0x1058
#define mmSRC2_WIDTH                                                 0x1080
#define mmSRC2_HEIGHT                                                0x1084
#define mmSRC2_INC                                                   0x1088
#define mmSRC_OFFSET                                                 0x11AC
#define mmSRC_PITCH                                                  0x11B0
#define mmSRC_PITCH_OFFSET                                           0x1028
#define mmSRC_X                                                      0x1014
#define mmSRC_Y                                                      0x1018
#define mmSRC_X_Y                                                    0x1190
#define mmSRC_Y_X                                                    0x1034
#define mmSRC_WIDTH                                                  0x1040
#define mmSRC_HEIGHT                                                 0x1044
#define mmSRC_INC                                                    0x1048
#define mmHOST_DATA0                                                 0x13C0
#define mmHOST_DATA1                                                 0x13C4
#define mmHOST_DATA2                                                 0x13C8
#define mmHOST_DATA3                                                 0x13CC
#define mmHOST_DATA4                                                 0x13D0
#define mmHOST_DATA5                                                 0x13D4
#define mmHOST_DATA6                                                 0x13D8
#define mmHOST_DATA7                                                 0x13DC
#define mmHOST_DATA_LAST                                             0x13E0
#define mmDP_SRC_FRGD_CLR                                            0x1240
#define mmDP_SRC_BKGD_CLR                                            0x1244
#define mmSC_LEFT                                                    0x1140
#define mmSC_RIGHT                                                   0x1144
#define mmSC_TOP                                                     0x1148
#define mmSC_BOTTOM                                                  0x114C
#define mmSRC_SC_RIGHT                                               0x1154
#define mmSRC_SC_BOTTOM                                              0x115C
#define mmDP_CNTL                                                    0x11C8
#define mmDP_CNTL_DST_DIR                                            0x11CC
#define mmDP_DATATYPE                                                0x12C4
#define mmDP_MIX                                                     0x12C8
#define mmDP_WRITE_MSK                                               0x12CC
#define mmCLR_CMP_CLR_SRC                                            0x1234
#define mmCLR_CMP_CLR_DST                                            0x1238
#define mmCLR_CMP_CNTL                                               0x1230
#define mmCLR_CMP_MSK                                                0x123C
#define mmDEFAULT_PITCH_OFFSET                                       0x10A0
#define mmDEFAULT_SC_BOTTOM_RIGHT                                    0x10A8
#define mmDEFAULT2_SC_BOTTOM_RIGHT                                   0x10AC
#define mmREF1_PITCH_OFFSET                                          0x10B8
#define mmREF2_PITCH_OFFSET                                          0x10BC
#define mmREF3_PITCH_OFFSET                                          0x10C0
#define mmREF4_PITCH_OFFSET                                          0x10C4
#define mmREF5_PITCH_OFFSET                                          0x10C8
#define mmREF6_PITCH_OFFSET                                          0x10CC
#define mmDP_GUI_MASTER_CNTL                                         0x106C
#define mmSC_TOP_LEFT                                                0x11BC
#define mmSC_BOTTOM_RIGHT                                            0x11C0
#define mmSRC_SC_BOTTOM_RIGHT                                        0x11C4
#define mmGLOBAL_ALPHA                                               0x1210
#define mmFILTER_COEF                                                0x1214
#define mmMVC_CNTL_START                                             0x11E0
#define mmE2_ARITHMETIC_CNTL                                         0x1220
#define mmDEBUG0                                                     0x1280
#define mmDEBUG1                                                     0x1284
#define mmDEBUG2                                                     0x1288
#define mmDEBUG3                                                     0x128C
#define mmDEBUG4                                                     0x1290
#define mmDEBUG5                                                     0x1294
#define mmDEBUG6                                                     0x1298
#define mmDEBUG7                                                     0x129C
#define mmDEBUG8                                                     0x12A0
#define mmDEBUG9                                                     0x12A4
#define mmDEBUG10                                                    0x12A8
#define mmDEBUG11                                                    0x12AC
#define mmDEBUG12                                                    0x12B0
#define mmDEBUG13                                                    0x12B4
#define mmDEBUG14                                                    0x12B8
#define mmDEBUG15                                                    0x12BC
#define mmENG_CNTL                                                   0x13E8
#define mmENG_PERF_CNT                                               0x13F0
/* Block GFX End: */

/* Block IDCT Start: */
#define mmIDCT_RUNS                                                  0x0C00
#define mmIDCT_LEVELS                                                0x0C04
#define mmIDCT_CONTROL                                               0x0C3C
#define mmIDCT_AUTH_CONTROL                                          0x0C08
#define mmIDCT_AUTH                                                  0x0C0C
/* Block IDCT End: */

/* Block MC Start: */
#define mmMEM_CNTL                                                   0x0180
#define mmMEM_ARB                                                    0x0184
#define mmMC_FB_LOCATION                                             0x0188
#define mmMEM_EXT_CNTL                                               0x018C
#define mmMC_EXT_MEM_LOCATION                                        0x0190
#define mmMEM_EXT_TIMING_CNTL                                        0x0194
#define mmMEM_SDRAM_MODE_REG                                         0x0198
#define mmMEM_IO_CNTL                                                0x019C
#define mmMC_DEBUG                                                   0x01A0
#define mmMC_BIST_CTRL                                               0x01A4
#define mmMC_BIST_COLLAR_READ                                        0x01A8
#define mmTC_MISMATCH                                                0x01AC
#define mmMC_PERF_MON_CNTL                                           0x01B0
#define mmMC_PERF_COUNTERS                                           0x01B4
/* Block MC End: */

/* Block RBBM Start: */
#define mmWAIT_UNTIL                                                 0x1400
#define mmISYNC_CNTL                                                 0x1404
#define mmRBBM_GUICNTL                                               0x1408
#define mmRBBM_STATUS                                                0x0140
#define mmRBBM_STATUS_alt_1                                          0x140C
#define mmRBBM_CNTL                                                  0x0144
#define mmRBBM_SOFT_RESET                                            0x0148
#define mmNQWAIT_UNTIL                                               0x0150
#define mmRBBM_DEBUG                                                 0x016C
#define mmRBBM_CMDFIFO_ADDR                                          0x0170
#define mmRBBM_CMDFIFO_DATAL                                         0x0174
#define mmRBBM_CMDFIFO_DATAH                                         0x0178
#define mmRBBM_CMDFIFO_STAT                                          0x017C
/* Block RBBM End: */

/* Block CG Start: */
#define mmCLK_PIN_CNTL                                               0x0080
#define mmPLL_REF_FB_DIV                                             0x0084
#define mmPLL_CNTL                                                   0x0088
#define mmSCLK_CNTL                                                  0x008C
#define mmPCLK_CNTL                                                  0x0090
#define mmCLK_TEST_CNTL                                              0x0094
#define mmPWRMGT_CNTL                                                0x0098
#define mmPWRMGT_STATUS                                              0x009C
/* Block CG End: */

/* default value definitions */
#define defCHIP_ID                        0x00001002
#define defREVISION_ID                    0x00000000
#define defWRAP_BUF_A                     0x01000000
#define defWRAP_BUF_B                     0x01000000
#define defWRAP_TOP_DIR                   0x00000000
#define defWRAP_START_DIR                 0x00000000
//#define defCIF_CNTL                       0x00082900
#define defCIF_CNTL                       0x00182d00		//??updated by Tobey Z.for Sharp,Oct11,2002
#define defCFGREG_BASE                    0x00000000
//#define defCIF_IO                         0x000c0800
#define defCIF_IO                         0x000C0902		//??updated by Tobey Z.for Sharp,Oct11,2002
#define defCIF_READ_DBG                   0x00018223
#define defCIF_WRITE_DBG                  0x00002100
#define defIND_ADDR_A_0                   0x00000000
#define defIND_ADDR_A_1                   0x00000000
#define defIND_ADDR_A_2                   0x00000000
#define defIND_DATA_A                     0x00000000
#define defREG_BASE                       0x00000001
#define defINTF_CNTL                      0x00000011
#define defSTATUS                         0x00000000
#define defCPU_DEFAULTS                   0x00000006
#define defIND_ADDR_B_0                   0x00000000
#define defIND_ADDR_B_1                   0x00000000
#define defIND_ADDR_B_2                   0x00000000
#define defIND_DATA_B                     0x00000000
#define defPM4_RPTR                       0x00000000
#define defSCRATCH                        0x00000000
#define defPM4_WRPTR_0                    0x00000000
#define defPM4_WRPTR_1                    0x00000000
#define defCP_RB_CNTL                     0x00000000
#define defCP_RB_BASE                     0x00000000
#define defCP_RB_RPTR_ADDR                0x00000000
#define defCP_RB_RPTR                     0x00000000
#define defCP_RB_RPTR_WR                  0x00000000
#define defCP_RB_WPTR                     0x00000000
#define defCP_IB_BASE                     0x00000000
#define defCP_IB_BUFSZ                    0x00000000
#define defCP_CSQ_CNTL                    0x00000000
#define defCP_CSQ_APER_PRIMARY            0x00000000
#define defCP_CSQ_APER_INDIRECT           0x00000000
#define defCP_ME_CNTL                     0x40000000
#define defCP_ME_RAM_ADDR                 0x00000000
#define defCP_ME_RAM_RADDR                0x00000000
#define defCP_ME_RAM_DATAH                0x00000000
#define defCP_ME_RAM_DATAL                0x00000000
#define defCP_DEBUG                       0x00000000
#define defSCRATCH_REG0                   0x00000000
#define defSCRATCH_REG1                   0x00000000
#define defSCRATCH_REG2                   0x00000000
#define defSCRATCH_REG3                   0x00000000
#define defSCRATCH_REG4                   0x00000000
#define defSCRATCH_REG5                   0x00000000
#define defSCRATCH_UMSK                   0x00000000
#define defSCRATCH_ADDR                   0x00000000
#define defCP_CSQ_ADDR                    0x00000000
#define defCP_CSQ_DATA                    0x00000000
#define defCP_CSQ_STAT                    0x00000000
#define defCP_STAT                        0x00000000
#define defGEN_INT_CNTL                   0x00000000
#define defGEN_INT_STATUS_rd              0x00080000
#define defGEN_INT_STATUS_wr              0x00000000
#define defLCD_FORMAT                     0x00000000
#define defGRAPHIC_CTRL                   0x00000000
#define defGRAPHIC_OFFSET                 0x00000000
#define defGRAPHIC_PITCH                  0x00000000
#define defCRTC_TOTAL                     0x00000000
#define defACTIVE_H_DISP                  0x00000000
#define defACTIVE_V_DISP                  0x00000000
#define defGRAPHIC_H_DISP                 0x00000000
#define defGRAPHIC_V_DISP                 0x00000000
#define defVIDEO_CTRL                     0x00000000
#define defGRAPHIC_KEY                    0x00000000
#define defVIDEO_Y_OFFSET                 0x00000000
#define defVIDEO_Y_PITCH                  0x00000000
#define defVIDEO_U_OFFSET                 0x00000000
#define defVIDEO_U_PITCH                  0x00000000
#define defVIDEO_V_OFFSET                 0x00000000
#define defVIDEO_V_PITCH                  0x00000000
#define defVIDEO_H_POS                    0x00000000
#define defVIDEO_V_POS                    0x00000000
#define defBRIGHTNESS_CNTL                0x00000000
#define defCURSOR1_OFFSET                 0x00000000
#define defCURSOR1_H_POS                  0x00000000
#define defCURSOR1_V_POS                  0x00000000
#define defCURSOR1_COLOR0                 0x00000000
#define defCURSOR1_COLOR1                 0x00000000
#define defCURSOR2_OFFSET                 0x00000000
#define defCURSOR2_H_POS                  0x00000000
#define defCURSOR2_V_POS                  0x00000000
#define defCURSOR2_COLOR0                 0x00000000
#define defCURSOR2_COLOR1                 0x00000000
#define defDISP_INT_CNTL                  0x00000000
#define defCRTC_SS                        0x00000000
#define defCRTC_LS                        0x00000000
#define defCRTC_REV                       0x00000000
#define defCRTC_DCLK                      0x00000000
#define defCRTC_GS                        0x00000000
#define defCRTC_VPOS_GS                   0x00000000
#define defCRTC_GCLK                      0x00000000
#define defCRTC_GOE                       0x00000000
#define defCRTC_FRAME                     0x00000000
#define defCRTC_FRAME_VPOS                0x00000000
#define defGPIO_DATA                      0x00000000
#define defGPIO_CNTL1                     0xff00ff00
#define defGPIO_CNTL2                     0x00000000
#define defLCDD_CNTL1                     0x0000ffff
#define defLCDD_CNTL2                     0x00000000
#define defGENLCD_CNTL1                   0x00aaa002
#define defGENLCD_CNTL2                   0x00000002
#define defDISP_DEBUG                     0x00000000
#define defDISP_DB_BUF_CNTL_rd            0x00000000
#define defDISP_DB_BUF_CNTL_wr            0x00000000
#define defDISP_CRC_SIG                   0x00000000
#define defCRTC_DEFAULT_COUNT             0x00000000
#define defLCD_BACKGROUND_COLOR           0x00000000
#define defCRTC_PS2                       0x00000000
#define defCRTC_PS2_VPOS                  0x00000000
#define defCRTC_PS1_ACTIVE                0x00000000
#define defCRTC_PS1_NACTIVE               0x00000000
#define defCRTC_GCLK_EXT                  0x00000000
#define defCRTC_ALW                       0x00000000
#define defCRTC_ALW_VPOS                  0x00000000
#define defCRTC_PSK                       0x00000000
#define defCRTC_PSK_HPOS                  0x00000000
#define defCRTC_CV4_START                 0x00000000
#define defCRTC_CV4_END                   0x00000000
#define defCRTC_CV4_HPOS                  0x00000000
#define defCRTC_ECK                       0x00000000
#define defREFRESH_CNTL                   0x00000000
#define defGENLCD_CNTL3                   0x000002aa
#define defGPIO_DATA2                     0x00000000
#define defGPIO_CNTL3                     0x00000000
#define defGPIO_CNTL4                     0x00000000
#define defCHIP_STRAP                     0x00000000
#define defDISP_DEBUG2                    0x00000000
#define defDEBUG_BUS_CNTL                 0x00000000
#define defGAMMA_VALUE1                   0x00000000
#define defGAMMA_VALUE2                   0x00000000
#define defGAMMA_SLOPE                    0x00000000
#define defGEN_STATUS                     0x00000000
#define defHW_INT                         0x00000000
#define defDST_OFFSET                     0x00000000
#define defDST_PITCH                      0x00000000
#define defDST_PITCH_OFFSET               0x00000000
#define defDST_X                          0x00000000
#define defDST_Y                          0x00000000
#define defDST_X_Y                        0x00000000
#define defDST_Y_X                        0x00000000
#define defDST_WIDTH                      0x00000000
#define defDST_HEIGHT                     0x00000000
#define defDST_WIDTH_HEIGHT               0x00000000
#define defDST_HEIGHT_WIDTH               0x00000000
#define defDST_HEIGHT_WIDTH_8             0x00000000
#define defDST_HEIGHT_Y                   0x00000000
#define defDST_WIDTH_X                    0x00000000
#define defDST_WIDTH_X_INCY               0x00000000
#define defDST_LINE_START                 0x00000000
#define defDST_LINE_END                   0x00000000
#define defBRUSH_OFFSET                   0x00000000
#define defBRUSH_Y_X                      0x00000000
#define defDP_BRUSH_FRGD_CLR              0x00000000
#define defDP_BRUSH_BKGD_CLR              0x00000000
#define defSRC2_OFFSET                    0x00000000
#define defSRC2_PITCH                     0x00000000
#define defSRC2_PITCH_OFFSET              0x00000000
#define defSRC2_X                         0x00000000
#define defSRC2_Y                         0x00000000
#define defSRC2_X_Y                       0x00000000
#define defSRC2_WIDTH                     0x00000000
#define defSRC2_HEIGHT                    0x00000000
#define defSRC2_INC                       0x00000000
#define defSRC_OFFSET                     0x00000000
#define defSRC_PITCH                      0x00000000
#define defSRC_PITCH_OFFSET               0x00000000
#define defSRC_X                          0x00000000
#define defSRC_Y                          0x00000000
#define defSRC_X_Y                        0x00000000
#define defSRC_Y_X                        0x00000000
#define defSRC_WIDTH                      0x00000000
#define defSRC_HEIGHT                     0x00000000
#define defSRC_INC                        0x00000000
#define defHOST_DATA0                     0x00000000
#define defHOST_DATA1                     0x00000000
#define defHOST_DATA2                     0x00000000
#define defHOST_DATA3                     0x00000000
#define defHOST_DATA4                     0x00000000
#define defHOST_DATA5                     0x00000000
#define defHOST_DATA6                     0x00000000
#define defHOST_DATA7                     0x00000000
#define defHOST_DATA_LAST                 0x00000000
#define defDP_SRC_FRGD_CLR                0x00000000
#define defDP_SRC_BKGD_CLR                0x00000000
#define defSC_LEFT                        0x00000000
#define defSC_RIGHT                       0x00000000
#define defSC_TOP                         0x00000000
#define defSC_BOTTOM                      0x00000000
#define defSRC_SC_RIGHT                   0x00000000
#define defSRC_SC_BOTTOM                  0x00000000
#define defDP_CNTL                        0x00000000
#define defDP_CNTL_DST_DIR                0x00000000
#define defDP_DATATYPE                    0x00000000
#define defDP_MIX                         0x00000000
#define defDP_WRITE_MSK                   0x00000000
#define defCLR_CMP_CLR_SRC                0x00000000
#define defCLR_CMP_CLR_DST                0x00000000
#define defCLR_CMP_CNTL                   0x00000000
#define defCLR_CMP_MSK                    0x00000000
#define defDEFAULT_PITCH_OFFSET           0x00000000
#define defDEFAULT_SC_BOTTOM_RIGHT        0x00000000
#define defDEFAULT2_SC_BOTTOM_RIGHT       0x00000000
#define defREF1_PITCH_OFFSET              0x00000000
#define defREF2_PITCH_OFFSET              0x00000000
#define defREF3_PITCH_OFFSET              0x00000000
#define defREF4_PITCH_OFFSET              0x00000000
#define defREF5_PITCH_OFFSET              0x00000000
#define defREF6_PITCH_OFFSET              0x00000000
#define defDP_GUI_MASTER_CNTL             0x00000000
#define defSC_TOP_LEFT                    0x00000000
#define defSC_BOTTOM_RIGHT                0x00000000
#define defSRC_SC_BOTTOM_RIGHT            0x00000000
#define defGLOBAL_ALPHA                   0x00000000
#define defFILTER_COEF                    0x00000000
#define defMVC_CNTL_START                 0x00000000
#define defE2_ARITHMETIC_CNTL             0x00000000
#define defDEBUG0                         0x00000000
#define defDEBUG1                         0x00000000
#define defDEBUG2                         0x00000000
#define defDEBUG3                         0x00000000
#define defDEBUG4                         0x00000000
#define defDEBUG5                         0x00000000
#define defDEBUG6                         0x00000000
#define defDEBUG7                         0x00000000
#define defDEBUG8                         0x00000000
#define defDEBUG9                         0x00000000
#define defDEBUG10                        0x00000000
#define defDEBUG11                        0x00000000
#define defDEBUG12                        0x00000000
#define defDEBUG13                        0x00000000
#define defDEBUG14                        0x00000000
#define defDEBUG15                        0x00000000
#define defENG_CNTL                       0x00000003
#define defENG_PERF_CNT                   0x00000000
#define defIDCT_RUNS                      0x00000000
#define defIDCT_LEVELS                    0x00000000
#define defIDCT_CONTROL                   0x00000000
#define defIDCT_AUTH_CONTROL              0x00000000
#define defIDCT_AUTH                      0x00000000
#define defMEM_CNTL                       0x00000006
#define defMEM_ARB                        0x00000000
#define defMC_FB_LOCATION                 0x00ff0000
#define defMEM_EXT_CNTL                   0x00040010
#define defMC_EXT_MEM_LOCATION            0x07ff0000
#define defMEM_EXT_TIMING_CNTL            0x00140c73
#define defMEM_SDRAM_MODE_REG             0x00050000
#define defMEM_IO_CNTL                    0x00ff00ff
#define defMC_DEBUG                       0x00000000
#define defMC_BIST_CTRL                   0x00000000
#define defMC_BIST_COLLAR_READ            0x00000000
#define defTC_MISMATCH                    0x00000000
#define defMC_PERF_MON_CNTL               0x00000000
#define defMC_PERF_COUNTERS               0x00000000
#define defWAIT_UNTIL                     0xc5cdcdcd
#define defISYNC_CNTL                     0x00000000
#define defRBBM_GUICNTL                   0x00000000
#define defRBBM_STATUS                    0x81cdcd40
#define defRBBM_CNTL                      0x0000000f
#define defRBBM_SOFT_RESET                0x00000000
#define defNQWAIT_UNTIL                   0x00000001
#define defRBBM_DEBUG                     0x00000000
#define defRBBM_CMDFIFO_ADDR              0x0000000d
#define defRBBM_CMDFIFO_DATAL             0xcdcdcdcd
#define defRBBM_CMDFIFO_DATAH             0x00000dcd
#define defRBBM_CMDFIFO_STAT              0x00000d0d
#define defCLK_PIN_CNTL                   0x0000003f
#define defPLL_REF_FB_DIV                 0x5a500000
#define defPLL_CNTL                       0x4b000203
#define defSCLK_CNTL                      0x00ff0300
#define defPCLK_CNTL                      0x00010000
#define defCLK_TEST_CNTL                  0x00000000
#define defPWRMGT_CNTL                    0x00000004
#define defPWRMGT_STATUS                  0x00000001

#define CFG_BASE_BOOT_DEFAULT  0x0
#define CFG_BASE_VALUE         0x0
#define REG_BASE_BOOT_DEFAULT  0x01
#define REG_BASE_VALUE         0x10000
#define MEM_INT_BASE_VALUE     0x100000
#define MEM_INT_TOP_VALUE_W100 0x15ffff
#define MEM_EXT_BASE_VALUE     0x800000
#define MEM_EXT_TOP_VALUE      0x9fffff
#define WRAP_BUF_BASE_VALUE    0x80000
#define WRAP_BUF_TOP_VALUE     0xbffff

//----------------------------------------------------------------------------
// Registers Field Definitions

// DP_GUI_MASTER_CNTL.GMC_Brush_DataType
// DP_DATATYPE.Brush_DataType
#define DP_BRUSH_8x8MONOOPA			0   //8x8 mono pattern (expanded to frgd, bkgd)
#define DP_BRUSH_8x8MONOTRA			1   //8x8 mono pattern (expanded to frgd, leave_alone)
#define DP_PEN_32x1MONOOPA			6   //32x1 mono pattern (expanded to frgd, bkgd)
#define DP_PEN_32x1MONOTRA			7   //32x1 mono pattern (expanded to frgd, leave_alone)
#define DP_BRUSH_8x8COLOR			10  //8x8 color pattern
#define DP_BRUSH_SOLIDCOLOR			13  //solid color pattern (frgd)
#define DP_BRUSH_NONE				15	//no brush used

#define SIZE_BRUSH_8x8MONO			2
#define SIZE_PEN_32x1MONO			1
#define SIZE_BRUSH_8x8COLOR_8		16
#define SIZE_BRUSH_8x8COLOR_16		32
#define MAX_BRUSH_SIZE				SIZE_BRUSH_8x8COLOR_16

// DP_GUI_MASTER_CNTL.GMC_Dst_DataType
// DP_DATATYPE.Dp_Dst_DataType
#define DP_DST_8BPP					2   // 8 bpp grey scale
#define DP_DST_16BPP_1555			3   //16 bpp aRGB 1555
#define DP_DST_16BPP_444			5   //16 bpp aRGB 4444

// DP_GUI_MASTER_CNTL.GMC_Src_DataType
// DP_DATATYPE.Dp_Src_DataType
#define DP_SRC_1BPP_OPA				0   //mono (expanded to frgd, bkgd)
#define DP_SRC_1BPP_TRA				1   //mono (expanded to frgd, leave_alone)
#define DP_SRC_COLOR_SAME_AS_DST				3   //color (same as DST)
#define	DP_SRC_SOLID_COLOR_BLT		4	//solid color for Blt (use frgd)
#define	DP_SRC_4BPP					5	//4 bpp
#define	DP_SRC_12BPP_PACKED			6	//12 bpp packed

// DP_GUI_MASTER_CNTL.GMC_Byte_Pix_Order
// DP_DATATYPE.Dp_Byte_Pix_Order
#define DP_PIX_ORDER_MSB2LSB		0   //monochrome pixel order from MSBit to LSBit
#define DP_PIX_ORDER_LSB2MSB		1   //monochrome pixel order from LSBit to MSBit

// DP_GUI_MASTER_CNTL.GMC_Dp_Src_Source
#define DP_SRC_MEM_LINEAR			1	//loaded from memory (linear trajectory)
#define DP_SRC_MEM_RECTANGULAR		2   //loaded from memory (rectangular trajectory)
#define DP_SRC_HOSTDATA_BIT			3   //loaded from hostdata (linear trajectory)
#define DP_SRC_HOSTDATA_BYTE		4   //loaded from hostdata (linear trajectory & byte-aligned)

// DP_GUI_MASTER_CNTL.GMC_Dp_Op
#define	DP_OP_ROP					0
#define	DP_OP_ARITHMETIC			1

// E2_ARITHMETIC_CNTL.opcode
#define	E2_OPC_GLBALP_ADD_SRC2		0
#define	E2_OPC_GLBALP_SUB_SRC2		1
#define	E2_OPC_SRC1_ADD_SRC2		2
#define	E2_OPC_SRC1_SUB_SRC2		3
#define	E2_OPC_DST_SADDBLEND_SRC2	4
#define	E2_OPC_DST_CADDBLEND_SRC2	5
#define	E2_OPC_DST_CSUBBLEND_SRC2	6
#define	E2_OPC_LF_SRC2				7
#define	E2_OPC_SCALE_SRC2			8
#define	E2_OPC_STRETCH_SRC2			9
#define	E2_OPC_SRC1_4BPPCPYWEXP		10
#define	E2_OPC_MC1					11
#define	E2_OPC_MC2					12
#define E2_OPC_MC1_IDCT				13
#define	E2_OPC_MC2_IDCT				14
#define	E2_OPC_IDCT_ONLY_IFRAME		15

// E2_ARITHMETIC_CNTL.clamp
#define	E2_CLAMP_OFF				0
#define	E2_CLAMP_ON					1

// E2_ARITHMETIC_CNTL.rounding
#define	E2_ROUNDING_TRUNCATE		0
#define	E2_ROUNDING_TO_INFINITY		1

// E2_ARITHMETIC_CNTL.srcblend
#define	E2_SRCBLEND_GLOBALALPHA		0
#define	E2_SRCBLEND_ZERO			1
#define	E2_SRCBLEND_SRC2ALPHA		2
#define	E2_SRCBLEND_DSTALPHA		3
#define	E2_SRCBLEND_ALPHA1PLANE		4

// E2_ARITHMETIC_CNTL.destblend
#define	E2_DSTBLEND_GLOBALALPHA		0
#define	E2_DSTBLEND_ZERO			1
#define	E2_DSTBLEND_SRC2ALPHA		2
#define	E2_DSTBLEND_DSTALPHA		3
#define	E2_DSTBLEND_ALPHA1PLANE		4

// LCD_FORMAT.lcd_type
#define	LCDTYPE_TFT333				0
#define	LCDTYPE_TFT444				1
#define	LCDTYPE_TFT555				2
#define	LCDTYPE_TFT666				3
#define	LCDTYPE_COLSTNPACK4			4
#define	LCDTYPE_COLSTNPACK8F1		5
#define	LCDTYPE_COLSTNPACK8F2		6
#define	LCDTYPE_COLSTNPACK16		7
#define	LCDTYPE_MONSTNPACK4			8
#define	LCDTYPE_MONSTNPACK8			9

// CP_RB_CNTL.rb_bufsz
#define	RB_SIZE_2K					8
#define	RB_SIZE_4K					9
#define	RB_SIZE_8K					10
#define	RB_SIZE_16K					11
#define	RB_SIZE_32K					12
#define	RB_SIZE_64K					13

// GRAPHIC_CTRL.color_depth
#define	COLOR_DEPTH_1BPP			0
#define	COLOR_DEPTH_2BPP			1
#define	COLOR_DEPTH_4BPP			2
#define	COLOR_DEPTH_8BPP			3
#define	COLOR_DEPTH_332				4
#define	COLOR_DEPTH_A444			5
#define	COLOR_DEPTH_A555			6

// VIDEO_CTRL.video_mode
#define	VIDEO_MODE_422				0
#define	VIDEO_MODE_420				1

/* data structure definitions */

typedef struct _chip_id_t {
     unsigned long vendor_id                      : 16;
     unsigned long device_id                      : 16;
     } chip_id_t;

typedef union {
     unsigned long val : 32;
     chip_id_t f;
} chip_id_u;

typedef struct _revision_id_t {
     unsigned long minor_rev_id                   : 4;
     unsigned long major_rev_id                   : 4;
     unsigned long                                : 24;
     } revision_id_t;

typedef union {
     unsigned long val : 32;
     revision_id_t f;
} revision_id_u;

typedef struct _wrap_buf_a_t {
     unsigned long offset_addr_a                  : 24;
     unsigned long block_size_a                   : 3;
     unsigned long                                : 5;
     } wrap_buf_a_t;

typedef union {
     unsigned long val : 32;
     wrap_buf_a_t f;
} wrap_buf_a_u;

typedef struct _wrap_buf_b_t {
     unsigned long offset_addr_b                  : 24;
     unsigned long block_size_b                   : 3;
     unsigned long                                : 5;
     } wrap_buf_b_t;

typedef union {
     unsigned long val : 32;
     wrap_buf_b_t f;
} wrap_buf_b_u;

typedef struct _wrap_top_dir_t {
     unsigned long top_addr                       : 23;
     unsigned long                                : 9;
     } wrap_top_dir_t;

typedef union {
     unsigned long val : 32;
     wrap_top_dir_t f;
} wrap_top_dir_u;

typedef struct _wrap_start_dir_t {
     unsigned long start_addr                     : 23;
     unsigned long                                : 9;
     } wrap_start_dir_t;

typedef union {
     unsigned long val : 32;
     wrap_start_dir_t f;
} wrap_start_dir_u;

typedef struct _cif_cntl_t {
     unsigned long swap_reg                       : 2;
     unsigned long swap_fbuf_1                    : 2;
     unsigned long swap_fbuf_2                    : 2;
     unsigned long swap_fbuf_3                    : 2;
     unsigned long pmi_int_disable                : 1;
     unsigned long pmi_schmen_disable             : 1;
     unsigned long intb_oe                        : 1;
     unsigned long en_wait_to_compensate_dq_prop_dly : 1;
     unsigned long compensate_wait_rd_size        : 2;
     unsigned long wait_asserted_timeout_val      : 2;
     unsigned long wait_masked_val                : 2;
     unsigned long en_wait_timeout                : 1;
     unsigned long en_one_clk_setup_before_wait   : 1;
     unsigned long interrupt_active_high          : 1;
     unsigned long en_overwrite_straps            : 1;
     unsigned long strap_wait_active_hi           : 1;
     unsigned long lat_busy_count                 : 2;
     unsigned long lat_rd_pm4_sclk_busy           : 1;
     unsigned long dis_system_bits                : 1;
     unsigned long dis_mr                         : 1;
     unsigned long cif_spare_1                    : 4;
     } cif_cntl_t;

typedef union {
     unsigned long val : 32;
     cif_cntl_t f;
} cif_cntl_u;

typedef struct _cfgreg_base_t {
     unsigned long cfgreg_base                    : 24;
     unsigned long                                : 8;
     } cfgreg_base_t;

typedef union {
     unsigned long val : 32;
     cfgreg_base_t f;
} cfgreg_base_u;

typedef struct _cif_io_t {
     unsigned long dq_srp                         : 1;
     unsigned long dq_srn                         : 1;
     unsigned long dq_sp                          : 4;
     unsigned long dq_sn                          : 4;
     unsigned long waitb_srp                      : 1;
     unsigned long waitb_srn                      : 1;
     unsigned long waitb_sp                       : 4;
     unsigned long waitb_sn                       : 4;
     unsigned long intb_srp                       : 1;
     unsigned long intb_srn                       : 1;
     unsigned long intb_sp                        : 4;
     unsigned long intb_sn                        : 4;
     unsigned long                                : 2;
     } cif_io_t;

typedef union {
     unsigned long val : 32;
     cif_io_t f;
} cif_io_u;

typedef struct _cif_read_dbg_t {
     unsigned long unpacker_pre_fetch_trig_gen    : 2;
     unsigned long dly_second_rd_fetch_trig       : 1;
     unsigned long rst_rd_burst_id                : 1;
     unsigned long dis_rd_burst_id                : 1;
     unsigned long en_block_rd_when_packer_is_not_emp : 1;
     unsigned long dis_pre_fetch_cntl_sm          : 1;
     unsigned long rbbm_chrncy_dis                : 1;
     unsigned long rbbm_rd_after_wr_lat           : 2;
     unsigned long dis_be_during_rd               : 1;
     unsigned long one_clk_invalidate_pulse       : 1;
     unsigned long dis_chnl_priority              : 1;
     unsigned long rst_read_path_a_pls            : 1;
     unsigned long rst_read_path_b_pls            : 1;
     unsigned long dis_reg_rd_fetch_trig          : 1;
     unsigned long dis_rd_fetch_trig_from_ind_addr : 1;
     unsigned long dis_rd_same_byte_to_trig_fetch : 1;
     unsigned long dis_dir_wrap                   : 1;
     unsigned long dis_ring_buf_to_force_dec      : 1;
     unsigned long dis_addr_comp_in_16bit         : 1;
     unsigned long clr_w                          : 1;
     unsigned long err_rd_tag_is_3                : 1;
     unsigned long err_load_when_ful_a            : 1;
     unsigned long err_load_when_ful_b            : 1;
     unsigned long                                : 7;
     } cif_read_dbg_t;

typedef union {
     unsigned long val : 32;
     cif_read_dbg_t f;
} cif_read_dbg_u;

typedef struct _cif_write_dbg_t {
     unsigned long packer_timeout_count           : 2;
     unsigned long en_upper_load_cond             : 1;
     unsigned long en_chnl_change_cond            : 1;
     unsigned long dis_addr_comp_cond             : 1;
     unsigned long dis_load_same_byte_addr_cond   : 1;
     unsigned long dis_timeout_cond               : 1;
     unsigned long dis_timeout_during_rbbm        : 1;
     unsigned long dis_packer_ful_during_rbbm_timeout : 1;
     unsigned long en_dword_split_to_rbbm         : 1;
     unsigned long en_dummy_val                   : 1;
     unsigned long dummy_val_sel                  : 1;
     unsigned long mask_pm4_wrptr_dec             : 1;
     unsigned long dis_mc_clean_cond              : 1;
     unsigned long err_two_reqi_during_ful        : 1;
     unsigned long err_reqi_during_idle_clk       : 1;
     unsigned long err_global                     : 1;
     unsigned long en_wr_buf_dbg_load             : 1;
     unsigned long en_wr_buf_dbg_path             : 1;
     unsigned long sel_wr_buf_byte                : 3;
     unsigned long dis_rd_flush_wr                : 1;
     unsigned long dis_packer_ful_cond            : 1;
     unsigned long dis_invalidate_by_ops_chnl     : 1;
     unsigned long en_halt_when_reqi_err          : 1;
     unsigned long cif_spare_2                    : 5;
     unsigned long                                : 1;
     } cif_write_dbg_t;

typedef union {
     unsigned long val : 32;
     cif_write_dbg_t f;
} cif_write_dbg_u;

typedef struct _ind_addr_a_0_t {
     unsigned char ind_addr_a_0                   : 8;
     } ind_addr_a_0_t;

typedef union {
     unsigned char val : 8;
     ind_addr_a_0_t f;
} ind_addr_a_0_u;

typedef struct _ind_addr_a_1_t {
     unsigned char ind_addr_a_1                   : 8;
     } ind_addr_a_1_t;

typedef union {
     unsigned char val : 8;
     ind_addr_a_1_t f;
} ind_addr_a_1_u;

typedef struct _ind_addr_a_2_t {
     unsigned char ind_addr_a_2                   : 8;
     } ind_addr_a_2_t;

typedef union {
     unsigned char val : 8;
     ind_addr_a_2_t f;
} ind_addr_a_2_u;

typedef struct _ind_data_a_t {
     unsigned char ind_data_a                     : 8;
     } ind_data_a_t;

typedef union {
     unsigned char val : 8;
     ind_data_a_t f;
} ind_data_a_u;

typedef struct _reg_base_t {
     unsigned char reg_base                       : 8;
     } reg_base_t;

typedef union {
     unsigned char val : 8;
     reg_base_t f;
} reg_base_u;

typedef struct _intf_cntl_t {
     unsigned char ad_inc_a                       : 1;
     unsigned char ring_buf_a                     : 1;
     unsigned char rd_fetch_trigger_a             : 1;
     unsigned char rd_data_rdy_a                  : 1;
     unsigned char ad_inc_b                       : 1;
     unsigned char ring_buf_b                     : 1;
     unsigned char rd_fetch_trigger_b             : 1;
     unsigned char rd_data_rdy_b                  : 1;
     } intf_cntl_t;

typedef union {
     unsigned char val : 8;
     intf_cntl_t f;
} intf_cntl_u;

typedef struct _status_t {
     unsigned char wr_fifo_available_space        : 2;
     unsigned char fbuf_wr_pipe_emp               : 1;
     unsigned char soft_reset                     : 1;
     unsigned char system_pwm_mode                : 2;
     unsigned char mem_access_dis                 : 1;
     unsigned char en_pre_fetch                   : 1;
     } status_t;

typedef union {
     unsigned char val : 8;
     status_t f;
} status_u;

typedef struct _cpu_defaults_t {
     unsigned char unpack_rd_data                 : 1;
     unsigned char access_ind_addr_a              : 1;
     unsigned char access_ind_addr_b              : 1;
     unsigned char access_scratch_reg             : 1;
     unsigned char pack_wr_data                   : 1;
     unsigned char transition_size                : 1;
     unsigned char en_read_buf_mode               : 1;
     unsigned char rd_fetch_scratch               : 1;
     } cpu_defaults_t;

typedef union {
     unsigned char val : 8;
     cpu_defaults_t f;
} cpu_defaults_u;

typedef struct _ind_addr_b_0_t {
     unsigned char ind_addr_b_0                   : 8;
     } ind_addr_b_0_t;

typedef union {
     unsigned char val : 8;
     ind_addr_b_0_t f;
} ind_addr_b_0_u;

typedef struct _ind_addr_b_1_t {
     unsigned char ind_addr_b_1                   : 8;
     } ind_addr_b_1_t;

typedef union {
     unsigned char val : 8;
     ind_addr_b_1_t f;
} ind_addr_b_1_u;

typedef struct _ind_addr_b_2_t {
     unsigned char ind_addr_b_2                   : 8;
     } ind_addr_b_2_t;

typedef union {
     unsigned char val : 8;
     ind_addr_b_2_t f;
} ind_addr_b_2_u;

typedef struct _ind_data_b_t {
     unsigned char ind_data_b                     : 8;
     } ind_data_b_t;

typedef union {
     unsigned char val : 8;
     ind_data_b_t f;
} ind_data_b_u;

typedef struct _pm4_rptr_t {
     unsigned char pm4_rptr                       : 8;
     } pm4_rptr_t;

typedef union {
     unsigned char val : 8;
     pm4_rptr_t f;
} pm4_rptr_u;

typedef struct _scratch_t {
     unsigned char scratch                        : 8;
     } scratch_t;

typedef union {
     unsigned char val : 8;
     scratch_t f;
} scratch_u;

typedef struct _pm4_wrptr_0_t {
     unsigned char pm4_wrptr_0                    : 8;
     } pm4_wrptr_0_t;

typedef union {
     unsigned char val : 8;
     pm4_wrptr_0_t f;
} pm4_wrptr_0_u;

typedef struct _pm4_wrptr_1_t {
     unsigned char pm4_wrptr_1                    : 6;
     unsigned char rd_fetch_pm4_rptr              : 1;
     unsigned char wrptr_atomic_update_w          : 1;
     } pm4_wrptr_1_t;

typedef union {
     unsigned char val : 8;
     pm4_wrptr_1_t f;
} pm4_wrptr_1_u;

typedef struct _cp_rb_cntl_t {
     unsigned long rb_bufsz                       : 6;
     unsigned long                                : 2;
     unsigned long rb_blksz                       : 6;
     unsigned long                                : 2;
     unsigned long buf_swap                       : 2;
     unsigned long max_fetch                      : 2;
     unsigned long                                : 7;
     unsigned long rb_no_update                   : 1;
     unsigned long                                : 3;
     unsigned long rb_rptr_wr_ena                 : 1;
     } cp_rb_cntl_t;

typedef union {
     unsigned long val : 32;
     cp_rb_cntl_t f;
} cp_rb_cntl_u;

typedef struct _cp_rb_base_t {
     unsigned long                                : 2;
     unsigned long rb_base                        : 22;
     unsigned long                                : 8;
     } cp_rb_base_t;

typedef union {
     unsigned long val : 32;
     cp_rb_base_t f;
} cp_rb_base_u;

typedef struct _cp_rb_rptr_addr_t {
     unsigned long rb_rptr_swap                   : 2;
     unsigned long rb_rptr_addr                   : 22;
     unsigned long                                : 8;
     } cp_rb_rptr_addr_t;

typedef union {
     unsigned long val : 32;
     cp_rb_rptr_addr_t f;
} cp_rb_rptr_addr_u;

typedef struct _cp_rb_rptr_t {
     unsigned long rb_rptr                        : 23;
     unsigned long                                : 9;
     } cp_rb_rptr_t;

typedef union {
     unsigned long val : 32;
     cp_rb_rptr_t f;
} cp_rb_rptr_u;

typedef struct _cp_rb_rptr_wr_t {
     unsigned long rb_rptr_wr                     : 23;
     unsigned long                                : 9;
     } cp_rb_rptr_wr_t;

typedef union {
     unsigned long val : 32;
     cp_rb_rptr_wr_t f;
} cp_rb_rptr_wr_u;

typedef struct _cp_rb_wptr_t {
     unsigned long rb_wptr                        : 23;
     unsigned long                                : 9;
     } cp_rb_wptr_t;

typedef union {
     unsigned long val : 32;
     cp_rb_wptr_t f;
} cp_rb_wptr_u;

typedef struct _cp_ib_base_t {
     unsigned long                                : 2;
     unsigned long ib_base                        : 22;
     unsigned long                                : 8;
     } cp_ib_base_t;

typedef union {
     unsigned long val : 32;
     cp_ib_base_t f;
} cp_ib_base_u;

typedef struct _cp_ib_bufsz_t {
     unsigned long ib_bufsz                       : 23;
     unsigned long                                : 9;
     } cp_ib_bufsz_t;

typedef union {
     unsigned long val : 32;
     cp_ib_bufsz_t f;
} cp_ib_bufsz_u;

typedef struct _cp_csq_cntl_t {
     unsigned long csq_cnt_primary                : 8;
     unsigned long csq_cnt_indirect               : 8;
     unsigned long                                : 12;
     unsigned long csq_mode                       : 4;
     } cp_csq_cntl_t;

typedef union {
     unsigned long val : 32;
     cp_csq_cntl_t f;
} cp_csq_cntl_u;

typedef struct _cp_csq_aper_primary_t {
     unsigned long cp_csq_aper_primary            : 32;
     } cp_csq_aper_primary_t;

typedef union {
     unsigned long val : 32;
     cp_csq_aper_primary_t f;
} cp_csq_aper_primary_u;

typedef struct _cp_csq_aper_indirect_t {
     unsigned long cp_csq_aper_indirect           : 32;
     } cp_csq_aper_indirect_t;

typedef union {
     unsigned long val : 32;
     cp_csq_aper_indirect_t f;
} cp_csq_aper_indirect_u;

typedef struct _cp_me_cntl_t {
     unsigned long me_stat                        : 16;
     unsigned long me_statmux                     : 5;
     unsigned long                                : 8;
     unsigned long me_busy                        : 1;
     unsigned long me_mode                        : 1;
     unsigned long me_step                        : 1;
     } cp_me_cntl_t;

typedef union {
     unsigned long val : 32;
     cp_me_cntl_t f;
} cp_me_cntl_u;

typedef struct _cp_me_ram_addr_t {
     unsigned long me_ram_addr                    : 8;
     unsigned long                                : 24;
     } cp_me_ram_addr_t;

typedef union {
     unsigned long val : 32;
     cp_me_ram_addr_t f;
} cp_me_ram_addr_u;

typedef struct _cp_me_ram_raddr_t {
     unsigned long me_ram_raddr                   : 8;
     unsigned long                                : 24;
     } cp_me_ram_raddr_t;

typedef union {
     unsigned long val : 32;
     cp_me_ram_raddr_t f;
} cp_me_ram_raddr_u;

typedef struct _cp_me_ram_datah_t {
     unsigned long me_ram_datah                   : 6;
     unsigned long                                : 26;
     } cp_me_ram_datah_t;

typedef union {
     unsigned long val : 32;
     cp_me_ram_datah_t f;
} cp_me_ram_datah_u;

typedef struct _cp_me_ram_datal_t {
     unsigned long me_ram_datal                   : 32;
     } cp_me_ram_datal_t;

typedef union {
     unsigned long val : 32;
     cp_me_ram_datal_t f;
} cp_me_ram_datal_u;

typedef struct _cp_debug_t {
     unsigned long cp_debug                       : 32;
     } cp_debug_t;

typedef union {
     unsigned long val : 32;
     cp_debug_t f;
} cp_debug_u;

typedef struct _scratch_reg0_t {
     unsigned long scratch_reg0                   : 32;
     } scratch_reg0_t;

typedef union {
     unsigned long val : 32;
     scratch_reg0_t f;
} scratch_reg0_u;

typedef struct _scratch_reg1_t {
     unsigned long scratch_reg1                   : 32;
     } scratch_reg1_t;

typedef union {
     unsigned long val : 32;
     scratch_reg1_t f;
} scratch_reg1_u;

typedef struct _scratch_reg2_t {
     unsigned long scratch_reg2                   : 32;
     } scratch_reg2_t;

typedef union {
     unsigned long val : 32;
     scratch_reg2_t f;
} scratch_reg2_u;

typedef struct _scratch_reg3_t {
     unsigned long scratch_reg3                   : 32;
     } scratch_reg3_t;

typedef union {
     unsigned long val : 32;
     scratch_reg3_t f;
} scratch_reg3_u;

typedef struct _scratch_reg4_t {
     unsigned long scratch_reg4                   : 32;
     } scratch_reg4_t;

typedef union {
     unsigned long val : 32;
     scratch_reg4_t f;
} scratch_reg4_u;

typedef struct _scratch_reg5_t {
     unsigned long scratch_reg5                   : 32;
     } scratch_reg5_t;

typedef union {
     unsigned long val : 32;
     scratch_reg5_t f;
} scratch_reg5_u;

typedef struct _scratch_umsk_t {
     unsigned long scratch_umsk                   : 6;
     unsigned long                                : 10;
     unsigned long scratch_swap                   : 2;
     unsigned long                                : 14;
     } scratch_umsk_t;

typedef union {
     unsigned long val : 32;
     scratch_umsk_t f;
} scratch_umsk_u;

typedef struct _scratch_addr_t {
     unsigned long                                : 5;
     unsigned long scratch_addr                   : 27;
     } scratch_addr_t;

typedef union {
     unsigned long val : 32;
     scratch_addr_t f;
} scratch_addr_u;

typedef struct _cp_csq_addr_t {
     unsigned long                                : 2;
     unsigned long csq_addr                       : 8;
     unsigned long                                : 22;
     } cp_csq_addr_t;

typedef union {
     unsigned long val : 32;
     cp_csq_addr_t f;
} cp_csq_addr_u;

typedef struct _cp_csq_data_t {
     unsigned long csq_data                       : 32;
     } cp_csq_data_t;

typedef union {
     unsigned long val : 32;
     cp_csq_data_t f;
} cp_csq_data_u;

typedef struct _cp_csq_stat_t {
     unsigned long csq_rptr_primary               : 8;
     unsigned long csq_wptr_primary               : 8;
     unsigned long csq_rptr_indirect              : 8;
     unsigned long csq_wptr_indirect              : 8;
     } cp_csq_stat_t;

typedef union {
     unsigned long val : 32;
     cp_csq_stat_t f;
} cp_csq_stat_u;

typedef struct _cp_stat_t {
     unsigned long mru_busy                       : 1;
     unsigned long mwu_busy                       : 1;
     unsigned long rsiu_busy                      : 1;
     unsigned long rciu_busy                      : 1;
     unsigned long                                : 5;
     unsigned long csf_primary_busy               : 1;
     unsigned long csf_indirect_busy              : 1;
     unsigned long csq_primary_busy               : 1;
     unsigned long csq_indirect_busy              : 1;
     unsigned long csi_busy                       : 1;
     unsigned long                                : 14;
     unsigned long guidma_busy                    : 1;
     unsigned long viddma_busy                    : 1;
     unsigned long cmdstrm_busy                   : 1;
     unsigned long cp_busy                        : 1;
     } cp_stat_t;

typedef union {
     unsigned long val : 32;
     cp_stat_t f;
} cp_stat_u;

typedef struct _gen_int_cntl_t {
     unsigned long crtc_vblank_mask               : 1;
     unsigned long crtc_vline_mask                : 1;
     unsigned long crtc_hwint1_mask               : 1;
     unsigned long crtc_hwint2_mask               : 1;
     unsigned long                                : 15;
     unsigned long gui_idle_mask                  : 1;
     unsigned long                                : 8;
     unsigned long pm4_idle_int_mask              : 1;
     unsigned long dvi_i2c_int_mask               : 1;
     unsigned long                                : 2;
     } gen_int_cntl_t;

typedef union {
     unsigned long val : 32;
     gen_int_cntl_t f;
} gen_int_cntl_u;

typedef struct _gen_int_status_rd_t {
     unsigned long crtc_vblank_stat               : 1;
     unsigned long crtc_vline_stat                : 1;
     unsigned long crtc_hwint1_stat               : 1;
     unsigned long crtc_hwint2_stat               : 1;
     unsigned long                                : 15;
     unsigned long gui_idle_stat                  : 1;
     unsigned long                                : 8;
     unsigned long pm4_idle_int_stat              : 1;
     unsigned long dvi_i2c_int_stat               : 1;
     unsigned long                                : 2;
     } gen_int_status_rd_t;

typedef union {
     unsigned long val : 32;
     gen_int_status_rd_t f;
} gen_int_status_rd_u;

typedef struct _gen_int_status_wr_t {
     unsigned long crtc_vblank_stat_ak            : 1;
     unsigned long crtc_vline_stat_ak             : 1;
     unsigned long crtc_hwint1_stat_ak            : 1;
     unsigned long crtc_hwint2_stat_ak            : 1;
     unsigned long                                : 15;
     unsigned long gui_idle_stat_ak               : 1;
     unsigned long                                : 8;
     unsigned long pm4_idle_int_ak                : 1;
     unsigned long dvi_i2c_int_ak                 : 1;
     unsigned long                                : 2;
     } gen_int_status_wr_t;

typedef union {
     unsigned long val : 32;
     gen_int_status_wr_t f;
} gen_int_status_wr_u;

typedef struct _lcd_format_t {
     unsigned long lcd_type                       : 4;
     unsigned long color_to_mono                  : 1;
     unsigned long data_inv                       : 1;
     unsigned long stn_fm                         : 2;
     unsigned long tft_fm                         : 2;
     unsigned long scan_lr_en                     : 1;
     unsigned long scan_ud_en                     : 1;
     unsigned long pol_inv                        : 1;
     unsigned long rst_fm                         : 1;
     unsigned long yuv_to_rgb                     : 1;
     unsigned long hr_tft                         : 1;
     unsigned long ulc_panel                      : 1;
     unsigned long                                : 15;
     } lcd_format_t;

typedef union {
     unsigned long val : 32;
     lcd_format_t f;
} lcd_format_u;

typedef struct _graphic_ctrl_t {
     unsigned long color_depth                    : 3; // 6
     unsigned long portrait_mode                  : 2; // 0
     unsigned long low_power_on                   : 1; // 1
     unsigned long req_freq                       : 4; // 5
     unsigned long en_crtc                        : 1; // 1
     unsigned long en_graphic_req                 : 1; // 1
     unsigned long en_graphic_crtc                : 1; // 1
     unsigned long total_req_graphic              : 9; // 240
     unsigned long lcd_pclk_on                    : 1; // 1
     unsigned long lcd_sclk_on                    : 1; // 1
     unsigned long pclk_running                   : 1; // 1
     unsigned long sclk_running                   : 1; // 1
     unsigned long                                : 6;
     } graphic_ctrl_t;

typedef union {
     unsigned long val : 32;
     graphic_ctrl_t f;
} graphic_ctrl_u;

typedef struct _graphic_offset_t {
     unsigned long graphic_offset                 : 24;
     unsigned long                                : 8;
     } graphic_offset_t;

typedef union {
     unsigned long val : 32;
     graphic_offset_t f;
} graphic_offset_u;

typedef struct _graphic_pitch_t {
     unsigned long graphic_pitch                  : 11;
     unsigned long                                : 21;
     } graphic_pitch_t;

typedef union {
     unsigned long val : 32;
     graphic_pitch_t f;
} graphic_pitch_u;

typedef struct _crtc_total_t {
     unsigned long crtc_h_total                   : 10;
     unsigned long                                : 6;
     unsigned long crtc_v_total                   : 10;
     unsigned long                                : 6;
     } crtc_total_t;

typedef union {
     unsigned long val : 32;
     crtc_total_t f;
} crtc_total_u;

typedef struct _active_h_disp_t {
     unsigned long active_h_start                 : 10;
     unsigned long                                : 6;
     unsigned long active_h_end                   : 10;
     unsigned long                                : 6;
     } active_h_disp_t;

typedef union {
     unsigned long val : 32;
     active_h_disp_t f;
} active_h_disp_u;

typedef struct _active_v_disp_t {
     unsigned long active_v_start                 : 10;
     unsigned long                                : 6;
     unsigned long active_v_end                   : 10;
     unsigned long                                : 6;
     } active_v_disp_t;

typedef union {
     unsigned long val : 32;
     active_v_disp_t f;
} active_v_disp_u;

typedef struct _graphic_h_disp_t {
     unsigned long graphic_h_start                : 10;
     unsigned long                                : 6;
     unsigned long graphic_h_end                  : 10;
     unsigned long                                : 6;
     } graphic_h_disp_t;

typedef union {
     unsigned long val : 32;
     graphic_h_disp_t f;
} graphic_h_disp_u;

typedef struct _graphic_v_disp_t {
     unsigned long graphic_v_start                : 10;
     unsigned long                                : 6;
     unsigned long graphic_v_end                  : 10;
     unsigned long                                : 6;
     } graphic_v_disp_t;

typedef union {
     unsigned long val : 32;
     graphic_v_disp_t f;
} graphic_v_disp_u;

typedef struct _video_ctrl_t {
     unsigned long video_mode                     : 1; // 00000001
     unsigned long keyer_en                       : 1; // 00000002
     unsigned long en_video_req                   : 1; // 00000004
     unsigned long en_graphic_req_video           : 1; // 00000008
     unsigned long en_video_crtc                  : 1; // 00000010
     unsigned long video_hor_exp                  : 2; // 00000060
     unsigned long video_ver_exp                  : 2; // 00000180
     unsigned long uv_combine                     : 1; // 00000200
     unsigned long total_req_video                : 9; // 0007fc00
     unsigned long video_ch_sel                   : 1; // 00080000
     unsigned long video_portrait                 : 2; // 00300000
     unsigned long yuv2rgb_en                     : 1; // 00400000
     unsigned long yuv2rgb_option                 : 1; // 00800000
     unsigned long video_inv_hor                  : 1; // 01000000
     unsigned long video_inv_ver                  : 1; // 02000000
     unsigned long gamma_sel                      : 2; // 0c000000
     unsigned long dis_limit                      : 1; // 10000000
     unsigned long en_uv_hblend                   : 1; // 20000000
     unsigned long rgb_gamma_sel                  : 2; // c0000000
     } video_ctrl_t;

typedef union {
     unsigned long val : 32;
     video_ctrl_t f;
} video_ctrl_u;

typedef struct _graphic_key_t {
     unsigned long keyer_color                    : 16;
     unsigned long keyer_mask                     : 16;
     } graphic_key_t;

typedef union {
     unsigned long val : 32;
     graphic_key_t f;
} graphic_key_u;

typedef struct _video_y_offset_t {
     unsigned long y_offset                       : 24;
     unsigned long                                : 8;
     } video_y_offset_t;

typedef union {
     unsigned long val : 32;
     video_y_offset_t f;
} video_y_offset_u;

typedef struct _video_y_pitch_t {
     unsigned long y_pitch                        : 11;
     unsigned long                                : 21;
     } video_y_pitch_t;

typedef union {
     unsigned long val : 32;
     video_y_pitch_t f;
} video_y_pitch_u;

typedef struct _video_u_offset_t {
     unsigned long u_offset                       : 24;
     unsigned long                                : 8;
     } video_u_offset_t;

typedef union {
     unsigned long val : 32;
     video_u_offset_t f;
} video_u_offset_u;

typedef struct _video_u_pitch_t {
     unsigned long u_pitch                        : 11;
     unsigned long                                : 21;
     } video_u_pitch_t;

typedef union {
     unsigned long val : 32;
     video_u_pitch_t f;
} video_u_pitch_u;

typedef struct _video_v_offset_t {
     unsigned long v_offset                       : 24;
     unsigned long                                : 8;
     } video_v_offset_t;

typedef union {
     unsigned long val : 32;
     video_v_offset_t f;
} video_v_offset_u;

typedef struct _video_v_pitch_t {
     unsigned long v_pitch                        : 11;
     unsigned long                                : 21;
     } video_v_pitch_t;

typedef union {
     unsigned long val : 32;
     video_v_pitch_t f;
} video_v_pitch_u;

typedef struct _video_h_pos_t {
     unsigned long video_h_start                  : 10;
     unsigned long                                : 6;
     unsigned long video_h_end                    : 10;
     unsigned long                                : 6;
     } video_h_pos_t;

typedef union {
     unsigned long val : 32;
     video_h_pos_t f;
} video_h_pos_u;

typedef struct _video_v_pos_t {
     unsigned long video_v_start                  : 10;
     unsigned long                                : 6;
     unsigned long video_v_end                    : 10;
     unsigned long                                : 6;
     } video_v_pos_t;

typedef union {
     unsigned long val : 32;
     video_v_pos_t f;
} video_v_pos_u;

typedef struct _brightness_cntl_t {
     unsigned long brightness                     : 7;
     unsigned long                                : 25;
     } brightness_cntl_t;

typedef union {
     unsigned long val : 32;
     brightness_cntl_t f;
} brightness_cntl_u;

typedef struct _cursor1_offset_t {
     unsigned long cur1_offset                    : 24;
     unsigned long cur1_x_offset                  : 4;
     unsigned long cur1_y_offset                  : 4;
     } cursor1_offset_t;

typedef union {
     unsigned long val : 32;
     cursor1_offset_t f;
} cursor1_offset_u;

typedef struct _cursor1_h_pos_t {
     unsigned long cur1_h_start                   : 10;
     unsigned long                                : 6;
     unsigned long cur1_h_end                     : 10;
     unsigned long                                : 5;
     unsigned long cur1_en                        : 1;
     } cursor1_h_pos_t;

typedef union {
     unsigned long val : 32;
     cursor1_h_pos_t f;
} cursor1_h_pos_u;

typedef struct _cursor1_v_pos_t {
     unsigned long cur1_v_start                   : 10;
     unsigned long                                : 6;
     unsigned long cur1_v_end                     : 10;
     unsigned long                                : 6;
     } cursor1_v_pos_t;

typedef union {
     unsigned long val : 32;
     cursor1_v_pos_t f;
} cursor1_v_pos_u;

typedef struct _cursor1_color0_t {
     unsigned long cur1_color0_r                  : 8;
     unsigned long cur1_color0_g                  : 8;
     unsigned long cur1_color0_b                  : 8;
     unsigned long                                : 8;
     } cursor1_color0_t;

typedef union {
     unsigned long val : 32;
     cursor1_color0_t f;
} cursor1_color0_u;

typedef struct _cursor1_color1_t {
     unsigned long cur1_color1_r                  : 8;
     unsigned long cur1_color1_g                  : 8;
     unsigned long cur1_color1_b                  : 8;
     unsigned long                                : 8;
     } cursor1_color1_t;

typedef union {
     unsigned long val : 32;
     cursor1_color1_t f;
} cursor1_color1_u;

typedef struct _cursor2_offset_t {
     unsigned long cur2_offset                    : 24;
     unsigned long cur2_x_offset                  : 4;
     unsigned long cur2_y_offset                  : 4;
     } cursor2_offset_t;

typedef union {
     unsigned long val : 32;
     cursor2_offset_t f;
} cursor2_offset_u;

typedef struct _cursor2_h_pos_t {
     unsigned long cur2_h_start                   : 10;
     unsigned long                                : 6;
     unsigned long cur2_h_end                     : 10;
     unsigned long                                : 5;
     unsigned long cur2_en                        : 1;
     } cursor2_h_pos_t;

typedef union {
     unsigned long val : 32;
     cursor2_h_pos_t f;
} cursor2_h_pos_u;

typedef struct _cursor2_v_pos_t {
     unsigned long cur2_v_start                   : 10;
     unsigned long                                : 6;
     unsigned long cur2_v_end                     : 10;
     unsigned long                                : 6;
     } cursor2_v_pos_t;

typedef union {
     unsigned long val : 32;
     cursor2_v_pos_t f;
} cursor2_v_pos_u;

typedef struct _cursor2_color0_t {
     unsigned long cur2_color0_r                  : 8;
     unsigned long cur2_color0_g                  : 8;
     unsigned long cur2_color0_b                  : 8;
     unsigned long                                : 8;
     } cursor2_color0_t;

typedef union {
     unsigned long val : 32;
     cursor2_color0_t f;
} cursor2_color0_u;

typedef struct _cursor2_color1_t {
     unsigned long cur2_color1_r                  : 8;
     unsigned long cur2_color1_g                  : 8;
     unsigned long cur2_color1_b                  : 8;
     unsigned long                                : 8;
     } cursor2_color1_t;

typedef union {
     unsigned long val : 32;
     cursor2_color1_t f;
} cursor2_color1_u;

typedef struct _disp_int_cntl_t {
     unsigned long vline_int_pos                  : 10;
     unsigned long                                : 6;
     unsigned long hpos_int_pos                   : 10;
     unsigned long                                : 4;
     unsigned long vblank_int_pol                 : 1;
     unsigned long frame_int_pol                  : 1;
     } disp_int_cntl_t;

typedef union {
     unsigned long val : 32;
     disp_int_cntl_t f;
} disp_int_cntl_u;

typedef struct _crtc_ss_t {
     unsigned long ss_start                       : 10;
     unsigned long                                : 6;
     unsigned long ss_end                         : 10;
     unsigned long                                : 2;
     unsigned long ss_align                       : 1;
     unsigned long ss_pol                         : 1;
     unsigned long ss_run_mode                    : 1;
     unsigned long ss_en                          : 1;
     } crtc_ss_t;

typedef union {
     unsigned long val : 32;
     crtc_ss_t f;
} crtc_ss_u;

typedef struct _crtc_ls_t {
     unsigned long ls_start                       : 10;
     unsigned long                                : 6;
     unsigned long ls_end                         : 10;
     unsigned long                                : 2;
     unsigned long ls_align                       : 1;
     unsigned long ls_pol                         : 1;
     unsigned long ls_run_mode                    : 1;
     unsigned long ls_en                          : 1;
     } crtc_ls_t;

typedef union {
     unsigned long val : 32;
     crtc_ls_t f;
} crtc_ls_u;

typedef struct _crtc_rev_t {
     unsigned long rev_pos                        : 10;
     unsigned long                                : 6;
     unsigned long rev_align                      : 1;
     unsigned long rev_freq_nref                  : 5;
     unsigned long rev_en                         : 1;
     unsigned long                                : 9;
     } crtc_rev_t;

typedef union {
     unsigned long val : 32;
     crtc_rev_t f;
} crtc_rev_u;

typedef struct _crtc_dclk_t {
     unsigned long dclk_start                     : 10;
     unsigned long                                : 6;
     unsigned long dclk_end                       : 10;
     unsigned long                                : 1;
     unsigned long dclk_run_mode                  : 2;
     unsigned long dclk_pol                       : 1;
     unsigned long dclk_align                     : 1;
     unsigned long dclk_en                        : 1;
     } crtc_dclk_t;

typedef union {
     unsigned long val : 32;
     crtc_dclk_t f;
} crtc_dclk_u;

typedef struct _crtc_gs_t {
     unsigned long gs_start                       : 10;
     unsigned long                                : 6;
     unsigned long gs_end                         : 10;
     unsigned long                                : 3;
     unsigned long gs_align                       : 1;
     unsigned long gs_pol                         : 1;
     unsigned long gs_en                          : 1;
     } crtc_gs_t;

typedef union {
     unsigned long val : 32;
     crtc_gs_t f;
} crtc_gs_u;

typedef struct _crtc_vpos_gs_t {
     unsigned long gs_vpos_start                  : 10;
     unsigned long                                : 6;
     unsigned long gs_vpos_end                    : 10;
     unsigned long                                : 6;
     } crtc_vpos_gs_t;

typedef union {
     unsigned long val : 32;
     crtc_vpos_gs_t f;
} crtc_vpos_gs_u;

typedef struct _crtc_gclk_t {
     unsigned long gclk_start                     : 10;
     unsigned long                                : 6;
     unsigned long gclk_end                       : 10;
     unsigned long                                : 3;
     unsigned long gclk_align                     : 1;
     unsigned long gclk_pol                       : 1;
     unsigned long gclk_en                        : 1;
     } crtc_gclk_t;

typedef union {
     unsigned long val : 32;
     crtc_gclk_t f;
} crtc_gclk_u;

typedef struct _crtc_goe_t {
     unsigned long goe_start                      : 10;
     unsigned long                                : 6;
     unsigned long goe_end                        : 10;
     unsigned long                                : 3;
     unsigned long goe_align                      : 1;
     unsigned long goe_pol                        : 1;
     unsigned long goe_en                         : 1;
     } crtc_goe_t;

typedef union {
     unsigned long val : 32;
     crtc_goe_t f;
} crtc_goe_u;

typedef struct _crtc_frame_t {
     unsigned long crtc_fr_start                  : 10;
     unsigned long                                : 6;
     unsigned long crtc_fr_end                    : 10;
     unsigned long                                : 4;
     unsigned long crtc_frame_en                  : 1;
     unsigned long crtc_frame_align               : 1;
     } crtc_frame_t;

typedef union {
     unsigned long val : 32;
     crtc_frame_t f;
} crtc_frame_u;

typedef struct _crtc_frame_vpos_t {
     unsigned long crtc_fr_vpos                   : 10;
     unsigned long                                : 22;
     } crtc_frame_vpos_t;

typedef union {
     unsigned long val : 32;
     crtc_frame_vpos_t f;
} crtc_frame_vpos_u;

typedef struct _gpio_data_t {
     unsigned long gio_out                        : 16;
     unsigned long gio_in                         : 16;
     } gpio_data_t;

typedef union {
     unsigned long val : 32;
     gpio_data_t f;
} gpio_data_u;

typedef struct _gpio_cntl1_t {
     unsigned long gio_pd                         : 16;
     unsigned long gio_schmen                     : 16;
     } gpio_cntl1_t;

typedef union {
     unsigned long val : 32;
     gpio_cntl1_t f;
} gpio_cntl1_u;

typedef struct _gpio_cntl2_t {
     unsigned long gio_oe                         : 16;
     unsigned long gio_srp                        : 1;
     unsigned long gio_srn                        : 1;
     unsigned long gio_sp                         : 4;
     unsigned long gio_sn                         : 4;
     unsigned long                                : 6;
     } gpio_cntl2_t;

typedef union {
     unsigned long val : 32;
     gpio_cntl2_t f;
} gpio_cntl2_u;

typedef struct _lcdd_cntl1_t {
     unsigned long lcdd_pd                        : 18;
     unsigned long lcdd_srp                       : 1;
     unsigned long lcdd_srn                       : 1;
     unsigned long lcdd_sp                        : 4;
     unsigned long lcdd_sn                        : 4;
     unsigned long lcdd_align                     : 1;
     unsigned long                                : 3;
     } lcdd_cntl1_t;

typedef union {
     unsigned long val : 32;
     lcdd_cntl1_t f;
} lcdd_cntl1_u;

typedef struct _lcdd_cntl2_t {
     unsigned long lcdd_oe                        : 18;
     unsigned long                                : 14;
     } lcdd_cntl2_t;

typedef union {
     unsigned long val : 32;
     lcdd_cntl2_t f;
} lcdd_cntl2_u;

typedef struct _genlcd_cntl1_t {
     unsigned long dclk_oe                        : 1;
     unsigned long dclk_pd                        : 1;
     unsigned long dclk_srp                       : 1;
     unsigned long dclk_srn                       : 1;
     unsigned long dclk_sp                        : 4;
     unsigned long dclk_sn                        : 4;
     unsigned long ss_oe                          : 1;
     unsigned long ss_pd                          : 1;
     unsigned long ls_oe                          : 1;
     unsigned long ls_pd                          : 1;
     unsigned long gs_oe                          : 1;
     unsigned long gs_pd                          : 1;
     unsigned long goe_oe                         : 1;
     unsigned long goe_pd                         : 1;
     unsigned long rev_oe                         : 1;
     unsigned long rev_pd                         : 1;
     unsigned long frame_oe                       : 1;
     unsigned long frame_pd                       : 1;
     unsigned long                                : 8;
     } genlcd_cntl1_t;

typedef union {
     unsigned long val : 32;
     genlcd_cntl1_t f;
} genlcd_cntl1_u;

typedef struct _genlcd_cntl2_t {
     unsigned long gclk_oe                        : 1;
     unsigned long gclk_pd                        : 1;
     unsigned long gclk_srp                       : 1;
     unsigned long gclk_srn                       : 1;
     unsigned long gclk_sp                        : 4;
     unsigned long gclk_sn                        : 4;
     unsigned long genlcd_srp                     : 1;
     unsigned long genlcd_srn                     : 1;
     unsigned long genlcd_sp                      : 4;
     unsigned long genlcd_sn                      : 4;
     unsigned long                                : 10;
     } genlcd_cntl2_t;

typedef union {
     unsigned long val : 32;
     genlcd_cntl2_t f;
} genlcd_cntl2_u;

typedef struct _disp_debug_t {
     unsigned long disp_debug                     : 32;
     } disp_debug_t;

typedef union {
     unsigned long val : 32;
     disp_debug_t f;
} disp_debug_u;

typedef struct _disp_db_buf_cntl_rd_t {
     unsigned long en_db_buf                      : 1;
     unsigned long update_db_buf_done             : 1;
     unsigned long db_buf_cntl                    : 6;
     unsigned long                                : 24;
     } disp_db_buf_cntl_rd_t;

typedef union {
     unsigned long val : 32;
     disp_db_buf_cntl_rd_t f;
} disp_db_buf_cntl_rd_u;

typedef struct _disp_db_buf_cntl_wr_t {
     unsigned long en_db_buf                      : 1;
     unsigned long update_db_buf                  : 1;
     unsigned long db_buf_cntl                    : 6;
     unsigned long                                : 24;
     } disp_db_buf_cntl_wr_t;

typedef union {
     unsigned long val : 32;
     disp_db_buf_cntl_wr_t f;
} disp_db_buf_cntl_wr_u;

typedef struct _disp_crc_sig_t {
     unsigned long crc_sig_r                      : 6;
     unsigned long crc_sig_g                      : 6;
     unsigned long crc_sig_b                      : 6;
     unsigned long crc_cont_en                    : 1;
     unsigned long crc_en                         : 1;
     unsigned long crc_mask_en                    : 1;
     unsigned long crc_sig_cntl                   : 6;
     unsigned long                                : 5;
     } disp_crc_sig_t;

typedef union {
     unsigned long val : 32;
     disp_crc_sig_t f;
} disp_crc_sig_u;

typedef struct _crtc_default_count_t {
     unsigned long crtc_hcount_def                : 10;
     unsigned long                                : 6;
     unsigned long crtc_vcount_def                : 10;
     unsigned long                                : 6;
     } crtc_default_count_t;

typedef union {
     unsigned long val : 32;
     crtc_default_count_t f;
} crtc_default_count_u;

typedef struct _lcd_background_color_t {
     unsigned long lcd_bg_red                     : 8;
     unsigned long lcd_bg_green                   : 8;
     unsigned long lcd_bg_blue                    : 8;
     unsigned long                                : 8;
     } lcd_background_color_t;

typedef union {
     unsigned long val : 32;
     lcd_background_color_t f;
} lcd_background_color_u;

typedef struct _crtc_ps2_t {
     unsigned long ps2_start                      : 10;
     unsigned long                                : 6;
     unsigned long ps2_end                        : 10;
     unsigned long                                : 4;
     unsigned long ps2_pol                        : 1;
     unsigned long ps2_en                         : 1;
     } crtc_ps2_t;

typedef union {
     unsigned long val : 32;
     crtc_ps2_t f;
} crtc_ps2_u;

typedef struct _crtc_ps2_vpos_t {
     unsigned long ps2_vpos_start                 : 10;
     unsigned long                                : 6;
     unsigned long ps2_vpos_end                   : 10;
     unsigned long                                : 6;
     } crtc_ps2_vpos_t;

typedef union {
     unsigned long val : 32;
     crtc_ps2_vpos_t f;
} crtc_ps2_vpos_u;

typedef struct _crtc_ps1_active_t {
     unsigned long ps1_h_start                    : 10;
     unsigned long                                : 6;
     unsigned long ps1_h_end                      : 10;
     unsigned long                                : 3;
     unsigned long ps1_pol                        : 1;
     unsigned long ps1_en                         : 1;
     unsigned long ps1_use_nactive                : 1;
     } crtc_ps1_active_t;

typedef union {
     unsigned long val : 32;
     crtc_ps1_active_t f;
} crtc_ps1_active_u;

typedef struct _crtc_ps1_nactive_t {
     unsigned long ps1_h_start_na                 : 10;
     unsigned long                                : 6;
     unsigned long ps1_h_end_na                   : 10;
     unsigned long                                : 5;
     unsigned long ps1_en_na                      : 1;
     } crtc_ps1_nactive_t;

typedef union {
     unsigned long val : 32;
     crtc_ps1_nactive_t f;
} crtc_ps1_nactive_u;

typedef struct _crtc_gclk_ext_t {
     unsigned long gclk_alter_start               : 10;
     unsigned long                                : 6;
     unsigned long gclk_alter_width               : 2;
     unsigned long gclk_en_alter                  : 1;
     unsigned long gclk_db_width                  : 2;
     unsigned long                                : 11;
     } crtc_gclk_ext_t;

typedef union {
     unsigned long val : 32;
     crtc_gclk_ext_t f;
} crtc_gclk_ext_u;

typedef struct _crtc_alw_t {
     unsigned long alw_hstart                     : 10;
     unsigned long                                : 6;
     unsigned long alw_hend                       : 10;
     unsigned long                                : 4;
     unsigned long alw_delay                      : 1;
     unsigned long alw_en                         : 1;
     } crtc_alw_t;

typedef union {
     unsigned long val : 32;
     crtc_alw_t f;
} crtc_alw_u;

typedef struct _crtc_alw_vpos_t {
     unsigned long alw_vstart                     : 10;
     unsigned long                                : 6;
     unsigned long alw_vend                       : 10;
     unsigned long                                : 6;
     } crtc_alw_vpos_t;

typedef union {
     unsigned long val : 32;
     crtc_alw_vpos_t f;
} crtc_alw_vpos_u;

typedef struct _crtc_psk_t {
     unsigned long psk_vstart                     : 10;
     unsigned long                                : 6;
     unsigned long psk_vend                       : 10;
     unsigned long                                : 4;
     unsigned long psk_pol                        : 1;
     unsigned long psk_en                         : 1;
     } crtc_psk_t;

typedef union {
     unsigned long val : 32;
     crtc_psk_t f;
} crtc_psk_u;

typedef struct _crtc_psk_hpos_t {
     unsigned long psk_hstart                     : 10;
     unsigned long                                : 6;
     unsigned long psk_hend                       : 10;
     unsigned long                                : 6;
     } crtc_psk_hpos_t;

typedef union {
     unsigned long val : 32;
     crtc_psk_hpos_t f;
} crtc_psk_hpos_u;

typedef struct _crtc_cv4_start_t {
     unsigned long cv4_vstart                     : 10;
     unsigned long                                : 20;
     unsigned long cv4_pol                        : 1;
     unsigned long cv4_en                         : 1;
     } crtc_cv4_start_t;

typedef union {
     unsigned long val : 32;
     crtc_cv4_start_t f;
} crtc_cv4_start_u;

typedef struct _crtc_cv4_end_t {
     unsigned long cv4_vend1                      : 10;
     unsigned long                                : 6;
     unsigned long cv4_vend2                      : 10;
     unsigned long                                : 6;
     } crtc_cv4_end_t;

typedef union {
     unsigned long val : 32;
     crtc_cv4_end_t f;
} crtc_cv4_end_u;

typedef struct _crtc_cv4_hpos_t {
     unsigned long cv4_hstart                     : 10;
     unsigned long                                : 6;
     unsigned long cv4_hend                       : 10;
     unsigned long                                : 6;
     } crtc_cv4_hpos_t;

typedef union {
     unsigned long val : 32;
     crtc_cv4_hpos_t f;
} crtc_cv4_hpos_u;

typedef struct _crtc_eck_t {
     unsigned long eck_freq1                      : 3;
     unsigned long eck_en                         : 1;
     unsigned long                                : 28;
     } crtc_eck_t;

typedef union {
     unsigned long val : 32;
     crtc_eck_t f;
} crtc_eck_u;

typedef struct _refresh_cntl_t {
     unsigned long ref_frame                      : 3;
     unsigned long nref_frame                     : 5;
     unsigned long ref_cntl                       : 1;
     unsigned long stop_sm_nref                   : 1;
     unsigned long stop_req_nref                  : 1;
     unsigned long                                : 21;
     } refresh_cntl_t;

typedef union {
     unsigned long val : 32;
     refresh_cntl_t f;
} refresh_cntl_u;

typedef struct _genlcd_cntl3_t {
     unsigned long ps1_oe                         : 1;
     unsigned long ps1_pd                         : 1;
     unsigned long ps2_oe                         : 1;
     unsigned long ps2_pd                         : 1;
     unsigned long rev2_oe                        : 1;
     unsigned long rev2_pd                        : 1;
     unsigned long awl_oe                         : 1;
     unsigned long awl_pd                         : 1;
     unsigned long dinv_oe                        : 1;
     unsigned long dinv_pd                        : 1;
     unsigned long psk_out                        : 1;
     unsigned long psd_out                        : 1;
     unsigned long eck_out                        : 1;
     unsigned long cv4_out                        : 1;
     unsigned long ps1_out                        : 1;
     unsigned long ps2_out                        : 1;
     unsigned long rev_out                        : 1;
     unsigned long rev2_out                       : 1;
     unsigned long                                : 14;
     } genlcd_cntl3_t;

typedef union {
     unsigned long val : 32;
     genlcd_cntl3_t f;
} genlcd_cntl3_u;

typedef struct _gpio_data2_t {
     unsigned long gio2_out                       : 16;
     unsigned long gio2_in                        : 16;
     } gpio_data2_t;

typedef union {
     unsigned long val : 32;
     gpio_data2_t f;
} gpio_data2_u;

typedef struct _gpio_cntl3_t {
     unsigned long gio2_pd                        : 16;
     unsigned long gio2_schmen                    : 16;
     } gpio_cntl3_t;

typedef union {
     unsigned long val : 32;
     gpio_cntl3_t f;
} gpio_cntl3_u;

typedef struct _gpio_cntl4_t {
     unsigned long gio2_oe                        : 16;
     unsigned long                                : 16;
     } gpio_cntl4_t;

typedef union {
     unsigned long val : 32;
     gpio_cntl4_t f;
} gpio_cntl4_u;

typedef struct _chip_strap_t {
     unsigned long config_strap                   : 8;
     unsigned long pkg_strap                      : 1;
     unsigned long                                : 23;
     } chip_strap_t;

typedef union {
     unsigned long val : 32;
     chip_strap_t f;
} chip_strap_u;

typedef struct _disp_debug2_t {
     unsigned long disp_debug2                    : 32;
     } disp_debug2_t;

typedef union {
     unsigned long val : 32;
     disp_debug2_t f;
} disp_debug2_u;

typedef struct _debug_bus_cntl_t {
     unsigned long debug_testmux                  : 4;
     unsigned long debug_testsel                  : 4;
     unsigned long debug_gioa_sel                 : 2;
     unsigned long debug_giob_sel                 : 2;
     unsigned long debug_clk_sel                  : 1;
     unsigned long debug_clk_inv                  : 1;
     unsigned long                                : 2;
     unsigned long debug_bus                      : 16;
     } debug_bus_cntl_t;

typedef union {
     unsigned long val : 32;
     debug_bus_cntl_t f;
} debug_bus_cntl_u;

typedef struct _gamma_value1_t {
     unsigned long gamma1                         : 8;
     unsigned long gamma2                         : 8;
     unsigned long gamma3                         : 8;
     unsigned long gamma4                         : 8;
     } gamma_value1_t;

typedef union {
     unsigned long val : 32;
     gamma_value1_t f;
} gamma_value1_u;

typedef struct _gamma_value2_t {
     unsigned long gamma5                         : 8;
     unsigned long gamma6                         : 8;
     unsigned long gamma7                         : 8;
     unsigned long gamma8                         : 8;
     } gamma_value2_t;

typedef union {
     unsigned long val : 32;
     gamma_value2_t f;
} gamma_value2_u;

typedef struct _gamma_slope_t {
     unsigned long slope1                         : 3;
     unsigned long slope2                         : 3;
     unsigned long slope3                         : 3;
     unsigned long slope4                         : 3;
     unsigned long slope5                         : 3;
     unsigned long slope6                         : 3;
     unsigned long slope7                         : 3;
     unsigned long slope8                         : 3;
     unsigned long                                : 8;
     } gamma_slope_t;

typedef union {
     unsigned long val : 32;
     gamma_slope_t f;
} gamma_slope_u;

typedef struct _gen_status_t {
     unsigned long status                         : 16;
     unsigned long                                : 16;
     } gen_status_t;

typedef union {
     unsigned long val : 32;
     gen_status_t f;
} gen_status_u;

typedef struct _hw_int_t {
     unsigned long hwint1_pos                     : 5;
     unsigned long hwint2_pos                     : 5;
     unsigned long hwint1_pol                     : 1;
     unsigned long hwint2_pol                     : 1;
     unsigned long hwint1_en_db                   : 1;
     unsigned long hwint2_en_db                   : 1;
     unsigned long                                : 18;
     } hw_int_t;

typedef union {
     unsigned long val : 32;
     hw_int_t f;
} hw_int_u;

typedef struct _dst_offset_t {
     unsigned long dst_offset                     : 24;
     unsigned long                                : 8;
     } dst_offset_t;

typedef union {
     unsigned long val : 32;
     dst_offset_t f;
} dst_offset_u;

typedef struct _dst_pitch_t {
     unsigned long dst_pitch                      : 14;
     unsigned long mc_dst_pitch_mul               : 2;
     unsigned long                                : 16;
     } dst_pitch_t;

typedef union {
     unsigned long val : 32;
     dst_pitch_t f;
} dst_pitch_u;

typedef struct _dst_pitch_offset_t {
     unsigned long dst_offset                     : 20;
     unsigned long dst_pitch                      : 10;
     unsigned long mc_dst_pitch_mul               : 2;
     } dst_pitch_offset_t;

typedef union {
     unsigned long val : 32;
     dst_pitch_offset_t f;
} dst_pitch_offset_u;

typedef struct _dst_x_t {
     unsigned long dst_x                          : 14;
     unsigned long                                : 18;
     } dst_x_t;

typedef union {
     unsigned long val : 32;
     dst_x_t f;
} dst_x_u;

typedef struct _dst_y_t {
     unsigned long dst_y                          : 14;
     unsigned long                                : 18;
     } dst_y_t;

typedef union {
     unsigned long val : 32;
     dst_y_t f;
} dst_y_u;

typedef struct _dst_x_y_t {
     unsigned long dst_y                          : 14;
     unsigned long                                : 2;
     unsigned long dst_x                          : 14;
     unsigned long                                : 2;
     } dst_x_y_t;

typedef union {
     unsigned long val : 32;
     dst_x_y_t f;
} dst_x_y_u;

typedef struct _dst_y_x_t {
     unsigned long dst_x                          : 14;
     unsigned long                                : 2;
     unsigned long dst_y                          : 14;
     unsigned long                                : 2;
     } dst_y_x_t;

typedef union {
     unsigned long val : 32;
     dst_y_x_t f;
} dst_y_x_u;

typedef struct _dst_width_t {
     unsigned long dst_width_b0                   : 8;
     unsigned long dst_width_b1                   : 6;
     unsigned long                                : 18;
     } dst_width_t;

typedef union {
     unsigned long val : 32;
     dst_width_t f;
} dst_width_u;

typedef struct _dst_height_t {
     unsigned long dst_height                     : 14;
     unsigned long                                : 18;
     } dst_height_t;

typedef union {
     unsigned long val : 32;
     dst_height_t f;
} dst_height_u;

typedef struct _dst_width_height_t {
     unsigned long dst_height                     : 14;
     unsigned long                                : 2;
     unsigned long dst_width_b0                   : 8;
     unsigned long dst_width_b1                   : 6;
     unsigned long                                : 2;
     } dst_width_height_t;

typedef union {
     unsigned long val : 32;
     dst_width_height_t f;
} dst_width_height_u;

typedef struct _dst_height_width_t {
     unsigned long dst_width_b0                   : 8;
     unsigned long dst_width_b1                   : 6;
     unsigned long                                : 2;
     unsigned long dst_height                     : 14;
     unsigned long                                : 2;
     } dst_height_width_t;

typedef union {
     unsigned long val : 32;
     dst_height_width_t f;
} dst_height_width_u;

typedef struct _dst_height_width_8_t {
     unsigned long                                : 16;
     unsigned long dst_width_b0                   : 8;
     unsigned long dst_height                     : 8;
     } dst_height_width_8_t;

typedef union {
     unsigned long val : 32;
     dst_height_width_8_t f;
} dst_height_width_8_u;

typedef struct _dst_height_y_t {
     unsigned long dst_y                          : 14;
     unsigned long                                : 2;
     unsigned long dst_height                     : 14;
     unsigned long                                : 2;
     } dst_height_y_t;

typedef union {
     unsigned long val : 32;
     dst_height_y_t f;
} dst_height_y_u;

typedef struct _dst_width_x_t {
     unsigned long dst_x                          : 14;
     unsigned long                                : 2;
     unsigned long dst_width_b0                   : 8;
     unsigned long dst_width_b1                   : 6;
     unsigned long                                : 2;
     } dst_width_x_t;

typedef union {
     unsigned long val : 32;
     dst_width_x_t f;
} dst_width_x_u;

typedef struct _dst_width_x_incy_t {
     unsigned long dst_x                          : 14;
     unsigned long                                : 2;
     unsigned long dst_width_b0                   : 8;
     unsigned long dst_width_b1                   : 6;
     unsigned long                                : 2;
     } dst_width_x_incy_t;

typedef union {
     unsigned long val : 32;
     dst_width_x_incy_t f;
} dst_width_x_incy_u;

typedef struct _dst_line_start_t {
     unsigned long dst_start_x                    : 14;
     unsigned long                                : 2;
     unsigned long dst_start_y                    : 14;
     unsigned long                                : 2;
     } dst_line_start_t;

typedef union {
     unsigned long val : 32;
     dst_line_start_t f;
} dst_line_start_u;

typedef struct _dst_line_end_t {
     unsigned long dst_end_x                      : 14;
     unsigned long                                : 2;
     unsigned long dst_end_y_b0                   : 8;
     unsigned long dst_end_y_b1                   : 6;
     unsigned long                                : 2;
     } dst_line_end_t;

typedef union {
     unsigned long val : 32;
     dst_line_end_t f;
} dst_line_end_u;

typedef struct _brush_offset_t {
     unsigned long brush_offset                   : 24;
     unsigned long                                : 8;
     } brush_offset_t;

typedef union {
     unsigned long val : 32;
     brush_offset_t f;
} brush_offset_u;

typedef struct _brush_y_x_t {
     unsigned long brush_x                        : 5;
     unsigned long                                : 3;
     unsigned long brush_y                        : 3;
     unsigned long                                : 21;
     } brush_y_x_t;

typedef union {
     unsigned long val : 32;
     brush_y_x_t f;
} brush_y_x_u;

typedef struct _dp_brush_frgd_clr_t {
     unsigned long dp_brush_frgd_clr              : 32;
     } dp_brush_frgd_clr_t;

typedef union {
     unsigned long val : 32;
     dp_brush_frgd_clr_t f;
} dp_brush_frgd_clr_u;

typedef struct _dp_brush_bkgd_clr_t {
     unsigned long dp_brush_bkgd_clr              : 32;
     } dp_brush_bkgd_clr_t;

typedef union {
     unsigned long val : 32;
     dp_brush_bkgd_clr_t f;
} dp_brush_bkgd_clr_u;

typedef struct _src2_offset_t {
     unsigned long src2_offset                    : 24;
     unsigned long                                : 8;
     } src2_offset_t;

typedef union {
     unsigned long val : 32;
     src2_offset_t f;
} src2_offset_u;

typedef struct _src2_pitch_t {
     unsigned long src2_pitch                     : 14;
     unsigned long src2_pitch_mul                 : 2;
     unsigned long                                : 16;
     } src2_pitch_t;

typedef union {
     unsigned long val : 32;
     src2_pitch_t f;
} src2_pitch_u;

typedef struct _src2_pitch_offset_t {
     unsigned long src2_offset                    : 20;
     unsigned long                                : 2;
     unsigned long src2_pitch                     : 8;
     unsigned long src2_pitch_mul                 : 2;
     } src2_pitch_offset_t;

typedef union {
     unsigned long val : 32;
     src2_pitch_offset_t f;
} src2_pitch_offset_u;

typedef struct _src2_x_t {
     unsigned long src_x                          : 14;
     unsigned long                                : 18;
     } src2_x_t;

typedef union {
     unsigned long val : 32;
     src2_x_t f;
} src2_x_u;

typedef struct _src2_y_t {
     unsigned long src_y                          : 14;
     unsigned long                                : 18;
     } src2_y_t;

typedef union {
     unsigned long val : 32;
     src2_y_t f;
} src2_y_u;

typedef struct _src2_x_y_t {
     unsigned long src_y                          : 14;
     unsigned long                                : 2;
     unsigned long src_x                          : 14;
     unsigned long                                : 2;
     } src2_x_y_t;

typedef union {
     unsigned long val : 32;
     src2_x_y_t f;
} src2_x_y_u;

typedef struct _src2_width_t {
     unsigned long src2_width                     : 14;
     unsigned long                                : 18;
     } src2_width_t;

typedef union {
     unsigned long val : 32;
     src2_width_t f;
} src2_width_u;

typedef struct _src2_height_t {
     unsigned long src2_height                    : 14;
     unsigned long                                : 18;
     } src2_height_t;

typedef union {
     unsigned long val : 32;
     src2_height_t f;
} src2_height_u;

typedef struct _src2_inc_t {
     unsigned long src2_xinc                      : 6;
     unsigned long                                : 2;
     unsigned long src2_yinc                      : 6;
     unsigned long                                : 18;
     } src2_inc_t;

typedef union {
     unsigned long val : 32;
     src2_inc_t f;
} src2_inc_u;

typedef struct _src_offset_t {
     unsigned long src_offset                     : 24;
     unsigned long                                : 8;
     } src_offset_t;

typedef union {
     unsigned long val : 32;
     src_offset_t f;
} src_offset_u;

typedef struct _src_pitch_t {
     unsigned long src_pitch                      : 14;
     unsigned long src_pitch_mul                  : 2;
     unsigned long                                : 16;
     } src_pitch_t;

typedef union {
     unsigned long val : 32;
     src_pitch_t f;
} src_pitch_u;

typedef struct _src_pitch_offset_t {
     unsigned long src_offset                     : 20;
     unsigned long src_pitch                      : 10;
     unsigned long src_pitch_mul                  : 2;
     } src_pitch_offset_t;

typedef union {
     unsigned long val : 32;
     src_pitch_offset_t f;
} src_pitch_offset_u;

typedef struct _src_x_t {
     unsigned long src_x                          : 14;
     unsigned long                                : 18;
     } src_x_t;

typedef union {
     unsigned long val : 32;
     src_x_t f;
} src_x_u;

typedef struct _src_y_t {
     unsigned long src_y                          : 14;
     unsigned long                                : 18;
     } src_y_t;

typedef union {
     unsigned long val : 32;
     src_y_t f;
} src_y_u;

typedef struct _src_x_y_t {
     unsigned long src_y                          : 14;
     unsigned long                                : 2;
     unsigned long src_x                          : 14;
     unsigned long                                : 2;
     } src_x_y_t;

typedef union {
     unsigned long val : 32;
     src_x_y_t f;
} src_x_y_u;

typedef struct _src_y_x_t {
     unsigned long src_x                          : 14;
     unsigned long                                : 2;
     unsigned long src_y                          : 14;
     unsigned long                                : 2;
     } src_y_x_t;

typedef union {
     unsigned long val : 32;
     src_y_x_t f;
} src_y_x_u;

typedef struct _src_width_t {
     unsigned long src_width                      : 14;
     unsigned long                                : 18;
     } src_width_t;

typedef union {
     unsigned long val : 32;
     src_width_t f;
} src_width_u;

typedef struct _src_height_t {
     unsigned long src_height                     : 14;
     unsigned long                                : 18;
     } src_height_t;

typedef union {
     unsigned long val : 32;
     src_height_t f;
} src_height_u;

typedef struct _src_inc_t {
     unsigned long src_xinc                       : 6;
     unsigned long                                : 2;
     unsigned long src_yinc                       : 6;
     unsigned long                                : 18;
     } src_inc_t;

typedef union {
     unsigned long val : 32;
     src_inc_t f;
} src_inc_u;

typedef struct _host_data0_t {
     unsigned long host_data                      : 32;
     } host_data0_t;

typedef union {
     unsigned long val : 32;
     host_data0_t f;
} host_data0_u;

typedef struct _host_data1_t {
     unsigned long host_data                      : 32;
     } host_data1_t;

typedef union {
     unsigned long val : 32;
     host_data1_t f;
} host_data1_u;

typedef struct _host_data2_t {
     unsigned long host_data                      : 32;
     } host_data2_t;

typedef union {
     unsigned long val : 32;
     host_data2_t f;
} host_data2_u;

typedef struct _host_data3_t {
     unsigned long host_data                      : 32;
     } host_data3_t;

typedef union {
     unsigned long val : 32;
     host_data3_t f;
} host_data3_u;

typedef struct _host_data4_t {
     unsigned long host_data                      : 32;
     } host_data4_t;

typedef union {
     unsigned long val : 32;
     host_data4_t f;
} host_data4_u;

typedef struct _host_data5_t {
     unsigned long host_data                      : 32;
     } host_data5_t;

typedef union {
     unsigned long val : 32;
     host_data5_t f;
} host_data5_u;

typedef struct _host_data6_t {
     unsigned long host_data                      : 32;
     } host_data6_t;

typedef union {
     unsigned long val : 32;
     host_data6_t f;
} host_data6_u;

typedef struct _host_data7_t {
     unsigned long host_data                      : 32;
     } host_data7_t;

typedef union {
     unsigned long val : 32;
     host_data7_t f;
} host_data7_u;

typedef struct _host_data_last_t {
     unsigned long host_data_last                 : 32;
     } host_data_last_t;

typedef union {
     unsigned long val : 32;
     host_data_last_t f;
} host_data_last_u;

typedef struct _dp_src_frgd_clr_t {
     unsigned long dp_src_frgd_clr                : 32;
     } dp_src_frgd_clr_t;

typedef union {
     unsigned long val : 32;
     dp_src_frgd_clr_t f;
} dp_src_frgd_clr_u;

typedef struct _dp_src_bkgd_clr_t {
     unsigned long dp_src_bkgd_clr                : 32;
     } dp_src_bkgd_clr_t;

typedef union {
     unsigned long val : 32;
     dp_src_bkgd_clr_t f;
} dp_src_bkgd_clr_u;

typedef struct _sc_left_t {
     unsigned long sc_left                        : 14;
     unsigned long                                : 18;
     } sc_left_t;

typedef union {
     unsigned long val : 32;
     sc_left_t f;
} sc_left_u;

typedef struct _sc_right_t {
     unsigned long sc_right                       : 14;
     unsigned long                                : 18;
     } sc_right_t;

typedef union {
     unsigned long val : 32;
     sc_right_t f;
} sc_right_u;

typedef struct _sc_top_t {
     unsigned long sc_top                         : 14;
     unsigned long                                : 18;
     } sc_top_t;

typedef union {
     unsigned long val : 32;
     sc_top_t f;
} sc_top_u;

typedef struct _sc_bottom_t {
     unsigned long sc_bottom                      : 14;
     unsigned long                                : 18;
     } sc_bottom_t;

typedef union {
     unsigned long val : 32;
     sc_bottom_t f;
} sc_bottom_u;

typedef struct _src_sc_right_t {
     unsigned long sc_right                       : 14;
     unsigned long                                : 18;
     } src_sc_right_t;

typedef union {
     unsigned long val : 32;
     src_sc_right_t f;
} src_sc_right_u;

typedef struct _src_sc_bottom_t {
     unsigned long sc_bottom                      : 14;
     unsigned long                                : 18;
     } src_sc_bottom_t;

typedef union {
     unsigned long val : 32;
     src_sc_bottom_t f;
} src_sc_bottom_u;

typedef struct _dp_cntl_t {
     unsigned long dst_x_dir                      : 1;
     unsigned long dst_y_dir                      : 1;
     unsigned long src_x_dir                      : 1;
     unsigned long src_y_dir                      : 1;
     unsigned long dst_major_x                    : 1;
     unsigned long src_major_x                    : 1;
     unsigned long                                : 26;
     } dp_cntl_t;

typedef union {
     unsigned long val : 32;
     dp_cntl_t f;
} dp_cntl_u;

typedef struct _dp_cntl_dst_dir_t {
     unsigned long                                : 15;
     unsigned long dst_y_dir                      : 1;
     unsigned long                                : 15;
     unsigned long dst_x_dir                      : 1;
     } dp_cntl_dst_dir_t;

typedef union {
     unsigned long val : 32;
     dp_cntl_dst_dir_t f;
} dp_cntl_dst_dir_u;

typedef struct _dp_datatype_t {
     unsigned long dp_dst_datatype                : 4;
     unsigned long                                : 4;
     unsigned long dp_brush_datatype              : 4;
     unsigned long dp_src2_type                   : 1;
     unsigned long dp_src2_datatype               : 3;
     unsigned long dp_src_datatype                : 3;
     unsigned long                                : 11;
     unsigned long dp_byte_pix_order              : 1;
     unsigned long                                : 1;
     } dp_datatype_t;

typedef union {
     unsigned long val : 32;
     dp_datatype_t f;
} dp_datatype_u;

typedef struct _dp_mix_t {
     unsigned long                                : 8;
     unsigned long dp_src_source                  : 3;
     unsigned long dp_src2_source                 : 3;
     unsigned long                                : 2;
     unsigned long dp_rop3                        : 8;
     unsigned long dp_op                          : 1;
     unsigned long                                : 7;
     } dp_mix_t;

typedef union {
     unsigned long val : 32;
     dp_mix_t f;
} dp_mix_u;

typedef struct _dp_write_msk_t {
     unsigned long dp_write_msk                   : 32;
     } dp_write_msk_t;

typedef union {
     unsigned long val : 32;
     dp_write_msk_t f;
} dp_write_msk_u;

typedef struct _clr_cmp_clr_src_t {
     unsigned long clr_cmp_clr_src                : 32;
     } clr_cmp_clr_src_t;

typedef union {
     unsigned long val : 32;
     clr_cmp_clr_src_t f;
} clr_cmp_clr_src_u;

typedef struct _clr_cmp_clr_dst_t {
     unsigned long clr_cmp_clr_dst                : 32;
     } clr_cmp_clr_dst_t;

typedef union {
     unsigned long val : 32;
     clr_cmp_clr_dst_t f;
} clr_cmp_clr_dst_u;

typedef struct _clr_cmp_cntl_t {
     unsigned long clr_cmp_fcn_src                : 3;
     unsigned long                                : 5;
     unsigned long clr_cmp_fcn_dst                : 3;
     unsigned long                                : 13;
     unsigned long clr_cmp_src                    : 2;
     unsigned long                                : 6;
     } clr_cmp_cntl_t;

typedef union {
     unsigned long val : 32;
     clr_cmp_cntl_t f;
} clr_cmp_cntl_u;

typedef struct _clr_cmp_msk_t {
     unsigned long clr_cmp_msk                    : 32;
     } clr_cmp_msk_t;

typedef union {
     unsigned long val : 32;
     clr_cmp_msk_t f;
} clr_cmp_msk_u;

typedef struct _default_pitch_offset_t {
     unsigned long default_offset                 : 20;
     unsigned long default_pitch                  : 10;
     unsigned long                                : 2;
     } default_pitch_offset_t;

typedef union {
     unsigned long val : 32;
     default_pitch_offset_t f;
} default_pitch_offset_u;

typedef struct _default_sc_bottom_right_t {
     unsigned long default_sc_right               : 14;
     unsigned long                                : 2;
     unsigned long default_sc_bottom              : 14;
     unsigned long                                : 2;
     } default_sc_bottom_right_t;

typedef union {
     unsigned long val : 32;
     default_sc_bottom_right_t f;
} default_sc_bottom_right_u;

typedef struct _default2_sc_bottom_right_t {
     unsigned long default_sc_right               : 14;
     unsigned long                                : 2;
     unsigned long default_sc_bottom              : 14;
     unsigned long                                : 2;
     } default2_sc_bottom_right_t;

typedef union {
     unsigned long val : 32;
     default2_sc_bottom_right_t f;
} default2_sc_bottom_right_u;

typedef struct _ref1_pitch_offset_t {
     unsigned long offset                         : 20;
     unsigned long                                : 2;
     unsigned long pitch                          : 8;
     unsigned long                                : 2;
     } ref1_pitch_offset_t;

typedef union {
     unsigned long val : 32;
     ref1_pitch_offset_t f;
} ref1_pitch_offset_u;

typedef struct _ref2_pitch_offset_t {
     unsigned long offset                         : 20;
     unsigned long                                : 2;
     unsigned long pitch                          : 8;
     unsigned long                                : 2;
     } ref2_pitch_offset_t;

typedef union {
     unsigned long val : 32;
     ref2_pitch_offset_t f;
} ref2_pitch_offset_u;

typedef struct _ref3_pitch_offset_t {
     unsigned long offset                         : 20;
     unsigned long                                : 2;
     unsigned long pitch                          : 8;
     unsigned long                                : 2;
     } ref3_pitch_offset_t;

typedef union {
     unsigned long val : 32;
     ref3_pitch_offset_t f;
} ref3_pitch_offset_u;

typedef struct _ref4_pitch_offset_t {
     unsigned long offset                         : 20;
     unsigned long                                : 2;
     unsigned long pitch                          : 8;
     unsigned long                                : 2;
     } ref4_pitch_offset_t;

typedef union {
     unsigned long val : 32;
     ref4_pitch_offset_t f;
} ref4_pitch_offset_u;

typedef struct _ref5_pitch_offset_t {
     unsigned long offset                         : 20;
     unsigned long                                : 2;
     unsigned long pitch                          : 8;
     unsigned long                                : 2;
     } ref5_pitch_offset_t;

typedef union {
     unsigned long val : 32;
     ref5_pitch_offset_t f;
} ref5_pitch_offset_u;

typedef struct _ref6_pitch_offset_t {
     unsigned long offset                         : 20;
     unsigned long                                : 2;
     unsigned long pitch                          : 8;
     unsigned long                                : 2;
     } ref6_pitch_offset_t;

typedef union {
     unsigned long val : 32;
     ref6_pitch_offset_t f;
} ref6_pitch_offset_u;

typedef struct _dp_gui_master_cntl_t {
     unsigned long gmc_src_pitch_offset_cntl      : 1;
     unsigned long gmc_dst_pitch_offset_cntl      : 1;
     unsigned long gmc_src_clipping               : 1;
     unsigned long gmc_dst_clipping               : 1;
     unsigned long gmc_brush_datatype             : 4;
     unsigned long gmc_dst_datatype               : 4;
     unsigned long gmc_src_datatype               : 3;
     unsigned long gmc_byte_pix_order             : 1;
     unsigned long gmc_default_sel                : 1;
     unsigned long gmc_rop3                       : 8;
     unsigned long gmc_dp_src_source              : 3;
     unsigned long gmc_clr_cmp_fcn_dis            : 1;
     unsigned long                                : 1;
     unsigned long gmc_wr_msk_dis                 : 1;
     unsigned long gmc_dp_op                      : 1;
     } dp_gui_master_cntl_t;

typedef union {
     unsigned long val : 32;
     dp_gui_master_cntl_t f;
} dp_gui_master_cntl_u;

typedef struct _sc_top_left_t {
     unsigned long sc_left                        : 14;
     unsigned long                                : 2;
     unsigned long sc_top                         : 14;
     unsigned long                                : 2;
     } sc_top_left_t;

typedef union {
     unsigned long val : 32;
     sc_top_left_t f;
} sc_top_left_u;

typedef struct _sc_bottom_right_t {
     unsigned long sc_right                       : 14;
     unsigned long                                : 2;
     unsigned long sc_bottom                      : 14;
     unsigned long                                : 2;
     } sc_bottom_right_t;

typedef union {
     unsigned long val : 32;
     sc_bottom_right_t f;
} sc_bottom_right_u;

typedef struct _src_sc_bottom_right_t {
     unsigned long sc_right                       : 14;
     unsigned long                                : 2;
     unsigned long sc_bottom                      : 14;
     unsigned long                                : 2;
     } src_sc_bottom_right_t;

typedef union {
     unsigned long val : 32;
     src_sc_bottom_right_t f;
} src_sc_bottom_right_u;

typedef struct _global_alpha_t {
     unsigned long alpha_r                        : 8;
     unsigned long alpha_g                        : 8;
     unsigned long alpha_b                        : 8;
     unsigned long alpha_a                        : 8;
     } global_alpha_t;

typedef union {
     unsigned long val : 32;
     global_alpha_t f;
} global_alpha_u;

typedef struct _filter_coef_t {
     unsigned long c_4                            : 4;
     unsigned long c_3                            : 4;
     unsigned long c_2                            : 4;
     unsigned long c_1                            : 4;
     unsigned long c1                             : 4;
     unsigned long c2                             : 4;
     unsigned long c3                             : 4;
     unsigned long c4                             : 4;
     } filter_coef_t;

typedef union {
     unsigned long val : 32;
     filter_coef_t f;
} filter_coef_u;

typedef struct _mvc_cntl_start_t {
     unsigned long mc_cntl_src_1_index            : 4;
     unsigned long mc_cntl_dst_offset             : 20;
     unsigned long mc_dst_pitch_mul               : 2;
     unsigned long mc_cntl_src_2_index            : 3;
     unsigned long mc_cntl_width_height_sel       : 3;
     } mvc_cntl_start_t;

typedef union {
     unsigned long val : 32;
     mvc_cntl_start_t f;
} mvc_cntl_start_u;

typedef struct _e2_arithmetic_cntl_t {
     unsigned long opcode                         : 5;
     unsigned long shiftright                     : 4;
     unsigned long clamp                          : 1;
     unsigned long rounding                       : 2;
     unsigned long filter_n                       : 3;
     unsigned long                                : 1;
     unsigned long srcblend_inv                   : 1;
     unsigned long srcblend                       : 4;
     unsigned long                                : 3;
     unsigned long dstblend_inv                   : 1;
     unsigned long dstblend                       : 4;
     unsigned long dst_signed                     : 1;
     unsigned long autoinc                        : 1;
     unsigned long                                : 1;
     } e2_arithmetic_cntl_t;

typedef union {
     unsigned long val : 32;
     e2_arithmetic_cntl_t f;
} e2_arithmetic_cntl_u;

typedef struct _debug0_t {
     unsigned long debug0_r                       : 8;
     unsigned long                                : 8;
     unsigned long debug0_rw                      : 8;
     unsigned long                                : 8;
     } debug0_t;

typedef union {
     unsigned long val : 32;
     debug0_t f;
} debug0_u;

typedef struct _debug1_t {
     unsigned long debug1_r                       : 8;
     unsigned long                                : 8;
     unsigned long debug1_rw                      : 8;
     unsigned long                                : 8;
     } debug1_t;

typedef union {
     unsigned long val : 32;
     debug1_t f;
} debug1_u;

typedef struct _debug2_t {
     unsigned long debug2_r                       : 8;
     unsigned long                                : 8;
     unsigned long debug2_rw                      : 8;
     unsigned long                                : 8;
     } debug2_t;

typedef union {
     unsigned long val : 32;
     debug2_t f;
} debug2_u;

typedef struct _debug3_t {
     unsigned long                                : 32;
     } debug3_t;

typedef union {
     unsigned long val : 32;
     debug3_t f;
} debug3_u;

typedef struct _debug4_t {
     unsigned long                                : 32;
     } debug4_t;

typedef union {
     unsigned long val : 32;
     debug4_t f;
} debug4_u;

typedef struct _debug5_t {
     unsigned long                                : 32;
     } debug5_t;

typedef union {
     unsigned long val : 32;
     debug5_t f;
} debug5_u;

typedef struct _debug6_t {
     unsigned long                                : 32;
     } debug6_t;

typedef union {
     unsigned long val : 32;
     debug6_t f;
} debug6_u;

typedef struct _debug7_t {
     unsigned long                                : 32;
     } debug7_t;

typedef union {
     unsigned long val : 32;
     debug7_t f;
} debug7_u;

typedef struct _debug8_t {
     unsigned long                                : 32;
     } debug8_t;

typedef union {
     unsigned long val : 32;
     debug8_t f;
} debug8_u;

typedef struct _debug9_t {
     unsigned long                                : 32;
     } debug9_t;

typedef union {
     unsigned long val : 32;
     debug9_t f;
} debug9_u;

typedef struct _debug10_t {
     unsigned long                                : 32;
     } debug10_t;

typedef union {
     unsigned long val : 32;
     debug10_t f;
} debug10_u;

typedef struct _debug11_t {
     unsigned long                                : 32;
     } debug11_t;

typedef union {
     unsigned long val : 32;
     debug11_t f;
} debug11_u;

typedef struct _debug12_t {
     unsigned long                                : 32;
     } debug12_t;

typedef union {
     unsigned long val : 32;
     debug12_t f;
} debug12_u;

typedef struct _debug13_t {
     unsigned long                                : 32;
     } debug13_t;

typedef union {
     unsigned long val : 32;
     debug13_t f;
} debug13_u;

typedef struct _debug14_t {
     unsigned long                                : 32;
     } debug14_t;

typedef union {
     unsigned long val : 32;
     debug14_t f;
} debug14_u;

typedef struct _debug15_t {
     unsigned long                                : 32;
     } debug15_t;

typedef union {
     unsigned long val : 32;
     debug15_t f;
} debug15_u;

typedef struct _eng_cntl_t {
     unsigned long erc_reg_rd_ws                  : 1;
     unsigned long erc_reg_wr_ws                  : 1;
     unsigned long erc_idle_reg_wr                : 1;
     unsigned long dis_engine_triggers            : 1;
     unsigned long dis_rop_src_uses_dst_w_h       : 1;
     unsigned long dis_src_uses_dst_dirmaj        : 1;
     unsigned long                                : 6;
     unsigned long force_3dclk_when_2dclk         : 1;
     unsigned long                                : 19;
     } eng_cntl_t;

typedef union {
     unsigned long val : 32;
     eng_cntl_t f;
} eng_cntl_u;

typedef struct _eng_perf_cnt_t {
     unsigned long perf_cnt                       : 20;
     unsigned long perf_sel                       : 4;
     unsigned long perf_en                        : 1;
     unsigned long                                : 3;
     unsigned long perf_clr                       : 1;
     unsigned long                                : 3;
     } eng_perf_cnt_t;

typedef union {
     unsigned long val : 32;
     eng_perf_cnt_t f;
} eng_perf_cnt_u;

typedef struct _idct_runs_t {
     unsigned long idct_runs_3                    : 8;
     unsigned long idct_runs_2                    : 8;
     unsigned long idct_runs_1                    : 8;
     unsigned long idct_runs_0                    : 8;
     } idct_runs_t;

typedef union {
     unsigned long val : 32;
     idct_runs_t f;
} idct_runs_u;

typedef struct _idct_levels_t {
     unsigned long idct_level_hi                  : 16;
     unsigned long idct_level_lo                  : 16;
     } idct_levels_t;

typedef union {
     unsigned long val : 32;
     idct_levels_t f;
} idct_levels_u;

typedef struct _idct_control_t {
     unsigned long idct_ctl_luma_rd_format        : 2;
     unsigned long idct_ctl_chroma_rd_format      : 2;
     unsigned long idct_ctl_scan_pattern          : 1;
     unsigned long idct_ctl_intra                 : 1;
     unsigned long idct_ctl_flush                 : 1;
     unsigned long idct_ctl_passthru              : 1;
     unsigned long idct_ctl_sw_reset              : 1;
     unsigned long idct_ctl_constreq              : 1;
     unsigned long idct_ctl_scramble              : 1;
     unsigned long idct_ctl_alt_scan              : 1;
     unsigned long                                : 20;
     } idct_control_t;

typedef union {
     unsigned long val : 32;
     idct_control_t f;
} idct_control_u;

typedef struct _idct_auth_control_t {
     unsigned long control_bits                   : 32;
     } idct_auth_control_t;

typedef union {
     unsigned long val : 32;
     idct_auth_control_t f;
} idct_auth_control_u;

typedef struct _idct_auth_t {
     unsigned long auth                           : 32;
     } idct_auth_t;

typedef union {
     unsigned long val : 32;
     idct_auth_t f;
} idct_auth_u;

typedef struct _mem_cntl_t {
     unsigned long                                : 1;
     unsigned long en_mem_ch1                     : 1;
     unsigned long en_mem_ch2                     : 1;
     unsigned long int_mem_mapping                : 1;
     unsigned long                                : 28;
     } mem_cntl_t;

typedef union {
     unsigned long val : 32;
     mem_cntl_t f;
} mem_cntl_u;

typedef struct _mem_arb_t {
     unsigned long disp_time_slot                 : 4;
     unsigned long disp_timer                     : 4;
     unsigned long arb_option                     : 1;
     unsigned long                                : 23;
     } mem_arb_t;

typedef union {
     unsigned long val : 32;
     mem_arb_t f;
} mem_arb_u;

typedef struct _mc_fb_location_t {
     unsigned long mc_fb_start                    : 16;
     unsigned long mc_fb_top                      : 16;
     } mc_fb_location_t;

typedef union {
     unsigned long val : 32;
     mc_fb_location_t f;
} mc_fb_location_u;

typedef struct _mem_ext_cntl_t {
     unsigned long mem_ext_enable                 : 1;
     unsigned long mem_ap_enable                  : 1;
     unsigned long mem_addr_mapping               : 2;
     unsigned long mem_wdoe_cntl                  : 2;
     unsigned long mem_wdoe_extend                : 1;
     unsigned long                                : 1;
     unsigned long mem_page_timer                 : 8;
     unsigned long mem_dynamic_cke                : 1;
     unsigned long mem_sdram_tri_en               : 1;
     unsigned long mem_self_refresh_en            : 1;
     unsigned long mem_power_down                 : 1;
     unsigned long mem_hw_power_down_en           : 1;
     unsigned long mem_power_down_stat            : 1;
     unsigned long                                : 3;
     unsigned long mem_pd_mck                     : 1;
     unsigned long mem_pd_ma                      : 1;
     unsigned long mem_pd_mdq                     : 1;
     unsigned long mem_tristate_mck               : 1;
     unsigned long mem_tristate_ma                : 1;
     unsigned long mem_tristate_mcke              : 1;
     unsigned long mem_invert_mck                 : 1;
     } mem_ext_cntl_t;

typedef union {
     unsigned long val : 32;
     mem_ext_cntl_t f;
} mem_ext_cntl_u;

typedef struct _mc_ext_mem_location_t {
     unsigned long mc_ext_mem_start               : 16;
     unsigned long mc_ext_mem_top                 : 16;
     } mc_ext_mem_location_t;

typedef union {
     unsigned long val : 32;
     mc_ext_mem_location_t f;
} mc_ext_mem_location_u;

typedef struct _mem_ext_timing_cntl_t {
     unsigned long mem_trp                        : 2;
     unsigned long mem_trcd                       : 2;
     unsigned long mem_tras                       : 3;
     unsigned long                                : 1;
     unsigned long mem_trrd                       : 2;
     unsigned long mem_tr2w                       : 2;
     unsigned long mem_twr                        : 2;
     unsigned long                                : 4;
     unsigned long mem_twr_mode                   : 1;
     unsigned long                                : 1;
     unsigned long mem_refresh_dis                : 1;
     unsigned long                                : 3;
     unsigned long mem_refresh_rate               : 8;
     } mem_ext_timing_cntl_t;

typedef union {
     unsigned long val : 32;
     mem_ext_timing_cntl_t f;
} mem_ext_timing_cntl_u;

typedef struct _mem_sdram_mode_reg_t {
     unsigned long mem_mode_reg                   : 14;
     unsigned long                                : 2;
     unsigned long mem_read_latency               : 2;
     unsigned long mem_schmen_latency             : 2;
     unsigned long mem_cas_latency                : 2;
     unsigned long mem_schmen_extend              : 1;
     unsigned long                                : 8;
     unsigned long mem_sdram_reset                : 1;
     } mem_sdram_mode_reg_t;

typedef union {
     unsigned long val : 32;
     mem_sdram_mode_reg_t f;
} mem_sdram_mode_reg_u;

typedef struct _mem_io_cntl_t {
     unsigned long mem_sn_mck                     : 4;
     unsigned long mem_sn_ma                      : 4;
     unsigned long mem_sn_mdq                     : 4;
     unsigned long mem_srn_mck                    : 1;
     unsigned long mem_srn_ma                     : 1;
     unsigned long mem_srn_mdq                    : 1;
     unsigned long                                : 1;
     unsigned long mem_sp_mck                     : 4;
     unsigned long mem_sp_ma                      : 4;
     unsigned long mem_sp_mdq                     : 4;
     unsigned long mem_srp_mck                    : 1;
     unsigned long mem_srp_ma                     : 1;
     unsigned long mem_srp_mdq                    : 1;
     unsigned long                                : 1;
     } mem_io_cntl_t;

typedef union {
     unsigned long val : 32;
     mem_io_cntl_t f;
} mem_io_cntl_u;

typedef struct _mc_debug_t {
     unsigned long mc_debug                       : 32;
     } mc_debug_t;

typedef union {
     unsigned long val : 32;
     mc_debug_t f;
} mc_debug_u;

typedef struct _mc_bist_ctrl_t {
     unsigned long mc_bist_ctrl                   : 32;
     } mc_bist_ctrl_t;

typedef union {
     unsigned long val : 32;
     mc_bist_ctrl_t f;
} mc_bist_ctrl_u;

typedef struct _mc_bist_collar_read_t {
     unsigned long mc_bist_collar_read            : 32;
     } mc_bist_collar_read_t;

typedef union {
     unsigned long val : 32;
     mc_bist_collar_read_t f;
} mc_bist_collar_read_u;

typedef struct _tc_mismatch_t {
     unsigned long tc_mismatch                    : 24;
     unsigned long                                : 8;
     } tc_mismatch_t;

typedef union {
     unsigned long val : 32;
     tc_mismatch_t f;
} tc_mismatch_u;

typedef struct _mc_perf_mon_cntl_t {
     unsigned long clr_perf                       : 1;
     unsigned long en_perf                        : 1;
     unsigned long                                : 2;
     unsigned long perf_op_a                      : 2;
     unsigned long perf_op_b                      : 2;
     unsigned long                                : 8;
     unsigned long monitor_period                 : 8;
     unsigned long perf_count_a_overflow          : 1;
     unsigned long perf_count_b_overflow          : 1;
     unsigned long                                : 6;
     } mc_perf_mon_cntl_t;

typedef union {
     unsigned long val : 32;
     mc_perf_mon_cntl_t f;
} mc_perf_mon_cntl_u;

typedef struct _mc_perf_counters_t {
     unsigned long mc_perf_counter_a              : 16;
     unsigned long mc_perf_counter_b              : 16;
     } mc_perf_counters_t;

typedef union {
     unsigned long val : 32;
     mc_perf_counters_t f;
} mc_perf_counters_u;

typedef struct _wait_until_t {
     unsigned long wait_crtc_pflip                : 1;
     unsigned long wait_re_crtc_vline             : 1;
     unsigned long wait_fe_crtc_vline             : 1;
     unsigned long wait_crtc_vline                : 1;
     unsigned long wait_dma_viph0_idle            : 1;
     unsigned long wait_dma_viph1_idle            : 1;
     unsigned long wait_dma_viph2_idle            : 1;
     unsigned long wait_dma_viph3_idle            : 1;
     unsigned long wait_dma_vid_idle              : 1;
     unsigned long wait_dma_gui_idle              : 1;
     unsigned long wait_cmdfifo                   : 1;
     unsigned long wait_ov0_flip                  : 1;
     unsigned long wait_ov0_slicedone             : 1;
     unsigned long                                : 1;
     unsigned long wait_2d_idle                   : 1;
     unsigned long wait_3d_idle                   : 1;
     unsigned long wait_2d_idleclean              : 1;
     unsigned long wait_3d_idleclean              : 1;
     unsigned long wait_host_idleclean            : 1;
     unsigned long wait_extern_sig                : 1;
     unsigned long cmdfifo_entries                : 7;
     unsigned long                                : 3;
     unsigned long wait_both_crtc_pflip           : 1;
     unsigned long eng_display_select             : 1;
     } wait_until_t;

typedef union {
     unsigned long val : 32;
     wait_until_t f;
} wait_until_u;

typedef struct _isync_cntl_t {
     unsigned long isync_any2d_idle3d             : 1;
     unsigned long isync_any3d_idle2d             : 1;
     unsigned long isync_trig2d_idle3d            : 1;
     unsigned long isync_trig3d_idle2d            : 1;
     unsigned long isync_wait_idlegui             : 1;
     unsigned long isync_cpscratch_idlegui        : 1;
     unsigned long                                : 26;
     } isync_cntl_t;

typedef union {
     unsigned long val : 32;
     isync_cntl_t f;
} isync_cntl_u;

typedef struct _rbbm_guicntl_t {
     unsigned long host_data_swap                 : 2;
     unsigned long                                : 30;
     } rbbm_guicntl_t;

typedef union {
     unsigned long val : 32;
     rbbm_guicntl_t f;
} rbbm_guicntl_u;

typedef struct _rbbm_status_t {
     unsigned long cmdfifo_avail                  : 7;
     unsigned long                                : 1;
     unsigned long hirq_on_rbb                    : 1;
     unsigned long cprq_on_rbb                    : 1;
     unsigned long cfrq_on_rbb                    : 1;
     unsigned long hirq_in_rtbuf                  : 1;
     unsigned long cprq_in_rtbuf                  : 1;
     unsigned long cfrq_in_rtbuf                  : 1;
     unsigned long cf_pipe_busy                   : 1;
     unsigned long eng_ev_busy                    : 1;
     unsigned long cp_cmdstrm_busy                : 1;
     unsigned long e2_busy                        : 1;
     unsigned long rb2d_busy                      : 1;
     unsigned long rb3d_busy                      : 1;
     unsigned long se_busy                        : 1;
     unsigned long re_busy                        : 1;
     unsigned long tam_busy                       : 1;
     unsigned long tdm_busy                       : 1;
     unsigned long pb_busy                        : 1;
     unsigned long                                : 6;
     unsigned long gui_active                     : 1;
     } rbbm_status_t;

typedef union {
     unsigned long val : 32;
     rbbm_status_t f;
} rbbm_status_u;

typedef struct _rbbm_cntl_t {
     unsigned long rb_settle                      : 4;
     unsigned long abortclks_hi                   : 3;
     unsigned long                                : 1;
     unsigned long abortclks_cp                   : 3;
     unsigned long                                : 1;
     unsigned long abortclks_cfifo                : 3;
     unsigned long                                : 2;
     unsigned long cpq_data_swap                  : 1;
     unsigned long                                : 3;
     unsigned long no_abort_idct                  : 1;
     unsigned long no_abort_bios                  : 1;
     unsigned long no_abort_fb                    : 1;
     unsigned long no_abort_cp                    : 1;
     unsigned long no_abort_hi                    : 1;
     unsigned long no_abort_hdp                   : 1;
     unsigned long no_abort_mc                    : 1;
     unsigned long no_abort_aic                   : 1;
     unsigned long no_abort_vip                   : 1;
     unsigned long no_abort_disp                  : 1;
     unsigned long no_abort_cg                    : 1;
     } rbbm_cntl_t;

typedef union {
     unsigned long val : 32;
     rbbm_cntl_t f;
} rbbm_cntl_u;

typedef struct _rbbm_soft_reset_t {
     unsigned long soft_reset_cp                  : 1;
     unsigned long soft_reset_hi                  : 1;
     unsigned long reserved3                      : 3;
     unsigned long soft_reset_e2                  : 1;
     unsigned long reserved2                      : 2;
     unsigned long soft_reset_mc                  : 1;
     unsigned long reserved1                      : 2;
     unsigned long soft_reset_disp                : 1;
     unsigned long soft_reset_cg                  : 1;
     unsigned long                                : 19;
     } rbbm_soft_reset_t;

typedef union {
     unsigned long val : 32;
     rbbm_soft_reset_t f;
} rbbm_soft_reset_u;

typedef struct _nqwait_until_t {
     unsigned long wait_gui_idle                  : 1;
     unsigned long                                : 31;
     } nqwait_until_t;

typedef union {
     unsigned long val : 32;
     nqwait_until_t f;
} nqwait_until_u;

typedef struct _rbbm_debug_t {
     unsigned long rbbm_debug                     : 32;
     } rbbm_debug_t;

typedef union {
     unsigned long val : 32;
     rbbm_debug_t f;
} rbbm_debug_u;

typedef struct _rbbm_cmdfifo_addr_t {
     unsigned long cmdfifo_addr                   : 6;
     unsigned long                                : 26;
     } rbbm_cmdfifo_addr_t;

typedef union {
     unsigned long val : 32;
     rbbm_cmdfifo_addr_t f;
} rbbm_cmdfifo_addr_u;

typedef struct _rbbm_cmdfifo_datal_t {
     unsigned long cmdfifo_datal                  : 32;
     } rbbm_cmdfifo_datal_t;

typedef union {
     unsigned long val : 32;
     rbbm_cmdfifo_datal_t f;
} rbbm_cmdfifo_datal_u;

typedef struct _rbbm_cmdfifo_datah_t {
     unsigned long cmdfifo_datah                  : 12;
     unsigned long                                : 20;
     } rbbm_cmdfifo_datah_t;

typedef union {
     unsigned long val : 32;
     rbbm_cmdfifo_datah_t f;
} rbbm_cmdfifo_datah_u;

typedef struct _rbbm_cmdfifo_stat_t {
     unsigned long cmdfifo_rptr                   : 6;
     unsigned long                                : 2;
     unsigned long cmdfifo_wptr                   : 6;
     unsigned long                                : 18;
     } rbbm_cmdfifo_stat_t;

typedef union {
     unsigned long val : 32;
     rbbm_cmdfifo_stat_t f;
} rbbm_cmdfifo_stat_u;

typedef struct _clk_pin_cntl_t {
     unsigned long osc_en                         : 1;
     unsigned long osc_gain                       : 5;
     unsigned long dont_use_xtalin                : 1;
     unsigned long xtalin_pm_en                   : 1;
     unsigned long xtalin_dbl_en                  : 1;
     unsigned long                                : 7;
     unsigned long cg_debug                       : 16;
     } clk_pin_cntl_t;

typedef union {
     unsigned long val : 32;
     clk_pin_cntl_t f;
} clk_pin_cntl_u;

typedef struct _pll_ref_fb_div_t {
     unsigned long pll_ref_div                    : 4;
     unsigned long                                : 4;
     unsigned long pll_fb_div_int                 : 6;
     unsigned long                                : 2;
     unsigned long pll_fb_div_frac                : 3;
     unsigned long                                : 1;
     unsigned long pll_reset_time                 : 4;
     unsigned long pll_lock_time                  : 8;
     } pll_ref_fb_div_t;

typedef union {
     unsigned long val : 32;
     pll_ref_fb_div_t f;
} pll_ref_fb_div_u;

typedef struct _pll_cntl_t {
     unsigned long pll_pwdn                       : 1;
     unsigned long pll_reset                      : 1;
     unsigned long pll_pm_en                      : 1;
     unsigned long pll_mode                       : 1;
     unsigned long pll_refclk_sel                 : 1;
     unsigned long pll_fbclk_sel                  : 1;
     unsigned long pll_tcpoff                     : 1;
     unsigned long pll_pcp                        : 3;
     unsigned long pll_pvg                        : 3;
     unsigned long pll_vcofr                      : 1;
     unsigned long pll_ioffset                    : 2;
     unsigned long pll_pecc_mode                  : 2;
     unsigned long pll_pecc_scon                  : 2;
     unsigned long pll_dactal                     : 4;
     unsigned long pll_cp_clip                    : 2;
     unsigned long pll_conf                       : 3;
     unsigned long pll_mbctrl                     : 2;
     unsigned long pll_ring_off                   : 1;
     } pll_cntl_t;

typedef union {
     unsigned long val : 32;
     pll_cntl_t f;
} pll_cntl_u;

typedef struct _sclk_cntl_t {
     unsigned long sclk_src_sel                   : 2;
     unsigned long                                : 2;
     unsigned long sclk_post_div_fast             : 4;
     unsigned long sclk_clkon_hys                 : 3;
     unsigned long sclk_post_div_slow             : 4;
     unsigned long disp_cg_ok2switch_en           : 1;
     unsigned long sclk_force_reg                 : 1;
     unsigned long sclk_force_disp                : 1;
     unsigned long sclk_force_mc                  : 1;
     unsigned long sclk_force_extmc               : 1;
     unsigned long sclk_force_cp                  : 1;
     unsigned long sclk_force_e2                  : 1;
     unsigned long sclk_force_e3                  : 1;
     unsigned long sclk_force_idct                : 1;
     unsigned long sclk_force_bist                : 1;
     unsigned long busy_extend_cp                 : 1;
     unsigned long busy_extend_e2                 : 1;
     unsigned long busy_extend_e3                 : 1;
     unsigned long busy_extend_idct               : 1;
     unsigned long                                : 3;
     } sclk_cntl_t;

typedef union {
     unsigned long val : 32;
     sclk_cntl_t f;
} sclk_cntl_u;

typedef struct _pclk_cntl_t {
     unsigned long pclk_src_sel                   : 2;
     unsigned long                                : 2;
     unsigned long pclk_post_div                  : 4;
     unsigned long                                : 8;
     unsigned long pclk_force_disp                : 1;
     unsigned long                                : 15;
     } pclk_cntl_t;

typedef union {
     unsigned long val : 32;
     pclk_cntl_t f;
} pclk_cntl_u;

typedef struct _clk_test_cntl_t {
     unsigned long testclk_sel                    : 4;
     unsigned long                                : 3;
     unsigned long start_check_freq               : 1;
     unsigned long tstcount_rst                   : 1;
     unsigned long                                : 15;
     unsigned long test_count                     : 8;
     } clk_test_cntl_t;

typedef union {
     unsigned long val : 32;
     clk_test_cntl_t f;
} clk_test_cntl_u;

typedef struct _pwrmgt_cntl_t {
     unsigned long pwm_enable                     : 1;
     unsigned long                                : 1;
     unsigned long pwm_mode_req                   : 2;
     unsigned long pwm_wakeup_cond                : 2;
     unsigned long pwm_fast_noml_hw_en            : 1;
     unsigned long pwm_noml_fast_hw_en            : 1;
     unsigned long pwm_fast_noml_cond             : 4;
     unsigned long pwm_noml_fast_cond             : 4;
     unsigned long pwm_idle_timer                 : 8;
     unsigned long pwm_busy_timer                 : 8;
     } pwrmgt_cntl_t;

typedef union {
     unsigned long val : 32;
     pwrmgt_cntl_t f;
} pwrmgt_cntl_u;

typedef struct _pwrmgt_status_t {
     unsigned long pwm_mode                       : 2;
     unsigned long                                : 30;
     } pwrmgt_status_t;

typedef union {
     unsigned long val : 32;
     pwrmgt_status_t f;
} pwrmgt_status_u;

typedef struct tagDISPLAYSTATE {
lcd_format_u	       LcdFormat;
crtc_total_u	       CrtcTotal;
active_h_disp_u	       ActiveHDisp;
active_v_disp_u	       ActiveVDisp;
crtc_ss_u	       CrtcSS;
crtc_ls_u	       CrtcLS;
crtc_gs_u	       CrtcGS;
crtc_vpos_gs_u	       CrtcVPosGS;
crtc_gclk_u	       CrtcGClk;
crtc_goe_u	       CrtcGOE;
crtc_rev_u	       CrtcRev;
crtc_dclk_u	       CrtcDClk;
crtc_default_count_u   CrtcDefaultCount;
crtc_frame_u	       CrtcFrame;
crtc_frame_vpos_u      CrtcFrameVPos;
lcdd_cntl1_u	       LcddCntl1;
lcdd_cntl2_u	       LcddCntl2;
genlcd_cntl1_u	       GenlcdCntl1;
genlcd_cntl2_u	       GenlcdCntl2;
lcd_background_color_u LcdBackgroundColor;
brightness_cntl_u      Brightness_Cntl;
} DISPLAYSTATE;

typedef struct {
s16		X_Top_Left;      	// x coordinate of top left corner
s16		Y_Top_Left;	   	// y coordinate of top left corner
s16		X_Bottom_Right;		// x coordinate of bottom right corner
s16		Y_Bottom_Right;		// y coordinate of bottom right corner
} ATI_CLIPRECT;

typedef struct tagGUISTATE {
dp_cntl_u            DpCntl;
dp_gui_master_cntl_u GMC;
e2_arithmetic_cntl_u E2AC;
global_alpha_u	     GlobalAlpha;
dst_pitch_u          dstPitch;
dst_offset_u         dstOffset;
src_pitch_u          srcPitch;
src_offset_u         srcOffset;
u32		     FrgrdColour;
u32		     BkgrdColour;
ATI_CLIPRECT	     SrcClipRect;
ATI_CLIPRECT	     DstClipRect;
u32 		     BrushOffset;
u16		     BrushHandle;
// for 16bpp, SRC must be the same type as DST, can't go from 1555->565
s8                   TurnOnDst565ForNon2D; 
} GUISTATE;

typedef struct tagGFXWINSTATE {
graphic_ctrl_u		GraphicCtrl;
graphic_offset_u        GraphicOffset;
graphic_pitch_u		GraphicPitch;   // byte-based
graphic_h_disp_u	GraphicHDisp;
graphic_v_disp_u	GraphicVDisp;
s8                      TurnOnDisp565;
// These memory offsets need to be translated before writing to registers
u32                     Grp_Offset;
u32			Grp_W;
u32			Grp_H;
u32			Grp_Src_X;
u32			Grp_Src_Y;
u32			Grp_Src_W;      // pixel-based
} GFXWINSTATE;

typedef struct tagPREVSTATE {
u16              PrevOverlayX;
u16              PrevOverlayY;
u8               bOverlayWasOn;
u16              PrevGfxWinX;
u16              PrevGfxWinY;
u8               bGfxWinWasOn;
} PREVSTATE;

typedef struct tagPOWERSTATE {
clk_pin_cntl_u   ClkPinCntl;
pll_ref_fb_div_u PllRefFbDiv;
pll_cntl_u       PllCntl;
sclk_cntl_u      SclkCntl;
pclk_cntl_u      PclkCntl;
clk_test_cntl_u  ClkTestCntl;
pwrmgt_cntl_u    PwrmgtCntl;
u32              Freq;
u8               tf100;
u8		 tf80;
u8               tf20;
u8               M;
u8               N_int;
u8               N_fac;
u8               lock_time;
u8               tfgoal;
u8               AutoMode;
u8               PWMMode;
u16              FastSclk;
u16              NormSclk;
PREVSTATE        PrevState;
} POWERSTATE;

typedef struct tagAPERTURE {
u32 MMRegBase;
u32 CfgRegBase;
u32 McFbStart;
u32 McFbTop;
u32 McExtMemStart;
u32 McExtMemTop;
u32 WrapStart;
u32 WrapTop;
} APERTURE;

#endif

