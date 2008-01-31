#Kernel for the xilinx-ml403 board using SecretLabs git tree
# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
SECTION = "kernel"
DESCRIPTION = "Linux kernel for Xilinx ML403 Virtex 4 fpga board"
LICENSE = "GPL"
PR = "r2"
PV = "2.6+git${SRCDATE}"

COMPATIBLE_MACHINE = "xilinx-ml403"

SRC_URI = "file://xilinx-ml403_defconfig "

inherit kernel xilinx-bsp

S = "${WORKDIR}/linux-2.6"


FILES_kernel-image = "/boot/zImage.elf"

export OS = "Linux"
ARCH = "ppc"
KERNEL_IMAGETYPE = "zImage"
KERNEL_OUTPUT = "arch/ppc/boot/images/zImage.elf"

#make sure git-native gets build before as
python __anonymous () {

    import bb


    depends = bb.data.getVarFlag('do_fetch', 'depends', d) or ""
    depends = depends + " git-native:do_populate_staging"
    bb.data.setVarFlag('do_fetch', 'depends', depends, d)

}


do_fetch () { 

        cd ${WORKDIR} 
        ${STAGING_BINDIR_NATIVE}/git clone git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git 
        cd linux-2.6                
        ${STAGING_BINDIR_NATIVE}/git clone git://git.secretlab.ca/git/linux-2.6-virtex.git  master 
} 



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

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile

