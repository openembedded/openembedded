require linux.inc

SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Compulab EM-X270 system"
LICENSE = "GPL"
DEPENDS = "u-boot-utils-native"
PR = "r1"

KERNEL_IMAGETYPE = "uImage"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	   file://em-x270.patch;patch=1 \
           file://defconfig \
	  "

S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'arm.*-linux'
COMPATIBLE_MACHINE = "em-x270"

inherit kernel
inherit package

ARCH = "arm"

FILES_kernel-image = ""

S = "${WORKDIR}/linux-${PV}"

