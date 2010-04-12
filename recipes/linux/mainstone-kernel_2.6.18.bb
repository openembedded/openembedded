require linux.inc 

SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Mainstone (PXA270 ref design)"
LICENSE = "GPLv2"
PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.18.tar.bz2 \
           file://flash-unlock.patch;patch=1;pnum=0 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.18"

COMPATIBLE_HOST = 'arm.*-linux'

ARCH = "arm"

CMDLINE_CONSOLE ?= "ttyS0,115200n8"
#CMDLINE_ROOT = "root=/dev/slug rootfstype=ext2,jffs2 initrd=0x01000000,10M mem=32M@0x00000000"
#CMDLINE_ROOT = "root=/dev/ram0 rw rootfstype=ext2,jffs2 initrd=0x01000000,10M init=/linuxrc mem=32M@0x00000000"
CMDLINE_ROOT = "root=/dev/mtdblock2 rootfstype=jffs2 console=ttyS0,115200 mem=64M"
CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_CONSOLE}"

COMPATIBLE_MACHINE = "mainstone"

SRC_URI[md5sum] = "296a6d150d260144639c3664d127d174"
SRC_URI[sha256sum] = "c95280ff6c5d2a17788f7cc582d23ae8a9a7ba3f202ec6e4238eaadfce7c163d"
