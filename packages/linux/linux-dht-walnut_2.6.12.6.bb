SECTION = "kernel"
DESCRIPTION = "Linux kernel for DHT-Walnut (ppc)  machine"
LICENSE = "GPL"
PR = "r2"
DEPENDS = "u-boot"

KERNEL_CCSUFFIX = "-3.4.4"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://ppc_40x_uboot.patch;patch=1 \
           file://iw_we18-5.diff;patch=1 \
           file://linux-2.6.12-mppe-mppc-1.3.patch;patch=1 \
           file://dht-walnut_defconfig"


S = "${WORKDIR}/linux-${PV}"

inherit kernel


FILES_kernel-image = "/boot/zImage.elf"

export OS = "Linux"
ARCH = "ppc"
KERNEL_IMAGETYPE = "zImage"
KERNEL_OUTPUT = "arch/ppc/boot/images/zImage.elf"




do_configure_prepend() {
	install -m 0644 ${WORKDIR}/dht-walnut_defconfig ${S}/.config
}

do_stage_append () {
#need ppc platforms includes + friends in order for external kernel modules to compile

       install -d ${STAGING_KERNEL_DIR}/arch/ppc/platforms
       install -m 0755  arch/ppc/platforms/*.h ${STAGING_KERNEL_DIR}/arch/ppc/platforms

       install -d ${STAGING_KERNEL_DIR}/arch/ppc/platforms/4xx
       install -m 0755  arch/ppc/platforms/4xx/*.h ${STAGING_KERNEL_DIR}/arch/ppc/platforms/4xx

       install -d ${STAGING_KERNEL_DIR}/arch/ppc/platforms/83xx
       install -m 0755  arch/ppc/platforms/83xx/*.h ${STAGING_KERNEL_DIR}/arch/ppc/platforms/83xx

       install -d ${STAGING_KERNEL_DIR}/arch/ppc/platforms/85xx
       install -m 0755  arch/ppc/platforms/85xx/*.h ${STAGING_KERNEL_DIR}/arch/ppc/platforms/85xx

       install -d ${STAGING_KERNEL_DIR}/include/asm-m68k
       install -m 0755  include/asm-m68k/*.h ${STAGING_KERNEL_DIR}/include/asm-m68k
}

do_install_append () {
        install -d  ${DEPLOY_DIR}/images
        install -m 0755 arch/ppc/boot/images/zImage.elf ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.elf
        install -m 0755 vmlinux ${DEPLOY_DIR}/images/
        powerpc-${TARGET_OS}-objcopy -O binary -R .note -R .comment -S ${DEPLOY_DIR}/images/vmlinux ${DEPLOY_DIR}/images/linux.bin
        gzip -f -9 ${DEPLOY_DIR}/images/linux.bin
        mkimage -A ppc -O linux -T kernel -C gzip -a 0 -e 0 -n "owmnr"+${PV}+"-ppc" -d ${DEPLOY_DIR}/images/linux.bin.gz ${DEPLOY_DIR}/images/uImage-${PV}-${MACHINE}-${DATETIME}.bin
        rm ${DEPLOY_DIR}/images/vmlinux
        rm ${DEPLOY_DIR}/images/linux.bin.gz


}

pkg_postinst_kernel () {
        true
}

pkg_postrm_kernel () {
        true
}

