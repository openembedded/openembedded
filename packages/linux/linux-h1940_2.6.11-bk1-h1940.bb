DESCRIPTION = "Linux kernel for h1940 devices."
MAINTAINER = "Arjan Schrijver <arjan@anymore.nl>"
SECTION = "kernel"
LICENSE = "GPL"

COMPATIBLE_HOST = "arm.*-linux"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.11.tar.bz2 \
           ftp://ftp.kernel.org/pub/linux/kernel/v2.6/snapshots/old/patch-2.6.11-bk1.gz;patch=1 \
           http://rtpnet.nerim.net/ipaq/2.6.11-bk1/2.6.11-bk1-h1940.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.11"

inherit kernel

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        yes '' | oe_runmake oldconfig
}
