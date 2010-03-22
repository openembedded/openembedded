SECTION = "kernel"
DESCRIPTION = "Linux kernel for PC-Engines WRAP which are \
Geode SC1100 (i486) based wirless router appliance boards"
LICENSE = "GPLv2"
PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	   file://defconfig"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'i486.*-linux'
COMPATIBLE_MACHINE = "wrap"

inherit kernel

ARCH = "i386"
KERNEL_OUTPUT = "arch/${ARCH}/boot/${KERNEL_IMAGETYPE}"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	yes '' | oe_runmake oldconfig
}
