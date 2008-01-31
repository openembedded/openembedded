DESCRIPTION = "Linux Kernel for ARM based Buffalo Linkstations"
SECTION = "kernel"
LICENSE = "GPL"
DEPENDS += "u-boot-utils-native"
PR = "r2"

COMPATIBLE_MACHINE = "lsarm"

SRC_URI = "http://kernel.org/pub/linux/kernel/v2.6/linux-2.6.12.tar.bz2 \
	   http://downloads.linkstationwiki.net/Users/timtimred/lsarm/2.6.12-compiler_fix.patch;patch=1 \
	   file://makefile.patch;patch=1 \
	   file://defconfig \
		"

S = "${WORKDIR}/linux-2.6.12"

inherit kernel

export ARCH="arm"

KERNEL_IMAGETYPE = "uImage"

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	ARCH=${ARCH} oe_runmake oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/vmlinux.UBoot
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile

