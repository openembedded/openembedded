SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Linksys NSLU2 device"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PR = "r1"

KERNEL_SUFFIX = "openslug"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.7.tar.bz2 \
	   file://arm-Makefile.patch;patch=1 \
	   file://ipx4xx-pci.patch;patch=1 \
	   file://arm-timer.patch;patch=1 \
           file://x1205-rtc.patch;patch=1;pnum=0 \
           cvs://anonymous@cvs.sourceforge.net/cvsroot/nslu;module=anyu2/source;method=pserver \
           file://defconfig"
S = "${WORKDIR}/linux-2.6.7"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"
CMDLINE_CONSOLE ?= "ttyS0,115200n8"
CMDLINE_ROOT = "root=/dev/ram0 initrd=0x01000000,10M mem=32M@0x00000000"
CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_CONSOLE}"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        install -m 0644 ${WORKDIR}/source/x1205-rtc.c ${S}/drivers/i2c/chips/x1205-rtc.c
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
	rm -rf ${S}/include/asm-arm/arch ${S}/include/asm-arm/proc \
	       ${S}/include/asm-arm/.proc ${S}/include/asm-arm/.arch
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${KERNEL_SUFFIX}
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
