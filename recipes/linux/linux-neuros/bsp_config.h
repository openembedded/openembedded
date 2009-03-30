/*
 * Automatically generated header file: don't edit
 */

#ifndef __BSP_CONFIG_H
#define __BSP_CONFIG_H

#define AUTOCONF_INCLUDED

#define NEUROS_BSP 1

/*
 * Build Configuration
 */
#define USING_CROSS_COMPILER 1
#define CONFIG_INSTALL_NO_USR 1
#define CONFIG_IMAGES_PREFIX "images"
#define CONFIG_SYSAPPS_PREFIX "rootfs/fs"
#define PREFIX "rootfs/fs"

/*
 * Memory Device Configuration
 */

/*
 * SDRAM Configuration
 */
#define CONFIG_NR_DRAM_BANKS 1
#define PHYS_SDRAM_1 0x01100000
#define PHYS_SDRAM_1_SIZE 0x04000000

/*
 * Flash Configuration
 */
#define CFG_MAX_FLASH_BANKS 1
#define PHYS_FLASH_1 0x00100000
#define PHYS_FLASH_SIZE 0x01000000
#define CFG_MAX_FLASH_SECT 270
#define CFG_FLASH_8BIT_MODE 1
#undef CFG_FLASH_16BIT_MODE

/*
 * Kernel Memory Configuration
 */
#define CONFIG_KERNEL_LOAD_ADDR 0x01108000
#define CONFIG_KERNEL_PARAM_ADDR 0x01100100
#define CONFIG_KERNEL_INITRD_ADDR 0x01800000
#define CFG_KERNEL_MEM_RESERVE 34

/*
 * U-Boot Bootloader Configuration
 */
#undef CONFIG_NTDEV_DM320
#undef CONFIG_NTR3_DM320
#define CONFIG_NTOSD_DM320 1
#undef CONFIG_DM320_30
#undef CONFIG_DM320
#undef CONFIG_DM270
#undef CONFIG_DM275
#undef CONFIG_DCIII
#undef CONFIG_DM340
#undef CONFIG_DM420
#undef CONFIG_OMAP2430
#define CONFIG_BOARD_CONFIG "ntosd-dm320_config"

/*
 * Neuros DM320 OSD production hardware
 */
#define CONFIG_ARM926EJS 1
#undef CONFIG_ARM_CLOCK175
#define CROSS_COMPILER_PREFIX "arm-linux-"
#define BOARD_POST_INIT 1
#undef CONFIG_MISC_INIT_R
#define CONFIG_BOOTLOADER_BASE 0x01400000
#define CONFIG_SYS_CLK_FREQ 27000000
#define CFG_TIMERBASE 0x00030080

/*
 * General Configuration
 */

/*
 * Miscellaneous Processing Setup
 */
#undef CONFIG_USE_IRQ
#undef CFG_CLKS_IN_HZ
#define CONFIG_CMDLINE_TAG 1
#define CONFIG_INITRD_TAG 1
#define CONFIG_SETUP_MEMORY_TAGS 1

/*
 * Environment Configuration
 */
#define CFG_ENV_IS_IN_FLASH 1
#define CFG_ENV_IS_IN_NAND 1
#define CFG_NAND_BASE_OFFSET 0X00080000
#define CFG_ENV_OFFSET 0x00040000
#define CFG_ENV_SIZE 0x00020000
#define CFG_LONGHELP 1
#define CFG_PROMPT "Neuros Devboard >  "
#define CFG_CONSOLE_IS_IN_ENV 1
#undef CFG_CONSOLE_INFO_QUIET
#define CONFIG_ENV_OVERWRITE 1

/*
 * Environment Variable Configuration
 */
#define CONFIG_BOOTDELAY 3
#define CONFIG_BOOTARGS ""
#define CONFIG_BOOTFILE ""
#define CFG_LOAD_ADDR 0x01800000

/*
 * Network Variables
 */
#define CONFIG_HOSTNAME "neuros"
#define CONFIG_ETHADDR "80:4C:EF:54:87:0A"
#define CONFIG_SERVERIP "192.168.1.1"
#define CONFIG_IPADDR "192.168.1.100"
#define CONFIG_NETMASK "255.0.0.0"
#define CONFIG_GATEWAYIP "192.168.1.1"
#define CONFIG_DNSIP "192.168.1.1"

/*
 * Buffers/Stack Configuration
 */
#define CFG_MAXARGS 16
#define CFG_CBSIZE 256
#define CONFIG_STACKSIZE 0x00020000

/*
 * Character Devices
 */

/*
 * Serial Drivers
 */
#define CONFIG_DM320_UART 1
#define CFG_DM320_UART_BASE 0x00030300
#define CONFIG_BAUDRATE 115200

/*
 * Network Configuration
 */
#define CONFIG_NETWORK 1
#undef CONFIG_DRIVER_SMC91111
#undef CONFIG_DRIVER_SMC9118
#undef CONFIG_DRIVER_CS8900
#define CS8900_BUS16 1
#undef CS8900_BUS32
#define CONFIG_DRIVER_DM9000 1
#define CONFIG_DM9000_BASE 0x60000300
#undef CONFIG_DM9000_USE_8BIT
#define CONFIG_DM9000_USE_16BIT 1
#undef CONFIG_DM9000_USE_32BIT


#endif
