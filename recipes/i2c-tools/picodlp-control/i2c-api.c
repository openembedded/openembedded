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
*   @file   i2c-api.c
*
*   @brief  This file contains the implementation for performing I2C operations
*           on the gumstix.
*
****************************************************************************/

// ---- Include Files -------------------------------------------------------

#include <string.h>
#include <errno.h>

#include "i2c.h"
#include "i2c-dev.h"
#include "i2c-api.h"

#include "Crc8.h"
#include "DumpMem.h"
#include "Log.h"

// ---- Public Variables ----------------------------------------------------

// ---- Private Constants and Types -----------------------------------------

// ---- Private Variables ---------------------------------------------------

static  I2C_Addr_t  gI2cAddr;
static  int         gUseCrc;

// ---- Private Function Prototypes -----------------------------------------

// ---- Functions -----------------------------------------------------------

//***************************************************************************
/**
*
*   Sets the I2C address that we'll be communicating with, as well as whether
*   the device uses smbus PEC (CRC).
*/

void I2cSetSlaveAddress( int i2cDev, I2C_Addr_t i2cAddr, int useCrc )
{
    gI2cAddr = i2cAddr;
    gUseCrc  = useCrc;

    LogDebug( "----- I2cSetSlaveAddress i2cAddr:0x%02x useCrc:%d -----\n",
              i2cAddr, useCrc );

    // Indicate which slave we wish to speak to

    if ( ioctl( i2cDev, I2C_SLAVE, gI2cAddr ) < 0 )
    {
        LogError( "I2cSetSlaveAddress: Error trying to set slave address to 0x%02x (%d %s)\n", 
                  gI2cAddr, errno, strerror( errno ));
    }

    // We do the CRC calculation ourself, so we don't need to tell the driver
    // that we're using it.

#if 0
    // Indicate that we use PEC (aka CRCs)

    if ( ioctl( i2cDev, I2C_PEC, 1 ) < 0 )
    {
        LogError( "I2cSetSlaveAddress: Error trying to set PEC mode\n" );
    }
#endif

} // I2cSetSlaveAddress

//***************************************************************************
/**
*   Transfer data to/from an i2c device.
*
*   This function implements the equivalent of the smbus functions using
*   I2C_RDWR.
*
*   The PXA driver doesn't support the smbus transfers.
*
*   This function can perform the following SMBUS transactions:
*
*       Write Byte:     wrLen == 1,                 rdLen == 0
*       Read Byte:      wrLen == 0,                 rdLen == 1
*       Write Word:     wrLen == 2,                 rdLen == 0
*       Read Word:      wrLen == 0,                 rdLen == 2
*       Process Call:   wrLen == 2,                 rdLen == 2
*       Write Block:    wrLen == 0x80 + numBytes,   rdLen == 0
*       Read Block:     wrLen == 0,                 rdLen == 0x80 + numBytes
*       Process Block:  wrLen == 0x80 + numBytes,   rdLen == 0x80 + numBytes
*/

