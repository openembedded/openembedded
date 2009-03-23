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
*   @file   DumpMem.c
*
*   @brief  Memmory dump routine
*
****************************************************************************/

// ---- Include Files -------------------------------------------------------

#include <inttypes.h>
#include "DumpMem.h"
#include "Log.h"

// ---- Public Variables ----------------------------------------------------
// ---- Private Constants and Types -----------------------------------------
// ---- Private Variables ---------------------------------------------------
// ---- Private Function Prototypes -----------------------------------------
// ---- Functions -----------------------------------------------------------

/**************************************************************************/
/**
*   Dumps a page of output for debugging purposes.
*/

void DumpMem( const char *prefix, unsigned address, const void *inData, unsigned numBytes )
{
    const uint8_t  *data = (const uint8_t *)inData;
    unsigned        byteOffset;

    if ( numBytes == 0 )
    {
        Log( "%s: No data\n", prefix );
        return;
    }

#define LINE_WIDTH  16

    for ( byteOffset = 0; byteOffset < numBytes; byteOffset += LINE_WIDTH ) 
    {
        unsigned    i;

        Log( "%s: %04x: ", prefix, address + byteOffset );

        for ( i = 0; i < LINE_WIDTH; i++ ) 
        {
            if (( byteOffset + i ) < numBytes )
            {
                Log( "%02.2X ", data[ byteOffset + i ] );
            }
            else
            {
                Log( "   " );
            }
        }
        for ( i = 0; i < LINE_WIDTH; i++ ) 
        {
            if (( byteOffset + i ) < numBytes )
            {
                unsigned char ch = data[ byteOffset + i ];
                if (( ch < ' ' ) || ( ch > '~' ))
                {
                    Log( "." );
                }
                else
                {
                    Log( "%c", ch );
                }
            }
            else
            {
                break;
            }
        }
        Log( "\n" );
    }

} // DumpMem

