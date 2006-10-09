PR      = "r0"
SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP processors"
LICENSE = "GPL"

SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
           file://defconfig"

S = "${WORKDIR}/git"

KERNEL_IMAGETYPE = "vmlinux"

DEPENDS = "u-boot"

inherit kernel

KERNEL_OUTPUT = "${KERNEL_IMAGETYPE}"
KERNEL_RELEASE = "2.6.18-omap1"

COMPATIBLE_HOST = 'arm.*-linux'

do_configure_prepend() {
#        if [ "${MACHINE}" == "omap5912osk" ] ; then
#                oe_runmake omap_osk_5912_defconfig
#        fi
         install -m 0644 ${WORKDIR}/defconfig ${S}/.config
         make oldconfig
}        

do_deploy() {
        if [ "${MACHINE}" == "omap5912osk" ]; then
                install -d ${DEPLOY_DIR_IMAGE}
                arm-linux-objcopy -O binary -R .note -R .comment -S ${KERNEL_OUTPUT} ${DEPLOY_DIR_IMAGE}/linux.bin
                gzip -f -9 ${DEPLOY_DIR_IMAGE}/linux.bin
                mkimage -A arm -O linux -T kernel -C gzip -a 0x10008000 -e 0x10008000 -n "OE" -d ${DEPLOY_DIR_IMAGE}/linux.bin.gz ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}-${DATETIME}.bin
                rm ${DEPLOY_DIR_IMAGE}/linux.bin.gz
        fi
}


do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
