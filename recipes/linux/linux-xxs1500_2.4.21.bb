SECTION = "kernel"
DESCRIPTION = "Linux kernel for mycable xxs1500"
LICENSE = "GPLv2"
KV = "2.4.21"
PV = "${KV}"

SRC_URI = "http://mycable.de/xxs1500/cms/index.php?download=linux-2.4.21-20040514.1522.tgz \
	file://Makefile \
	file://defconfig-xxs1500 \
	file://zboot-Makefile-flags.diff;patch=1;pnum=0"

S = "${WORKDIR}/linux"

inherit kernel

COMPATIBLE_MACHINE = "xxs1500"

PACKAGE_ARCH = "xxs1500"
ARCH = "mips"
KERNEL_OUTPUT = "arch/mips/zboot/images/xxs1500.flash.srec"
KERNEL_IMAGETYPE = "zImage.flash"
KERNEL_IMAGEDEST = "tmp"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig-xxs1500 ${S}/.config
	cp ${WORKDIR}/Makefile ${S}/arch/mips
}

FILES_kernel += " /tmp"
