require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "74c89552b4a5f9b5b066f74fa265248f9b5d3f1d"

PV = "2.6.25+2.6.26-rc2+git${SRCREV}"
PR = "r13"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff;patch=1 \
			       file://usb-timout.patch;patch=1 \
			       file://l2-cache.patch;patch=1 \
			       file://0001-board-omap3beagle-fix-merge-damage-in-RTC-code.patch;patch=1 \ 	
			       file://0001-omap3beagle-add-driver-to-turn-on-the-TFP410-framer.patch;patch=1 \
"

COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard"


S = "${WORKDIR}/git"
