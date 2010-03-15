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
