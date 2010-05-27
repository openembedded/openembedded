#Kernel for the xilinx-ml403 board using SecretLabs git tree
# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
SECTION = "kernel"
DESCRIPTION = "Linux kernel for Xilinx ML403 Virtex 4 fpga board"
LICENSE = "GPLv2"

SRCREV = "d7ed933b578d9c4dec0e23a5a6f78c464b31c47c"

PR = "r3"
PV = "2.6.25+2.6.26+${PR}+gitr${SRCREV}"
PE = "1"

COMPATIBLE_MACHINE = "xilinx-ml403"

#inherit kernel xilinx-bsp
inherit kernel

S = "${WORKDIR}/git"


FILES_kernel-image = "/boot/zImage.elf"

export OS = "Linux"
ARCH = "ppc"
KERNEL_IMAGETYPE = "zImage"
KERNEL_OUTPUT = "arch/ppc/boot/images/zImage.elf"

SRC_URI = "\
           git://git.secretlab.ca/git/linux-2.6-virtex.git;protocol=git \
          "

do_configure() {

                make ARCH=${ARCH} ml403_defconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE}.elf \
                 ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}

#seems like 2.6.21 kernel images have moved (or is this only for the Denx kernel ?)
#so we need to copy the kernel image where kernel.bbclass expects it to be
#do_install_prepend() {
#        install -m 0644 arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE}.elf \
#                        arch/${ARCH}/boot/${KERNEL_IMAGETYPE}
#}
