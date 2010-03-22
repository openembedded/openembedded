# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
SECTION = "kernel"
DESCRIPTION = "Linux kernel for Xilinx ML403 Virtex 4 fpga board"
LICENSE = "GPLv2"
DEPENDS = "git-native"
PR = "r1"
DEFAULT_PREFERENCE = "-1"
COMPATIBLE_MACHINE = "xilinx-ml403"
SRC_URI = "git://source.mvista.com/git/linux-xilinx-26;protocol=git \
           file://xilinx-ml403_defconfig "

inherit kernel xilinx-bsp

S = "${WORKDIR}/git"


FILES_kernel-image = "/boot/zImage.elf"

export OS = "Linux"
ARCH = "ppc"
KERNEL_IMAGETYPE = "zImage"
KERNEL_OUTPUT = "arch/ppc/boot/images/zImage.elf"


do_configure() {
               
                install -m 644 ${WORKDIR}/xilinx-ml403_defconfig ${S}/.config
                make ARCH=${ARCH} oldconfig
}

do_stage_append () {
#need ppc platforms includes + friends in order for external kernel modules to compile as headers a$

       install -d ${STAGING_KERNEL_DIR}/arch/
       cp -pPR arch/ppc ${STAGING_KERNEL_DIR}/arch/
       cp -pPR arch/powerpc ${STAGING_KERNEL_DIR}/arch/

       install -d ${STAGING_KERNEL_DIR}/include/asm
       cp -pPR include/asm-powerpc ${STAGING_KERNEL_DIR}/include/
       cp -pPR include/asm-ppc ${STAGING_KERNEL_DIR}/include/
}



do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE}.elf \
                 ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}

#seems like 2.6.21 kernel images have moved (or is this only for the Denx kernel ?)
#so we need to copy the kernel image where kernel.bbclass expects it to be
do_install_prepend() {
        install -m 0644 arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE}.elf \
                        arch/${ARCH}/boot/${KERNEL_IMAGETYPE}
}
