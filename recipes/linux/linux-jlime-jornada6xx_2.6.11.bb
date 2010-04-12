SECTION = "kernel"
DESCRIPTION = "Linux kernel for Hitachi SH3 based Jornada 6xx"
LICENSE = "GPLv2"
PR = "r0"


COMPATIBLE_HOST = "sh.*-linux"
COMPATIBLE_MACHINE = 'jornada6xx'

SRC_URI = "http://www.jlime.com/downloads/releases/shrek/kernels/6xx/sources/linuxsh-snapshot-050320-jlimepatched-3.tar.bz2 \
           file://defconfig_jlime"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

ARCH = "sh"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig_jlime ${S}/.config
}

SRC_URI[md5sum] = "d19680b5cb29c70b92fab15f01d69303"
SRC_URI[sha256sum] = "b909e5c1b00e17d0588f95b764c618c948d234f23817363096a51e7b05ef4e1f"
