DESCRIPTION = "Linux 2.6.32 kernel for the Samsung Omnia SGH-i900."
SECTION = "kernel"
LICENSE = "GPLv2"

RDEPENDS += "marvell-gspi-fw"

COMPATIBLE_MACHINE = "sgh-i900"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://sgh-i900-support.patch;patch=1 \
           file://sgh_i900_defconfig"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/sgh_i900_defconfig ${S}/.config
}