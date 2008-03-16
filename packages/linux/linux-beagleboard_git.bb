require linux.inc

SRCREV = "7dc52e0ee406b0e5f0759472f3638105ae0a23ab"
PV = "2.6.x+git${SRCREV}"

COMPATIBLE_MACHINE = "beagleboard"

SRC_URI = "git://www.beagleboard.org/linux.git;protocol=http \
           file://defconfig"

S = "${WORKDIR}/git"
