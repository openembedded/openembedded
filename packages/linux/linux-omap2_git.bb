require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "547ba9200727d2334f779cbf46ab62accb1281aa"

PV = "2.6.25+git${SRCREV}"
PR = "r7"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff;patch=1 \
			       file://usb-timout.patch;patch=1 \
			       file://l2-cache.patch;patch=1 \ 	
"

COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard"


S = "${WORKDIR}/git"
