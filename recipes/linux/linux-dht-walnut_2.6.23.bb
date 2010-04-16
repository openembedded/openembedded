# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
require linux.inc

DESCRIPTION = "Linux kernel for DHT-Walnut (ppc)  machine"

DEFAULT_PREFERENCE = "-1"

PR = "r0"
DEPENDS = "u-boot"

COMPATIBLE_MACHINE = "dht-walnut"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"

S = "${WORKDIR}/linux-${PV}"

FILES_kernel-image = "/boot/zImage.elf"

export OS = "Linux"
ARCH = "ppc"

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
	if [ -e arch/ppc/boot/images/zImage.elf ] ; then
	    cp -a arch/ppc/boot/images/zImage.elf arch/ppc/boot/images/zImage
            install -m 0755 arch/ppc/boot/images/zImage.elf \ 
                ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}.elf
	fi	
        install -m 0755 vmlinux ${DEPLOY_DIR_IMAGE}/
}


pkg_postinst_kernel () {
        true
}

pkg_postrm_kernel () {
        true
}





SRC_URI[md5sum] = "2cc2fd4d521dc5d7cfce0d8a9d1b3472"
SRC_URI[sha256sum] = "d4e67c0935ffb2a4158234bff92cc791b83177866009fc9b2214104e0038dbdb"
