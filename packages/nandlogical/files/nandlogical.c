/*
   NAND logical utility for Sharp Zaurus SL-C7x0/860/7500/Cxx00
   version 1.0
   Copyright 2006 Alexander Chukov <sash@pdaXrom.org>

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2, or (at your option)
   any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
 */

#define _GNU_SOURCE
#include <ctype.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <getopt.h>
#include <sys/ioctl.h>
#include <sys/types.h>
#include <sys/stat.h>

#include <asm/types.h>
#include <mtd/mtd-user.h>

int fd;

unsigned char *readbuf;
unsigned char *oobbuf;
unsigned long *log2phy;

struct mtd_oob_buf oob = {0, 16, NULL};

struct nand_oobinfo none_oobinfo = {
	.useecc = MTD_NANDECC_OFF,
};

#define NAND_LOGICAL_SIZE (7 * 1024 * 1024)

/////////////////////////////////////////////////////////////////////
// oob structure
/////////////////////////////////////////////////////////////////////

#define NAND_NOOB_LOGADDR_00		8
#define NAND_NOOB_LOGADDR_01		9
#define NAND_NOOB_LOGADDR_10		10
#define NAND_NOOB_LOGADDR_11		11
#define NAND_NOOB_LOGADDR_20		12
#define NAND_NOOB_LOGADDR_21		13

static uint nand_get_logical_no(unsigned char *oob)
{
    unsigned short us,bit;
    int par;
    int good0, good1;

    if(oob[NAND_NOOB_LOGADDR_00] == oob[NAND_NOOB_LOGADDR_10] &&
       oob[NAND_NOOB_LOGADDR_01] == oob[NAND_NOOB_LOGADDR_11]){
	good0 = NAND_NOOB_LOGADDR_00;
	good1 = NAND_NOOB_LOGADDR_01;
    }else
    if(oob[NAND_NOOB_LOGADDR_10] == oob[NAND_NOOB_LOGADDR_20] &&
       oob[NAND_NOOB_LOGADDR_11] == oob[NAND_NOOB_LOGADDR_21]){
	good0 = NAND_NOOB_LOGADDR_10;
	good1 = NAND_NOOB_LOGADDR_11;
    }else
    if(oob[NAND_NOOB_LOGADDR_20] == oob[NAND_NOOB_LOGADDR_00] &&
       oob[NAND_NOOB_LOGADDR_21] == oob[NAND_NOOB_LOGADDR_01]){
	good0 = NAND_NOOB_LOGADDR_20;
	good1 = NAND_NOOB_LOGADDR_21;
    }else{
	return (uint)-1;
    }

    us = (((unsigned short)(oob[good0]) & 0x00ff) << 0) |
	 (((unsigned short)(oob[good1]) & 0x00ff) << 8);

    par = 0;
    for(bit = 0x0001; bit != 0; bit <<= 1){
	if(us & bit){
	    par++;
	}
    }
    if(par & 1){
	return (uint)-2;
    }

    if(us == 0xffff){
	return 0xffff;
    }else{
	return ((us & 0x07fe) >> 1);
    }
}

static void nand_set_logical_no(uint log_no, unsigned char *oob)
{
    unsigned short us,bit;
    int par;

    us = (((log_no & 0x03ff) << 1) | 0x1000);

    par = 0;
    for(bit = 0x0001; bit != 0; bit <<= 1){
	if(us & bit){
	    par++;
	}
    }
    if(par & 1){
	us |= 0x0001;
    }

    oob[NAND_NOOB_LOGADDR_00] = (unsigned char)((us & 0x00ff) >> 0);
    oob[NAND_NOOB_LOGADDR_01] = (unsigned char)((us & 0xff00) >> 8);
    oob[NAND_NOOB_LOGADDR_10] = oob[NAND_NOOB_LOGADDR_00];
    oob[NAND_NOOB_LOGADDR_11] = oob[NAND_NOOB_LOGADDR_01];
    oob[NAND_NOOB_LOGADDR_20] = oob[NAND_NOOB_LOGADDR_00];
    oob[NAND_NOOB_LOGADDR_21] = oob[NAND_NOOB_LOGADDR_01];
}

