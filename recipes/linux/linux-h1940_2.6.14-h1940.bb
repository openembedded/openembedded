DESCRIPTION = "Linux kernel for h1940 devices."
SECTION = "kernel"
LICENSE = "GPL"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "h1940"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.14.tar.bz2 \
	   http://rtp-net.org/ipaq/patches/2.6.14-3/v2.6.14-gitcurrent.patch;patch=1 \
           http://rtp-net.org/ipaq/patches/2.6.14-3/full.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.14"

inherit kernel

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        yes '' | oe_runmake oldconfig
}
