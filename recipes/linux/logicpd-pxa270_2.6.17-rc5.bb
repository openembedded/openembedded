SECTION = "kernel"
DESCRIPTION = "Linux kernel for the LogicPD Zoom(PXA270 ref design)"
LICENSE = "GPLv2"
PR = "r3"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/linux-2.6.17-rc5.tar.bz2 \
           file://linux-2.6.17-rc5.patch;pnum=0;patch=1 \
           file://ucb1400-ac97-audio.patch;pnum=1;patch=1 \
           file://ucb1400-touchscreen.patch;pnum=1;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.17-rc5"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel
inherit package

ARCH = "arm"

FILES_kernel-image = ""

do_configure_prepend() {
#	install -m 0644 ${S}/arch/arm/configs/lpd270_defconfig ${S}/.config
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config

}

COMPATIBLE_MACHINE = "logicpd-pxa270"
