SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP processors"
LICENSE = "GPL"
DEPENDS = "u-boot"

COMPATIBLE_MACHINE = "omap5912osk"

inherit kernel

KERNEL_IMAGETYPE = "uImage"

module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"

do_configure_prepend() {

        if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibcgnueabi" ]; then
	       install -m 0644 ${WORKDIR}/defconfig.eabi ${S}/.config
        else
	       install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        fi

        oe_runmake oldconfig
}
do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
