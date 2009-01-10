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
*   This implements a driver for using the robostix from the gumstix
*
*   Initially, this contains the required support to emulate enough of the
*   parallel port interface to allow avrdude to program the ATMega128.
*
*****************************************************************************/

/* ---- Include Files ---------------------------------------------------- */

#include <linux/module.h>
#include <linux/init.h>
#include <linux/fs.h>

#include <linux/parport.h>
#include <linux/ppdev.h>
#include <linux/sysctl.h>
#include <linux/cdev.h>
#include <linux/device.h>
#include <linux/version.h>

#include <asm/delay.h>
#include <asm/uaccess.h>

#include <asm/arch/hardware.h>
#include <asm/arch/pxa-regs.h>

#include "robostix.h"

/****************************************************************************
*
*   This driver assumes that the robostix uses the following GPIO pins:
*
*   Robostix gumstix    ATmega 
*   Symbol     GPIO Dir Symbol          Description
*   ---------- ---- --- --------------  -------------------------------------
*   IR_RXD      46  in  ATM_TX0 PE1     Acts as PDO or MISO for programming
*   IR_TXD      47  out ATM_RX0 PE0     Acts as PDI or MOSI for programming
*
*   L_DD11      69  in  ATM_IRQ PE2     IRQ from ATmega128 to gumstix
*   L_DD12      70  out                 Enable for Vcc5 and AVCC for the ATMega
*   L_DD14      72  out                 Active low enable for the 245's
*   L_DD15      73  out ATM_RESET       Resets the processor
*
* The following shows the mapping of the SPI port for the gumstix:
*
*   NSSPCLK     81  out ATM_SCK         Acts as SCK for SPI use
*   NSSPFRAME   82  out ATM_SS          Acts as SS for SPI use
*   X_MOSI      83  out ATM_MOSI        Acts as MOSI for SPI use
*   X_MISO      84  in  ATM_MISO        Acts as MISO for SPI use
*
* On the verdex, the mapping for the SPI port is slightly different:
*
*   SSPCLK2     19  out ATM_SCK         Acts as SCK for SPI use
*   SSPSFRM2    14  out ATM_SS          Acts as SS for SPI use
*   SSPTXD2     13  out ATM_MOSI        Acts as MOSI for SPI use
*   SSPRXD2     11  in  ATM_MISO        Acts as MISO for SPI use   
*
*   X_SCL       -   i/o ATM_SCL         i2c clock
*   X_SDA       -   i/o ATM_SDA         i2c data
*
*****************************************************************************/

//---------------------------------------------------------------------------
//
//  This was extracted from avrdude, and it gives the pin configuration for
//  AVR Dude's default programmer. UISP calls it "BSD"
//  This is what I've chosen for this driver to implement.

#if 0
programmer
  id    = "bsd";
  desc  = "Brian Dean's Programmer, http://www.bsdhome.com/avrdude/";
  type  = par;
  vcc   = 2, 3, 4, 5;
  reset = 7;
  sck   = 8;
  mosi  = 9;
  miso  = 10;
;
#endif
//---------------------------------------------------------------------------
//
//  The following was extracted from avrdude. It basically gives the pin
//  number to register mapping that is in effect for the parallel port.
//
//  I added the comments on the right which shows pin usage for the default
//  programmer.
//
//  From this, we can glean that the Control register is never used, and none
//  of the signals which are used are inverted.
//
//  Furthermore, all of the Data accesses are writes and all of the Status
//  accesses are reads.

#if 0
struct ppipins_t {
  int pin;
  int reg;
  int bit;
  int inverted;
};

static struct ppipins_t pins[] = {
  {  1, PPICTRL,   0x01, 1 },
  {  2, PPIDATA,   0x01, 0 },   // Vcc
  {  3, PPIDATA,   0x02, 0 },   // Vcc
  {  4, PPIDATA,   0x04, 0 },   // Vcc
  {  5, PPIDATA,   0x08, 0 },   // Vcc
  {  6, PPIDATA,   0x10, 0 },
  {  7, PPIDATA,   0x20, 0 },   // Reset
  {  8, PPIDATA,   0x40, 0 },   // SCK
  {  9, PPIDATA,   0x80, 0 },   // MOSI
  { 10, PPISTATUS, 0x40, 0 },   // MISO
  { 11, PPISTATUS, 0x80, 1 },
  { 12, PPISTATUS, 0x20, 0 },
  { 13, PPISTATUS, 0x10, 0 },
  { 14, PPICTRL,   0x02, 1 }, 
  { 15, PPISTATUS, 0x08, 0 },
  { 16, PPICTRL,   0x04, 0 }, 
  { 17, PPICTRL,   0x08, 1 }
};

