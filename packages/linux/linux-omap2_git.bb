require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "41c13615e46ed02a1aaafcc267603be8ea5244e9"

PV = "2.6.25+2.6.26-rc3+git${SRCREV}"
PR = "r16"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
           file://00001-mcbsp-transform.patch;patch=1 \
           file://00002-mcbsp-omap1.patch;patch=1 \
           file://00003-mcbsp-omap3-clock.patch;patch=1 \
           file://00004-omap2-mcbsp.patch;patch=1 \
           file://0001-ASoC-OMAP-Add-basic-support-for-OMAP34xx-in-McBSP.patch;patch=1 \
	   file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff;patch=1 \
"

COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard"


S = "${WORKDIR}/git"
