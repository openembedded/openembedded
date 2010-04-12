SECTION = "kernel"
DESCRIPTION = "Linux kernel for the LogicPD Zoom(PXA270 ref design)"
LICENSE = "GPLv2"
PR = "r3"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.17/linux-2.6.17-rc5.tar.bz2 \
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

SRC_URI[md5sum] = "ab96dd67e9d459d8b09aa300319a1107"
SRC_URI[sha256sum] = "10c17d1d77b5b2496c4da8b42f3ea3d738c766e634e5e46f0f5070bcba0876f2"
