require linux.inc

SRCREV = "1a77f70604e00b94bb3c841665a44b34430e9eda"
PV = "2.6.23+2.6.24rc3-git${SRCREV}"
PR = "r1"

COMPATIBLE_MACHINE = "beagleboard"

SRC_URI = "git://www.beagleboard.org/linux.git;protocol=http \
           file://defconfig"

S = "${WORKDIR}/linux"
