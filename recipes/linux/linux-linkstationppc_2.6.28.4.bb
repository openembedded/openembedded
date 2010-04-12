DESCRIPTION = "Linux Kernel for the Buffalo Linkstation HD/HG"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "dtc-native u-boot-mkimage-native"
COMPATIBLE_MACHINE = "(lsppchd|lsppchg)"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.gz;patch=1;name=patch \
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

SRC_URI[kernel.md5sum] = "d351e44709c9810b85e29b877f50968a"
SRC_URI[kernel.sha256sum] = "ae0d97c55efe7fce01273c97f8152af0deff5541e3bbf5b9ad98689112b54380"
SRC_URI[patch.md5sum] = "464f663266e2c18371e213adab3c0077"
SRC_URI[patch.sha256sum] = "4862e7bf53553f645d9d730d3657bbec79f7c03482a984259b38e10e25b54382"
