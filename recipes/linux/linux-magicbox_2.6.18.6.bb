SECTION = "kernel"
DESCRIPTION = "Linux kernel for Magicbox ver 1.1 and 2.0 router boards"
LICENSE = "GPLv2"
PR = "r2"
DEPENDS = "u-boot"

COMPATIBLE_MACHINE = "magicbox"

KERNEL_CCSUFFIX = "-3.4.4"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
          file://000-fix-makefile.patch;patch=1 \
          file://001-magicbox-board-2.6.18.patch;patch=1 \
          file://002-magicbox-mtd-map-2.6.18.patch;patch=1 \
          file://010-load-ramdisk-even-if-rootdev-equals-ramdisk.patch;patch=1 \
          file://magicbox2-ide-cf_2.6.18.patch;patch=1 \
          file://squashfs3.1-patch;patch=1 \
          file://squashfs-lzma-support.patch;patch=1 \
          file://kernel-2.6.18-layer7-2.6.patch;patch=1 \
          file://config-2.6.18-magicbox2\
"


S = "${WORKDIR}/linux-${PV}"

inherit kernel


FILES_kernel-image = "/boot/zImage.elf"

export OS = "Linux"
ARCH = "ppc"
KERNEL_OUTPUT = "arch/ppc/boot/images/zImage.elf"




do_configure_prepend() {
	install -m 0644 ${WORKDIR}/config-2.6.18-magicbox2 ${S}/.config
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
        install -d  ${DEPLOY_DIR}/images
        install -m 0755 arch/ppc/boot/images/zImage.elf ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.elf
        install -m 0755 vmlinux ${DEPLOY_DIR}/images/
        powerpc-${TARGET_OS}-objcopy -O binary -R .note -R .comment -S ${DEPLOY_DIR}/images/vmlinux ${DEPLOY_DIR}/images/linux.bin
        gzip -f -9 ${DEPLOY_DIR}/images/linux.bin
        mkimage -A ppc -O linux -T kernel -C gzip -a 0 -e 0 -n "ppc405"+${PV} -d ${DEPLOY_DIR}/images/linux.bin.gz ${DEPLOY_DIR}/images/uImage-${PV}-${MACHINE}-${DATETIME}.bin        
        rm ${DEPLOY_DIR}/images/vmlinux
        rm ${DEPLOY_DIR}/images/linux.bin.gz


}


pkg_postinst_kernel () {
        true
}

pkg_postrm_kernel () {
        true
}


