/* config.h

   written by Marc Singer
   23 Jun 2006

   Copyright (C) 2006 Marc Singer

   -----------
   DESCRIPTION
   -----------

*/

#if !defined (__CONFIG_H__)
#    define   __CONFIG_H__

#define PHYS_PARAMS	   0x00000100 /* Address for the parameter list */

#define MACH_TYPE		   964

#define GUARANTEE_ATAG_CMDLINE

/* Uncomment one of these to switch the CPU into a specific mode. */
//#define FORCE_LITTLEENDIAN
//#define FORCE_BIGENDIAN

#endif  /* __CONFIG_H__ */
