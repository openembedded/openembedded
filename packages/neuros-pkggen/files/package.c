/*
 * Copyright (C) 2006 - 2008 Neuros Technology LLC.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; only support version 2 of the License.
 *
 *  This program is distributed in the hope that, in addition to its 
 *  original purpose to support Neuros hardware, it will be useful 
 *  otherwise, but WITHOUT ANY WARRANTY; without even the implied 
 *  warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 *****************************************************************************/
/** package.c
 *
 *  This file for packaging some images to one package.
 *  The package is named r3.upk.
 *
 *  02/22/2005	        T.Qiu	
 *			Initial creation.
 *  11/07/2007          T.Qiu
 *                      change follow the new UPK structure
 *  05/15/2008          JWU
 *                      change for osd2.0
 */

#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include "package.h"

#define RETRYTIMES  15
#define VER_LIMIT_LEN	14
#define VER_HW2_LEN	4
#define SAFE_SIZE (250*1024*1024) //250MB

static package_header_t p_head;
static image_info_t     i_info[10];

static void print_image_info(image_info_t *iif)
{
    printf("iif->i_type: %x\n",        iif->i_type);
    printf("iif->i_imagesize: %d\n",   iif->i_imagesize);
    printf("iif->i_startaddr_p: %d\n", iif->i_startaddr_p);
    printf("iif->i_startaddr_f: %x\n", iif->i_startaddr_f);
    printf("iif->i_endaddr_f: %x\n",   iif->i_endaddr_f);
    printf("iif->i_name: %s\n",        iif->i_name);
    printf("iif->i_version: %s\n",     iif->i_version);
}

static void print_head_info(void)
{
    package_header_t *phd = &p_head;

    printf("phd->p_headsize: %x\n", phd->p_headsize);
    printf("phd->p_reserve: %x\n",  phd->p_reserve);
    printf("phd->p_headcrc: %x\n",  phd->p_headcrc);
    printf("phd->p_datasize: %d\n", phd->p_datasize);
    printf("phd->p_datacrc: %x\n",  phd->p_datacrc);
    printf("phd->p_name: %s\n",     phd->p_name);
    printf("phd->p_vuboot: %s\n",   phd->p_vuboot);
    printf("phd->p_vkernel: %s\n",  phd->p_vkernel);
    printf("phd->p_vrootfs: %s\n",  phd->p_vrootfs);
    printf("phd->p_imagenum: %x\n", phd->p_imagenum);
}

static void print_version_info(version_info *ver_t)
{
    printf("ver_t->upk_desc: %s\n", ver_t->upk_desc);
    printf("ver_t->pack_id: %s\n",  ver_t->pack_id);
    printf("ver_t->os_ver : %s\n",  ver_t->os_ver);
    printf("ver_t->app_ver: %s\n",  ver_t->app_ver);
}

