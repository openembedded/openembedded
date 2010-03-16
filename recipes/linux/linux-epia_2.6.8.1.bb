SECTION = "kernel"
DESCRIPTION = "Linux kernel for VIA EPiA"
LICENSE = "GPLv2"
PR = "r15"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	   http://www.epiawiki.org/files/epia_kernel/patch-2.6.8.1-epia1.bz2;patch=1 \
	   http://hem.bredband.net/ekmlar/patch-vt1211-2.6.txt;patch=1 \
           file://epia_defconfig"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'i.86.*-linux'

inherit kernel

ARCH = "i386"

# Don't want kernel in rootfs
FILES_kernel = ""
ALLOW_EMPTY_kernel = "1"
PACKAGES += "kernel-image"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/epia_defconfig ${S}/.config
}
