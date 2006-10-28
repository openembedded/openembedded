SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Compulab PXA270 system"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.16.tar.bz2 \
           file://linux-2.6.16.patch;patch=1 \
           file://defconfig \
	   http://www.compulab.co.il/x270/download/x270-linux-drv.zip"

S = "${WORKDIR}/linux-2.6.16"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel
inherit package

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	install -m 0644 ${WORKDIR}/2.6.16/CL_FlashDrv ${S}/drivers/block/cl_flash
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}-${DATETIME}.bin
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile

COMPATIBLE_MACHINE = "compulab-pxa270"

