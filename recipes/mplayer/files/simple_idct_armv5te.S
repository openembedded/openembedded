/*
 * Simple IDCT
 *
 * Copyright (c) 2001 Michael Niedermayer <michaelni@gmx.at>
 * Copyright (c) 2006 Mans Rullgard <mans@mansr.com>
 * Copyright (c) 2007 Siarhei Siamashka <ssvb@users.sourceforge.net>
 *
 * This file is part of FFmpeg.
 *
 * FFmpeg is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * FFmpeg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with FFmpeg; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */

.arch armv5te

/* IMPORTANT: this value should be the same as defined in dsputil.h */
#define MAX_NEG_CROP 1024

/*
 * ARM EABI guarantees 8 byte stack alignment, so we can use LDRD instructions
 * for accessing stack and load two registers per cycle to improve performance
 * on ARM11 and XScale
 */
#ifdef __ARM_EABI__
#define DWORD_ALIGNED_STACK 1
#endif

#define W1  22725   /* cos(i*M_PI/16)*sqrt(2)*(1<<14) + 0.5 */
#define W2  21407   /* cos(i*M_PI/16)*sqrt(2)*(1<<14) + 0.5 */
#define W3  19266   /* cos(i*M_PI/16)*sqrt(2)*(1<<14) + 0.5 */
#define W4  16383   /* cos(i*M_PI/16)*sqrt(2)*(1<<14) + 0.5 */
#define W5  12873   /* cos(i*M_PI/16)*sqrt(2)*(1<<14) + 0.5 */
#define W6  8867    /* cos(i*M_PI/16)*sqrt(2)*(1<<14) + 0.5 */
#define W7  4520    /* cos(i*M_PI/16)*sqrt(2)*(1<<14) + 0.5 */
#define ROW_SHIFT 11
#define COL_SHIFT 20

#define W13 (W1 | (W3 << 16))
#define W26 (W2 | (W6 << 16))
#define W57 (W5 | (W7 << 16))

#define W22 ((-W2 & 0xFFFF) | (W2 << 16))
#define W44 ((-W4 & 0xFFFF) | (W4 << 16))
#define W66 ((-W6 & 0xFFFF) | (W6 << 16))

#define M51 ((-W5 & 0xFFFF) | ((-W1 & 0xFFFF) << 16))

        .text

/*
 * a local pool with 64-bit constants for 'idct_rows_armv5te' function,
 * we align it at 16 byte boundary in order to ensure that it does not cross
 * cache line boundary (occupies only a single cache line)
 */
        .balign 16
w2266idct_rows_armv5te:
        .long W22
        .long W66
w1357idct_rows_armv5te:
        .long W13
        .long W57

/*
 * A rows processing function. Benchmarks on a few video files show that
 * about 80-90% of uses of this function have all rows empty except for
 * the row[0].
 *
 * On entry:
 * a1              - row address
 * lr              - return address
 *
 * On exit:
 * a1              - row address
 *
 * Registers usage within this function:
 *  a1             - row address
 *  a2             - temporary register
 *  v5, v6, v7, v8 - row data
 *  v1, v2, v3, v4 - A0, A1, A2 and A3 variables
 *  a3, a4         - used for loading constants
 *  ip             - temporary register
 *  lr             - temporary register, also holds initial row address value
 *                   to check end of loop condition
 */
        .balign 32
        .type idct_rows_armv5te, %function
        .func idct_rows_armv5te
