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
*   @file   DumpMem.h
*
*   @brief  Debug routine for dumping memory
*
****************************************************************************/

#if !defined( DUMPMEM_H )
#define DUMPMEM_H                   ///< Include Guard

// ---- Include Files -------------------------------------------------------

/**
 * @addtogroup Log
 * @{
 */

#if defined( __cplusplus )
extern "C"
{
#endif


void DumpMem( const char *prefix, unsigned address, const void *data, unsigned numBytes );

#if defined( __cplusplus )
}
#endif

                 
/** @} */

#endif // DUMPMEM_H

