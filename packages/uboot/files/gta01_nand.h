/*
 * (C) Copyright 2006 Harald Welte <hwelte@hmw-consulting.de>
 *
 * Configuation settings for the FIC GTA01 Linux GSM phone
 *
 * See file CREDITS for list of people who contributed to this
 * project.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 * MA 02111-1307 USA
 */

#ifndef __CONFIG_H
#define __CONFIG_H

/* we want to start u-boot directly from within NAND flash */
#define CONFIG_S3C2410_NAND_BOOT	1

/*
 * High Level Configuration Options
 * (easy to change)
 */
#define CONFIG_ARM920T		1	/* This is an ARM920T Core	*/
#define	CONFIG_S3C2410		1	/* in a SAMSUNG S3C2410 SoC     */
#define CONFIG_SMDK2410		1	/* on a SAMSUNG SMDK2410 Board  */

/* input clock of PLL */
#define CONFIG_SYS_CLK_FREQ	12000000/* the GTA01 has 12MHz input clock */


#define USE_920T_MMU		1
#define CONFIG_USE_IRQ		1

/*
 * Size of malloc() pool
 */
#define CFG_MALLOC_LEN		(CFG_ENV_SIZE + 128*1024)
#define CFG_GBL_DATA_SIZE	128	/* size in bytes reserved for initial data */

/*
 * Hardware drivers
 */

/*
 * select serial console configuration
 */
#define CONFIG_SERIAL1          1	/* we use SERIAL 1 on GTA01 */
//#define CONFIG_HWFLOW		1

/************************************************************
 * RTC
 ************************************************************/
#define	CONFIG_RTC_S3C24X0	1

/* allow to overwrite serial and ethaddr */
#define CONFIG_ENV_OVERWRITE

#define CONFIG_BAUDRATE		115200

/***********************************************************
 * Command definition
 ***********************************************************/
#define CONFIG_COMMANDS (\
			CFG_CMD_BDI	 | \
			CFG_CMD_LOADS	 | \
			CFG_CMD_LAODB	 | \
			CFG_CMD_IMI	 | \
			CFG_CMD_CACHE	 | \
			CFG_CMD_MEMORY	 | \
			CFG_CMD_ENV	 | \
			/* CFG_CMD_IRQ	 | */  \
			CFG_CMD_BOOTD	 | \
			CFG_CMD_CONSOLE	 | \
			CFG_CMD_ASKENV	 | \
			CFG_CMD_RUN	 | \
			CFG_CMD_ECHO	 | \
			CFG_CMD_I2C	 | \
			CFG_CMD_REGINFO	 | \
			CFG_CMD_IMMAP	 | \
			CFG_CMD_DATE	 | \
			CFG_CMD_AUTOSCRIPT | \
			CFG_CMD_BSP	 | \
			CFG_CMD_ELF	 | \
			CFG_CMD_MISC	 | \
			CFG_CMD_USB	 | \
			CFG_CMD_JFFS2	 | \
			CFG_CMD_DIAG	 | \
			/* CFG_CMD_HWFLOW	 | */ \
			CFG_CMD_SAVES	 | \
			CFG_CMD_NAND	 | \
			CFG_CMD_PORTIO	 | \
			CFG_CMD_MMC	 | \
			CFG_CMD_FAT	 | \
			CFG_CMD_EXT2	 | \
			0)
/* this must be included AFTER the definition of CONFIG_COMMANDS (if any) */
#include <cmd_confdefs.h>

#define CONFIG_BOOTDELAY	3
#define CONFIG_BOOTARGS    	"rootfstype=jffs2 root=/dev/mtdblock4 console=ttySAC0,115200 console=tty0 loglevel=8"
/*#define CONFIG_BOOTFILE	"elinos-lart" */
#define CONFIG_BOOTCOMMAND	"nand load 0x32000000 0x34000 0x200000; bootm 0x32000000"

#define CONFIG_DOS_PARTITION	1

#if (CONFIG_COMMANDS & CFG_CMD_KGDB)
#define CONFIG_KGDB_BAUDRATE	115200		/* speed to run kgdb serial port */
/* what's this ? it's not used anywhere */
#define CONFIG_KGDB_SER_INDEX	1		/* which serial port to use */
#endif

/*
 * Miscellaneous configurable options
 */
