/*
   sltime utility replacement for Sharp Zaurus SL-C7x0/860
   version 1.0
   Copyright 2004 Alexander Chukov <sash@cacko.biz>

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

#define CONFIG_MTD_NAND_LOGICAL_ADDRESS_ACCESS
#include "mtduser.h"

#define APM_IOC_SETRTC 0x4146
#define APM_IOC_GETRTC 0x4147

static int open_mtd(void)
{
	int fd;
	mtd_info_t meminfo;

	/* Open the device */
	if((fd = open("/dev/mtd1", O_RDWR)) == -1) {
		perror("open flash");
		exit(1);
	}

	/* Fill in MTD device capability structure */  
	if(ioctl(fd, MEMGETINFO, &meminfo) != 0) {
		perror("MEMGETINFO");
		close(fd);
		exit(1);
	}

	/* Make sure device page sizes are valid */
	if( !(meminfo.oobsize == 16 && meminfo.oobblock == 512) &&
		!(meminfo.oobsize == 8 && meminfo.oobblock == 256) ) {
		printf("Unknown flash (not normal NAND)\n");
		close(fd);
		exit(1);
	}

	return fd;
}

int main(int argc, char *argv[])
{
	int fd, mfd;
	struct timeval tv;
	unsigned int setime;
	struct read_laddr_info_user rinfo = {0x4C004, 4, (unsigned char *) &setime};
	
	if (argc < 2) {
	    mfd = open_mtd();
	    if (ioctl(mfd, MEMREADLADDR, &rinfo) != 0) {
		perror("ioctl(MEMREADLADDR)");
		close(mfd);
		exit(1);
	    }
	    close(mfd);
	    fd = open("/dev/apm_bios", O_RDWR);
	    //setime += ioctl(fd, APM_IOC_GETRTC, 0);
	    ioctl(fd, APM_IOC_SETRTC, &setime);
	    tv.tv_usec = 0;
	    tv.tv_sec = setime;
	    settimeofday(&tv, 0);
	    close(fd);
	} else if (strcmp(argv[1], "-clear") == 0) {
	    fd = open("/dev/apm_bios", O_RDWR);
	    tv.tv_usec = 0;
	    tv.tv_sec  = 1075658510;
	    settimeofday(&tv, 0);
	    setime = tv.tv_sec;
	    ioctl(fd, APM_IOC_SETRTC, (void*)&setime);
	    close(fd);
	} else if (strcmp(argv[1], "-set") == 0) {
	    gettimeofday(&tv, 0);
	    setime = tv.tv_sec;
	    mfd = open_mtd();
	    if (ioctl(mfd, MEMWRITELADDR, &rinfo) != 0) {
		perror("ioctl(MEMWRITELADDR)");
		close(mfd);
		exit(1);
	    }
	    close(mfd);
	} else {
	    fprintf(stderr, "Usage:\n%s [-set|-clear]\n", argv[0]);
	    exit(1);
	}
	return 0;
}

