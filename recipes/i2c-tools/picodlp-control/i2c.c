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
*   @file   i2c.c
*
*   @brief  This program allows basic i2c commands to be sent out the i2c
*           bus,
*
****************************************************************************/

// ---- Include Files -------------------------------------------------------

#include <stdio.h>
#include <stdlib.h>
#include <getopt.h>
#include <fcntl.h>
#include <errno.h>
#include <string.h>
#include <signal.h>
#include <unistd.h>
#include <sys/timeb.h>

#include "i2c-dev.h"
#include "i2c-api.h"
#include "i2c-io-api.h"
#include "Log.h"

// #include "svn-version.h"

// ---- Public Variables ----------------------------------------------------
// ---- Private Constants and Types -----------------------------------------

// ---- Private Variables ---------------------------------------------------

enum
{
    OPT_MEM_DEFAULT     = 0,

    // Options assigned a single character code can use that charater code
    // as a short option.

    OPT_COUNT           = 'c',

    // Options from this point onwards don't have any short option equivalents

    OPT_FIRST_LONG_OPT   = 0x80,

    OPT_HELP,
    OPT_VERSION,
};

enum
{
    CMD_DEFAULT,

    CMD_READ_BYTE,
    CMD_READ_BYTE_2,
    CMD_READ_BYTE_4,

    CMD_WRITE_BYTE,
    CMD_WRITE_BYTE_2,
    CMD_WRITE_BYTE_4,

    CMD_RECV_BYTE,
    CMD_RECV_BYTE_2,
    CMD_RECV_BYTE_4,

    CMD_SEND_BYTE,
    CMD_SEND_BYTE_2,
    CMD_SEND_BYTE_4,
};

struct 
{
    int         cmd;
    const char *cmdStr;

} gCmdMap[] =
{
    { CMD_READ_BYTE,    "ReadByte" },
    { CMD_READ_BYTE,    "rb" },
    { CMD_READ_BYTE_2,  "ReadByte2" },
    { CMD_READ_BYTE_2,  "rb2" },
    { CMD_READ_BYTE_4,  "ReadByte4" },
    { CMD_READ_BYTE_4,  "rb4" },

    { CMD_WRITE_BYTE,   "WriteByte" },
    { CMD_WRITE_BYTE,   "wb" },
    { CMD_WRITE_BYTE_2, "WriteByte2" },
    { CMD_WRITE_BYTE_2, "wb2" },
    { CMD_WRITE_BYTE_4, "WriteByte4" },
    { CMD_WRITE_BYTE_4, "wb4" },

    { CMD_RECV_BYTE,    "RecvByte" },
    { CMD_RECV_BYTE,    "vb" },
    { CMD_RECV_BYTE_2,  "RecvByte2" },
    { CMD_RECV_BYTE_2,  "vb2" },
    { CMD_RECV_BYTE_4,  "RecvByte4" },
    { CMD_RECV_BYTE_4,  "vb4" },

    { CMD_SEND_BYTE,    "SendByte" },
    { CMD_SEND_BYTE,    "sb" },
    { CMD_SEND_BYTE_2,  "SendByte2" },
    { CMD_SEND_BYTE_2,  "sb2" },
    { CMD_SEND_BYTE_4,  "SendByte4" },
    { CMD_SEND_BYTE_4,  "sb4" },
};

int gNumCmds = sizeof( gCmdMap ) / sizeof( gCmdMap[ 0 ]);

int gI2cAddr    = -1;
int gByteCount  = 1;

const char *gCmdStr;
int         gCmd        = CMD_DEFAULT;
const char *gAddrStr    = NULL;
const char *gDataStr    = NULL;

struct option gOption[] =
{
    { "count",      required_argument,  NULL,           OPT_COUNT },
    { "version",    no_argument,        NULL,           OPT_VERSION },
    { "verbose",    no_argument,        &gVerbose,      1 },
    { "debug",      no_argument,        &gDebug,        1 },
    { "help",       no_argument,        NULL,           OPT_HELP },
    { NULL }
};

#define TRUE    1
#define FALSE   0

