require linux.inc
require linux-openmoko.inc

DESCRIPTION = "Linux 2.6.x (development) kernel for the Openmoko Neo Smartphones"

DEFAULT_PREFERENCE = "-1"

KERNEL_RELEASE = "2.6.27"
KERNEL_VERSION = "${KERNEL_RELEASE}"

OEV = "oe2"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=andy-tracking \
  \
  file://openwrt-ledtrig-netdev.patch;patch=1 \
  \
  file://defconfig-oe \
"
S = "${WORKDIR}/git"
