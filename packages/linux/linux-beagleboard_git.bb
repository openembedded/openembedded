require linux.inc

SRCREV = "039ced63db6a3f90f8b8f23a74499e38c0462b27"
PV = "2.6.24+2.6.25rc7-git${SRCREV}"
PR = "r2"

COMPATIBLE_MACHINE = "beagleboard"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
           file://beagle-board-patch-dirk.diff;patch=1 \
           file://defconfig"

S = "${WORKDIR}/git"