int I2cTransfer
(
    int         i2cDev,        ///< Handle to i2c-dev file
    uint8_t     cmd,           ///< Command to send
    const void *wrData,        ///< Data to write
    uint8_t     wrLen,         ///< Number of bytes to write (or in 0x80 for a block write)
    void       *rdData,        ///< Place to store data read
    uint8_t     rdLen,         ///< Number of bytes to read  (or in 0x80 for a block read)
    uint8_t    *bytesReadp     ///< Place to store number of bytes read 
)
{
    struct i2c_rdwr_ioctl_data  rdwr;
    struct i2c_msg              msg[ 2 ];
    uint8_t                     wrBuf[ I2C_MAX_DATA_LEN + 3 ];  // +1 for cmd, +1 for len, +1 for CRC
    uint8_t                     rdBuf[ I2C_MAX_DATA_LEN + 2 ];  // +1 for len, +1 for CRC
    uint8_t                     crc = 0;
    uint8_t                     wrBlock = (( wrLen & 0x80 ) != 0 );
    uint8_t                     rdBlock = (( rdLen & 0x80 ) != 0 );
    int                         rc = 0;

    LogDebug( "----- I2cTransfer: cmd:0x%02x wrLen:0x%02x rdLen:0x%02x wrBlock:%d rdBlock:%d -----\n",
              cmd, wrLen, rdLen, wrBlock, rdBlock );
    if ( wrData != NULL )
    {
        LogDebug( "----- wrData:0x%08x *wrData:0x%02x -----\n", wrData, *(const uint8_t *)wrData ); 
    }

    rdLen &= 0x7f;
    wrLen &= 0x7f;

    if ( bytesReadp != NULL )
    {
        *bytesReadp = 0;
    }

    if ( wrLen > I2C_MAX_DATA_LEN ) 
    {
        LogError( "I2cTransfer: wrLen too big: %d, max is %d\n",
                  wrLen, I2C_MAX_DATA_LEN );
        errno = ENOBUFS;
        return -1;
    }

    if ( rdLen > I2C_MAX_DATA_LEN )
    {
        LogError( "I2cTransfer: rdLen too big: %d, max is %d\n",
                  rdLen, I2C_MAX_DATA_LEN );
        errno = ENOBUFS;
        return -1;
    }

    // Whether we're doing a read or a write, we always send
    // the command.

    msg[ 0 ].addr  = gI2cAddr;
    msg[ 0 ].flags = 0;
    msg[ 0 ].len   = wrLen + 1 + wrBlock;    // +1 for cmd
    msg[ 0 ].buf   = (char *)&wrBuf[ 0 ];

    if ( gUseCrc )
    {
        crc = Crc8( 0,   gI2cAddr << 1 );
        crc = Crc8( crc, cmd );
    }

    wrBuf[ 0 ] = cmd;

    if ( wrLen > 0 )
    {
        // We have some data to send down to the device

        if ( wrBlock )
        {
            wrBuf[ 1 ] = wrLen;
            memcpy( &wrBuf[ 2 ], wrData, wrLen );
            wrLen++;    // Add in cmd to the length
        }
        else
        {
            memcpy( &wrBuf[ 1 ], wrData, wrLen );
        }
        if ( gUseCrc )
        {
            crc = Crc8Block( crc, &wrBuf[ 1 ], wrLen );

            if ( rdLen == 0 )
            {
                // This is a write-only, so we need to send the CRC

                wrBuf[ wrLen + 1 ] = crc;
                msg[ 0 ].len++;
            }
        }
    }

    if ( gDebug )
    {
        Log( "msg[ 0 ].addr  = 0x%02x\n", msg[ 0 ].addr );
        Log( "msg[ 0 ].flags = 0x%04x\n", msg[ 0 ].flags );
        Log( "msg[ 0 ].len   = %d\n",     msg[ 0 ].len );
        DumpMem( "I2cTransfer W", 0, &wrBuf[ 0 ], msg[ 0 ].len );
    }

    rdwr.msgs = msg;
    rdwr.nmsgs = 1;

    if ( rdLen > 0 )
    {
        // We're expecting some data to come back

        msg[ 1 ].addr  = gI2cAddr;
        msg[ 1 ].flags = I2C_M_RD;
        msg[ 1 ].len   = rdLen + rdBlock + gUseCrc;
        msg[ 1 ].buf   = (char *)&rdBuf[ 0 ];

        rdwr.nmsgs = 2;

        if ( gUseCrc )
        {
            crc = Crc8( crc, ( gI2cAddr << 1 ) | 1 );
        }

        if ( gDebug )
        {
            Log( "msg[ 1 ].addr  = 0x%02x\n", msg[ 1 ].addr );
            Log( "msg[ 1 ].flags = 0x%04x\n", msg[ 1 ].flags );
            Log( "msg[ 1 ].len   = %d\n",     msg[ 1 ].len );
        }
    }

    if ( ioctl( i2cDev, I2C_RDWR, &rdwr ) < 0 )
    {
        LogError( "I2cTransfer: ioctl failed: %s (%d)\n", strerror( errno ), errno );
        return -1;
    }

    if ( rdLen > 0 )
    {
        if ( rdBlock )
        {
            if ( rdBuf[ 0 ] > rdLen )
            {
                LogError( "I2cTransfer: length is too big: %d max: %d\n", rdBuf[ 0 ], rdLen );

                rc = EMSGSIZE;
            }
            else
            {
                rdLen = rdBuf[ 0 ];
            }
        }

        if ( gUseCrc )
        {
            crc = Crc8Block( crc, &rdBuf[ 0 ], rdLen + rdBlock );

            if ( crc != rdBuf[ rdLen + rdBlock ] )
            {
                LogError( "I2cTransfer: CRC failed: Rcvd: 0x%02x, expecting: 0x%02x\n",
                          rdBuf[ rdLen + rdBlock ], crc );
                rc = EBADMSG;
            }
        }
        
        if ( gDebug )
        {
            DumpMem( "I2cTransfer R", 0, &rdBuf[ 0 ], msg[ 1 ].len );
        }
        memcpy( rdData, &rdBuf[ rdBlock ], rdLen );

        if ( bytesReadp != NULL )
        {
            *bytesReadp = rdLen;
        }
    }
    return rc;

} // I2cTransfer