void scan_logical(int blocks, int erasesize)
{
    int i;
    unsigned long offset;
    int ret = 1;
    for (i = 0; i < blocks; i++)
	log2phy[i] = (uint) -1;
    offset = 0;
    for (i = 0; i < blocks; i++) {
	oob.start = offset;
	ret = ioctl(fd, MEMREADOOB, &oob);

	//ret = nand_read_raw(nand, oobuf, offset, nand->writesize, nand->oobsize);
	if (!ret) {
    	    int log_no = nand_get_logical_no(oobbuf);
	    if (((int)log_no >= 0) && (log_no < blocks)) {
		log2phy[log_no] = offset;
		//printf("NAND logical - %08X -> %04X\n", offset, log_no * erasesize);
	    } else {
		//printf("NAND logical - %08X - skip (%x)\n", offset, log_no);
	    }
	} else {
	    //printf("NAND logical - offset %x read OOB problem\n", offset);
	}
	offset += erasesize;
    }
}

unsigned long add_logical(unsigned long ofs, int blocks, int erasesize, int bs)
{
    erase_info_t erase;
    unsigned long offset = 0;
    int i;
    int ret;

    erase.length = erasesize;

    for (i = 0; i < blocks; i++) {
	oob.start = offset;
	ret = ioctl(fd, MEMREADOOB, &oob);

	if (!ret) {
    	    int log_no = nand_get_logical_no(oobbuf);

//printf("-- %x\n", log_no);

	    if ((short)log_no == -1) {
		int j = 0;
		{
		loff_t offs = offset;
		erase.start = offset;
		int ret = ioctl(fd, MEMGETBADBLOCK, &offs);
		if (ret > 0) {
		    printf ("\nSkipping bad block at 0x%08x\n", erase.start);
		    goto nextblock;
		} else if (ret < 0) {
			perror("ioctl(MEMGETBADBLOCK)");
			exit(1);
		} else {
			printf("%x - no bad block\n", offset);
		}
		
		if (ioctl(fd, MEMERASE, &erase) != 0) {
		    perror("ioctl(MEMERASE)");
		    goto nextblock;
		}

		//printf("%x - erased\n", offset);

		}

		//printf("NAND logical - found free block %x, mapped as %x\n", offset, ofs);

		log2phy[ofs / erasesize] = offset;

		return offset;
	    } else {
		//fprintf(stderr, "found: %x\n", log_no);
	    }
	} else {
	    perror ("ioctl(MEMREADOOB)");
	}
    
    nextblock:
        offset += erasesize;
    }
    
    return (unsigned long)-1;
}

void usage(void)
{
	fprintf(stderr, "Usage:\nnandlogical <mtd char device> READ|WRITE <start> <length> <file>\n");
	exit(1);
}

