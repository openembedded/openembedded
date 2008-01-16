require linux.inc

SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Chumby"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://files.chumby.com/source/ironforge/build396/linux-2.6.16-chumby-1.2.tar.gz \
           http://files.chumby.com/source/ironforge/build396/align.pl \
           file://defconfig \
           "

S = "${WORKDIR}/linux-2.6.16"

COMPATIBLE_HOST = 'arm.*-linux'

ARCH = "arm"

#CMDLINE_CONSOLE ?= "ttyS0,115200n8"
#CMDLINE_ROOT = "root=/dev/slug rootfstype=ext2,jffs2 initrd=0x01000000,10M mem=32M@0x00000000"
#CMDLINE_ROOT = "root=/dev/ram0 rw rootfstype=ext2,jffs2 initrd=0x01000000,10M init=/linuxrc mem=32M@0x00000000"
#CMDLINE_ROOT = "root=/dev/mtdblock2 rootfstype=jffs2 console=ttyS0,115200 mem=64M"
#CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_CONSOLE}"
#CMDLINE = "console=ttyS0,38400 root=/dev/mtdblock5 rootfstype=cramfs psplash=false"

COMPATIBLE_MACHINE = "chumby"

do_deploy_prepend() {
	perl ../align.pl arch/arm/boot/zImage
}

do_deploy_append() {
	rm -f ${DEPLOY_DIR_IMAGE}/zImage-${PV}-${PR}-${MACHINE}.bin.zip
	zip ${DEPLOY_DIR_IMAGE}/zImage-${PV}-${PR}-${MACHINE}.bin.zip ${DEPLOY_DIR_IMAGE}/zImage-${PV}-${PR}-${MACHINE}.bin
	ln -sf zImage-${PV}-${PR}-${MACHINE}.bin.zip ${DEPLOY_DIR_IMAGE}/zImage-${MACHINE}.bin.zip
}