typedef enum
{
    NoADC,
    AllowADC,

} AllowADC_t;

#define ADC_PORT    8

// ---- Private Function Prototypes -----------------------------------------

static  int  ParseByte( const char *byteStr, uint8_t *byte );
static  int  ParseBytes( const char *byteStr, uint8_t *byte, uint8_t maxBytes, uint8_t *bytesParsed );

static  void ProcessReadByteCommand( int i2cDev, const char *addrStr );
static  void ProcessWriteByteCommand( int i2cDev, const char *addrStr, const char *dataStr );
static  void ProcessRecvByteCommand( int i2cDev );
static  void ProcessSendByteCommand( int i2cDev, const char *dataStr );
static  void Usage( void );

// ---- Functions -----------------------------------------------------------

//***************************************************************************
/**
*   Main entry point
*/

int main( int argc, char **argv )
{
    char                shortOptsStr[ sizeof( gOption ) / sizeof( gOption[ 0 ] ) + 1 ];
    char               *shortOpts = shortOptsStr;
    struct option       *scanOpt;
    int                 opt;
    const char         *i2cDevName = "/dev/i2c-3";
    int                 i2cDev;
    int                 cmdIdx;

    LogInit( stdout );

    // Figure out the short options from our options structure

    for ( scanOpt = gOption; scanOpt->name != NULL; scanOpt++ ) 
    {
        if (( scanOpt->flag == NULL ) && ( scanOpt->val < OPT_FIRST_LONG_OPT ))
        {
            *shortOpts++ = (char)scanOpt->val;

            if ( scanOpt->has_arg != no_argument )
            {
                *shortOpts++ = ':';
            }
        }
    }
    *shortOpts++ = '\0';

    // Parse the command line options

    while (( opt = getopt_long( argc, argv, shortOptsStr, gOption, NULL )) != -1 )
    {
        switch ( opt )
        {
            case 0: 
            {
                // getopt_long returns 0 for entries where flag is non-NULL

                break;
            }

            case OPT_COUNT:
            {
                gByteCount = (int)strtol( optarg, NULL, 0 );
                if ( gByteCount <= 0 )
                {
                    LogError( "Expecting byte count >= 0, found: '%s'\n", optarg );
                    Usage();
                    exit( 1 );
                }
                if ( gByteCount > I2C_MAX_DATA_LEN )
                {
                    LogError( "Max byte count supported: %d, found %d\n", I2C_MAX_DATA_LEN, gByteCount );
                    Usage();
                    exit( 1 );
                }
                break;
            }

//            case OPT_VERSION:
//            {
//                Log( "i2c SVN Revision: %d\n", SVN_REVISION );
//                exit( 0 );
//                break;
//            }

            case '?':
            case OPT_HELP:
            default:
            {
                LogError( "opt:%d\n", opt );
                Usage();
                exit( 1 );
            }
        }
    }
    argc -= optind;
    argv += optind;

    // Verify that an i2c-address was specified

    if ( argc < 1 )
    {
        LogError( "Must specify an i2c address\n\n" );
        Usage();
        exit( 1 );
    }
    gI2cAddr = strtol( argv[ 0 ], NULL, 0 );
    if (( gI2cAddr <= 0 ) || ( gI2cAddr > 127 ))
    {
        LogError( "Expecting i2c address in the range of 1-127, Found: %d\n", gI2cAddr );
        Usage();
        exit( 1 );
    }

    // Verify that a command has been specified

    if ( argc < 2 )
    {
        LogError( "Must specify a command\n" );
        Usage();
        exit( 1 );
    }
    gCmdStr = argv[ 1 ];
    for ( cmdIdx = 0; cmdIdx < gNumCmds; cmdIdx++ ) 
    {
        if ( strcasecmp( gCmdStr, gCmdMap[ cmdIdx ].cmdStr ) == 0 )
        {
            gCmd = gCmdMap[ cmdIdx ].cmd;
            break;
        }
    }
    if ( gCmd == CMD_DEFAULT )
    {
        LogError( "Unrecognized command '%s'\n", gCmdStr );
        exit( 1 );
    }

    // Process command specific arguments

    if (( gCmd == CMD_READ_BYTE_2  )
    ||  ( gCmd == CMD_WRITE_BYTE_2 )
    ||  ( gCmd == CMD_RECV_BYTE_2 )
    ||  ( gCmd == CMD_SEND_BYTE_2 ))
    {
        gByteCount = 2;
    }
    else
    if (( gCmd == CMD_READ_BYTE_4  )
    ||  ( gCmd == CMD_WRITE_BYTE_4 )
    ||  ( gCmd == CMD_RECV_BYTE_4 )
    ||  ( gCmd == CMD_SEND_BYTE_4 ))
    {
        gByteCount = 4;
    }

    if (( gCmd == CMD_READ_BYTE )
    ||  ( gCmd == CMD_READ_BYTE_2 )
    ||  ( gCmd == CMD_READ_BYTE_4 ))
    {
        if ( argc < 3 )
        {
            LogError( "Expecting address\n" );
            Usage();
            exit( 1 );
        }
        if ( argc > 3 )
        {
            LogError( "Unexpected extra parameters\n" );
            Usage();
            exit( 1 );
        }

        gAddrStr = argv[ 2 ];
    }
    else
    if (( gCmd == CMD_WRITE_BYTE )
    ||  ( gCmd == CMD_WRITE_BYTE_2 )
    ||  ( gCmd == CMD_WRITE_BYTE_4 ))
    {
        if ( argc < 4 )
        {
            LogError( "Expecting address and data\n" );
            Usage();
            exit( 1 );
        }
        if ( argc > 4 )
        {
            LogError( "Unexpected extra parameters\n" );
            Usage();
            exit( 1 );
        }

        gAddrStr = argv[ 2 ];
        gDataStr = argv[ 3 ];
    }
    else
    if (( gCmd == CMD_RECV_BYTE )
    ||  ( gCmd == CMD_RECV_BYTE_2 )
    ||  ( gCmd == CMD_RECV_BYTE_4 ))
    {
        if ( argc > 2 )
        {
            LogError( "Unexpected extra parameters\n" );
            Usage();
            exit( 1 );
        }
    }
    else
    if (( gCmd == CMD_SEND_BYTE )
    ||  ( gCmd == CMD_SEND_BYTE_2 )
    ||  ( gCmd == CMD_SEND_BYTE_4 ))
    {
        if ( argc < 3 )
        {
            LogError( "Expecting data\n" );
            Usage();
            exit( 1 );
        }
        if ( argc > 3 )
        {
            LogError( "Unexpected extra parameters\n" );
            Usage();
            exit( 1 );
        }
        gDataStr = argv[ 2 ];
    }

    if ( gDebug )
    {
        Log( "i2cAddr:0x%02x Cmd: %s (%d)", gI2cAddr, gCmdStr, gCmd );
        if ( gAddrStr != NULL )
        {
            Log( " Addr: %s", gAddrStr );
        }
        if ( gDataStr != NULL )
        {
            Log( " Data: %s", gDataStr );
        }
        Log( "\n" );
    }

    // Try to open the i2c device

    if (( i2cDev = open( i2cDevName, O_RDWR )) < 0 )
    {
        LogError( "Error  opening '%s': %s\n", i2cDevName, strerror( errno ));
        exit( 1 );
    }

    // Indicate which slave we wish to speak to

    I2cSetSlaveAddress( i2cDev, gI2cAddr, I2C_NO_CRC );

    switch ( gCmd )
    {
        case CMD_READ_BYTE:
        case CMD_READ_BYTE_2:
        case CMD_READ_BYTE_4:
        {
            ProcessReadByteCommand( i2cDev, gAddrStr );
            break;
        }

        case CMD_WRITE_BYTE:
        case CMD_WRITE_BYTE_2:
        case CMD_WRITE_BYTE_4:
        {
            ProcessWriteByteCommand( i2cDev, gAddrStr, gDataStr );
            break;
        }

        case CMD_RECV_BYTE:
        case CMD_RECV_BYTE_2:
        case CMD_RECV_BYTE_4:
        {
            ProcessRecvByteCommand( i2cDev );
            break;
        }

        case CMD_SEND_BYTE:
        case CMD_SEND_BYTE_2:
        case CMD_SEND_BYTE_4:
        {
            ProcessSendByteCommand( i2cDev, gDataStr );
            break;
        }
    }

    close( i2cDev );

    return 0;

} // main

