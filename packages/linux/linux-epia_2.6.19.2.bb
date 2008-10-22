SECTION = "kernel"
DESCRIPTION = "Linux kernel for VIA EPiA"
LICENSE = "GPL"
PR = "r1"

KERNEL_CCSUFFIX = "-3.3.4"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
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
