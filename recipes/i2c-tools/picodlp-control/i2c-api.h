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
*   @file   i2c-api.h
*
*   @brief  This file contains definitions for performing i2c operations 
*           on the gumstix.
*
****************************************************************************/

#if !defined( I2C_API_H )
#define I2C_API_H

// ---- Include Files -------------------------------------------------------

#include <inttypes.h>
#include "i2c.h"

// ---- Constants and Types -------------------------------------------------

#define I2C_USE_CRC 1
#define I2C_NO_CRC  0

// ---- Variable Externs ----------------------------------------------------

// ---- Function Prototypes -------------------------------------------------

void I2cSetSlaveAddress
(
    int         i2cDev,     ///< Handle to i2c-dev file
    I2C_Addr_t  i2cAddr,    ///< 7 bit i2c address to use
    int         useCrc );   ///< Should CRC's be used?

int I2cTransfer
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    const void *wrData,     ///< Data to write
    uint8_t     wrLen,      ///< Number of bytes to write (or in 0x80 for a block write)
    void       *rdData,     ///< Place to store data read
    uint8_t     rdLen,      ///< Number of bytes to read  (or in 0x80 for a block read)
    uint8_t    *bytesReadp  ///< Place to store number of bytes read 
);

int I2cProcessBlock
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    const void *wrData,     ///< Data to write
    uint8_t     wrLen,      ///< Number of bytes to write
    void       *rdData,     ///< Place to store data read
    uint8_t     rdLen,      ///< Number of bytes to read
    uint8_t    *bytesReadp  ///< Place to store number of bytes read 
);

int I2cReadBlock
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    void       *rdData,     ///< Place to store data read
    uint8_t     rdLen,      ///< Number of bytes to read
    uint8_t    *bytesReadp  ///< Place to store number of bytes read 
);

int I2cReadByte
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    uint8_t    *rdByte      ///< Place to store byte to read
);

int I2cReadBytes
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    void       *rdByte,     ///< Place to store bytes read
    uint8_t     rdLen       ///< Number of bytes to read
);

int I2cWriteBlock
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    const void *wrData,     ///< Data to write
    uint8_t     wrLen       ///< Number of bytes to write
);

int I2cWriteByte
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    uint8_t     wrByte      ///< Byte to write
);

int I2cWriteBytes
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    const void *wrByte,     ///< Bytes to write
    uint8_t     wrLen       ///< Number of bytes to write
);

int I2cReceiveByte
(
    int      i2cDev,        ///< Handle to i2c-dev file
    uint8_t *rdByte         ///< Place to store byte read
);

int I2cReceiveBytes
(
    int      i2cDev,        ///< Handle to i2c-dev file
    uint8_t *rdData,        ///< Place to store byte read
    uint8_t  rdLen          ///< Number of bytes to read
);

int I2cSendByte
(
    int      i2cDev,        ///< Handle to i2c-dev file
    uint8_t  wrByte         ///< Byte to write
);

int I2cSendBytes
(
    int      i2cDev,        ///< Handle to i2c-dev file
    uint8_t *wrData,        ///< Pointer to data to write.
    uint8_t  wrLen          ///< Number of bytes to write.
);

#endif  // I2C_API_H

