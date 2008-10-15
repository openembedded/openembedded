DESCRIPTION = "Linux Kernel for the Iomega storcenter platform"
SECTION = "kernel"
LICENSE = "GPL"
DEPENDS = "u-boot-utils-native"
PR = "r1"

COMPATIBLE_MACHINE = "storcenter"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	file://kernel.patch-${PV};patch=1 \
	file://defconfig-${PV} "

S = "${WORKDIR}/linux-${PV}"

inherit kernel

export ARCH = "ppc" 

KERNEL_IMAGETYPE = "uImage"
KERNEL_OUTPUT = "arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE}"

do_configure() {
	install -m 644 ${WORKDIR}/defconfig-${PV} ${S}/.config
	make ARCH=${ARCH} oldconfig
}