int main(int argc, char *argv[])
{
	mtd_info_t meminfo;
	char *mtddev;
	int blocks;
	unsigned long start_addr;
	unsigned long end_addr;
	unsigned long length;
	unsigned long ofs;
	int bs;
	int ofd;
	int func_write = 0;
	int oobinfochanged = 0;
	struct nand_oobinfo old_oobinfo;

	if (argc < 6)
	    usage();

	if (strcmp(argv[2], "WRITE") == 0)
	    func_write = 1;
	else if (strcmp(argv[2], "READ") != 0)
	    usage();
	
	mtddev = argv[1];
	start_addr = strtoul(argv[3], NULL, 0);
	length = strtoul(argv[4], NULL, 0);

	if (func_write) {
	    if ((ofd = open(argv[5], O_RDONLY)) == -1) {
		perror("open input file");
		exit(1);
	    }
	    /* Open MTD device */
	    if ((fd = open(mtddev, O_RDWR)) == -1) {
	        perror("open flash");
		exit (1);
	    }
	} else {
	    if ((ofd = open(argv[5], O_WRONLY | O_TRUNC | O_CREAT, 0644)) == -1) {
		perror ("open outfile");
		exit(1);
	    }
	    /* Open MTD device */
	    if ((fd = open(mtddev, O_RDONLY)) == -1) {
		perror("open flash");
	        exit (1);
	    }
	}

	/* Fill in MTD device capability structure */
	if (ioctl(fd, MEMGETINFO, &meminfo) != 0) {
	    perror("MEMGETINFO");
	    close(fd);
	    exit (1);
	}

	/* Make sure device page sizes are valid */
	if (!(meminfo.oobsize == 64 && meminfo.writesize == 2048) &&
	    !(meminfo.oobsize == 16 && meminfo.writesize == 512) &&
	    !(meminfo.oobsize == 8 && meminfo.writesize == 256)) {
	    fprintf(stderr, "Unknown flash (not normal NAND)\n");
	    close(fd);
	    exit(1);
	}

	//printf("erasesize %x\nwritesize %x\noobsize %x\nsize %x\n", meminfo.erasesize, meminfo.writesize, meminfo.oobsize, meminfo.size);
	
	blocks = NAND_LOGICAL_SIZE / meminfo.erasesize;
	log2phy = (unsigned long *) malloc(blocks * sizeof(unsigned long));
	readbuf = (char *)malloc(meminfo.erasesize);
	oobbuf = (char *)malloc(meminfo.writesize);	
	oob.ptr = oobbuf;

	scan_logical(blocks, meminfo.erasesize);
	
	//printf("Start: %x\nEnd: %x\n", start_addr, length);
	
	end_addr = start_addr + length;
	bs = meminfo.writesize;

	for (ofs = start_addr; ofs < end_addr ; ofs+=bs) {
	    int new_logical_added = 0;
	    int offset = log2phy[ofs / meminfo.erasesize];
	    
	    if ((int)offset < 0 && func_write) {
		//printf("add logical block...\n");
		offset = add_logical(ofs, blocks, meminfo.erasesize, bs);
		new_logical_added = 1;
	    }
	    
	    if ((int)offset < 0) {
	        printf("NAND logical - offset %08X not found\n", ofs);
		goto closeall;
	    }

	    offset += ofs % meminfo.erasesize;

	    //printf(":%x\n", offset);

	    if (func_write) {
		int len;
		memset(readbuf, 0xff, bs);
		len = read(ofd, readbuf, bs);
		if (len > 0) {
#if 1
			if (ofs % meminfo.erasesize == 0) {
			    int j;
			    erase_info_t erase;
			    erase.start = offset;
			    erase.length = meminfo.erasesize;
			    if (ioctl(fd, MEMERASE, &erase) != 0) {
				printf("ioctl(MEMERASE) %x\n", offset);
				//goto nextblock;
			    }
			    //printf("Erased\n");

			    for (j = 0; j < meminfo.erasesize; j+=bs) {
				int log_no;
				oob.start = offset + j;
				oob.length = 16;

				memset(oobbuf, 0xff, 16);
				nand_set_logical_no(ofs / meminfo.erasesize, oobbuf);
				if (ioctl(fd, MEMWRITEOOB, &oob) != 0) {
				    //perror ("ioctl(MEMWRITEOOB)");
				    printf("NAND logical add - MEMWRITEOOB error %x\n", offset + j);
				    exit(1);
				}
				memset(oobbuf, 0xff, 16);
				if (ioctl(fd, MEMREADOOB, &oob) != 0) {
				    perror ("ioctl(MEMREADOOB)");
				    exit(1);
				}
				log_no = nand_get_logical_no(oobbuf);
				//printf("%x:1 write %x, read %x\n", offset + j, ofs / meminfo.erasesize, log_no);
			    }

			}
#endif
			if (pwrite(fd, readbuf, bs, offset) != bs) {
				perror ("pwrite");
				goto closeall;
			}

		} else
		    break;
	    } else {
		if (pread(fd, readbuf, bs, offset) != bs) {
		    perror("pread");
		    goto closeall;
		}
		write(ofd, readbuf, ((end_addr - ofs) < bs)?(end_addr - ofs):bs);
	    }
	}

 closeall:

	free(log2phy);
	free(readbuf);
	free(oobbuf);
	close(fd);
	close(ofd);
	
	return 0;
}
