# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
SECTION = "kernel"
DESCRIPTION = "Linux kernel for AMCC's Sequoia dev board"
LICENSE = "GPLv2"
PR = "r0"
#DEPENDS = "u-boot"

COMPATIBLE_MACHINE = "sequoia"

#DENX git kernel
#Same as in AMCC's sequoia dev kit
SRC_URI ="git://www.denx.de/git/linux-2.6-denx.git;protocol=git;tag=78157a82fa20719f7e3307307755888e9af2c0e9 \
          file://sequoia_defconfig "


S = "${WORKDIR}/git"

inherit kernel

export ARCH="ppc"

KERNEL_IMAGETYPE = "zImage.elf"

do_configure() {
                install -m 644 ${WORKDIR}/sequoia_defconfig ${S}/.config
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

#seems like 2.6.21 kernel images have moved (or is this only for the Denx kernel ?)
#so we need to copy the kernel image where kernel.bbclass expects it to be
do_install_prepend() {
        install -m 0644 arch/${ARCH}/boot/images/${KERNEL_IMAGETYPE} \
                        arch/${ARCH}/boot/${KERNEL_IMAGETYPE}
}
