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
*   @file   Crc8.c 
*
*   @brief  This file contains the definition of the CRC-8 algorithim
*           used by SMBus
*           
*
*****************************************************************************/

/* ---- Include Files ----------------------------------------------------- */

#include "Config.h"

#include "Crc8.h"

#include "Log.h"

/* ---- Public Variables -------------------------------------------------- */
/* ---- Private Constants and Types --------------------------------------- */
/* ---- Private Variables ------------------------------------------------- */
/* ---- Private Function Prototypes --------------------------------------- */
/* ---- Functions --------------------------------------------------------- */

/****************************************************************************/
/**
*   Calculates the CRC-8 used as part of SMBus.
*
*   CRC-8 is defined to be x^8 + x^2 + x + 1
*
*   To use this function use the following template:
*
*       crc = Crc8( crc, data );
*/

#if 0   // Traditional implementation

#define POLYNOMIAL    (0x1070U << 3) 

unsigned char Crc8( unsigned char inCrc, unsigned char inData )
{
        int i;
    unsigned short  data;

    data = inCrc ^ inData;
    data <<= 8;
  
        for ( i = 0; i < 8; i++ ) 
    {
                if (( data & 0x8000 ) != 0 )
        {
            data = data ^ POLYNOMIAL;
        }
                data = data << 1;
        }

#if 0
#if defined( LogBuf2 )
    LogBuf2( "Crc8: data:0x%02x crc:0x%02x\n", inData, (unsigned char)( data >> 8 ));
#else

    Log( "Crc8: data:0x%02x crc:0x%02x\n", inData, (unsigned char)( data >> 8 ));
#endif

#endif


        return (unsigned char)( data >> 8 );

} // Crc8

#else   // Optimized for 8 bit CPUs (0x22 bytes on ATMega128 versus 0x30 for above version)

unsigned char Crc8( unsigned char inCrc, unsigned char inData )
{
        unsigned char   i;
    unsigned char   data;

    data = inCrc ^ inData;
  
        for ( i = 0; i < 8; i++ ) 
    {
        if (( data & 0x80 ) != 0 )
        {
            data <<= 1;
            data ^= 0x07;
        }
        else
        {
            data <<= 1;
        }
        }

#if 0
#if defined( LogBuf2 )
    LogBuf2( "Crc8: data:0x%02x crc:0x%02x\n", inData, data );
#else

    Log( "Crc8: data:0x%02x crc:0x%02x\n", inData, data );
#endif

#endif


        return data;

} // Crc8

#endif


#if defined( CFG_CRC8BLOCK )

/****************************************************************************/
/**
*   Calculates the CRC-8 used as part of SMBus over a block of memory.
*/

uint8_t Crc8Block( uint8_t crc, uint8_t *data, uint8_t len )
{
    while ( len > 0 )
    {
        crc = Crc8( crc, *data++ );
        len--;
    }

    return crc;

} // Crc8Block

#endif  // CFG_CRC8BLOCK

/** @} */


