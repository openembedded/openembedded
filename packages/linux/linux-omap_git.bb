require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm"


SRCREV = "2a4625ebb6538f9eef5d524b8e39e5c0c1316f9a"

PV = "2.6.26+2.6.27-rc5+${PR}+git${SRCREV}"
PR = "r2"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " file://no-harry-potter.diff;patch=1 \
           file://timer-suppression.patch;patch=1 \
           file://no-empty-flash-warnings.patch;patch=1 \
           file://oprofile-0.9.3.armv7.diff;patch=1 \
           file://cache-display-fix.patch;patch=1 \
           file://4bitmmc.diff;patch=1 \
           file://no-cortex-deadlock.patch;patch=1 \
           file://read_die_ids.patch;patch=1 \
           "

temporarely-disabled = " \
           file://01-fix-timing-print.diff;patch=1 \
           file://02-set-clkseld11.diff;patch=1 \
	   file://03-enable-overlay-opt.diff;patch=1 \
           file://04-use-pcd.diff;patch=1 \
           file://05-fix-display-panning.diff;patch=1 \
           file://06-ensure-fclk.diff;patch=1 \
           file://07-set-burst-size.diff;patch=1 \
           file://mru-clocks1.diff;patch=1 \
           file://mru-clocks2.diff;patch=1 \
           file://mru-clocks3.diff;patch=1 \	
           file://000-mru-make-video-mode-selcatable.diff;patch=1 \
	   file://001-mru-enable-overlay.diff;patch=1 \
           file://002-mru-set-default-800x600.diff;patch=1 \
           file://003-mru-omapfb-more-video-modes.diff;patch=1 \
           file://004-mru-export-omapfb-register-panel.diff;patch=1 \
           file://005-mru-add-omapfb-unregister-panel.diff;patch=1 \
           file://006-mru-lcd-as-modules.diff;patch=1 \
           file://007-mru-omapfb-as-module.diff;patch=1 \
           file://008-mru-lcd-omap3beagle-license.diff;patch=1 \
           file://009-mru-unregister-beagle-lcd.diff;patch=1 \
           file://010-mru-fix-video-mode-param.diff;patch=1 \
           file://001-sakoman-twl4030-asoc.diff;patch=1 \
           file://musb-dmafix.patch;patch=1 \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
                             "

SRC_URI_append_omap3evm = " \
           file://touchscreen.patch;patch=1 \
"

S = "${WORKDIR}/git"


module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"


