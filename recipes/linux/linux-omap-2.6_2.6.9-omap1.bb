SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP processors"
LICENSE = "GPLv2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.9.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/patch-2.6.9-omap1.bz2;patch=1;name=patch \
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

SRC_URI[kernel.md5sum] = "e921200f074ca97184e150ef5a4af825"
SRC_URI[kernel.sha256sum] = "f5dba6366e87e91234d1b0069cfea655b0a4cb37ea97f899226f16998e6ab9f1"
SRC_URI[patch.md5sum] = "d6249654087f0bcafaa860ac573316a4"
SRC_URI[patch.sha256sum] = "91806347cb386002a8bfd20ee66e536e4a7dfb01f207dd751341f2971090d9ac"
