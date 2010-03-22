BROKEN = "1"
#linux-2.6.5-gnalm1-gum0.patch is not fetchable

SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP processors"
LICENSE = "GPLv2"

COMPATIBLE_MACHINE = "gumstix"

# NOTE: pulled local linux-2.6.5-gnalm1, since it didn't apply cleanly
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.5.tar.bz2 \
           file://linux-2.6.5-gnalm1.patch;patch=1 \
           http://gumstix.superlucidity.net/downloads/kernel/patches/linux-2.6.5-gnalm1-gum0.patch;patch=1 \
           file://defconfig"
S = "${WORKDIR}/linux-2.6.5"

inherit kernel


do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config || die "no default configuration for ${MACHINE} available."
        oe_runmake oldconfig
}

COMPATIBLE_HOST = 'arm.*-linux'
