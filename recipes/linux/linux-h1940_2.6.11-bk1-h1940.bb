DESCRIPTION = "Linux kernel for h1940 devices."
SECTION = "kernel"
LICENSE = "GPLv2"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "h1940"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.11.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/snapshots/old/patch-2.6.11-bk1.gz;patch=1 \
           http://rtpnet.nerim.net/ipaq/2.6.11-bk1/2.6.11-bk1-h1940.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.11"

inherit kernel

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        yes '' | oe_runmake oldconfig
}