//***************************************************************************
/**
*   Uses the SMBUS Process-Block protocol to read data from a device.
*/

int I2cProcessBlock
(
    int         i2cDev,        ///< Handle to i2c-dev file
    uint8_t     cmd,           ///< Command to send
    const void *wrData,        ///< Data to write
    uint8_t     wrLen,         ///< Number of bytes to write
    void       *rdData,        ///< Place to store data read
    uint8_t     rdLen,         ///< Number of bytes to read
    uint8_t    *bytesReadp     ///< Place to store number of bytes read 
)
{
    LogDebug( "----- I2cProcessBlock cmd: 0x%02x wrLen:0x%02x rdLen:0x%02x -----\n", cmd, wrLen, rdLen );

    return I2cTransfer( i2cDev, cmd, wrData, 0x80 | wrLen, rdData, 0x80 | rdLen, bytesReadp );

} // I2cProcessBlock

//***************************************************************************
/**
*   Uses the SMBUS Read-Block protocol to read data from a device.
*/

int I2cReadBlock
(
    int      i2cDev,        ///< Handle to i2c-dev file
    uint8_t  cmd,           ///< Command to send
    void    *rdData,        ///< Place to store data read
    uint8_t  rdLen,         ///< Number of bytes to read
    uint8_t *bytesReadp     ///< Place to store number of bytes read 
)
{
    LogDebug( "----- I2cReadBlock cmd: 0x%02x rdLen:0x%02x -----\n", cmd, rdLen );

    return I2cTransfer( i2cDev, cmd, NULL, 0, rdData, 0x80 | rdLen, bytesReadp );

} // I2cReadBlock

//***************************************************************************
/**
*   Uses the SMBUS Read-Byte protocol to read a byte.
*/

int I2cReadByte
(
    int      i2cDev,        ///< Handle to i2c-dev file
    uint8_t  cmd,           ///< Command to send
    uint8_t *rdByte         ///< Place to store byte read
)
{
    LogDebug( "----- I2cReadByte cmd: 0x%02x -----\n", cmd );

    return I2cTransfer( i2cDev, cmd, NULL, 0, rdByte, 1, NULL );

} // I2cReadByte

//***************************************************************************
/**
*   Reads an array of bytes usinng i2c (not compatible with SMBUS)
*/

int I2cReadBytes
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    void       *rdByte,     ///< Place to store bytes read
    uint8_t     rdLen       ///< Number of bytes to read
)
{
    LogDebug( "----- I2cReadBytes cmd: 0x%02x rdLen: 0x%02x -----\n", cmd, rdLen );

    return I2cTransfer( i2cDev, cmd, NULL, 0, rdByte, rdLen, NULL );

} // I2cReadBytes

//***************************************************************************
/**
*   Uses the SMBUS Write-Block protocol to write data from a device.
*/

int I2cWriteBlock
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    const void *wrData,     ///< Data to write
    uint8_t     wrLen       ///< Number of bytes to write
)
{
    LogDebug( "----- I2cWriteBlock cmd: 0x%02x wrLen:0x%02x -----\n", cmd, wrLen );

    return I2cTransfer( i2cDev, cmd, wrData, 0x80 | wrLen, NULL, 0, NULL );

} // I2cWriteBlock

