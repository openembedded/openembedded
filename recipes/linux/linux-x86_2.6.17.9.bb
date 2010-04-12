DESCRIPTION = "Linux Kernel for x86 compatible machines"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

COMPATIBLE_HOST = "i.86.*-linux"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

SRC_URI[md5sum] = "f7a5b1aedb5b44f4df005caa5f4cceb6"
SRC_URI[sha256sum] = "3e0478ae9d2402086dd7c45f132ab02045db6f9d1908229dbca1a39684234723"
