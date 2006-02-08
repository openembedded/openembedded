DESCRIPTION = "Linux Kernel for Cirrus Logic ep39xxcompatible machines"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
		   file://linux-2.6.15-ep93xx-gao19.diff;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

KERNEL_IMAGETYPE = "zImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

