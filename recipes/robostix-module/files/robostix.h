/****************************************************************************
*
*   Copyright (c) 2006 Dave Hylands     <dhylands@gmail.com>
*
*   This program is free software; you can redistribute it and/or modify
*   it under the terms of the GNU General Public License version 2 as
*   published by the Free Software Foundation.
*
*   Alternatively, this software may be distributed under the terms of BSD
*   license.
*
*   See README and COPYING for more details.
*
****************************************************************************/
/**
*
*  robostix_drv.h
*
*  PURPOSE:
*
*   This implements a driver for using the robostix from the gumstix
*
*   Initially, this contains the required support to emulate enough of the
*   parallel port interface to allow avrdude to program the ATMega128.
*
*****************************************************************************/

#if !defined( LINUX_ROBOSTIX_H )
#define LINUX_ROBOSTIX_H )

/* ---- Include Files ----------------------------------------------------- */

#include <linux/ioctl.h>

/* ---- Constants and Types ----------------------------------------------- */

#define ROBOSTIX_MAJOR          240

#define ROBOSTIX_IOCTL_MAGIC    'R'

/**
 *  Deefines for each of the commands. Note that since we want to reduce
 *  the possibility that a user mode program gets out of sync with a given 
 *  driver, we explicitly assign a value to each enumeration. This makes
 *  it more difficult to stick new ioctl's in the middle of the list.
 */

typedef enum
{
    ROBOSTIX_CMD_FIRST          = 0x80,

    ROBOSTIX_CMD_POWER_VCC5     = 0x80,
    ROBOSTIX_CMD_RESET          = 0x81,
    ROBOSTIX_CMD_245_ENABLE     = 0x82,
    ROBOSTIX_CMD_SET_SCK        = 0x83,
    ROBOSTIX_CMD_SET_SS         = 0x84,
    ROBOSTIX_CMD_SET_IR_TXD     = 0x85,
    ROBOSTIX_CMD_GET_IR_RXD     = 0x86,
    ROBOSTIX_CMD_SET_MOSI       = 0x87,
    ROBOSTIX_CMD_GET_MISO       = 0x88,
    ROBOSTIX_CMD_GET_IRQ        = 0x89,
    ROBOSTIX_CMD_DELAY_USEC     = 0x8A,     // value is hardocded in uisp DAPA.C

    /* Insert new ioctls here                                               */

    ROBOSTIX_CMD_LAST,

} ROBOSTIX_CMD;

/*
 * The following are arguments to the various ioctl's
 */

#define ROBOSTIX_PIN_OFF        0
#define ROBOSTIX_PIN_ON         1
#define ROBOSTIX_PIN_PULSE      2   // only used or Reset

/*
 * Definitions for the actual ioctl commands
 */

#define ROBOSTIX_IOCTL_POWER_VCC5   _IO(    ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_POWER_VCC5 )         // arg is int
#define ROBOSTIX_IOCTL_RESET        _IO(    ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_RESET )              // arg is int
#define ROBOSTIX_IOCTL_245_ENABLE   _IO(    ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_245_ENABLE )         // arg is int
#define ROBOSTIX_IOCTL_SET_SCK      _IO(    ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_SET_SCK )            // arg is int
#define ROBOSTIX_IOCTL_SET_SS       _IO(    ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_SET_SS )             // arg is int
#define ROBOSTIX_IOCTL_SET_IR_TXD   _IO(    ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_SET_IR_TXD )         // arg is int
#define ROBOSTIX_IOCTL_GET_IR_RXD   _IOR(   ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_GET_IR_RXD, int )    // arg is int *
#define ROBOSTIX_IOCTL_SET_MOSI     _IO(    ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_SET_MOSI )           // arg is int
#define ROBOSTIX_IOCTL_GET_MISO     _IOR(   ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_GET_MISO, int )      // arg is int *
#define ROBOSTIX_IOCTL_GET_IRQ      _IOR(   ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_GET_IRQ, int )       // arg is int *
#define ROBOSTIX_IOCTL_DELAY_USEC   _IO(    ROBOSTIX_IOCTL_MAGIC, ROBOSTIX_CMD_DELAY_USEC )         // arg is int


/*
 * Definitions for sysctl. The top level define has to be unique system wide.
 * The kernel defines values 1 thru about 10 (see include/linunx/sysctl.h)
 */

#define CTL_ROBOSTIX    0x526F626F  /* 'Robo' in hex form */

/*
 * The following are for entries in /proc/sys/robostix
 */

enum
{
    CTL_ROBOSTIX_DEBUG_TRACE    = 101,
    CTL_ROBOSTIX_DEBUG_IOCTL    = 102,
    CTL_ROBOSTIX_DEBUG_ERROR    = 103
};

#endif  // LINUX_ROBOSTIX_H