#endif

#define PPI_DATA_VCC_MASK       ( 0x01 | 0x02 | 0x04 | 0x08 )
#define PPI_DATA_RESET_MASK     ( 0x20 )
#define PPI_DATA_SCK_MASK       ( 0x40 )
#define PPI_DATA_MOSI_MASK      ( 0x80 )

#define PPI_STATUS_MISO_MASK    ( 0x40 )

/* ---- Public Variables ------------------------------------------------- */
/* ---- Private Constants and Types -------------------------------------- */

#define USE_SYSCTL  1

#if 1
#   if USE_SYSCTL
#       define ROBO_DEBUG( flag, fmt, args... ) do { if ( gDebug ## flag ) printk( "%s: " fmt, __FUNCTION__ , ## args ); } while (0)
#   else
#       define ROBO_DEBUG( flag, fmt, args... ) printk( "%s: " fmt, __FUNCTION__ , ## args )
#   endif
#else
#   define ROBO_DEBUG( flag, fmt, args... )
#endif

#define SET_GPIO( pin, val )    do { if ( val ) { GPSR( pin ) = GPIO_bit( pin ); } else { GPCR( pin ) = GPIO_bit( pin ); }} while(0)
#define GET_GPIO( pin )         (( GPLR( pin ) & GPIO_bit( pin )) != 0 )

// The Alternate function register is 2 bits per pin, so we can't use the
// GPIO_bit macro.

#define GPIO_AF_shift(x)        (((x) & 0x0F ) << 1 )
#define GPIO_AF_mask(x)         ( 3 << GPIO_AF_shift( x ))

/*
 * Define the mappings between various GPIO pins and functions on the robostix
 * board.
 */

#define ROBOSTIX_GPIO_ATM_IRQ       GPIO69_LDD_11
#define ROBOSTIX_GPIO_VCC5_ENABLE   GPIO70_LDD_12
#define ROBOSTIX_GPIO_245_ENABLE    GPIO72_LDD_14
#define ROBOSTIX_GPIO_ATM_RESET     GPIO73_LDD_15

#ifdef CONFIG_PXA27x
#   define ROBOSTIX_GPIO_ATM_SCK    ( 19 | GPIO_ALT_FN_1_OUT )
#   define ROBOSTIX_GPIO_ATM_SS     ( 14 | GPIO_ALT_FN_2_OUT )
#   define ROBOSTIX_GPIO_ATM_MOSI   ( 13 | GPIO_ALT_FN_1_OUT )
#   define ROBOSTIX_GPIO_ATM_MISO   ( 11 | GPIO_ALT_FN_2_IN )
#else
#   define ROBOSTIX_GPIO_ATM_SCK    GPIO81_NSCLK
#   define ROBOSTIX_GPIO_ATM_SS     GPIO82_NSFRM
#   define ROBOSTIX_GPIO_ATM_MOSI   GPIO83_NSTXD
#   define ROBOSTIX_GPIO_ATM_MISO   GPIO84_NSRXD
#endif

#define ROBOSTIX_GPIO_IR_RXD_5V     GPIO46_STRXD
#define ROBOSTIX_GPIO_IR_TXD_5V     GPIO47_STTXD

// Since IR TxD/RxD behave like MOSI/MISO during programming, we define a
// couple of aliases

#define ROBOSTIX_GPIO_ATM_PGM_MOSI  ROBOSTIX_GPIO_IR_TXD_5V
#define ROBOSTIX_GPIO_ATM_PGM_MISO  ROBOSTIX_GPIO_IR_RXD_5V


typedef enum
{
    RoboStixGpioIn,
    RoboStixGpioOut,
} PinMode_e;

typedef struct
{
    unsigned    grer;
    unsigned    gfer;
    unsigned    gafr;
    unsigned    gpdr;
    unsigned    gplr;

} PinConfig_t;

/* ---- Private Variables ------------------------------------------------ */

#define ROBOSTIX_DEV_NAME   "robostix"

static char gBanner[] __initdata = KERN_INFO "Robostix Driver Compiled: " __DATE__ " at " __TIME__ "\n";

static  PinConfig_t gIrTxdConfig;
static  PinConfig_t gIrRxdConfig;

dev_t           gRobostixDevNum;
struct  cdev    gRobostixCDev;
struct  class  *gRobostixClass;

#if USE_SYSCTL

static  int gDebugTrace = 0;
static  int gDebugIoctl = 0;
static  int gDebugError = 1;

