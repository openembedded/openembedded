DESCRIPTION = "Linux kernel x86 for IBM Netvista"
LICENSE = "GPL"


PR = "r2"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.4/linux-${PV}.tar.bz2 \
           file://netvista_defconfig"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'i.86.*-linux'

inherit kernel

KERNEL_CCSUFFIX="-3.3.4"
ARCH = "i386"
KERNEL_IMAGETYPE = "bzImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/netvista_defconfig ${S}/.config
}
