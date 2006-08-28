PR      = "r0"
SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP processors"
LICENSE = "GPL"

SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git"

S = "${WORKDIR}/git"

KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "arch/${ARCH}/boot/compressed/${KERNEL_IMAGETYPE}"
#KERNEL_CCSUFFIX = "-4.1.1"

DEPENDS = "u-boot"

inherit kernel

# GIT does not have the UTS_RELEASE in version.h used to find the kernel version
KERNEL_RELEASE = "2.6.17"

COMPATIBLE_HOST = 'arm.*-linux'

do_configure_prepend() {
        if [ "${MACHINE}" == "omap5912osk" ] ; then
                 make omap_osk_5912_defconfig
        fi
        
        oe_runmake oldconfig
}

do_deploy() {
        if [ "${MACHINE}" == "omap5912osk" ]; then
                install -d ${DEPLOY_DIR_IMAGE}
                arm-linux-objcopy -O binary -R .note -R .comment -S arch/arm/boot/compressed/vmlinux ${DEPLOY_DIR_IMAGE}/linux.bin
                gzip -f -9 ${DEPLOY_DIR_IMAGE}/linux.bin
                mkimage -A arm -O linux -T kernel -C gzip -a 0x10c08000 -e 0x10c08000 -n "OE" -d ${DEPLOY_DIR_IMAGE}/linux.bin.gz ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}-${DATETIME}.bin
                rm ${DEPLOY_DIR_IMAGE}/linux.bin.gz
        fi
}


do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