static  struct ctl_table_header    *gSysCtlHeader;

static struct ctl_table gSysCtlRobostix[] =
{
    {
        .ctl_name       = CTL_ROBOSTIX_DEBUG_TRACE,     
        .procname       = "debug-trace",
        .data           = &gDebugTrace,
        .maxlen         = sizeof( int ), 
        .mode           = 0644,
        .proc_handler   = &proc_dointvec 
    },
    { 
        .ctl_name       = CTL_ROBOSTIX_DEBUG_IOCTL,     
        .procname       = "debug-ioctl",  
        .data           = &gDebugIoctl,
        .maxlen         = sizeof( int ),
        .mode           = 0644,
        .proc_handler   = &proc_dointvec
    },
    {
        .ctl_name       = CTL_ROBOSTIX_DEBUG_ERROR,
        .procname       = "debug-error", 
        .data           = &gDebugError,
        .maxlen         = sizeof( int ), 
        .mode           = 0644,
        .proc_handler   = &proc_dointvec
    },
    { 0 }
};

static struct ctl_table gSysCtl[] =
{
    {
        .ctl_name       = CTL_ROBOSTIX, 
        .procname       = "robostix", 
        .mode           = 0555, 
        .child          = gSysCtlRobostix
    },
    { 0 }
};

#endif  // USE_SYSCTL

/* ---- Private Function Prototypes -------------------------------------- */

static  void    robostix_configure_pin( int pin, PinMode_e pinMode );
static  void    robostix_get_pin_config( int pin, PinConfig_t *pinConfig );
static  void    robostix_set_pin_config( int pin, const PinConfig_t *pinConfig );

static  void    robostix_exit( void );
static  int     robostix_init( void );
static  int     robostix_ioctl( struct inode *inode, struct file *file, unsigned int cmd, unsigned long arg );
static  int     robostix_open( struct inode *inode, struct file *file );
static  int     robostix_release( struct inode *inode, struct file *file );

/****************************************************************************
*
*   File Operations (these are the device driver entry points)
*
*****************************************************************************/

static struct file_operations robostix_fops =
{
    owner:      THIS_MODULE,
    ioctl:      robostix_ioctl,
    open:       robostix_open,
    release:    robostix_release,
};

/* ---- Functions -------------------------------------------------------- */

/****************************************************************************
*
*   robostix_configure_pin
*
*   Configures a GPIO pin for use with the RoboStix.
*
*****************************************************************************/

void robostix_configure_pin( int pin, PinMode_e pinMode )
{
    // Make sure that interrupts on rising/falling edges are turned off. This
    // is a bit paranoid, but might as well be sure.

    GRER( pin ) &= ~GPIO_bit( pin );
    GFER( pin ) &= ~GPIO_bit( pin );

    // Set the pin to be a GPIO pin

    GAFR( pin ) &= ~GPIO_AF_mask( pin );    // AF = 0 is GPIO

    // Reprogram the direction of the pin.

    if ( pinMode == RoboStixGpioIn )
    {
        GPDR( pin ) &= ~GPIO_bit( pin );    // in
    }
    else
    {
        GPDR( pin ) |= GPIO_bit( pin );     // out
    }

} // robostix_configure_pin

/****************************************************************************
*
*   robostix_get_pin_config
*
*   Retrieves the current pin configuration and stores it in @a pinConfig.
*
*****************************************************************************/

void robostix_get_pin_config( int pin, PinConfig_t *pinConfig )
{
    pinConfig->grer = GRER( pin ) & GPIO_bit( pin );
    pinConfig->gfer = GFER( pin ) & GPIO_bit( pin );
    pinConfig->gafr = GAFR( pin ) & GPIO_AF_mask( pin );
    pinConfig->gpdr = GPDR( pin ) & GPIO_bit( pin );
    pinConfig->gplr = GPLR( pin ) & GPIO_bit( pin );

} // robostix_get_pin_config

/****************************************************************************
*
*   robostix_set_pin_config
*
*   Restores the pin configuration to a previously saved comfiguration.
*
*****************************************************************************/