static int pack_firmware(FILE *fp_w, uint32 offst, int num, char *name[])
{
    FILE *fp_r;
    int i, j;
    uint32 curptr, extcrc;
    char ch;
    package_header_t *phd = &p_head;
    image_info_t     *iif;

    /* read version file */
    if ((fp_r = fopen(UBOOT_VER_FILE, "rb")) == NULL)
    {
        printf("Can't open uboot version file: %s\n", UBOOT_VER_FILE);
        return(-1);
    }
    j=0;
    while (1)
    {
        if (feof(fp_r)) break;
        if (j > VER_LIMIT_LEN+1)
        {
            printf("uboot version can't be longer than 14\n");
            goto bail;
        }
        phd->p_vuboot[j] = fgetc(fp_r);
        if ((phd->p_vuboot[j]==0x0d) || (phd->p_vuboot[j]==0x0a))
            phd->p_vuboot[j] = '\0';
        j++;
    }
    fclose(fp_r);

    if ((fp_r = fopen(KERNEL_VER_FILE, "rb")) == NULL)
    {
        printf("Can't open kernel version file: %s\n", KERNEL_VER_FILE);
        return(-1);
    }
    j=0;
    while (1)
    {
        if (feof(fp_r)) break;
        if (j > VER_LIMIT_LEN+1)
        {
            printf("kernel version can't be longer than 14\n");
            goto bail;
        }
        phd->p_vkernel[j]=fgetc(fp_r);
        if ((phd->p_vkernel[j]==0x0d) || (phd->p_vkernel[j]==0x0a))
            phd->p_vkernel[j] = '\0';
        j++; 
    }
    fclose(fp_r);

    if ((fp_r = fopen(ROOTFS_VER_FILE, "rb")) == NULL)
    {
        printf("Can't open rootfs version file: %s\n", ROOTFS_VER_FILE);
        return(-1);
    }
    j=0;
    while (1)
    {
        if (feof(fp_r)) break;
        if (j > VER_LIMIT_LEN+1)
        {
            printf("rootfs version can't be longer than 14\n");
            goto bail;
        }
        phd->p_vrootfs[j] = fgetc(fp_r);
        if ((phd->p_vrootfs[j]==0x0d) ||(phd->p_vrootfs[j]==0x0a))
            phd->p_vrootfs[j] = '\0';
        j++;
    }
    fclose(fp_r);

    phd->p_imagenum = (uint8)num;
    phd->p_headsize = sizeof(package_header_t) + phd->p_imagenum * sizeof(image_info_t);

    /* Bit[3] use to indicate osd2.0 package */
    phd->p_reserve = 0x08;

    phd->p_datasize = 0;
    phd->p_datacrc  = 0;
    phd->p_headcrc  = 0;

    curptr = phd->p_headsize + sizeof(version_info);

    for (i=0; i < phd->p_imagenum; i++)
    {
        /* image info */
        iif = &i_info[i];
        if (strncmp(name[i], ROOTFS_FILE_NAME, strlen(ROOTFS_FILE_NAME)) == 0)
        {
            iif->i_type = IH_TYPE_ROOTFS;
            strncpy((char *)iif->i_name, ROOTFS_FILE_NAME, NAMELEN-1);

            if ((fp_r = fopen(ROOTFS_VER_FILE, "rb")) == NULL)
            {
                printf("Can't open kernel version file: %s\n", ROOTFS_VER_FILE);
                break;
            }
            for (j = 0; j < sizeof(iif->i_version); j++)
            {
                if (feof(fp_r)) break;
                iif->i_version[j] = fgetc(fp_r);
                if ((iif->i_version[j]==0x0d) || (iif->i_version[j]==0x0a))
                    iif->i_version[j] = '\0';
            }
            fclose(fp_r);
        }
        else if (strncmp(name[i], KERNEL_FILE_NAME, strlen(KERNEL_FILE_NAME)) == 0)
        {
            iif->i_type = IH_TYPE_KERNEL;
            strncpy((char *)iif->i_name, KERNEL_FILE_NAME, NAMELEN-1);

            if ((fp_r = fopen(KERNEL_VER_FILE, "rb")) == NULL)
            {
                printf("Can't open kernel version file: %s\n", KERNEL_VER_FILE);
                break;
            }
            for (j = 0; j < sizeof(iif->i_version); j++)
            {
                if (feof(fp_r)) break;
                iif->i_version[j] = fgetc(fp_r);
                if ((iif->i_version[j]==0x0d) ||(iif->i_version[j]==0x0a))
                    iif->i_version[j] = '\0';
            }
            fclose(fp_r);
        }
        else if (strncmp(name[i], UBOOT_FILE_NAME, strlen(UBOOT_FILE_NAME)) == 0)
        {
            iif->i_type = IH_TYPE_UBOOT;
            strncpy((char *)iif->i_name, UBOOT_FILE_NAME, NAMELEN-1);

            if ((fp_r = fopen(UBOOT_VER_FILE, "rb")) == NULL)
            {
                printf("Can't open uboot version file: %s\n", UBOOT_VER_FILE);
                break;
            }
            for (j = 0; j < sizeof(iif->i_version); j++)
            {
                if (feof(fp_r)) break;
                iif->i_version[j] = fgetc(fp_r);
                if ((iif->i_version[j]==0x0d)|| (iif->i_version[j]==0x0a))
                    iif->i_version[j] = '\0';
            }
            fclose(fp_r);
        }
        else if (strncmp(name[i], SCRIPT_FILE_NAME, strlen(SCRIPT_FILE_NAME)) == 0)
        {
            iif->i_type = IH_TYPE_SCRIPT;
            strncpy((char *)iif->i_name, SCRIPT_FILE_NAME, NAMELEN-1);
        }

        /* address in flash*/
        switch (iif->i_type)
        {
        case IH_TYPE_ROOTFS:
            iif->i_startaddr_f = ROOTFS_ADDR_START;
            iif->i_endaddr_f   = ROOTFS_ADDR_END;
            break;
        case IH_TYPE_KERNEL:
            iif->i_startaddr_f = KERNEL_ADDR_START;
            iif->i_endaddr_f   = KERNEL_ADDR_END;
            break;       
        case IH_TYPE_UBOOT:
            iif->i_startaddr_f = UBOOT_ADDR_START;
            iif->i_endaddr_f   = UBOOT_ADDR_END;
            break;
        case IH_TYPE_SCRIPT:
            break;
        default:
            printf("un-handle image type\n");
            break;
        }

        /* write whole image to package and calculate the imagesize*/
        iif->i_imagesize = 0;
        /* images file */
        if ((fp_r = fopen(name[i], "rb")) == NULL)
        {
            printf("can't open file: %s\n", name[i]);
            break;
        }

        fseek(fp_w, offst+curptr,SEEK_SET);
        extcrc = 0;
        while (!feof(fp_r))
        {
            ch = fgetc(fp_r);
            fputc(ch, fp_w);
            phd->p_datacrc = crc32(phd->p_datacrc,(uint8 *)&ch, 1);
            iif->i_imagesize ++;
        }
        fclose(fp_r);

        iif->i_startaddr_p = curptr-sizeof(version_info);
        curptr += iif->i_imagesize;
        phd->p_datasize += iif->i_imagesize;

        print_image_info(iif); /* print iff*/

        /*write image info */
        fseek(fp_w, offst+sizeof(version_info)+sizeof(package_header_t)+i*sizeof(image_info_t), SEEK_SET);
        if (fwrite(iif, sizeof(image_info_t), 1, fp_w) != 1)
        {
            printf("can not write iif into package\n");
            break;
        }
    }

    /* write package head*/
    phd->p_headcrc = crc32(phd->p_headcrc, (uint8 *)phd, sizeof(package_header_t));
    phd->p_headcrc = crc32(phd->p_headcrc, (uint8 *)i_info, phd->p_imagenum*sizeof(image_info_t));

    print_head_info();  /* print phd */

    fseek(fp_w, offst+sizeof(version_info), SEEK_SET);
    if (fwrite((uint8 *)phd, sizeof(package_header_t), 1, fp_w) != 1)
    {
        printf("can not write head into package");
        return(-1);
    }
    return 0;

    bail:
    fclose(fp_r);

    return -1;
}

