DESCRIPTION = "Linux kernel for h1940 devices."
MAINTAINER = "Arjan Schrijver <arjan@anymore.nl>"
SECTION = "kernel"
LICENSE = "GPL"

COMPATIBLE_HOST = "arm.*-linux"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.14.tar.bz2 \
	   http://rtpnet.nerim.net/ipaq/patches/2.6.14-3/v2.6.14-gitcurrent.patch;patch=1 \
           http://rtpnet.nerim.net/ipaq/patches/2.6.14-3/full.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.14"

inherit kernel

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        yes '' | oe_runmake oldconfig
}
