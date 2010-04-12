DESCRIPTION = "Linux Kernel for the Thecus n1200"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r3"
DEPENDS = "u-boot-mkimage-native"
COMPATIBLE_MACHINE = "n1200"

SRC_URI = "http://downloads.thecus.nas-central.org/N1200/Kernels/linux-2.6.27-foonas-git.tar.gz \
           file://fw-install.patch;patch=1 \
           file://defconfig"
S = "${WORKDIR}/linux-2.6.27-foonas-git"

export ARCH="powerpc"

# Bootloader is not device tree aware
KERNEL_OUTPUT = "${S}/arch/powerpc/boot/cuImage.thecus_n1200"

require linux.inc

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        ARCH=${ARCH} oe_runmake oldconfig
}

SRC_URI[md5sum] = "0d0f5b5d4ef7b8916b5a733bbf8dc05c"
SRC_URI[sha256sum] = "cb5837924f7234045b4841998987b257977e64d141291068e5b145a3a276df7a"
