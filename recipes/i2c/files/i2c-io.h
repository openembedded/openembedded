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
*   @file   i2c-io.h
*
*   @brief  This file defines the interface to the i2c-io program which
*           runs on the robostix.
*
*****************************************************************************/

#if !defined( I2C_IO_H )
#define I2C_IO_H            /**< Include Guard                             */

/* ---- Include Files ---------------------------------------------------- */

/* ---- Constants and Types ---------------------------------------------- */

//---------------------------------------------------------------------------
/**
 *  Defines the version of this API. This includes the layout of the 
 *  various structures, along with the semantics associated with the 
 *  protocol. Any changes require the version number to be incremented.
 *
 *  Version 2 - Introduced READ/WRITE_REG_8/16
 */

#define I2C_IO_API_VERSION      2

//---------------------------------------------------------------------------
/**
 *  The min version, determines the minimum version that this API is
 *  compatable with. This allows old host side programs to determine
 *  that they're not compatible.
 */

#define I2C_IO_API_MIN_VERSION  1


//---------------------------------------------------------------------------
/**
*   The I2C_IO_GET_INFO command retrieves information about the i2c-io
*   program running on the robostix.
*/

#define I2C_IO_GET_INFO     0x01

typedef struct
{
    uint8_t     version;
    uint8_t     minVersion;
    uint16_t    svnRevision;

} I2C_IO_Info_t;

//---------------------------------------------------------------------------
/**
*   The I2C_IO_GET_GPIO command retrieves the values of the pins indicated
*   by portNum.
*
*   The portNum is set such that 0 = A, 1 = B, etc.
*
*   A block-reply with a single 8 bit value is returned.
*/

typedef struct
{
    uint8_t     portNum;

} I2C_IO_Get_GPIO_t;

#define I2C_IO_GET_GPIO     0x02

//---------------------------------------------------------------------------
/**
*   The I2C_IO_SET_GPIO command sets the values of the pins specified
*   by pinMask to the correponding bits in ponVal.
*
*   Note: Setting a pin that's configured for input will enable a pullup
*         resistor.
*
*   The portNum is set such that 0 = A, 1 = B, etc.
*/

typedef struct
{
    uint8_t     portNum;
    uint8_t     pinMask;
    uint8_t     pinVal;

} I2C_IO_Set_GPIO_t;

#define I2C_IO_SET_GPIO     0x03

//---------------------------------------------------------------------------
/**
*   The I2C_IO_GET_GPIO_DIR command retrieves the data direction
*   register (DDR) for the indicated portNum.
*
*   The I2C_IO_Get_GPIO_t structure is used for this command.
*
*   Note: It's ok to read the values of pins which are set for output.
*
*   The portNum is set such that 0 = A, 1 = B, etc.
*
*   A block-reply with a single 8 bit value is returned.
*   A 1 bit means that the pin is set for output and a 0 bit means that 
*   the pin is set for input.
*/

#define I2C_IO_GET_GPIO_DIR 0x04

//---------------------------------------------------------------------------
/**
*   The I2C_IO_SET_GPIO_DIR command sets the data direction
*   register (DDR) for the indicated portNum.
*
*   The I2C_IO_Set_GPIO_t structure is used for this command.
*
*   The portNum is set such that 0 = A, 1 = B, etc.
*/

#define I2C_IO_SET_GPIO_DIR 0x05

//---------------------------------------------------------------------------
/**
*   The I2C_IO_GET_ADC command performs an ADC sample and returns the result.
*
*   mux values 0 thru 7 read singled ended ADC values. Values 8 thru 31
*   return a variety of values. See the data sheet for specifics.
*
*   A block-reply with a 16 bit value is returned, although only the 
*   lower 10 bits are significant.
*/

typedef struct
{
    uint8_t mux;

} I2C_IO_Get_ADC_t;

#define I2C_IO_GET_ADC      0x06

//---------------------------------------------------------------------------
/**
*   The I2C_IO_READ_REG_8 command reads a 8-bit register.
*
*   A block reply with an 8 bit value is returned.
*/

typedef struct
{
    uint8_t reg;    ///< Index of the register to be read.

} I2C_IO_ReadReg8_t;

#define I2C_IO_READ_REG_8   0x07

//---------------------------------------------------------------------------
/**
*   The I2C_IO_READ_REG_16 command reads a 16-bit register.
*
*   A block reply with a 16 bit value is returned.
*/

typedef struct
{
    uint8_t reg;    ///< Index of the register to be read.

} I2C_IO_ReadReg16_t;

#define I2C_IO_READ_REG_16  0x08

//---------------------------------------------------------------------------
/**
*   The I2C_IO_WRITE_REG_8 command writes an 8-bit register.
*/

typedef struct
{
    uint8_t reg;    ///< Index of the register to be read.
    uint8_t val;    ///< Value to write into the register

} I2C_IO_WriteReg8_t;

#define I2C_IO_WRITE_REG_8   0x09

//---------------------------------------------------------------------------
/**
*   The I2C_IO_WRITE_REG_16 command writes a 16-bit register.
*/

typedef struct
{
    uint8_t     reg;    ///< Index of the register to be read.
    uint8_t     pad;    ///< Pad for alignment on the host.
    uint16_t    val;    ///< Value to write

} I2C_IO_WriteReg16_t;

#define I2C_IO_WRITE_REG_16  0x0A

/* ---- Variable Externs ------------------------------------------------- */

/* ---- Function Prototypes ---------------------------------------------- */

#endif /* I2C_IO_H */

