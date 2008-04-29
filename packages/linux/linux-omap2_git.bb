require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "b1224e0086dc0b27a5af1e7b4f59709521569060"

PV = "2.6.25+git${SRCREV}"
PR = "r5"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
           file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff;patch=1 \
"

COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard"


S = "${WORKDIR}/git"
