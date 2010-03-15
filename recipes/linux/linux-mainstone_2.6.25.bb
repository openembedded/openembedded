require linux.inc 

SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Mainstone (PXA270 ref design)"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.25/patch-2.6.25-rc4.bz2;patch=1 \
           file://mainstone-keypad.patch;patch=1 \
	   file://0001-time-prevent-the-loop-in-timespec_add_ns-from-bei.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.24"

COMPATIBLE_HOST = 'arm.*-linux'

ARCH = "arm"

CMDLINE_CONSOLE ?= "ttyS0,115200n8"
#CMDLINE_ROOT = "root=/dev/slug rootfstype=ext2,jffs2 initrd=0x01000000,10M mem=32M@0x00000000"
#CMDLINE_ROOT = "root=/dev/ram0 rw rootfstype=ext2,jffs2 initrd=0x01000000,10M init=/linuxrc mem=32M@0x00000000"
CMDLINE_ROOT = "root=/dev/mtdblock2 rootfstype=jffs2 console=ttyS0,115200 mem=64M"
CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_CONSOLE}"

COMPATIBLE_MACHINE = "mainstone"
