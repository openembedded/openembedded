require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "3bbf8f7b69276626ed9bab406a4a2e59709b27d7"

PV = "2.6.25+2.6.26-rc5+git${SRCREV}"
PR = "r20"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff;patch=1 \
           file://0001-ASoC-OMAP-Add-basic-support-for-OMAP34xx-in-McBSP.patch;patch=1 \
           file://mux.patch;patch=1 \
	   file://0001-omap3beagle-add-a-platform-device-to-hook-up-the-GP.patch;patch=1 \
	   file://flash.patch;patch=1 \
	   file://0001-ARM-OMAP-SmartReflex-driver.patch;patch=1 \
	   file://0002-ARM-OMAP-SmartReflex-driver.patch;patch=1 \
	   file://0003-ARM-OMAP-SmartReflex-driver.patch;patch=1 \
"

COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard"


S = "${WORKDIR}/git"