void robostix_set_pin_config( int pin, const PinConfig_t *pinConfig )
{
    GRER( pin ) = ( GRER( pin ) & ~GPIO_bit( pin )) | ( pinConfig->grer & GPIO_bit( pin ));
    GFER( pin ) = ( GFER( pin ) & ~GPIO_bit( pin )) | ( pinConfig->gfer & GPIO_bit( pin ));
    GPDR( pin ) = ( GPDR( pin ) & ~GPIO_bit( pin )) | ( pinConfig->gpdr & GPIO_bit( pin ));
    GAFR( pin ) = ( GAFR( pin ) & ~GPIO_AF_mask( pin )) | ( pinConfig->gafr & GPIO_AF_mask( pin ));

    if (( pinConfig->gplr & GPIO_bit( pin )) == 0 )
    {
        GPSR( pin ) |= GPIO_bit( pin );
    }
    else
    {
        GPCR( pin ) |= GPIO_bit( pin );
    }
    
} // robostix_set_pin_config

/****************************************************************************
*
*   robostix_exit
*
*   Called to perform module cleanup when the module is unloaded.
*
*****************************************************************************/

void robostix_exit( void )
{
    ROBO_DEBUG( Trace, "called\n" );

    class_device_destroy( gRobostixClass, gRobostixDevNum );
    class_destroy( gRobostixClass );

    cdev_del( &gRobostixCDev );

#if USE_SYSCTL
    if ( gSysCtlHeader != NULL )
    {
        unregister_sysctl_table( gSysCtlHeader );
    }
#endif

    unregister_chrdev_region( gRobostixDevNum, 1 );

#if 0
    unregister_chrdev( ROBOSTIX_MAJOR, ROBOSTIX_DEV_NAME );
#endif

} // robostix_exit

/****************************************************************************
*
*   robostix_init
*
*   Called to perform module initialization when the module is loaded.
*
*****************************************************************************/

int __init robostix_init( void )
{
    int rc;

    ROBO_DEBUG( Trace, "called\n" );

    printk( gBanner);

#if 0
    // Register our device with Linux

    if (( rc = register_chrdev( ROBOSTIX_MAJOR, ROBOSTIX_DEV_NAME, &robostix_fops )) < 0 )
    {
        printk( KERN_WARNING "robostix: register_chrdev failed for major %d\n", ROBOSTIX_MAJOR ); 
        return rc;
    }
#endif

    if (( rc = alloc_chrdev_region( &gRobostixDevNum, 0, 1, ROBOSTIX_DEV_NAME )) < 0 )
    {
        printk( KERN_WARNING "robostix: Unable to allocate major, err: %d\n", rc );
        return rc;
    }

#if USE_SYSCTL
    #if ( LINUX_VERSION_CODE <= KERNEL_VERSION( 2, 6, 20 ))
        gSysCtlHeader = register_sysctl_table( gSysCtl, 0 );
        if ( gSysCtlHeader != NULL )
        {
            gSysCtlHeader->ctl_table->child->de->owner = THIS_MODULE;
        }
    #else
        gSysCtlHeader = register_sysctl_table( gSysCtl );
    #endif
#endif

    // Initialize the various GPIO pins that control the Robostix.
    //
    //  IR_RXD      46  in  ATM_TX0 PE1     Acts as PDO or MISO for programming
    //  IR_TXD      47  out ATM_RX0 PE0     Acts as PDI or MOSI for programming
    //
    //  L_DD11      69  in  ATM_IRQ PE2     IRQ from ATmega128 to gumstix
    //  L_DD12      70  out                 Enable for Vcc5 and AVCC for the ATMega
    //  L_DD14      72  out                 Active low enable for the 245's
    //  L_DD15      73  out ATM_RESET       Resets the processor
    //
    //  NSSPCLK     81  out ATM_SCK         Acts as SCK for SPI use
    //  NSSPFRAME   82  out ATM_SS          Acts as SS for SPI use
    //  X_MOSI      83  out ATM_MOSI        Acts as MOSI for SPI use
    //  X_MISO      84  in  ATM_MISO        Acts as MISO for SPI use
    //
    // For now, we initialize things so that they continue on the way that 
    // they were when the gumstix boots:
    //
    //  245 is enabled
    //  voltage regulators are enabled
    //  Robostix is held in Reset
    //
    // I'd like to either see the voltage regulators in a disabled state 
    // or see the robostix not be held in reset so that we don't have sensors 
    // and motors and stuff going wild while the gumstix boots.
    //
    // The gumstix console runs through the '245 so we make sure to leave
    // it enabled.

    // The first thing to do is configure the input pins.

    robostix_configure_pin( ROBOSTIX_GPIO_ATM_MISO,     RoboStixGpioIn );

    // TODO: Set ATM_IRQ line to generate an interrupt

//    printk( "IRQ\n" );
//    robostix_configure_pin( ROBOSTIX_GPIO_ATM_IRQ,      RoboStixGpioIn );

    // Configure the output pins. We set the GPIO value register before
    // setting configuring it as a GPIO so that we don't create a glitch.

    SET_GPIO( ROBOSTIX_GPIO_VCC5_ENABLE, 1 );   // Voltage regulator on (active high)
    robostix_configure_pin( ROBOSTIX_GPIO_VCC5_ENABLE,  RoboStixGpioOut );

    SET_GPIO( ROBOSTIX_GPIO_ATM_RESET, 0 );     // AVR held in Reset (active low)
    robostix_configure_pin( ROBOSTIX_GPIO_ATM_RESET,    RoboStixGpioOut );

    // The values of these pins don't really matter.

    robostix_configure_pin( ROBOSTIX_GPIO_ATM_SCK,      RoboStixGpioOut );
    robostix_configure_pin( ROBOSTIX_GPIO_ATM_SS,       RoboStixGpioOut );
    robostix_configure_pin( ROBOSTIX_GPIO_ATM_MOSI,     RoboStixGpioOut );

    // Finally enable the '245

    SET_GPIO( ROBOSTIX_GPIO_245_ENABLE, 0 );    // '245 enabled (active low)
    robostix_configure_pin( ROBOSTIX_GPIO_245_ENABLE,   RoboStixGpioOut );

    // Don't change the configuration of the IR TxD/RxD here. Instead we
    // save/restore using the PPCLAIM/PPRELEASE which brackets when avrdude
    // is doing the actual programming.

    // TODO: Probably configure IR TxD as UART

    // Register our device. The device becomes "active" as soon as cdev_add 
    // is called.

    cdev_init( &gRobostixCDev, &robostix_fops );
    gRobostixCDev.owner = THIS_MODULE;

    if (( rc = cdev_add( &gRobostixCDev, gRobostixDevNum, 1 )) != 0 )
    {
        printk( KERN_WARNING "robostix: cdev_add failed: %d\n", rc );
        return rc;
    }

    gRobostixClass = class_create( THIS_MODULE, ROBOSTIX_DEV_NAME );
    if ( IS_ERR( gRobostixClass ))
    {
        printk( KERN_WARNING "robostix: Unable to create class\n" );
        return -1;
    }

    class_device_create( gRobostixClass, NULL, gRobostixDevNum, NULL, ROBOSTIX_DEV_NAME );

    return 0;

} // robostix_init

