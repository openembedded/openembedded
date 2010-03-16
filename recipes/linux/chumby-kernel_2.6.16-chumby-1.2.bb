require linux.inc

SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Chumby"
LICENSE = "GPLv2"
PR = "r4"

SRC_URI = "http://files.chumby.com/source/ironforge/build396/linux-2.6.16-chumby-1.2.tar.gz \
           http://files.chumby.com/source/ironforge/build396/align.pl \
           file://chumby-override-cmdline.patch;patch=1 \
           file://disable-fbchanging.patch;patch=1 \
           file://Makefile-remove-hard-setting-CROSS_COMPILE.patch;patch=1 \
           file://defconfig \
           "

S = "${WORKDIR}/linux-2.6.16"

COMPATIBLE_HOST = 'arm.*-linux'

ARCH = "arm"

# Use this CMDLINE for booting from RootFS 1 on the internal flash (22MB)
#CMDLINE = "console=ttyS0,38400 console=tty0 root=/dev/mtdblock5 rootfstype=jffs2 psplash=false"

# Use this CMDLINE for booting from the second partition of an USB disk
CMDLINE = "console=ttyS0,38400 console=tty0 root=/dev/sda2 rootfstype=ext2 rootdelay=8 psplash=false"

COMPATIBLE_MACHINE = "chumby"

module_autoload_chumby_accel = "chumby_accel"
module_autoload_chumby_emma = "chumby_emma"
module_autoload_chumby_sense1 = "chumby_sense1"
module_autoload_chumby_timer = "chumby_timer"
module_autoload_chumby_udma = "chumby_udma"
module_autoload_chumby-tsc2100 = "chumby-tsc2100"

do_deploy_prepend() {
	perl ../align.pl arch/arm/boot/zImage
}

do_deploy_append() {
	rm -f ${DEPLOY_DIR_IMAGE}/zImage-${PV}-${PR}-${MACHINE}.bin.zip
	zip ${DEPLOY_DIR_IMAGE}/zImage-${PV}-${PR}-${MACHINE}.bin.zip ${DEPLOY_DIR_IMAGE}/zImage-${PV}-${PR}-${MACHINE}.bin
	ln -sf zImage-${PV}-${PR}-${MACHINE}.bin.zip ${DEPLOY_DIR_IMAGE}/zImage-${MACHINE}.bin.zip
}

