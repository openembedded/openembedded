SECTION = "kernel"
DESCRIPTION = "Linux kernel for Simtec EB2410ITX"
LICENSE = "GPLv2"
KV = "2.4.25"

KERNEL_CCSUFFIX = "-3.3.3"
COMPATIBLE_HOST = "arm.*-linux"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${KV}.tar.bz2 \
           ftp://ftp.arm.linux.org.uk/pub/armlinux/source/kernel-patches/v2.4/patch-2.4.25-vrs1.bz2;patch=1 \
           http://www.simtec.co.uk/products/SWLINUX/files/patch-2.4.25-vrs1-bast1.bz2;patch=1 \
           file://defconfig \
           file://mkdep.patch;patch=1 \
           file://defconfig"
S = "${WORKDIR}/linux-${KV}"

inherit kernel


do_configure_prepend() {
	cp ${WORKDIR}/defconfig ${S}/.config
}
