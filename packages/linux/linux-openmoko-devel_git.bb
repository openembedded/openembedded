require linux.inc
require linux-openmoko.inc

DESCRIPTION = "Linux 2.6.x (development) kernel for the Openmoko Neo Smartphones"

DEFAULT_PREFERENCE = "-1"

KERNEL_RELEASE = "2.6.26"
KERNEL_VERSION = "${KERNEL_RELEASE}"

PV = "${KERNEL_RELEASE}+${PR}-gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=stable-tracking \
  file://defconfig-oe \
"
S = "${WORKDIR}/git"
