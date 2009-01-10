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
*   @file   Log.h
*
*   @brief  Contains some logging macros.
*
****************************************************************************/
/**
*   @defgroup   Log   Logging
*
*   @brief      Provides a common interface for logging.
*
****************************************************************************/

#if !defined( LOG_H )
#define LOG_H                   ///< Include Guard

// ---- Include Files -------------------------------------------------------

#include <stdarg.h>
#include <stdio.h>

#if !defined( CONFIG_H )
#   include "Config.h"
#endif

#if !defined( CFG_LOG_USE_STDIO )
#   define  CFG_LOG_USE_STDIO   1
#endif


#if defined( AVR )
#   include <avr/pgmspace.h>
#   include <avr/interrupt.h>
#endif


#if CFG_LOG_TO_BUFFER
#   if !defined( CBUF_H )
#       include "CBUF.h"
#   endif

#endif



/**
 * @addtogroup Log
 * @{
 */

#if !defined( CFG_LOG_ENABLED )
#   define  CFG_LOG_ENABLED 1
#endif


#if !CFG_LOG_ENABLED

#define  Log( fmt, args... )
#define  LogError( fmt, args... )

#else


#if defined( __cplusplus )
extern "C"
{
#endif


/***************************************************************************
*
*   Log Buffer support
*/

#if CFG_LOG_TO_BUFFER

#if defined( AVR )

typedef struct
{
    const prog_char    *fmt;
    uint8_t             param1;
    uint8_t             param2;
#if CFG_LOG_EXTRA_PARAMS
    uint8_t             param3;
    uint8_t             param4;
#endif


} LOG_Entry_t;

#if CFG_LOG_EXTRA_PARAMS
#   define LOG_EXTRA_PARAMS_DECL    , uint8_t arg3, uint8_t arg4
#   define LOG_EXTRA_PARAMS         , 0, 0
#else

#   define LOG_EXTRA_PARAMS_DECL
#   define LOG_EXTRA_PARAMS
#endif


void LogBuf_P( const prog_char *fmt, uint8_t arg1, uint8_t arg2 LOG_EXTRA_PARAMS_DECL );

#define LogBuf0( fmt )              LogBuf_P( PSTR( fmt ), 0, 0       LOG_EXTRA_PARAMS )
#define LogBuf1( fmt, arg1 )        LogBuf_P( PSTR( fmt ), arg1, 0    LOG_EXTRA_PARAMS )
#define LogBuf2( fmt, arg1, arg2 )  LogBuf_P( PSTR( fmt ), arg1, arg2 LOG_EXTRA_PARAMS )

#if CFG_LOG_EXTRA_PARAMS
#define LogBuf3( fmt, arg1, arg2, arg3 )        LogBuf_P( PSTR( fmt ), arg1, arg2, arg3, 0 )
#define LogBuf4( fmt, arg1, arg2, arg3, arg4 )  LogBuf_P( PSTR( fmt ), arg1, arg2, arg3, arg4 )
#endif


#else


typedef struct
{
    const char         *fmt;
    uint8_t             param1;
    uint8_t             param2;

} LOG_Entry_t;

void LogBuf( const char *fmt, uint8_t arg1, uint8_t arg2 );

#define LogBuf0( fmt, arg1 )        LogBuf( fmt, 0, 0 )
#define LogBuf1( fmt, arg1 )        LogBuf( fmt, arg1, 0 )
#define LogBuf2( fmt, arg1, arg2 )  LogBuf( fmt, arg1, arg2 )

#endif  // AVR

#if ( CFG_LOG_NUM_BUFFER_ENTRIES > 128 )
typedef uint16_t    LOG_BufferIdx_t;
#else

typedef uint8_t     LOG_BufferIdx_t;
#endif


typedef struct
{
    LOG_BufferIdx_t m_getIdx;
    LOG_BufferIdx_t m_putIdx;
    LOG_Entry_t     m_entry[ CFG_LOG_NUM_BUFFER_ENTRIES ];

} LOG_Buffer_t;

extern  volatile    LOG_Buffer_t    LOG_gBuffer;

#define LOG_gBuffer_SIZE ( sizeof( LOG_gBuffer.m_entry ) / sizeof( LOG_gBuffer.m_entry[ 0 ] ))

void LogBufDump( void );

#endif  // CFG_LOG_TO_BUFFER

/***************************************************************************
*
*   Regular logging support
*/

#if CFG_LOG_USE_STDIO
extern FILE *gLogFs;

void LogInit( FILE *logFs );
#endif


#if defined( AVR )

void Log_P( const prog_char *fmt, ... );
void LogError_P( const prog_char *fmt, ... );
void vLog_P( const prog_char *fmt, va_list args );

#define Log( fmt, args... )         Log_P( PSTR( fmt ), ## args )
#define LogError( fmt, args... )    LogError_P( PSTR( fmt ), ## args )
#define vLog( fmt, va_list, args )  vLog_P( PSTR( fmt ), args )

#else   // AVR

#define LOG_LEVEL_NORMAL    0
#define LOG_LEVEL_ERROR     1

typedef void (*LogFunc_t)( int logLevel, const char *fmt, va_list args );

extern  int     gVerbose;
extern  int     gDebug;
extern  int     gQuiet;

void Log( const char *fmt, ... );
void LogError( const char *fmt, ... );
void vLog( const char *fmt, va_list args );
void vLogError( const char *fmt, va_list args );

#define Log_P( fmt, args... )       Log( fmt, ## args )
#define LogError_P( fmt, args... )  LogError( fmt, ## args )
#define vLog_P( fmt, args )         vLog( fmt, args )

#define LogDebug( fmt, args... )    do { if ( gDebug )   { Log( fmt, ## args ); }} while (0)
#define LogVerbose( fmt, args... )  do { if ( gVerbose ) { Log( fmt, ## args ); }} while (0)

void SetLogFunc( LogFunc_t logFunc );
void DefaultLogFunc( int logLevel, const char *fmt, va_list args );

#endif  // AVR

#if defined( __cplusplus )
}
#endif


#endif  // CFG_LOG_ENABLED

/** @} */

#endif // LOG_H

