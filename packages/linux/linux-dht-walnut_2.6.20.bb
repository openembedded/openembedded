# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
SECTION = "kernel"
DESCRIPTION = "Linux kernel for DHT-Walnut (ppc)  machine"
LICENSE = "GPL"
PR = "r3"
DEPENDS = "u-boot"

COMPATIBLE_MACHINE = "dht-walnut"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://dht-walnut_defconfig"


S = "${WORKDIR}/linux-${PV}"

inherit kernel


FILES_kernel-image = "/boot/zImage.elf"

export OS = "Linux"
ARCH = "ppc"
KERNEL_OUTPUT = "arch/ppc/boot/images/zImage.elf"




do_configure_prepend() {
	install -m 0644 ${WORKDIR}/dht-walnut_defconfig ${S}/.config
}


do_stage_append () {
#need ppc platforms includes + friends in order for external kernel modules to compile as headers as still split

       install -d ${STAGING_KERNEL_DIR}/arch/
       cp -pPR arch/ppc ${STAGING_KERNEL_DIR}/arch/
       cp -pPR arch/powerpc ${STAGING_KERNEL_DIR}/arch/

       cp -pPR include/asm-powerpc ${STAGING_KERNEL_DIR}/include/
       cp -pPR include/asm-ppc ${STAGING_KERNEL_DIR}/include/
}





do_install_append () {
        install -d  ${DEPLOY_DIR_IMAGE}
        install -m 0755 arch/ppc/boot/images/zImage.elf \ 
                ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.elf
        install -m 0755 vmlinux ${DEPLOY_DIR_IMAGE}/
        powerpc${TARGET_VENDOR}-${TARGET_OS}-objcopy -O binary -R .note -R .comment -S \ 
               ${DEPLOY_DIR_IMAGE}/vmlinux ${DEPLOY_DIR_IMAGE}/linux.bin
        gzip -f -9 ${DEPLOY_DIR_IMAGE}/linux.bin
        mkimage -A ppc -O linux -T kernel -C gzip -a 0 -e 0 -n "ppc405"+${PV} -d ${DEPLOY_DIR_IMAGE}/linux.bin.gz \ 
                ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${MACHINE}-${DATETIME}.bin        
        rm ${DEPLOY_DIR_IMAGE}/vmlinux
        rm ${DEPLOY_DIR_IMAGE}/linux.bin.gz


}


pkg_postinst_kernel () {
        true
}

pkg_postrm_kernel () {
        true
}




