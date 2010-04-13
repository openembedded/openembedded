DESCRIPTION = "Linux kernel for h6300 devices."
SECTION = "kernel"
LICENSE = "GPLv2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.12/linux-2.6.12-rc5.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/old/patch-2.6.12-rc5-omap2.bz2;patch=1;name=patch \
           file://h6300_omap1_2612rc5.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.12-rc5"

inherit kernel

COMPATIBLE_MACHINE = "h6300"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        oe_runmake oldconfig
}

SRC_URI[kernel.md5sum] = "0f9afd619a10872b3383362d55c892c3"
SRC_URI[kernel.sha256sum] = "4cc5ca6e2ea8583f026620169e5d6eceb6c620181ba0633efbeb74cdb8c2fc59"
SRC_URI[patch.md5sum] = "e52cf4f24b46bee3df0d9e9e257eecc3"
SRC_URI[patch.sha256sum] = "457ec3ccb135b80ce3b5c79ad356b142080405f7bd510b52c349567fff82fa46"