//***************************************************************************
/**
*   Parse a string looking for a single byte.
*/

int ParseByte( const char *byteStr, uint8_t *byte )
{
    char       *endPtr;

    *byte = (uint8_t)strtol( byteStr, &endPtr, 0 );

    if ( *endPtr != '\0' )
    {
        LogError( "Expecting numeric value, found '%s'\n", byteStr );
        return FALSE;
    }

    return TRUE;

} // ParseByte

//***************************************************************************
/**
*   Parse a string looking for an array of bytes.
*/

int ParseBytes( const char *byteStr, uint8_t *byte, uint8_t maxBytes, uint8_t *bytesParsed )
{
    char       *endPtr;

    if (( byteStr[ 0 ] == '0' ) && ( byteStr[ 1 ] == 'x' ))
    {
        const char *s = &byteStr[ 2 ];
        *bytesParsed = 0;

        // Could be a multi-byte hex string

        while ( *s != '\0' )
        {
            if ( *bytesParsed >= maxBytes )
            {
                LogError( "Too many bytes, max: %d\n", maxBytes );
                return FALSE;
            }

            (*bytesParsed)++;
            *byte = 0;

            if (( *s >= 'A' ) && ( *s <= 'F' ))
            {
                *byte = *s - 'A' + 10;
            }
            else
            if (( *s >= 'a' ) && ( *s <= 'f' ))
            {
                *byte = *s - 'a' + 10;
            }
            else
            if (( *s >= '0' ) && ( *s <= '9' ))
            {
                *byte = *s - '0';
            }
            else
            {
                LogError( "Expecting hex digit, found '%c'\n", *s );
                return FALSE;
            }
            s++;

            if ( *s == '\0' )
            {
                break;
            }

            *byte <<= 4;
            if (( *s >= 'A' ) && ( *s <= 'F' ))
            {
                *byte |= *s - 'A' + 10;
            }
            else
            if (( *s >= 'a' ) && ( *s <= 'f' ))
            {
                *byte |= *s - 'a' + 10;
            }
            else
            if (( *s >= '0' ) && ( *s <= '9' ))
            {
                *byte |= *s - '0';
            }
            else
            {
                LogError( "Expecting hex digit, found '%c'\n", *s );
                return FALSE;
            }
            s++;
            byte++;
        }
    }
    else
    {
        // It's decimal or octal - only a single byte

        *byte = (uint8_t)strtol( byteStr, &endPtr, 0 );

        if ( *endPtr != '\0' )
        {
            LogError( "Expecting numeric value, found '%s'\n", byteStr );
            return FALSE;
        }
        *bytesParsed = 1;
    }

    return TRUE;

} // ParseBytes

