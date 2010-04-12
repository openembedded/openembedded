DESCRIPTION = "Linux kernel for h1940 devices."
SECTION = "kernel"
LICENSE = "GPLv2"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "h1940"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.14.tar.bz2;name=kernel \
	   http://rtp-net.org/ipaq/patches/2.6.14-3/v2.6.14-gitcurrent.patch;patch=1;name=patch1 \
           http://rtp-net.org/ipaq/patches/2.6.14-3/full.patch;patch=1;name=patch2 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.14"

inherit kernel

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        yes '' | oe_runmake oldconfig
}

SRC_URI[kernel.md5sum] = "66d02cbd723876c6d69846a067875a22"
SRC_URI[kernel.sha256sum] = "cc56285834bed461fd405c00a34d3c3095673333b94621580eeeb0c65237af15"
SRC_URI[patch1.md5sum] = "e0b42e51630e9cd7e3b0adf1be42f4a1"
SRC_URI[patch1.sha256sum] = "0c625e90d13f91269d3a02ebdfba97226651a849ad8d69a0734bb5df7964c571"
SRC_URI[patch2.md5sum] = "d7ec27a9b44eed194426038640af5460"
SRC_URI[patch2.sha256sum] = "70e8e8230390fb355d62270764f18f6b553bcb9383ddabfbed4a1238b0e79b80"
