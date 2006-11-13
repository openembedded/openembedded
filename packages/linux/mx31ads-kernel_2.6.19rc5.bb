SECTION = "kernel"
DESCRIPTION = "Linux kernel for the MX31ADS"
LICENSE = "GPL"
MAINTAINER = "Liam Girdwood <liam.girdwood@wolfsonmicro.com>"
PR = "r1"

SRC_URI = "http://www.kernel.org/pub/linux/kernel/v2.6/linux-2.6.18.tar.bz2 \
    http://www.kernel.org/pub/linux/kernel/v2.6/testing/patch-2.6.19-rc5.bz2;patch=1 \
    http://opensource.wolfsonmicro.com/~lg/linux-2.6-mx31/mx31ads-2.6.19rc5-lg3.patch.bz2;patch=1 \
    file://imx31ads_defconfig"

S = "${WORKDIR}/linux-2.6.18"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel
inherit package

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"
#CMDLINE_ROOT = "root=/dev/mtdblock4 rootfstype=jffs2 mem=32M@0x00000000"
#CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_CONSOLE}"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/imx31ads_defconfig ${S}/.config
#	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}-${DATETIME}.bin
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile

COMPATIBLE_MACHINE = "mx31ads"

# to get module dependencies working
KERNEL_RELEASE = "2.6.19-rc5"

