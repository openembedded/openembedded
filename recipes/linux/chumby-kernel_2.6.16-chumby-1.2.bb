require linux.inc

SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Chumby"
LICENSE = "GPLv2"
PR = "r4"

SRC_URI = "http://files.chumby.com/source/ironforge/build396/linux-2.6.16-chumby-1.2.tar.gz;name=kernel \
           http://files.chumby.com/source/ironforge/build396/align.pl;name=align \
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


SRC_URI[kernel.md5sum] = "efb128aed7aba5d47b72bfa8d42d97c4"
SRC_URI[kernel.sha256sum] = "69468ffe7dade5448c498230bd67fd5a9b843ef1b11ea3fe7161b2c7fc26ea77"
SRC_URI[align.md5sum] = "d1cbac52c52b956d9cbe6277a7f9a8c5"
SRC_URI[align.sha256sum] = "67695e9af2b0938b6406eeed41954bf8317693aa7ef8ad2e30fcea5bea59777f"
