DESCRIPTION = "Linux 2.6.29 kernel for the Samsung Omnia SGH-i900."
SECTION = "kernel"
LICENSE = "GPL"

RDEPENDS += "marvell-gspi-fw"

COMPATIBLE_MACHINE = "sgh-i900"

SRC_URI = "git://andromnia.git.sourceforge.net/gitroot/andromnia/andromnia;protocol=git;branch=master \
           file://wm97xx-ts-fix.patch;patch=1 \
           file://sgh_i900_defconfig"

S = "${WORKDIR}/git"

inherit kernel

FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/sgh_i900_defconfig ${S}/.config
}
