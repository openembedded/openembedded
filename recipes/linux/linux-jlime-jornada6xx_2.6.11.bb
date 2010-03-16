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