static int pack_ver_info(FILE *fp_w, uint32 offset, char *desc)
{
    version_info ver_t;
    FILE *fp_r;
    int i;

    memset((char *)&ver_t, 0, sizeof(version_info));

    if (strlen(desc) >= DESCLEN)
    {
        printf("The upk_desc is too long\n");
        return(-1);
    }
    strncpy((char *)ver_t.upk_desc, desc, DESCLEN-1);
    strncpy((char *)ver_t.pack_id, (char *)PACKAGE_ID, NAMELEN-1);
    strncpy((char *)ver_t.os_ver,  "0.00", VERLEN-1);
    strncpy((char *)ver_t.app_ver, "0.00", VERLEN-1);

    if ((fp_r = fopen(KERNEL_VER_FILE, "rb")) == NULL)
    {
        printf("Can't open OS version file: %s\n", KERNEL_VER_FILE);
        return(-1);
    }
    for (i = 0; i < sizeof(ver_t.os_ver); i++)
    {
        if (feof(fp_r)) break;
        ver_t.os_ver[i] = fgetc(fp_r);
        if ((ver_t.os_ver[i]==0x0d) || (ver_t.os_ver[i]==0x0a))
            ver_t.os_ver[i] = '\0';
    }
    fclose(fp_r);

    if ((fp_r = fopen(ROOTFS_VER_FILE, "rb")) == NULL)
    {
        printf("Can't open App version file: %s\n", ROOTFS_VER_FILE);
        return(-1);
    }
    for (i = 0; i < sizeof(ver_t.app_ver); i++)
    {
        if (feof(fp_r)) break;
        ver_t.app_ver[i] = fgetc(fp_r);
        if ((ver_t.app_ver[i]==0x0d) || (ver_t.app_ver[i]==0x0a))
            ver_t.app_ver[i] = '\0';
    }
    fclose(fp_r);

    fseek(fp_w, 0, SEEK_SET);
    if (fwrite((uint8 *)&ver_t, sizeof(version_info), 1, fp_w) != 1)
    {
        printf("can not write the version struct into package\n");
        return(-1);
    }

    print_version_info(&ver_t);

    return(0);
}

/* argv[1] packet name
    argv[2] upk descpription
    argv[3] u-env image
    argv[4] u-boot image
    argv[5] kernel image
    argv[5] rootfs image*/
int main(int argc, char *argv[])
{
    FILE *fp_w;
    uint32 hw_len = 0;
    package_header_t *phd = &p_head;
    struct stat buf;

    printf("\npackage tool version %s \n", VERSION);

    strncpy((char *)phd->p_name, argv[1], NAMELEN-1);
    if ((fp_w = fopen((char *)phd->p_name, "wb+")) == NULL)
    {
        printf("Can't open %s\n",phd->p_name);
        return(-1);
    }

    /* packet firmware to package */
    if (pack_firmware(fp_w, hw_len, argc - 3, &argv[3]) != 0)
        return(-1);
    /* packet upk_desc and version info */
    if (pack_ver_info(fp_w, hw_len+phd->p_headsize, argv[2]) != 0)
        return(-1);

    fclose(fp_w);

    stat((char *)phd->p_name, &buf);
    if (buf.st_size > SAFE_SIZE)
    {
        printf("Warning!!!!! The upk size is larger than the safe size\n");
    }

    return 0;
}


