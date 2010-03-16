DESCRIPTION = "Linux kernel for HP iPAQ h6300 series OMAP1510 based phones."
SECTION = "kernel"
LICENSE = "GPLv2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.16.tar.bz2 \
	   http://www.muru.com/linux/omap/patches/patch-2.6.16-omap2.bz2;patch=1 \
           file://linux-2.6.16.16.patch;patch=1 \
           file://linux-h6300-omap2-2.6.16.16.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.16"

inherit kernel

COMPATIBLE_MACHINE = "h6300"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        oe_runmake oldconfig
}