#define	CFG_LONGHELP				/* undef to save memory		*/
#define	CFG_PROMPT		"GTA01 # "	/* Monitor Command Prompt	*/
#define	CFG_CBSIZE		256		/* Console I/O Buffer Size	*/
#define	CFG_PBSIZE (CFG_CBSIZE+sizeof(CFG_PROMPT)+16) /* Print Buffer Size */
#define	CFG_MAXARGS		16		/* max number of command args	*/
#define CFG_BARGSIZE		CFG_CBSIZE	/* Boot Argument Buffer Size	*/

#define CFG_MEMTEST_START	0x30000000	/* memtest works on	*/
#define CFG_MEMTEST_END		0x33F00000	/* 63 MB in DRAM	*/

#undef  CFG_CLKS_IN_HZ		/* everything, incl board info, in Hz */

#define	CFG_LOAD_ADDR		0x33000000	/* default load address	*/

/* the PWM TImer 4 uses a counter of 15625 for 10 ms, so we need */
/* it to wrap 100 times (total 1562500) to get 1 sec. */
#define	CFG_HZ			1562500

/* valid baudrates */
#define CFG_BAUDRATE_TABLE	{ 9600, 19200, 38400, 57600, 115200 }

/*-----------------------------------------------------------------------
 * Stack sizes
 *
 * The stack sizes are set up in start.S using the settings below
 */
#define CONFIG_STACKSIZE	(128*1024)	/* regular stack */
#ifdef CONFIG_USE_IRQ
#define CONFIG_STACKSIZE_IRQ	(4*1024)	/* IRQ stack */
#define CONFIG_STACKSIZE_FIQ	(4*1024)	/* FIQ stack */
#endif

#define CONFIG_USB_OHCI		1

/*-----------------------------------------------------------------------
 * Physical Memory Map
 */
#define CONFIG_NR_DRAM_BANKS	1	   /* we have 1 bank of DRAM */
#define PHYS_SDRAM_1		0x30000000 /* SDRAM Bank #1 */
#define PHYS_SDRAM_1_SIZE	0x04000000 /* 64 MB */
#define PHYS_SDRAM_RES_SIZE	0x00200000 /* 2 MB for frame buffer */

/*-----------------------------------------------------------------------
 * FLASH and environment organization
 */

#if 1
#define CFG_NO_FLASH		1
#else
#define CFG_MAX_FLASH_SECT	1
#define CFG_MAX_FLASH_BANKS	1
#endif

#define	CFG_ENV_IS_IN_NAND	1
#define CFG_ENV_SIZE		0x4000		/* 16k Total Size of Environment Sector */
#define CFG_ENV_OFFSET		0x30000		/* environment after bootloader */

#define NAND_MAX_CHIPS		1
#define CFG_NAND_BASE		0x4e000000
#define CFG_MAX_NAND_DEVICE	1

#define CONFIG_MMC		1
#define CFG_MMC_BASE		0xff000000

/* EXT2 driver */
#define CONFIG_EXT2		1

/* FAT driver in u-boot is broken currently */
#define CONFIG_FAT		1
#define CONFIG_SUPPORT_VFAT	1

/* JFFS2 driver */
#define CONFIG_JFFS2_NAND	1
#define CONFIG_JFFS2_NAND_DEV	0
#define CONFIG_JFFS2_NAND_OFF	0x634000
#define CONFIG_JFFS2_NAND_SIZE	0x39cc000

/* ATAG configuration */
#define CONFIG_INITRD_TAG		1
#define CONFIG_SETUP_MEMORY_TAGS	1
#define CONFIG_CMDLINE_TAG		1
#if 0
#define CONFIG_SERIAL_TAG		1
#define CONFIG_REVISION_TAG		1
#endif

#define CONFIG_DRIVER_S3C24X0_I2C	1
#define CONFIG_HARD_I2C			1
#define CFG_I2C_SPEED			400000	/* 400kHz according to PCF50707 data sheet */
#define CFG_I2C_SLAVE			0x7f


#if 0
#define CONFIG_VIDEO
#define CONFIG_VIDEO_S3C2410
#define CONFIG_CFB_CONSOLE
#define CONFIG_VIDEO_LOGO
#define CONFIG_VGA_AS_SINGLE_DEVICE

#define VIDEO_KBD_INIT_FCT	0
#define VIDEO_TSTC_FCT		serial_tstc
#define VIDEO_GETC_FCT		serial_getc

#define LCD_VIDEO_ADDR		0x33d00000
#endif

#endif	/* __CONFIG_H */
