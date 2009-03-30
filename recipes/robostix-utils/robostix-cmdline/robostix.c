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
*  robostix.c
*
*  PURPOSE:
*
*   This implements the usermode program for talking to the robostix.
*
*****************************************************************************/

/* ---- Include Files ---------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <errno.h>

#include "robostix.h"

/* ---- Public Variables ------------------------------------------------- */

int gFd = -1;

int gVal;

/* ---- Private Constants and Types -------------------------------------- */
/* ---- Private Variables ------------------------------------------------ */

typedef struct
{
    const   char   *cmdStr;
    const   char   *argStr;
    const   char   *helpStr;
    int           (*parseArgs)( int argc, char **argv );
    void          (*execFunc)( int cmd );
    int             cmd;

} Cmd;

int     ParseNone( int argc, char **argv );
int     ParseOnOffArg( int argc, char **argv );
int     ParseOnOffPulseArg( int argc, char **argv );
void    Usage( void );

void    Power( int cmd );
void    ReadIOctl( int cmd );
void    SimpleIOctl( int cmd );

Cmd gCmd[] =
{
    { "power",  "on|off",           "Controls the robostix voltage regulators", ParseOnOffArg,      Power, -1 },
    { "reset",  "on|off|pulse",     "Resets the robostix",                      ParseOnOffPulseArg, SimpleIOctl, ROBOSTIX_IOCTL_RESET },
    { "245",    "on|off",           "Controls the 245 buffer chip",             ParseOnOffArg,      SimpleIOctl, ROBOSTIX_IOCTL_245_ENABLE },

    { "sck",    "on|off",           "Sets/clears the SCK line",                 ParseOnOffArg,      SimpleIOctl, ROBOSTIX_IOCTL_SET_SCK },
    { "ss",     "on|off",           "Sets/clears the SS line",                  ParseOnOffArg,      SimpleIOctl, ROBOSTIX_IOCTL_SET_SS },
    { "txd",    "on|off",           "Sets/clears the IR-TXD line",              ParseOnOffArg,      SimpleIOctl, ROBOSTIX_IOCTL_SET_IR_TXD },
    { "mosi",   "on|off",           "Sets/clears the MOSI line",                ParseOnOffArg,      SimpleIOctl, ROBOSTIX_IOCTL_SET_MOSI },

    { "rxd",    "",                 "Reads the IR-RXD line",                    ParseNone,          ReadIOctl,   ROBOSTIX_IOCTL_GET_IR_RXD },
    { "irq",    "",                 "Reads the TM-IRQ line",                    ParseNone,          ReadIOctl,   ROBOSTIX_IOCTL_GET_IRQ },
    { "miso",   "",                 "Reads the MISO line",                      ParseNone,          ReadIOctl,   ROBOSTIX_IOCTL_GET_MISO },

    { NULL }
};

/* ---- Private Function Prototypes -------------------------------------- */
/* ---- Functions -------------------------------------------------------- */


/****************************************************************************
*
*  main
*
***************************************************************************/

int main( int argc, char **argv )
{
    char   *cmdStr;
    int     argIdx;
    Cmd    *cmd;

    if ( argc == 1 )
    {
        Usage( );
        exit( 0 );
    }

    if (( gFd = open( "/dev/robostix",  O_RDWR )) < 0 )
    {
        perror( "Unable to open /dev/robostix" );
        exit( 1 );
    }

    argIdx = 1;
    cmdStr = argv[ argIdx++ ];

    for ( cmd = gCmd; cmd->cmdStr != NULL; cmd++ ) 
    {
        if ( strcasecmp( cmdStr, cmd->cmdStr ) == 0 )
        {
            break;
        }
    }
    if ( cmd->cmdStr == NULL )
    {
        fprintf( stderr, "Unrecognized command: '%s'\n", cmdStr );
        exit( 1 );
    }

    if ( cmd->parseArgs( argc - argIdx, &argv[ argIdx ] ))
    {
        cmd->execFunc( cmd->cmd );
    }

    close( gFd );

    exit( 0 );
    return 0;

} // main

/****************************************************************************
*
*  Checks to see if the argument is on/off (or equivalent)
*
***************************************************************************/

int IsOnOffArg( int argc, char **argv )
{
    if (( strcasecmp( *argv, "on" ) == 0 )
    ||  ( strcasecmp( *argv, "t" ) == 0 )
    ||  ( strcasecmp( *argv, "1" ) == 0 ))
    {
        gVal = 1;
        return 1;
    }

    if (( strcasecmp( *argv, "off" ) == 0 )
    ||  ( strcasecmp( *argv, "f" ) == 0 )
    ||  ( strcasecmp( *argv, "0" ) == 0 ))
    {
        gVal = 0;
        return 1;
    }

    return 0;

} // IsOnOffArg

/****************************************************************************
*
*  Parses no arguments
*
***************************************************************************/

int ParseNone( int argc, char **argv )
{
    return 1;

} // ParseNone

/****************************************************************************
*
*  Parses a command line argument for legel on/off values
*
***************************************************************************/

int ParseOnOffArg( int argc, char **argv )
{
    if ( IsOnOffArg( argc, argv ))
    {
        return 1;
    }

    fprintf( stderr, "Expecting on/off, found: '%s'\n", *argv );
    return 0;

} // ParseOnOffArg

/****************************************************************************
*
*  Parses a command line argument for legel on/off values
*
***************************************************************************/

int ParseOnOffPulseArg( int argc, char **argv )
{
    if (( strcasecmp( *argv, "pulse" ) == 0 )
    ||  ( strcasecmp( *argv, "2" ) == 0 ))
    {
        gVal = 2;
        return 1;
    }

    if ( IsOnOffArg( argc, argv ))
    {
        return 1;
    }

    fprintf( stderr, "Expecting on/off/pulse, found: '%s'\n", *argv );
    return 0;

} // ParseOnoffPulseArg

/****************************************************************************
*
*  Power
*
***************************************************************************/

void Power( int cmd )
{
    SimpleIOctl( ROBOSTIX_IOCTL_POWER_VCC5 );

} // Power

/****************************************************************************
*
*  SimpleIOctl
*
***************************************************************************/

void SimpleIOctl( int cmd )
{
    if ( ioctl( gFd, cmd, gVal ) != 0 )
    {
        fprintf( stderr, "ioctl call failed: %d\n", errno );
    }

} // SimpleIOctl

/****************************************************************************
*
*  SimpleIOctl
*
***************************************************************************/

void ReadIOctl( int cmd )
{
    if ( ioctl( gFd, cmd, &gVal ) != 0 )
    {
        fprintf( stderr, "ioctl call failed: %d\n", errno );
    }

} // ReadIOctl

/****************************************************************************
*
*  Usage
*
***************************************************************************/

void Usage( void )
{
    Cmd *cmd;

    for ( cmd = gCmd; cmd->cmdStr != NULL; cmd++ ) 
    {
        printf( "%-12s %-12s %s\n", cmd->cmdStr, cmd->argStr, cmd->helpStr );
    }

} // Usage

