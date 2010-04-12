BROKEN = "1"
#linux-2.6.5-gnalm1-gum0.patch is not fetchable

SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP processors"
LICENSE = "GPLv2"

COMPATIBLE_MACHINE = "gumstix"

# NOTE: pulled local linux-2.6.5-gnalm1, since it didn't apply cleanly
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.5.tar.bz2;name=kernel \
           file://linux-2.6.5-gnalm1.patch;patch=1 \
           http://gumstix.superlucidity.net/downloads/kernel/patches/linux-2.6.5-gnalm1-gum0.patch;patch=1;name=patch \
           file://defconfig"
S = "${WORKDIR}/linux-2.6.5"

inherit kernel


do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config || die "no default configuration for ${MACHINE} available."
        oe_runmake oldconfig
}

COMPATIBLE_HOST = 'arm.*-linux'

SRC_URI[kernel.md5sum] = "9a76bf64c1151369b250f967d83077aa"
SRC_URI[kernel.sha256sum] = "e405000ad0b74af383b5f9c6db30b309e8cb872bb5df55ddef0413970f2e18c2"
SRC_URI[patch.md5sum] = "10c494456bd3a17f351ce1bef1618d55"
SRC_URI[patch.sha256sum] = "942e391ab93d55e18ef07c5653ae8fd09e12b11d1c789711277407e10371350f"