//***************************************************************************
/**
*   Issues a read byte command to read a byte from a particular address.
*/

void ProcessReadByteCommand( int i2cDev, const char *addrStr )
{
    uint8_t addr;
    uint8_t dataByte[ I2C_MAX_DATA_LEN ];
    int     rc;
    int     i;

    if ( !ParseByte( addrStr, &addr ))
    {
        return;
    }

    if (( rc = I2cReadBytes( i2cDev, addr, dataByte, gByteCount )) != 0 )
    {
        LogError( "I2cReadByte failed: %d\n", rc );
        return;
    }

    Log( "0x", dataByte[0] );

    for ( i = 0; i < gByteCount; i++ ) 
    {
        Log( "%02x", dataByte[i] );
    }
    Log( "\n" );

} // ProcessReadByteCommand

//***************************************************************************
/**
*   Issues a recv byte command to read bytes with no address.
*/

void ProcessRecvByteCommand( int i2cDev )
{
    uint8_t dataByte[ I2C_MAX_DATA_LEN ];
    int     rc;
    int     i;

    if (( rc = I2cReceiveBytes( i2cDev, dataByte, gByteCount )) != 0 )
    {
        LogError( "I2cRecvBytes failed: %d\n", rc );
        return;
    }

    Log( "0x", dataByte[0] );

    for ( i = 0; i < gByteCount; i++ ) 
    {
        Log( "%02x", dataByte[i] );
    }
    Log( "\n" );

} // ProcessRecvByteCommand

