SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP processors"
LICENSE = "GPL"
DEPENDS = "u-boot"

COMPATIBLE_MACHINE = "omap5912osk"

inherit kernel

KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "${KERNEL_IMAGETYPE}"

do_configure_prepend() {

        if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibcgnueabi" ]; then
	       install -m 0644 ${WORKDIR}/defconfig.eabi ${S}/.config
        else
	       install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        fi

        oe_runmake oldconfig
}

do_deploy() {
        if [ "${MACHINE}" == "omap5912osk" ]; then
                install -d ${DEPLOY_DIR_IMAGE}
                ${OBJCOPY} -O binary -R .note -R .comment -S ${KERNEL_OUTPUT} ${S}/linux.bin
                gzip -f -9 ${S}/linux.bin
                mkimage -A arm -O linux -T kernel -C gzip -a 0x10008000 -e 0x10008000 -n "OE" -d ${S}/linux.bin.gz ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${KERNEL_RELEASE}-${MACHINE}-${DATETIME}.bin
                rm ${S}/linux.bin.gz
        fi
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
