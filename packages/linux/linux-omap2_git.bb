require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "af933cd32a5e14f119a4acb4fe20055f6f8ab1aa"

PV = "2.6.25+2.6.26-rc8+${PR}+git${SRCREV}"
PR = "r30"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff;patch=1 \
           file://0001-ASoC-OMAP-Add-basic-support-for-OMAP34xx-in-McBSP.patch;patch=1 \
           file://flash.patch;patch=1 \
           file://0001-omap3-cpuidle.patch;patch=1 \ 
           file://0002-omap3-cpuidle.patch;patch=1 \
           file://timer-suppression.patch;patch=1 \
           file://fix-dispc-clocks.patch;patch=1 \
           file://soc.patch;patch=1 \
           file://16bpp.patch;patch=1 \
           file://omap3-dppl-divider.patch;patch=1 \
           file://omap3-jitter.patch;patch=1 \
"

SRC_URI_append_omap3evm = " file://no-harry-potter.diff;patch=1 \
           file://0001-ASoC-OMAP-Add-basic-support-for-OMAP34xx-in-McBSP.patch;patch=1 \
           file://0001-ARM-OMAP-SmartReflex-driver.patch;patch=1 \
           file://0002-ARM-OMAP-SmartReflex-driver.patch;patch=1 \
           file://0003-ARM-OMAP-SmartReflex-driver.patch;patch=1 \
           file://0001-omap3-cpuidle.patch;patch=1 \
           file://0002-omap3-cpuidle.patch;patch=1 \
"


COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard|omap3evm"


S = "${WORKDIR}/git"
