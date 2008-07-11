require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "7786cd7a00ae0b18923185789380a88052f4eee7"

PV = "2.6.25+2.6.26-rc9+${PR}+git${SRCREV}"
PR = "r42"

SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff;patch=1 \
           file://0001-ASoC-OMAP-Add-basic-support-for-OMAP34xx-in-McBSP.patch;patch=1 \
           file://flash.patch;patch=1 \
           file://0001-omap3-cpuidle.patch;patch=1 \ 
           file://0002-omap3-cpuidle.patch;patch=1 \
           file://timer-suppression.patch;patch=1 \
           file://soc.patch;patch=1 \
           file://16bpp.patch;patch=1 \
           file://no-empty-flash-warnings.patch;patch=1 \
           file://logo_linux_clut224.ppm \
           file://oprofile-0.9.3.armv7.diff;patch=1 \
           file://01-fix-timing-print.diff;patch=1 \
           file://02-set-clkseld11.diff;patch=1 \
           file://03-enable-overlay-opt.diff;patch=1 \
           file://04-use-pcd.diff;patch=1 \
           file://05-fix-display-panning.diff;patch=1 \
           file://06-ensure-fclk.diff;patch=1 \
           file://07-set-burst-size.diff;patch=1 \
"

SRC_URI_append_omap3evm = " file://no-harry-potter.diff;patch=1 \
           file://0001-ASoC-OMAP-Add-basic-support-for-OMAP34xx-in-McBSP.patch;patch=1 \
           file://0001-omap3-cpuidle.patch;patch=1 \
           file://0002-omap3-cpuidle.patch;patch=1 \
           file://timer-suppression.patch;patch=1 \
           file://soc.patch;patch=1 \
           file://no-empty-flash-warnings.patch;patch=1 \
           file://touchscreen.patch;patch=1 \
"


COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard|omap3evm"


S = "${WORKDIR}/git"
