/*
 * Copyright (C) Koen Kooi <<koen@beagleboard.org>
 *
 * The pico DLP Controller Driver is free software; you
 * can redistribute it and/or modify it under the terms of the GNU
 * General Public License version 3 as published by the Free Software
 * Foundation.
 *
 * The pico DLP Controller Driver is distributed in
 * the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with The pico DLP Controller Driver ; if not,
 * write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307  USA
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <sys/ioctl.h>
#include <unistd.h>
#include <errno.h>
#include <fcntl.h>

#include "i2c-dev.h"

#define ADDRESS 0x1b

int main(int argc, char **argv)
{

	int fd = 0;

	/* Attempt to open I2C device (/dev/i2c-3) */
	fd = open("/dev/i2c-3", O_RDWR);
	if (fd == -1) {
		fprintf(stderr, "Failed to open pico DLP I2C device: %m\n");
		exit(0);
	}

	/* Set the slave address of type I2C_SLAVE */
	if (ioctl(fd, I2C_SLAVE, ADDRESS) < 0) {
		fprintf(stderr, "Failed to access pico DLp: %m\n");
		exit(0);
	}

	/* Attempt to enable checksumming */
	if (ioctl(fd, I2C_PEC, 1) < 0) {
		fprintf(stderr, "Failed to enable PEC\n");
		exit(0);
	}

	uint16_t hflip;		/* The horizontal flip bit */
	uint16_t vflip;		/* The vertical flip bit */

    uint16_t hflip_temp;     /* The horizontal flip bit */
    uint16_t vflip_temp;     /* The vertical flip bit */


	/* Read the status bits for horizontal and vertical vlip */
	fprintf(stdout, "Getting flip bits \n");
	hflip = i2c_smbus_read_word_data(fd, 0x08);
	vflip = i2c_smbus_read_word_data(fd, 0x09);

    /* Output the values to stdout */
    fprintf(stdout, "hflip: %d - vflip: %d\n", hflip, vflip);

	/* set flip bits to 0 */
	fprintf(stdout, "Setting flip bits to zero\n");
	i2c_smbus_write_word_data(fd, 0x08, 0);
	i2c_smbus_write_word_data(fd, 0x09, 0);
    
	hflip_temp = i2c_smbus_read_word_data(fd, 0x08);
    vflip_temp = i2c_smbus_read_word_data(fd, 0x09);
	fprintf(stdout, "hflip: %d - vflip: %d\n", hflip_temp, vflip_temp);

	sleep(2);

	/* set flip bits to 1 */
	fprintf(stdout, "Setting flip bits to one\n");
	i2c_smbus_write_word_data(fd, 0x08, 1);
	i2c_smbus_write_word_data(fd, 0x09, 1);

    hflip_temp = i2c_smbus_read_word_data(fd, 0x08);
    vflip_temp = i2c_smbus_read_word_data(fd, 0x09);
    fprintf(stdout, "hflip: %d - vflip: %d\n", hflip_temp, vflip_temp);

	sleep(2);

	/* restore values */
	fprintf(stdout, "Restoring flip bits \n");
	i2c_smbus_write_word_data(fd, 0x08, hflip);
	i2c_smbus_write_word_data(fd, 0x09, vflip);

    /* Read the status bits for horizontal and vertical vlip */
    hflip = i2c_smbus_read_word_data(fd, 0x08);
    vflip = i2c_smbus_read_word_data(fd, 0x09);

	/* Output the values to stdout */
	fprintf(stdout, "hflip: %d - vflip: %d\n", hflip, vflip);

	return 0;

}
