DESCRIPTION = "Linux Kernel for the Buffalo Linkstation HD/HG"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "dtc-native u-boot-mkimage-native"
COMPATIBLE_MACHINE = "(lsppchd|lsppchg)"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.gz;patch=1 \
           file://fw-and-powerpc-install.patch;patch=1 \
           file://defconfig \
               "
S = "${WORKDIR}/linux-2.6.28"

require linux.inc

export ARCH="powerpc"

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        ARCH=${ARCH} oe_runmake oldconfig
}
