require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"
PV = "2.6.x+git${SRCDATE}"
PR = "r1"

COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4"

SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
           file://defconfig"

S = "${WORKDIR}/git"
