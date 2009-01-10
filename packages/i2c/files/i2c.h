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
*   @file   i2c.h
*
*   @brief  Global definitions for interfacing with the AVR TWI (aka I2C)
*           hardware
*
****************************************************************************/
/**
*   @defgroup   xxx   Readable version of xxx.
*
*   @brief   Brief description of what xxx does.
*
*   Longer description of what xxx does.
*
****************************************************************************/

#if !defined( I2C_H )
#define I2C_H               /**< Include Guard                             */

/* ---- Include Files ---------------------------------------------------- */

#include <inttypes.h>

#if !defined( CONFIG_H )
#   include "Config.h"
#endif


/**
 *  @addtogroup I2C
 *  @{
 */

/* ---- Constants and Types ---------------------------------------------- */

/**
 *  Error Codes
 */

#define I2C_ERROR_NONE               0  // No Error
#define I2C_ERROR_ADDR_NACK         -1  // No response to SLA+R/W
#define I2C_ERROR_DATA_NACK         -2  // NACK during data transmission
#define I2C_ERROR_ARBITRATION_LOST  -3  // Lost arbitration
#define I2C_ERROR_BAD_LEN           -4  // Length is wonky
#define I2C_ERROR_BAD_CRC           -5  // CRC failed
#define I2C_ERROR_BUS_ERROR         -6  // Someting weird on the i2c bus

typedef int8_t  I2C_Error_t;

/**
 *  Since we're loosely following the SMBus spec, we restrict the amount
 *  of data in each transaction to 32 bytes.
 */

#define I2C_MAX_DATA_LEN    32

/**
 *  I2C_Addr_t can contain the address of any device on the bus. This
 *  module only supports 7 bit addressing.
 */

typedef uint8_t I2C_Addr_t;

/**
 *  The I2C_CRC macro can be used to remove all CRC support at compile time.
 */

#if CFG_I2C_USE_CRC
#   define  I2C_CRC(x)  x
#else

#   define  I2C_CRC(x)
#endif


/**
 *  I2C_Data_t encapsulates the data being read or written on the i2c bus.
 *  This module follows the SMBus spec, whihch specifies a maximum payload
 *  of 32 bytes.
 */

typedef struct
{
#if CFG_I2C_USE_CRC
    uint8_t     m_crc;
#endif


    //  For reads, m_len is the number of bytes actually read (doesn't include
    //  the CRC - if present). If a block transfer was performed which has a 
    //  length byte, this length will include the length byte.

    uint8_t     m_len;

    // Note: Under SMBus, a block write can consist of a command, a length,
    //       32 bytes of payload, and a CRC.
    //
    // A read response can consist of a length, 32 bytes of data, and a CRC.

    uint8_t     m_data[ I2C_MAX_DATA_LEN  + 2]; // +1 for the command, +1 for length

} I2C_Data_t;

/* ---- Variable Externs ------------------------------------------------- */

/**
 *  Description of variable.
 */

/* ---- Function Prototypes ---------------------------------------------- */

/*
 *  Just include prototypes here. Put full descriptions in the .c files.
 */

/** @} */

#endif /* I2C_H */


