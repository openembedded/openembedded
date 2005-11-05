/*
   slbl backlight utility for Sharp Zaurus
   version 1.0
   Copyright 2004 Michael 'Mickey' Lauer <mickey@Vanille.de>

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2, or (at your option)
   any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
 */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ioctl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <time.h>
#include <string.h>

#define SHARP_FL_IOCTL_DEVICE   "/dev/sharp_fl"
#define SHARP_FL_IOCTL_ON                  1
#define SHARP_FL_IOCTL_OFF                 2
#define SHARP_FL_IOCTL_STEP_CONTRAST     100
#define SHARP_FL_IOCTL_GET_STEP_CONTRAST 101
#define SHARP_FL_IOCTL_GET_STEP          102

int main(int argc, char *argv[])
{
	int fd;
	int steps;
	int current;
	int new;

	fd = open( SHARP_FL_IOCTL_DEVICE, O_RDWR );
	steps = ioctl( fd, SHARP_FL_IOCTL_GET_STEP, 0 );
	
	if ( steps < 1 )
	{
        	perror( "SHARP_FL_IOCTL_GET_STEP: ");
                close( fd );
                exit( 1 );
        }
        current = ioctl( fd, SHARP_FL_IOCTL_GET_STEP_CONTRAST, 0 );

	if (argc < 2)
	{
		printf( "Current backlight setting = %d / %d\n", current, steps-1 );
	}
	else if (strcmp(argv[1], "on") == 0)
	{
		ioctl( fd, SHARP_FL_IOCTL_ON, 0 );
	}
	else if (strcmp(argv[1], "off") == 0)
	{
		ioctl( fd, SHARP_FL_IOCTL_OFF, 0 );
	}
	else if (sscanf(argv[1], "%d", &new) == 1)
	{
		printf( "Setting backlight to %d\n", new );
		ioctl( fd, SHARP_FL_IOCTL_STEP_CONTRAST, new );
	}
	else
	{
		printf( "Usage:\n%s [on|off|<num>]\n", argv[0]);
		exit(1);
	}
	close( fd );
	return 0;
}

