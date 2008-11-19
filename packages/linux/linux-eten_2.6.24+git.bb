require linux.inc

DESCRIPTION = "The Linux kernel for E-Ten Glofiish smartphones"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "eten-m800"

KERNEL_RELEASE = "2.6.24"
KERNEL_VERSION = "${KERNEL_RELEASE}"

PV = "${KERNEL_RELEASE}+${PR}+gitr${SRCREV}"
PR = "r1"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=stable \
  file://defconfig \
"
S = "${WORKDIR}/git"
