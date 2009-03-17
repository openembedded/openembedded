DESCRIPTION = "Linux Kernel for the Thecus n1200"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "u-boot-mkimage-native"
COMPATIBLE_MACHINE = "n1200"

SRC_URI = "http://downloads.thecus.nas-central.org/N1200/Kernels/linux-2.6.27-foonas-git.tar.gz \
           file://fw-install.patch;patch=1 \
           file://defconfig"
S = "${WORKDIR}/linux-2.6.27-foonas-git"

inherit kernel

export ARCH="powerpc"

KERNEL_IMAGETYPE = "zImage"

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        ARCH=${ARCH} oe_runmake oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 ${S}/arch/powerpc/boot/cuImage.thecus_n1200 ${DEPLOY_DIR_IMAGE}/zImage
}

do_deploy[dirs] = "${S}"

addtask deploy before do_package after do_install
