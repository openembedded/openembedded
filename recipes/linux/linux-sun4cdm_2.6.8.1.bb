SECTION = "kernel"
DESCRIPTION = "Linux kernel for sparc32/sun4c"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://sun4c_defconfig"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'sparc.*-linux'

inherit kernel

ARCH = "sparc"
KERNEL_IMAGETYPE = "image"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/sun4c_defconfig ${S}/.config
}