idct_rows_armv5te:
        str    a1, [sp, #-4]!
        str    lr, [sp, #-4]!
        mov    lr, a1
        ldrd   v7, [a1, #(8 * 16 - 8)]! /* v7 = row[5:4], v8 = row[7:6] */
1:
        ldrd   v5, [a1, #-8]!           /* v5 = row[1:0], v6 = row[3:2] */
        orrs   v1, v7, v8
        cmpeq  v1, v6
        cmpeq  v1, v5, lsr #16
        bne    2f                       /* jump to process full row */
        /* only row[0] is not empty here */
        mov    v5, v5, lsl #19
        cmp    a1, lr
        orr    v5, v5, v5, lsr #16
        str    v5, [a1]
        str    v5, [a1, #4]
        str    v5, [a1, #8]
        str    v5, [a1, #12]
        ldrned v7, [a1, #-8]!           /* v7 = row[5:4], v8 = row[7:6] */
        bne    1b
        ldr    pc, [sp], #8

2:      /* process full row */
        /* the next code fragment calculates A variables */

        ldr    a2, w44                 /* a2 = -W4 | (W4 << 16) */
        ldrd   a3, w2266idct_rows_armv5te /* a3 = -W2 | (W2 << 16) */
                                       /* a4 = -W6 | (W6 << 16) */
        mov    v1, #(1<<(ROW_SHIFT-1))
        smlatb v1, a2, v5, v1          /* v1 = W4*row[0]+(1<<(ROW_SHIFT-1)) */

        cmp    a1, lr

        smlabb v2, a2, v7, v1          /* v2 = v1 - W4*row[4] */
        smlatb v1, a2, v7, v1          /* v1 = v1 - W4*row[4] */

        smlabb v3, a4, v6, v2          /* v3 = v2 - W6*row[2] */
        smlabb v4, a3, v6, v1          /* v4 = v1 - W2*row[2] */

        smlatb v3, a3, v8, v3          /* v3 += W2*row[6] */
        smlabb v4, a4, v8, v4          /* v4 -= W6*row[6] */

        ldrd   a3, w1357idct_rows_armv5te /* a3 = W1 | (W3 << 16) */
                                       /* a4 = W5 | (W7 << 16) */

        rsb    v2, v3, v2, lsl #1      /* v2 = 2*v2 - v3 */
        rsb    v1, v4, v1, lsl #1      /* v1 = 2*v1 - v4 */

        /* all A variables are now calculated (and stored in v1, v2, v3, v4 registers) */

        smulbt a2, a3, v5              /* b0 = W1*row[1] */
        smultt ip, a3, v5              /* tmp = W3*row[1] */
        smultt lr, a4, v6              /* -b1 = W7*row[3] */
        smlatt a2, a3, v6, a2          /* b0 += W3*row[3] */
        smlabt lr, a3, v7, lr          /* -b1 += W1*row[5] */
        smlabt a2, a4, v7, a2          /* b0 += W5*row[5] */
        smlabt lr, a4, v8, lr          /* -b1 += W5*row[7] */
        smlatt a2, a4, v8, a2          /* b0 += W7*row[7] */
        sub    lr, ip, lr              /* b1 = -b1 - tmp */

        /* B0 is now calculated (a2), B1 is now calculated (lr) */

        add    ip, v1, a2              /* ip = (A0 + B0) */
        sub    a2, v1, a2              /* a2 = (A0 - B0) */
        mov    ip, ip, asr #ROW_SHIFT
        mov    a2, a2, asr #ROW_SHIFT
        strh   ip, [a1, #0]            /* row[0] = (A0 + B0) >> ROW_SHIFT */
        strh   a2, [a1, #14]           /* row[7] = (A0 - B0) >> ROW_SHIFT */

        ldr    v1, m51                 /* v1 = ((-W5 & 0xFFFF) | ((-W1 & 0xFFFF) << 16)) */

        add    ip, v2, lr              /* ip = (A1 + B1) */
        sub    a2, v2, lr              /* ip = (A1 - B1) */
        mov    ip, ip, asr #ROW_SHIFT
        mov    a2, a2, asr #ROW_SHIFT
        strh   ip, [a1, #2]            /* row[1] = (A1 + B1) >> ROW_SHIFT */
        strh   a2, [a1, #12]           /* row[6] = (A1 - B1) >> ROW_SHIFT */

        smulbt a2, a4, v5              /* b2 = W5*row[1] */
        smultt v2, a4, v5              /* b3 = W7*row[1] */
        smlatt a2, v1, v6, a2          /* b2 -= W1*row[3] */
        smlatt v2, a3, v7, v2          /* b3 += W3*row[5] */
        smlatt a2, a4, v7, a2          /* b2 += W7*row[5] */
        smlatt v2, v1, v8, v2          /* b3 -= W1*row[7] */
        smlatt a2, a3, v8, a2          /* b2 += W3*row[7] */
        smlabt v2, v1, v6, v2          /* b3 -= W5*row[3] */

        /* B2 is now calculated (a2), B3 is now calculated (v2) */

        ldr    lr, [sp, #4]

        add    ip, v3, a2              /* ip = (A2 + B2) */
        sub    a2, v3, a2              /* a2 = (A2 - B2) */
        mov    ip, ip, asr #ROW_SHIFT
        mov    a2, a2, asr #ROW_SHIFT
        strh   ip, [a1, #4]            /* row[2] = (A2 + B2) >> ROW_SHIFT */
        strh   a2, [a1, #10]           /* row[5] = (A2 - B2) >> ROW_SHIFT */

        add    ip, v4, v2              /* ip = (A3 + B3) */
        sub    a2, v4, v2              /* a2 = (A3 - B3) */
        mov    ip, ip, asr #ROW_SHIFT
        mov    a2, a2, asr #ROW_SHIFT
        strh   ip, [a1, #6]            /* row[3] = (A3 + B3) >> ROW_SHIFT */
        strh   a2, [a1, #8]            /* row[4] = (A3 - B3) >> ROW_SHIFT */

        ldrned v7, [a1, #-8]!          /* v7 = row[5:4], v8 = row[7:6] */
        bne    1b
        ldr    pc, [sp], #8
        .endfunc

/******************************************************************************/

/*
 * a global pool with 32-bit constants (used from all the functions in this module),
 * we align it at 32 byte boundary in order to ensure that it does not cross cache
 * line boundary (occupies only a single cache line)
 */
        .balign 32
simple_idct_croptbl_armv5te:
        .long (ff_cropTbl + MAX_NEG_CROP)
m51:    .long M51
w44:    .long W44
xxx:    .long (((1<<(COL_SHIFT-1))/W4)*W4)
m7:     .long (-W7)

/*
 * Enforce 8 byte stack alignment if it is not provided by ABI. Used at the beginning
 * of global functions. If stack is not properly aligned, real return address is
 * pushed to stack (thus fixing stack alignment) and lr register is set to a thunk
 * function 'unaligned_return_thunk_armv5te' which is responsible for providing
 * correct return from the function in this case.
 */
        .macro idct_stackalign_armv5te
#ifndef DWORD_ALIGNED_STACK
        tst    sp, #4
        strne  lr, [sp, #-4]!
        adrne  lr, unaligned_return_thunk_armv5te
#endif
        .endm

/*
 * Process two columns at once.
 *
 * Registers usage within this macro:
 *  a1             - column address
 *  a2             - temporary register
 *  A0b (v1), A0t (v2), A1b (v3), A1t (v4), A2b (v5), A2t (v6), A3b (v7), A3t (v8)
 *  B0b (v1), B0t (v2), B1b (v3), B1t (v4), B2b (v5), B2t (v6), B3b (v7), B3t (v8)
 *  a3, a4         - used for loading constants
 *  ip             - temporary register
 *  lr             - temporary register
 *
 * Data on exit ('b' suffix - first column (also bottom 16-bits of a register),
 *               't' suffix - second column (also top 16-bits of a register)):
 *  A0b, A0t, A1b, A1t, A2b, A2t, A3b, A3t - are returned in stack
 *  B0b, B0t, B1b, B1t, B2b, B2t, B3b, B3t - are returned in v1, v2, v3, v4, v5, v6, v7, v8 registers
 *  a1 - address of the next pair of columns
 */
        .macro idct_two_col_armv5te DWORD_CONST_SUFFIX
        ldr    v4, [a1], #4            /* v4 = col_t[0]:col_b[0] */
        ldr    a2, w44                 /* a2 = -W4 | (W4 << 16) */
        ldr    v1, xxx                 /* v1 = (((1<<(COL_SHIFT-1))/W4)*W4) */
        ldr    ip, [a1, #(16*4 - 4)]   /* ip = col_t[4]:col_b[4] */
        ldrd   a3, w2266\DWORD_CONST_SUFFIX /* a3 = -W2 | (W2 << 16) */
                                       /* a4 = -W6 | (W6 << 16) */
        smlatt v2, a2, v4, v1          /* A0t = W4 * (col_t[0] + ((1<<(COL_SHIFT-1))/W4)) */
        smlatb v1, a2, v4, v1          /* A0b = W4 * (col_b[0] + ((1<<(COL_SHIFT-1))/W4)) */

        ldr    lr, [a1, #(16*2 - 4)]   /* lr = col_t[2]:col_b[2] */

        smlabb v3, a2, ip, v1          /* A1b = A0b - W4*col_b[4] */
        smlatb v1, a2, ip, v1          /* A0b = A0b + W4*col_b[4] */
        smlabt v4, a2, ip, v2          /* A1t = A0t - W4*col_t[4] */
        smlatt v2, a2, ip, v2          /* A0t = A0t + W4*col_t[4] */

        ldr    ip, [a1, #(16*6 - 4)]   /* ip = col_t[6]:col_b[6] */

        smlabb v5, a4, lr, v3          /* A2b = A1b - W6*col_b[2] */
        smlabb v7, a3, lr, v1          /* A3b = A0b - W2*col_b[2] */
        smlabt v6, a4, lr, v4          /* A2t = A1t - W6*col_t[2] */
        smlabt v8, a3, lr, v2          /* A3t = A0t - W2*col_t[2] */

        ldr    lr, [a1, #(16*1 - 4)]   /* lr = col_t[1]:col_b[1] */

        smlatb v5, a3, ip, v5          /* A2b += W2*col_b[6] */
        smlabb v7, a4, ip, v7          /* A3b -= W6*col_b[6] */
        smlatt v6, a3, ip, v6          /* A2t += W2*col_t[6] */
        smlabt v8, a4, ip, v8          /* A3t -= W6*col_t[6] */

        ldrd   a3, w1357\DWORD_CONST_SUFFIX /* a3 = W1 | (W3 << 16) */
                                       /* a4 = W5 | (W7 << 16) */

        rsb    v3, v5, v3, lsl #1      /* A1b = 2*A1b - A2b */
        rsb    v1, v7, v1, lsl #1      /* A0b = 2*A0b - A3b */
        rsb    v4, v6, v4, lsl #1      /* A1t = 2*A1t - A2t */
        rsb    v2, v8, v2, lsl #1      /* A0t = 2*A0t - A3t */

        ldr    ip, [a1, #(16*5 - 4)]   /* ip = col_t[5]:col_b[5] */
        ldr    a2, m51                 /* a2 = ((-W5 & 0xFFFF) | ((-W1 & 0xFFFF) << 16)) */

        stmfd  sp!, {v1, v2, v3, v4, v5, v6, v7, v8}

        smulbb v1, a3, lr              /* B0b = W1*col_b[1] */
        smulbt v2, a3, lr              /* B0t = W1*col_t[1] */
        smultb v3, a3, lr              /* B1b = W3*col_b[1] */
        smultt v4, a3, lr              /* B1t = W3*col_t[1] */
        smulbb v5, a4, lr              /* B2b = W5*col_b[1] */
        smulbt v6, a4, lr              /* B2t = W5*col_t[1] */
        smultb v7, a4, lr              /* B3b = W7*col_b[1] */
        smultt v8, a4, lr              /* B3t = W7*col_t[1] */

        ldr    lr, [a1, #(16*7 - 4)]   /* lr = col_t[7]:col_b[7] */

        cmp    ip, #0
        beq    2f                      /* jump probability is typically more than 75% */

        smlabt v2, a4, ip, v2          /* B0t += W5*col_t[5] */
        smlatt v4, a2, ip, v4          /* B1t -= W1*col_t[5] */
        smlatt v6, a4, ip, v6          /* B2t += W7*col_t[5] */
        smlatt v8, a3, ip, v8          /* B3t += W3*col_t[5] */
        smlabb v1, a4, ip, v1          /* B0b += W5*col_b[5] */
        smlatb v3, a2, ip, v3          /* B1b -= W1*col_b[5] */
        smlatb v5, a4, ip, v5          /* B2b += W7*col_b[5] */
        smlatb v7, a3, ip, v7          /* B3b += W3*col_b[5] */
2:
        ldr    ip, [a1, #(16*3 - 4)]   /* ip = col_t[3]:col_b[3] */

        cmp    lr, #0
        beq    3f                      /* jump probability is typically more than 90% */

        smlatt v2, a4, lr, v2          /* B0t += W7*col_t[7] */
        smlabt v4, a2, lr, v4          /* B1t -= W5*col_t[7] */
        smlatt v6, a3, lr, v6          /* B2t += W3*col_t[7] */
        smlatt v8, a2, lr, v8          /* B3t -= W1*col_t[7] */

        smlatb v1, a4, lr, v1          /* B0b += W7*col_b[7] */
        smlabb v3, a2, lr, v3          /* B1b -= W5*col_b[7] */
        smlatb v5, a3, lr, v5          /* B2b += W3*col_b[7] */
        smlatb v7, a2, lr, v7          /* B3b -= W1*col_b[7] */
3:
        cmp    ip, #0
        beq    4f                      /* jump probability is typically more than 65% */

        ldr    a4, m7

        smlatt v2, a3, ip, v2          /* B0t += W3*col_t[3] */
        smlatt v6, a2, ip, v6          /* B2t -= W1*col_t[3] */
        smlabt v8, a2, ip, v8          /* B3t -= W5*col_t[3] */
        smlabt v4, a4, ip, v4          /* B1t -= W7*col_t[3] */

        smlatb v1, a3, ip, v1          /* B0b += W3*col_b[3] */
        smlatb v5, a2, ip, v5          /* B2b -= W1*col_b[3] */
        smlabb v7, a2, ip, v7          /* B3b -= W5*col_b[3] */
        smlabb v3, a4, ip, v3          /* B1b -= W7*col_b[3] */
4:
        .endm

/******************************************************************************/

/*
 * a local pool with 64-bit constants for 'simple_idct_put_armv5te' function,
 * we align it at 16 byte boundary in order to ensure that it does not cross
 * cache line boundary (occupies only a single cache line)
 */
        .balign 16
w2266simple_idct_put_armv5te:
        .long W22
        .long W66
w1357simple_idct_put_armv5te:
        .long W13
        .long W57

        .balign 32
        .global simple_idct_put_armv5te
        .type simple_idct_put_armv5te, %function
        .func simple_idct_put_armv5te
simple_idct_put_armv5te:

        idct_stackalign_armv5te

        stmfd  sp!, {v1, v2, v3, v4, v5, v6, v7, v8, lr}
        strd   a1, [sp, #-12]!

        mov    a1, a3
        bl     idct_rows_armv5te

        add    a2, a1, #16
        strd   a1, [sp, #-8]!
1:
        idct_two_col_armv5te simple_idct_put_armv5te
        str    a1, [sp, #(0 + 32)]
        ldrd   a3, [sp, #(8 + 32)]
        ldr    lr, simple_idct_croptbl_armv5te

        ldrd   a1, [sp], #8
        add    ip, a3, #2
        str    ip, [sp, #(8 + 32 - 8)]

        add    ip, a1, v1
        sub    v1, a1, v1
        add    a1, a2, v2
        sub    v2, a2, v2
        ldrb   a1, [lr, a1, asr #COL_SHIFT]
        ldrb   ip, [lr, ip, asr #COL_SHIFT]
        ldrb   v2, [lr, v2, asr #COL_SHIFT]
        ldrb   v1, [lr, v1, asr #COL_SHIFT]
        orr    ip, ip, a1, asl #8
        ldrd   a1, [sp], #8
        orr    v1, v1, v2, asl #8
        strh   ip, [a3], a4

        add    ip, a1, v3
        sub    v3, a1, v3
        add    a1, a2, v4
        sub    v4, a2, v4
        ldrb   a1, [lr, a1, asr #COL_SHIFT]
        ldrb   ip, [lr, ip, asr #COL_SHIFT]
        ldrb   v4, [lr, v4, asr #COL_SHIFT]
        ldrb   v3, [lr, v3, asr #COL_SHIFT]
        orr    ip, ip, a1, asl #8
        ldrd   a1, [sp], #8
        orr    v3, v3, v4, asl #8
        strh   ip, [a3], a4

        add    ip, a1, v5
        sub    v5, a1, v5
        add    a1, a2, v6
        sub    v6, a2, v6
        ldrb   a1, [lr, a1, asr #COL_SHIFT]
        ldrb   ip, [lr, ip, asr #COL_SHIFT]
        ldrb   v6, [lr, v6, asr #COL_SHIFT]
        ldrb   v5, [lr, v5, asr #COL_SHIFT]
        orr    ip, ip, a1, asl #8
        ldrd   a1, [sp], #8
        orr    v5, v5, v6, asl #8
        strh   ip, [a3], a4

        add    ip, a1, v7
        sub    v7, a1, v7
        add    a1, a2, v8
        sub    v8, a2, v8
        ldrb   a1, [lr, a1, asr #COL_SHIFT]
        ldrb   ip, [lr, ip, asr #COL_SHIFT]
        ldrb   v8, [lr, v8, asr #COL_SHIFT]
        ldrb   v7, [lr, v7, asr #COL_SHIFT]
        orr    ip, ip, a1, asl #8
        strh   ip, [a3], a4

        ldrd   a1, [sp, #0]
        orr    v7, v7, v8, asl #8

        strh   v7, [a3], a4
        strh   v5, [a3], a4
        cmp    a1, a2
        strh   v3, [a3], a4
        strh   v1, [a3], a4

        bne    1b

        add    sp, sp, #20
        ldmfd  sp!, {v1, v2, v3, v4, v5, v6, v7, v8, pc}
        .endfunc

/******************************************************************************/

/*
 * a local pool with 64-bit constants for 'simple_idct_add_armv5te' function, we
 * align it at 16 byte boundary in order to ensure that it does not cross
 * cache line boundary (occupies only a single cache line)
 */
        .balign 16
w2266simple_idct_add_armv5te:
        .long W22
        .long W66
w1357simple_idct_add_armv5te:
        .long W13
        .long W57

        .balign 32
        .global simple_idct_add_armv5te
        .type simple_idct_add_armv5te, %function
        .func simple_idct_add_armv5te
simple_idct_add_armv5te:

        idct_stackalign_armv5te

        stmfd  sp!, {v1, v2, v3, v4, v5, v6, v7, v8, lr}
        strd   a1, [sp, #-12]!

        mov    a1, a3
        bl     idct_rows_armv5te

        add    a2, a1, #16
        strd   a1, [sp, #-8]!

        sub    sp, sp, #8
1:
        idct_two_col_armv5te simple_idct_add_armv5te
        ldrd   a3, [sp, #(8 + 40)]
        str    a1, [sp, #(0 + 40)]

        ldrd   a1, [sp], #8
        add    ip, a3, #2
        str    ip, [sp, #(8 + 40 - 8)]

        add    ip, a1, v1
        sub    v1, a1, v1
        add    a1, a2, v2
        sub    v2, a2, v2
        strd   v1, [sp, #(32 - 8)] /* save v1 and v2 to stack in order to use them as temporary registers */
        ldrb   v1, [a3, #1]
        ldrb   v2, [a3]
        ldr    lr, simple_idct_croptbl_armv5te
        add    v1, v1, a1, asr #COL_SHIFT
        ldrd   a1, [sp], #8
        add    ip, v2, ip, asr #COL_SHIFT
        ldrb   v2, [lr, v1]
        ldrb   ip, [lr, ip]

        add    v1, a1, v3
        sub    v3, a1, v3

        ldrb   a1, [a3, a4]
        orr    ip, ip, v2, asl #8
        strh   ip, [a3], a4

        ldrb   v2, [a3, #1]

        add    ip, a2, v4
        sub    v4, a2, v4
        add    ip, v2, ip, asr #COL_SHIFT
        add    v1, a1, v1, asr #COL_SHIFT
        ldrb   v2, [lr, ip]
        ldrb   ip, [lr, v1]
        ldrb   v1, [a3, a4]
        ldrd   a1, [sp], #8
        orr    ip, ip, v2, asl #8
        strh   ip, [a3], a4

        ldrb   v2, [a3, #1]
        add    ip, a1, v5
        sub    v5, a1, v5
        add    a1, a2, v6
        sub    v6, a2, v6
        add    a1, v2, a1, asr #COL_SHIFT
        add    ip, v1, ip, asr #COL_SHIFT
        ldrb   v2, [lr, a1]
        ldrb   ip, [lr, ip]
        ldrb   v1, [a3, a4]
        ldrd   a1, [sp], #8
        orr    ip, ip, v2, asl #8
        strh   ip, [a3], a4

        ldrb   v2, [a3, #1]
        add    ip, a1, v7
        sub    v7, a1, v7
        add    a1, a2, v8
        sub    v8, a2, v8
        add    a1, v2, a1, asr #COL_SHIFT
        add    ip, v1, ip, asr #COL_SHIFT
        ldrb   v2, [lr, a1]
        ldrb   ip, [lr, ip]
        ldrb   v1, [a3, a4]
        add    a2, lr, v7, asr #COL_SHIFT
        orr    ip, ip, v2, asl #8
        strh   ip, [a3], a4

        ldrb   v2, [a3, #1]
        add    v8, lr, v8, asr #COL_SHIFT
        mov    v7, a3        /* a good news, now we have two more spare registers v7 and v8 */
        ldrb   ip, [a2, v1]
        ldrb   v8, [v8, v2]
        ldrb   v1, [v7, a4]!
        ldrb   v2, [v7, #1]
        orr    ip, ip, v8, asl #8
        strh   ip, [a3], a4

        ldrb   a1, [v7, a4]!
        ldrb   a2, [v7, #1]

        add    v6, v2, v6, asr #COL_SHIFT
        add    v5, v1, v5, asr #COL_SHIFT
        ldrb   v6, [lr, v6]
        ldrb   v5, [lr, v5]
        ldrd   v1, [sp, #0]         /* restore v1 and v2 that were saved earlier */
        orr    v5, v5, v6, asl #8
        strh   v5, [a3], a4
        ldrb   v5, [v7, a4]!
        ldrb   v6, [v7, #1]

        add    v4, a2, v4, asr #COL_SHIFT
        add    v3, a1, v3, asr #COL_SHIFT
        ldrb   v4, [lr, v4]
        ldrb   v3, [lr, v3]

        ldrd   a1, [sp, #8]
        add    v2, v6, v2, asr #COL_SHIFT
        add    v1, v5, v1, asr #COL_SHIFT
        ldrb   v2, [lr, v2]
        ldrb   v1, [lr, v1]
        cmp    a1, a2
        orr    v3, v3, v4, asl #8
        strh   v3, [a3], a4
        orr    v1, v1, v2, asl #8
        strh   v1, [a3], a4

        bne    1b

        add    sp, sp, #28
        ldmfd  sp!, {v1, v2, v3, v4, v5, v6, v7, v8, pc}
        .endfunc

/******************************************************************************/

/*
 * a local pool with 64-bit constants for 'simple_idct_armv5te' function, we
 * align it at 16 byte boundary in order to ensure that it does not cross
 * cache line boundary (occupies only a single cache line)
 */
        .balign 16
w2266simple_idct_armv5te:
        .long W22
        .long W66
w1357simple_idct_armv5te:
        .long W13
        .long W57

        .balign 32
        .global simple_idct_armv5te
        .type simple_idct_armv5te, %function
        .func simple_idct_armv5te
simple_idct_armv5te:

        idct_stackalign_armv5te

        stmfd  sp!, {v1, v2, v3, v4, v5, v6, v7, v8, lr}
        strd   a1, [sp, #-12]!

        bl     idct_rows_armv5te

        add    a2, a1, #16
        str    a2, [sp, #-8]!
1:
        idct_two_col_armv5te simple_idct_armv5te

        ldr    lr, [sp, #32]

        ldrd   a3, [sp], #8

        cmp    lr, a1

        add    a2, a3, v1
        add    ip, a4, v2
        mov    a2, a2, asr #COL_SHIFT
        mov    ip, ip, asr #COL_SHIFT
        strh   a2, [a1, #(16*0 - 4)]
        strh   ip, [a1, #(16*0 + 2 - 4)]
        sub    a2, a3, v1
        sub    ip, a4, v2
        ldrd   a3, [sp], #8
        mov    a2, a2, asr #COL_SHIFT
        mov    ip, ip, asr #COL_SHIFT
        strh   a2, [a1, #(16*7 - 4)]
        strh   ip, [a1, #(16*7 + 2 - 4)]

        add    a2, a3, v3
        add    ip, a4, v4
        mov    a2, a2, asr #COL_SHIFT
        mov    ip, ip, asr #COL_SHIFT
        strh   a2, [a1, #(16*1 - 4)]
        strh   ip, [a1, #(16*1 + 2 - 4)]
        sub    a2, a3, v3
        sub    ip, a4, v4
        ldrd   a3, [sp], #8
        mov    a2, a2, asr #COL_SHIFT
        mov    ip, ip, asr #COL_SHIFT
        strh   a2, [a1, #(16*6 - 4)]
        strh   ip, [a1, #(16*6 + 2 - 4)]

        add    a2, a3, v5
        add    ip, a4, v6
        mov    a2, a2, asr #COL_SHIFT
        mov    ip, ip, asr #COL_SHIFT
        strh   a2, [a1, #(16*2 - 4)]
        strh   ip, [a1, #(16*2 + 2 - 4)]
        sub    a2, a3, v5
        sub    ip, a4, v6
        ldrd   a3, [sp], #8
        mov    a2, a2, asr #COL_SHIFT
        mov    ip, ip, asr #COL_SHIFT
        strh   a2, [a1, #(16*5 - 4)]
        strh   ip, [a1, #(16*5 + 2 - 4)]

        add    a2, a3, v7
        add    ip, a4, v8
        mov    a2, a2, asr #COL_SHIFT
        mov    ip, ip, asr #COL_SHIFT
        strh   a2, [a1, #(16*3 - 4)]
        strh   ip, [a1, #(16*3 + 2 - 4)]
        sub    a2, a3, v7
        sub    ip, a4, v8
        mov    a2, a2, asr #COL_SHIFT
        mov    ip, ip, asr #COL_SHIFT
        strh   a2, [a1, #(16*4 - 4)]
        strh   ip, [a1, #(16*4 + 2 - 4)]

        bne    1b

        add    sp, sp, #20
        ldmfd  sp!, {v1, v2, v3, v4, v5, v6, v7, v8, pc}
        .endfunc

/******************************************************************************/

unaligned_return_thunk_armv5te:
        ldr    pc, [sp], #4
