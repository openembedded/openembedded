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
*   @file   i2c-io-api.h
*
*   @brief  This file contains definitions for performing i2c-io operations 
*           on the gumstix.
*
****************************************************************************/

#if !defined( I2C_IO_API_H )
#define I2C_IO_API_H

// ---- Include Files -------------------------------------------------------

#include <inttypes.h>
#include "i2c-io.h"

// ---- Constants and Types -------------------------------------------------

// ---- Variable Externs ----------------------------------------------------

// ---- Function Prototypes -------------------------------------------------

int I2C_IO_CheckVersion( const I2C_IO_Info_t *info );

int I2C_IO_GetInfo( int i2cDev, I2C_IO_Info_t *info );
int I2C_IO_GetGPIO( int i2cDev, uint8_t portNum, uint8_t *pinVal );
int I2C_IO_SetGPIO( int i2cDev, uint8_t portNum, uint8_t pinMask, uint8_t pinVal );
int I2C_IO_GetGPIODir( int i2cDev, uint8_t portNum, uint8_t *pinVal );
int I2C_IO_SetGPIODir( int i2cDev, uint8_t portNum, uint8_t pinMask, uint8_t pinVal );
int I2C_IO_GetADC( int i2cDev, uint8_t mux, uint16_t *adcVal );
int I2C_IO_ReadReg8( int i2cDev, uint8_t reg, uint8_t *regVal );
int I2C_IO_ReadReg16( int i2cDev, uint8_t reg, uint16_t *regVal );
int I2C_IO_WriteReg8( int i2cDev, uint8_t reg, uint8_t regVal );
int I2C_IO_WriteReg16( int i2cDev, uint8_t reg, uint16_t regVal );

#endif  // I2C_IO_API_H