/****************************************************************************
*
*   robostix_ioctl
*
*   Called to process ioctl requests
*
*****************************************************************************/

int robostix_ioctl( struct inode *inode, struct file *file, unsigned int cmd, unsigned long arg )
{
    int err;
    int userVal;

    ROBO_DEBUG( Trace, "type: '%c' cmd: 0x%x\n", _IOC_TYPE( cmd ), _IOC_NR( cmd ));

    if (( _IOC_TYPE( cmd ) != ROBOSTIX_IOCTL_MAGIC )
    ||  ( _IOC_NR( cmd ) < ROBOSTIX_CMD_FIRST )
    ||  ( _IOC_NR( cmd ) >= ROBOSTIX_CMD_LAST ))
    {
        // Since we emulate some of the parallel port commands, we need to allow
        // those as well.

        if (( _IOC_TYPE( cmd ) != PP_IOCTL )
        ||  ( _IOC_NR( cmd ) < 0x80 )
        ||  ( _IOC_NR( cmd ) >= 0x9b ))
        {
            return -ENOTTY;
        }
    }

    // Note that _IOC_DIR Read/Write is from the perspective of userland. access_ok
    // is from the perspective of kernelland.

    err = 0;
    if (( _IOC_DIR( cmd ) & _IOC_READ ) != 0 )
    {
        err |= !access_ok( VERIFY_WRITE, (void *)arg, _IOC_SIZE( cmd ));
    }
    if (( _IOC_DIR( cmd ) & _IOC_WRITE ) != 0 )
    {
        err |= !access_ok( VERIFY_READ, (void *)arg, _IOC_SIZE( cmd ));
    }
    if ( err )
    {
        ROBO_DEBUG( Error, "arg pointer is invalid\n" );
        return -EFAULT;
    }

    switch ( cmd )
    {
        case ROBOSTIX_IOCTL_POWER_VCC5:
        {
            ROBO_DEBUG( Ioctl, "Power: %ld\n", arg );

#if 1
            // Until I figure something else out, the only way I can get the
            // power to really go off is to also turn off the '245. This means
            // that we'll lose the console, so you better be turning things
            // back on real soon now

            SET_GPIO( ROBOSTIX_GPIO_245_ENABLE, !arg );    // '245 is active low

            // Also - I noticed that the Console connector on the Robostix has
            // Vcc5 going to it, which means that if a TTL <=> RS232 converter
            // is being powered off the robostix, we'll lose our console as
            // soon as the voltage regulator (which generates Vcc5) gets 
            // turned off.

#else
            // In order to truly power off the robostix, we need to turn off
            // the voltage regulator. We assume that the '245 stays on so we
            // continue to get our console. This also means that we need to
            // take all of the GPIO lines low to eliminate any leak-thru 
            // current.

            if ( arg )
            {
                // Powering on - Configure I/O pins in "typical" manner.

                // TODO: Probably set MOSI/SCK/SS back to NSSP
                // TODO: Probably set IR TxD back to UART
            }
            else
            {
                // Powering off. Make them all GPIO's so that we can force
                // them low.

                SET_GPIO( ROBOSTIX_GPIO_ATM_RESET, 0 );
                SET_GPIO( ROBOSTIX_GPIO_ATM_MOSI,  0 );
                SET_GPIO( ROBOSTIX_GPIO_ATM_SCK,   0 );
                SET_GPIO( ROBOSTIX_GPIO_ATM_SS,    0 );
                SET_GPIO( ROBOSTIX_GPIO_IR_TXD_5V, 0 );

                robostix_configure_pin( ROBOSTIX_GPIO_ATM_RESET, RoboStixGpioOut );
                robostix_configure_pin( ROBOSTIX_GPIO_ATM_MOSI,  RoboStixGpioOut );
                robostix_configure_pin( ROBOSTIX_GPIO_ATM_SCK,   RoboStixGpioOut );
                robostix_configure_pin( ROBOSTIX_GPIO_ATM_SS,    RoboStixGpioOut );
                robostix_configure_pin( ROBOSTIX_GPIO_IR_TXD_5V, RoboStixGpioOut );

                // Grr - ATM_SCL and ATM_SDA are both pulled up to V_BATT,
                // so we probably need to make these go low too, which effectively
                // means that we lose the i2c bus.
            }
#endif

            SET_GPIO( ROBOSTIX_GPIO_VCC5_ENABLE, arg ); // Voltage regulator is active high
            break;
        }

        case ROBOSTIX_IOCTL_RESET:
        {
            if ( arg == ROBOSTIX_PIN_PULSE )
            {
                // The ATMega128 datasheet says that the reset pulse needs
                // to have a minimum pulse width of 1.5 usec.

                ROBO_DEBUG( Ioctl, "Reset: %ld (pulse)\n", arg );

                SET_GPIO( ROBOSTIX_GPIO_ATM_RESET, 0 ); // Reset is active low
                udelay( 3 );
                SET_GPIO( ROBOSTIX_GPIO_ATM_RESET, 1 );
            }
            else
            {
                // Reset is active low, so "on" means low

                ROBO_DEBUG( Ioctl, "Reset: %ld\n", arg );

                SET_GPIO( ROBOSTIX_GPIO_ATM_RESET, !arg );
            }
            break;
        }

        case ROBOSTIX_IOCTL_245_ENABLE:
        {
            // The 245 is active low, so we invert the sense of on/off

            ROBO_DEBUG( Ioctl, "245 Enable: %ld\n", arg );

            if ( arg != 0 )
            {
                printk( KERN_WARNING "Robostix: Warning turning '245 off - console may become inactive\n" );

                // Allow some time for the above warning to get printed on the
                // console before we turn it off.

                set_current_state( TASK_INTERRUPTIBLE );
                schedule_timeout( 2 );
            }

            SET_GPIO( ROBOSTIX_GPIO_245_ENABLE, !arg );
            break;
        }

        case ROBOSTIX_IOCTL_SET_SCK:    // out
        {
            ROBO_DEBUG( Ioctl, "Set SCK: %ld\n", arg );

            SET_GPIO( ROBOSTIX_GPIO_ATM_SCK, arg );
            break;
        }

        case ROBOSTIX_IOCTL_SET_SS:     // out
        {
            ROBO_DEBUG( Ioctl, "Set SS: %ld\n", arg );

            SET_GPIO( ROBOSTIX_GPIO_ATM_SS, arg );
            break;
        }

        case ROBOSTIX_IOCTL_SET_IR_TXD: // out
        {
            // This particular ioctl should only ever be called as part of 
            // somebody testing something. We assume that they'll be smart
            // enough to reconfigure when they're done.

            ROBO_DEBUG( Ioctl, "Set IR TxD: %ld\n", arg );

            robostix_configure_pin( ROBOSTIX_GPIO_IR_TXD_5V, RoboStixGpioOut );

            SET_GPIO( ROBOSTIX_GPIO_IR_TXD_5V, arg );
            break;
        }

        case ROBOSTIX_IOCTL_GET_IR_RXD: // in
        {
            // This particular ioctl should only ever be called as part of 
            // somebody testing something. We assume that they'll be smart
            // enough to reconfigure when they're done.

            robostix_configure_pin( ROBOSTIX_GPIO_IR_RXD_5V, RoboStixGpioIn );

            userVal = GET_GPIO( ROBOSTIX_GPIO_IR_RXD_5V );
            if ( copy_to_user( (int *)arg, &userVal, sizeof( userVal )) != 0 )
            {
                return -EFAULT;
            }

            ROBO_DEBUG( Ioctl, "Get IR RxD: %d\n", userVal );
            break;
        }

        case ROBOSTIX_IOCTL_SET_MOSI:   // out
        {
            ROBO_DEBUG( Ioctl, "Set MOSI: %ld\n", arg );

            SET_GPIO( ROBOSTIX_GPIO_ATM_MOSI, arg );
            break;
        }

        case ROBOSTIX_IOCTL_GET_MISO:   // in
        {
            userVal = GET_GPIO( ROBOSTIX_GPIO_ATM_MISO );
            if ( copy_to_user( (int *)arg, &userVal, sizeof( userVal )) != 0 )
            {
                return -EFAULT;
            }
            ROBO_DEBUG( Ioctl, "Get MISO: %d\n", userVal );
            break;
        }

        case ROBOSTIX_IOCTL_GET_IRQ:    // in
        {
            userVal = GET_GPIO( ROBOSTIX_GPIO_ATM_IRQ );
            if ( copy_to_user( (int *)arg, &userVal, sizeof( userVal )) != 0 )
            {
                return -EFAULT;
            }
            ROBO_DEBUG( Ioctl, "Get IRQ: %d\n", userVal );
            break;
        }

        case ROBOSTIX_IOCTL_DELAY_USEC:
        {
            ROBO_DEBUG( Ioctl, "Delay: %ld usecs\n", arg );

            udelay( arg );
            break;
        }

        //-------------------------------------------------------------------
        //
        // Parallel port interface. Some documentation on these ioctls can
        // be found here: 
        //  http://www.kernelnewbies.org/documents/kdoc/parportbook/x623.html
        //

        case PPRSTATUS:     // Read status register
        {
            unsigned char   statusReg = 0;
            int             miso;

            // The only thing mapped into the status register, is MISO.

            miso = GET_GPIO( ROBOSTIX_GPIO_ATM_PGM_MISO );


            if ( miso )
            {
                statusReg |= PPI_STATUS_MISO_MASK;
            }

            ROBO_DEBUG( Ioctl, "PPRSTATUS: 0x%02x miso:%d\n", statusReg, miso ); 

            if ( copy_to_user( (unsigned char *)arg, &statusReg, sizeof( statusReg )) != 0 )
            {
                return -EFAULT;
            }
            break;
        }

        case PPRCONTROL:    // Read control register
        {
            // Called once to initialize avrdude's shadow registers

            unsigned char controlReg = 0;

            ROBO_DEBUG( Ioctl, "PPRCONTROL: 0x%02x\n", controlReg ); 

            if ( copy_to_user( (unsigned char *)arg, &controlReg, sizeof( controlReg )) != 0 )
            {
                return -EFAULT;
            }
            break;
        }

        case PPWCONTROL:    // Write control register
        {
            unsigned char controlReg = 0;

            if ( copy_from_user( &controlReg, (unsigned char *)arg, sizeof( controlReg )) != 0 )
            {
                return -EFAULT;
            }

            ROBO_DEBUG( Ioctl, "PPWCONTROL: 0x%02x\n", controlReg ); 
            break;
        }

        case PPRDATA:   // Read data register
        {
            // Called once to initialize avrdude's shadow registers

            unsigned char   dataReg = 0;
            int             power, sck, reset, mosi;

            power = GET_GPIO( ROBOSTIX_GPIO_VCC5_ENABLE );
            sck   = GET_GPIO( ROBOSTIX_GPIO_ATM_SCK );
            reset = GET_GPIO( ROBOSTIX_GPIO_ATM_RESET );
            mosi  = GET_GPIO( ROBOSTIX_GPIO_ATM_PGM_MOSI );

            if ( power )
            {
                dataReg |= PPI_DATA_VCC_MASK;
            }
            if ( reset )
            {
                dataReg |= PPI_DATA_RESET_MASK;
            }
            if ( sck )
            {
                dataReg |= PPI_DATA_SCK_MASK;
            }
            if ( mosi )
            {
                dataReg |= PPI_DATA_MOSI_MASK;
            }

            ROBO_DEBUG( Ioctl, "PPRDATA: 0x%02x pow:%d reset:%d sck:%d mosi: %d\n", dataReg, power, reset, sck, mosi ); 

            if ( copy_to_user( (unsigned char *)arg, &dataReg, sizeof( dataReg )) != 0 )
            {
                return -EFAULT;
            }
            break;
        }

        case PPWDATA:   // Write data register
        {
            unsigned char   dataReg = 0;
            int             power, sck, reset, mosi;
            
            if ( copy_from_user( &dataReg, (unsigned char *)arg, sizeof( dataReg )) != 0 )
            {
                return -EFAULT;
            }

            power = ( dataReg & PPI_DATA_VCC_MASK ) != 0;
            sck   = ( dataReg & PPI_DATA_SCK_MASK ) != 0;
            reset = ( dataReg & PPI_DATA_RESET_MASK ) != 0;
            mosi  = ( dataReg & PPI_DATA_MOSI_MASK ) != 0;

            ROBO_DEBUG( Ioctl, "PPWDATA: 0x%02x pow:%d reset:%d sck:%d mosi: %d\n", dataReg, power, reset, sck, mosi ); 

            SET_GPIO( ROBOSTIX_GPIO_VCC5_ENABLE, power );
            SET_GPIO( ROBOSTIX_GPIO_245_ENABLE, !power );   // 245 is active low

            SET_GPIO( ROBOSTIX_GPIO_ATM_SCK,      sck );
            SET_GPIO( ROBOSTIX_GPIO_ATM_RESET,    reset );
            SET_GPIO( ROBOSTIX_GPIO_ATM_PGM_MOSI, mosi );
            break;
        }

        case PPCLAIM:       // Claim the parallel port
        {
            ROBO_DEBUG( Ioctl, "PPCLAIM\n" );

            // We use this opportunity to save away the state of the IR Txd/Rxd lines
            // and convert them to GPIO.

            robostix_get_pin_config( ROBOSTIX_GPIO_IR_TXD_5V, &gIrTxdConfig );
            robostix_get_pin_config( ROBOSTIX_GPIO_IR_RXD_5V, &gIrRxdConfig );

            robostix_configure_pin( ROBOSTIX_GPIO_IR_TXD_5V, RoboStixGpioOut );
            robostix_configure_pin( ROBOSTIX_GPIO_IR_RXD_5V, RoboStixGpioIn );
            break;
        }

        case PPRELEASE:     // Release the parallel port
        {
            ROBO_DEBUG( Ioctl, "PPRELEASE\n" );

            // We use this opportunity to restore the state of the IR Txd/Rxd lines
            // back to what they were.

            robostix_set_pin_config( ROBOSTIX_GPIO_IR_TXD_5V, &gIrTxdConfig );
            robostix_set_pin_config( ROBOSTIX_GPIO_IR_RXD_5V, &gIrRxdConfig );
            break;
        }

        case PPDATADIR:
        {
            int dataDirReg;

            if ( copy_from_user( &dataDirReg, (int *)arg, sizeof( dataDirReg )) != 0 )
            {
                return -EFAULT;
            }

            ROBO_DEBUG( Ioctl, "PPDATADIR: 0x%02x\n", dataDirReg );
            break;
        }

        default:
        {
            ROBO_DEBUG( Error, "Unrecognized ioctl: '0x%x'\n", cmd );
            return -ENOTTY;
        }
    }

    return 0;

} // robostix_ioctl

/****************************************************************************
*
*   robostix_open
*
*   Called to process open requests
*
*****************************************************************************/

int robostix_open( struct inode *inode, struct file *file )
{
    ROBO_DEBUG( Trace, "major = %d, minor = %d\n", MAJOR( inode->i_rdev ),  MINOR( inode->i_rdev ));
                
    return 0;

} // robostix_open

/****************************************************************************
*
*   robostix_release
*
*   Called when the last istance is closed.
*
*****************************************************************************/

int robostix_release( struct inode *inode, struct file *file )
{
    ROBO_DEBUG( Trace, "called\n" );

    return 0;

} // robostix_release

/****************************************************************************/

module_init(robostix_init);
module_exit(robostix_exit);

MODULE_AUTHOR("Dave Hylands");
MODULE_DESCRIPTION("gumstix/robostix driver");
MODULE_LICENSE("Dual BSD/GPL");

