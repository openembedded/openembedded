require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "039ced63db6a3f90f8b8f23a74499e38c0462b27"
PV = "2.6.24+2.6.25rc7-git${SRCREV}"
PR = "r2"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
           file://defconfig"

SRC_URI_append_beagleboard = " file://beagle-board-patch-dirk.diff;patch=1 "

COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard"


S = "${WORKDIR}/git"
