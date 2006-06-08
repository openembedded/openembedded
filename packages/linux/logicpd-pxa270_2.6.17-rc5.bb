SECTION = "kernel"
DESCRIPTION = "Linux kernel for the LogicPD Zoom(PXA270 ref design)"
LICENSE = "GPL"
MAINTAINER = "Shane Volpe <shane.volpe@gmail.com>"
PR = "r1"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/linux-2.6.17-rc5.tar.bz2 \
           file://linux-2.6.17-rc5.patch;pnum=0;patch=1 \
           file://defconfig"


S = "${WORKDIR}/linux-2.6.17-rc5"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel
inherit package

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"

do_configure_prepend() {
#	install -m 0644 ${S}/arch/arm/configs/lpd270_defconfig ${S}/.config
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config

}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}-${DATETIME}.bin
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile

COMPATIBLE_MACHINE = "logicpd-pxa270"
