# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
SECTION = "kernel"
DESCRIPTION = "Linux kernel for Magicbox ver 1.1 and 2.0 router boards"
LICENSE = "GPLv2"
PR = "r3"
DEPENDS = "u-boot"

COMPATIBLE_MACHINE = "magicbox"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
          file://001-squashfs.patch;patch=1 \                      
          file://002-lzma_decompress.patch;patch=1 \  
          file://003-squashfs_lzma.patch;patch=1 \  
          file://004-extra_optimization.patch;patch=1 \
          file://006-gcc4_inline_fix.patch;patch=1 \
          file://007-samsung_flash.patch;patch=1 \
          file://009-revert_intel_flash_breakage.patch;patch=1 \
          file://010-disable_old_squashfs_compatibility.patch;patch=1 \
          file://011-mips_boot.patch;patch=1 \ 
          file://012-mips_cpu_tlb.patch;patch=1 \  
          file://050-mtdpart_redboot_partition_truncate.patch;patch=1 \  
          file://060-rootfs_split.patch;patch=1 \
          file://100-netfilter_layer7_2.8.patch;patch=1 \
          file://101-netfilter_layer7_pktmatch.patch;patch=1 \  
          file://110-ipp2p_0.8.1rc1.patch;patch=1 \
          file://120-openswan-2.4.0.kernel-2.6-natt.patch;patch=1 \
          file://130-netfilter-ipset.patch;patch=1 \
          file://140-netfilter_time.patch;patch=1 \
          file://150-netfilter_imq.patch;patch=1 \        
          file://160-netfilter_route.patch;patch=1 \
          file://170-netfilter_chaostables.patch;patch=1 \       
          file://200-sched_esfq.patch;patch=1 \
          file://201-multiple_default_gateways.patch;patch=1 \
          file://202-mips-freestanding.patch;patch=1 \
          file://204-jffs2_eofdetect.patch;patch=1 \
          file://207-powerpc_asm_segment_h.patch;patch=1 \
          file://210-d80211_compat.patch;patch=1 \
          file://211-no_block2mtd_readahead.patch;patch=1 \
          file://212-block2mtd_erase_scan.patch;patch=1 \
          file://510-Yaffs.patch;patch=1 \
          file://600-x86_lzma.patch;patch=1 \
          file://700-airprime.patch;patch=1 \
          file://900-headers_type_and_time.patch;patch=1 \
          file://901-asm_bitops_include.patch;patch=1 \
          file://902-darwin_scripts_include.patch;patch=1 \
          file://903-stddef_include.patch;patch=1 \
          file://904-ls_time_locale.patch;patch=1 \
          file://001-magicbox_support.patch;patch=1 \
          file://002-flash_map.patch;patch=1 \
          file://100-cf_slot.patch;patch=1 \

          file://config-magicbox2\
"


S = "${WORKDIR}/linux-${PV}"

inherit kernel


FILES_kernel-image = "/boot/zImage.elf"

export OS = "Linux"
ARCH = "ppc"
KERNEL_OUTPUT = "arch/ppc/boot/images/zImage.elf"




do_configure_prepend() {
	install -m 0644 ${WORKDIR}/config-magicbox2 ${S}/.config
}


do_install_append () {
#need ppc platforms includes + friends in order for external kernel modules to compile as headers as still split

       install -d $kerneldir/arch/
       cp -pPR arch/ppc $kerneldir/arch/
       cp -pPR arch/powerpc $kerneldir/arch/

       cp -pPR include/asm-powerpc $kerneldir/include/
       cp -pPR include/asm-ppc $kerneldir/include/
}



do_install_append () {
        install -d  ${DEPLOY_DIR_IMAGE}
        install -m 0755 arch/ppc/boot/images/zImage.elf ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.elf
        install -m 0755 vmlinux ${DEPLOY_DIR_IMAGE}/
        powerpc${TARGET_VENDOR}-${TARGET_OS}-objcopy -O binary -R .note -R .comment -S ${DEPLOY_DIR_IMAGE}/vmlinux \ 
                 ${DEPLOY_DIR_IMAGE}/linux.bin
        gzip -f -9 ${DEPLOY_DIR_IMAGE}/linux.bin
        cp -pPR ${DEPLOY_DIR_IMAGE}/linux.bin.gz ${DEPLOY_DIR_IMAGE}/linux-${PV}-${MACHINE}-${DATETIME}.bin.gz        
        mkimage -A ppc -O linux -T kernel -C gzip -a 00000000 -e 00000000 -n "magicbox"-${PV} \
                -d ${DEPLOY_DIR_IMAGE}/linux.bin.gz ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${MACHINE}-${DATETIME}.bin        
        rm ${DEPLOY_DIR_IMAGE}/vmlinux
        rm ${DEPLOY_DIR_IMAGE}/linux.bin.gz


}


pkg_postinst_kernel () {
        true
}

pkg_postrm_kernel () {
        true
}



SRC_URI[md5sum] = "ca0ce8f288e8ae93ac243b568f906bf8"
SRC_URI[sha256sum] = "c55c52caa613d1f25718b35811e4614d9712b9e1de56a91aa73c867f351a540b"
