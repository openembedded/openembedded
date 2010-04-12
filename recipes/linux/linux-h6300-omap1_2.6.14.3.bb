DESCRIPTION = "Linux kernel for h6300 devices."
SECTION = "kernel"
LICENSE = "GPLv2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.14.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/old/patch-2.6.14-omap2.bz2;patch=1;name=patch \
           file://patch-linux-2614-omap2-to-2614_3-omap1-h6300;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.14"

inherit kernel

COMPATIBLE_MACHINE = "h6300"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        oe_runmake oldconfig
}

SRC_URI[kernel.md5sum] = "66d02cbd723876c6d69846a067875a22"
SRC_URI[kernel.sha256sum] = "cc56285834bed461fd405c00a34d3c3095673333b94621580eeeb0c65237af15"
SRC_URI[patch.md5sum] = "f9c9b0fe2ce0eef71c50ef45ddd0075d"
SRC_URI[patch.sha256sum] = "e4ac37531a455776ace04e234001c2849cbe2b1a3563409d23e4a6b3390c3e2d"
