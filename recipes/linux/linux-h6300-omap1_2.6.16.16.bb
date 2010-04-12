DESCRIPTION = "Linux kernel for HP iPAQ h6300 series OMAP1510 based phones."
SECTION = "kernel"
LICENSE = "GPLv2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.16.tar.bz2;name=kernel \
	   http://www.muru.com/linux/omap/patches/patch-2.6.16-omap2.bz2;patch=1;name=patch \
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

SRC_URI[kernel.md5sum] = "9a91b2719949ff0856b40bc467fd47be"
SRC_URI[kernel.sha256sum] = "1200dcc7e60fcdaf68618dba991917a47e41e67099e8b22143976ec972e2cad7"
SRC_URI[patch.md5sum] = "b8de4aa518292ad3aef913645898218a"
SRC_URI[patch.sha256sum] = "34beecc0dd156267e8004fb79efea9bf97e1157ed597bdde1841c16def2e9195"
