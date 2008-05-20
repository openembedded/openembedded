require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "f4eb51b909144550048b7922ebd1904a54005394"

PV = "2.6.25+2.6.26-rc3+git${SRCREV}"
PR = "r15"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff;patch=1 \
"

COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard"


S = "${WORKDIR}/git"