//***************************************************************************
/**
*   Uses the SMBUS Write-Byte protocol to write a byte.
*/

int I2cWriteByte
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    uint8_t     wrByte      ///< Byte to write
)
{
    LogDebug( "----- I2cWriteByte cmd: 0x%02x wrByte:0x%02x -----\n", cmd, wrByte );
    LogDebug( "----- &wrByte = 0x%08x wrByte = 0x%02x -----\n", &wrByte, *&wrByte );

    return I2cTransfer( i2cDev, cmd, &wrByte, 1, NULL, 0, NULL );

} // I2cWriteByte

//***************************************************************************
/**
*   Writes an array of bytes using i2c (not compatible with SMBUS)
*/

int I2cWriteBytes
(
    int         i2cDev,     ///< Handle to i2c-dev file
    uint8_t     cmd,        ///< Command to send
    const void *wrByte,     ///< Bytes to write
    uint8_t     wrLen       ///< Number of bytes to write
)
{
    LogDebug( "----- I2cWriteBytes cmd: 0x%02x wrLen: 0x%02x -----\n", cmd, wrLen );

    return I2cTransfer( i2cDev, cmd, wrByte, wrLen, NULL, 0, NULL );

} // I2cWriteBytes

//***************************************************************************
/**
*   Uses the SMBUS Receive-Byte protocol to read a byte.
*/

int I2cReceiveByte
(
    int      i2cDev,        ///< Handle to i2c-dev file
    uint8_t *rdByte         ///< Place to store byte read
)
{
    return I2cReceiveBytes( i2cDev, rdByte, 1 );

} // I2cReceiveByte

//***************************************************************************
/**
*   Uses the SMBUS Receive-Byte protocol to read multiple (or one or zero) bytes.
*/

int I2cReceiveBytes
(
    int      i2cDev,        ///< Handle to i2c-dev file
    uint8_t *rdData,        ///< Place to store data read
    uint8_t  rdLen          ///< Number of bytes to read
)
{
    struct  i2c_rdwr_ioctl_data rdwr;
    struct  i2c_msg             msg;

    LogDebug( "----- I2cReceiveBytes -----\n" );

    msg.addr    = gI2cAddr;
    msg.flags   = I2C_M_RD;
    msg.len     = rdLen;
    msg.buf     = (char *)rdData;

    rdwr.msgs = &msg;
    rdwr.nmsgs = 1;

    if ( ioctl( i2cDev, I2C_RDWR, &rdwr ) < 0 )
    {
        LogError( "I2cReceiveBytes: ioctl failed: %s (%d)\n", strerror( errno ), errno );
        return -1;
    }

    return 0;

} // I2cReceiveBytes

//***************************************************************************
/**
*   Uses the SMBUS Send-Byte protocol to write a byte.
*/

int I2cSendByte
(
    int      i2cDev,        ///< Handle to i2c-dev file
    uint8_t  wrByte         ///< Byte to write
)
{
    return I2cSendBytes( i2cDev, &wrByte, 1 );

} // I2cSendByte

//***************************************************************************
/**
*   Uses the SMBUS Send-Byte protocol to write multiple (or zero or one) bytes.
*/

int I2cSendBytes
(
    int      i2cDev,        ///< Handle to i2c-dev file
    uint8_t *wrData,        ///< Pointer to data to write
    uint8_t  wrLen          ///< NUmber of bytes to write
)
{
    struct  i2c_rdwr_ioctl_data rdwr;
    struct  i2c_msg             msg;

    LogDebug( "----- I2cSendBytes wrLen = 0x%02x -----\n", wrLen );

    msg.addr    = gI2cAddr;
    msg.flags   = 0;
    msg.len     = wrLen;
    msg.buf     = (char *)wrData;

    rdwr.msgs = &msg;
    rdwr.nmsgs = 1;

    if ( ioctl( i2cDev, I2C_RDWR, &rdwr ) < 0 )
    {
        LogError( "I2cSendBytes: ioctl failed: %s (%d)\n", strerror( errno ), errno );
        return -1;
    }

    return 0;

} // I2cSendBytes

