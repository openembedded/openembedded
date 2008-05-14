require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "a59e04f09caf72992577775c89849a821f839858"
#cb170dcdce58de20b045ae964a4ccfc29aad1647"

PV = "2.6.25+2.6.26-rc2+git${SRCREV}"
PR = "r12"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff;patch=1 \
			       file://usb-timout.patch;patch=1 \
			       file://l2-cache.patch;patch=1 \ 	
			       file://0001-This-patch-adds-RTC-support-to-the-omap3-based-beagl.patch;patch=1 \	
			       file://0001-omap3beagle-add-driver-to-turn-on-the-TFP410-framer.patch;patch=1 \
			       file://l2-cache-check.patch;patch=1 \
			       file://convert-rwsem-to-rwclock.patch;patch=1 \
"

COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard"


S = "${WORKDIR}/git"
