SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP processors"
LICENSE = "GPL"
DEPENDS = "u-boot"

COMPATIBLE_MACHINE = "omap5912osk"

inherit kernel

KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "${KERNEL_IMAGETYPE}"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        oe_runmake oldconfig
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