//***************************************************************************
/**
*   Issues a write byte command to write a byte to a particular address.
*/

void ProcessWriteByteCommand( int i2cDev, const char *addrStr, const char *dataStr )
{
    uint8_t addr;
    uint8_t dataByte[ I2C_MAX_DATA_LEN ];
    uint8_t bytesParsed;
    int     rc;

    if ( !ParseByte( addrStr, &addr ))
    {
        return;
    }

    if ( !ParseBytes( dataStr, dataByte, sizeof( dataByte ), &bytesParsed ))
    {
        return;
    }

    if (( rc = I2cWriteBytes( i2cDev, addr, dataByte, bytesParsed )) != 0 )
    {
        LogError( "I2cWriteBytes failed: %d\n", rc );
        return;
    }

} // ProcessWriteByteCommand

//***************************************************************************
/**
*   Issues a send byte command to write bytes with no address specified.
*/

void ProcessSendByteCommand( int i2cDev, const char *dataStr )
{
    uint8_t dataByte[ I2C_MAX_DATA_LEN ];
    uint8_t bytesParsed;
    int     rc;

    if ( !ParseBytes( dataStr, dataByte, sizeof( dataByte ), &bytesParsed ))
    {
        return;
    }

    if (( rc = I2cSendBytes( i2cDev, dataByte, bytesParsed )) != 0 )
    {
        LogError( "I2cSendBytes failed: %d\n", rc );
        return;
    }

} // ProcessSendByteCommand

//***************************************************************************
/**
*   Usage
*/

void Usage( void )
{
    fprintf( stderr, "Usage: i2c [options] i2c-addr cmd [cmd-arguments]\n" );
    fprintf( stderr, "Send I2C commands\n" );
    fprintf( stderr, "\n" );
    fprintf( stderr, "The following commands are supported:\n" );
    fprintf( stderr, "ReadByte addr         Retrieves byte(s) starting at the indicated address\n" );
    fprintf( stderr, "WriteByte addr data   Write byte(s) starting at the indicated address\n" );
    fprintf( stderr, "ReadByte2 addr        Retrieves two bytes from the indicated address\n" );
    fprintf( stderr, "WriteByte2 addr data  Writes two bytes into the indicated address\n" );
    fprintf( stderr, "ReadByte4 addr        Retrieves four bytes from the indicated address\n" );
    fprintf( stderr, "WriteByte4 addr data  Writes four bytes into the indicated address\n" );
    fprintf( stderr, "RecvByte              Retrieves byte(s)(no address specified)\n" );
    fprintf( stderr, "SendByte data         Writes byte(s)(no address specified)\n" );
    fprintf( stderr, "RecvByte2             Retrieves 2 bytes (no address specified)\n" );
    fprintf( stderr, "SendByte2 data        Writes 2 bytes(no address specified)\n" );
    fprintf( stderr, "RecvByte4             Retrieves 4 bytes (no address specified)\n" );
    fprintf( stderr, "SendByte4 data        Writes 4 bytes(no address specified)\n" );
    fprintf( stderr, "\n" );
    fprintf( stderr, "The above commands can be shortened to rb, wb, rb2, wb2, rb4, wb4, vb, sd, vb2 sb2 vb4, and sb4 \n" );
    fprintf( stderr, "respectively.\n" );
    fprintf( stderr, "\n" );
    fprintf( stderr, "The following options may be used:\n" );
    fprintf( stderr, "--count=n             Specifies how many bytes to read for ReadByte or RecvByte\n" );
    fprintf( stderr, "--version             Prints the SVN version of this program\n" );
    fprintf( stderr, "--verbose             Print additional information\n" );
    fprintf( stderr, "--help                Prints this information\n" );
}

