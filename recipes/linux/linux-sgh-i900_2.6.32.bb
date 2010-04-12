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
SRC_URI[md5sum] = "260551284ac224c3a43c4adac7df4879"
SRC_URI[sha256sum] = "5099786d80b8407d98a619df00209c2353517f22d804fdd9533b362adcb4504e"
