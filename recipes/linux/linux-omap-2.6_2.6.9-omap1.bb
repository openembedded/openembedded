SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP processors"
LICENSE = "GPLv2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.9.tar.bz2 \
           http://www.muru.com/linux/omap/patches/patch-2.6.9-omap1.bz2;patch=1 \
           file://schedstats-arm.patch;patch=1 \
           file://defconfig"
S = "${WORKDIR}/linux-2.6.9"

inherit kernel

COMPATIBLE_HOST = 'arm.*-linux'

KERNEL_IMAGETYPE = "uImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        oe_runmake oldconfig
}
