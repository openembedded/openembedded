DESCRIPTION = "Linux kernel for h6300 devices."
SECTION = "kernel"
LICENSE = "GPLv2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.14.tar.bz2 \
           http://www.muru.com/linux/omap/patches/patch-2.6.14-omap2.bz2;patch=1 \
           file://patch-linux-2614-omap2-to-2614_3-omap1-h6300;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.14"

inherit kernel

COMPATIBLE_MACHINE = "h6300"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        oe_runmake oldconfig
}
