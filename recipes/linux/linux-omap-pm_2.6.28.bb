require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm|omap3-pandora"

SRCREV = "fe30e75b8c0b91b259fcea781b859e594ba21ae9"

PV = "2.6.28-pm3+gitr${SRCREV}"
PR = "r7"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/khilman/linux-omap-pm.git;protocol=git;branch=pm-2.6.28 \
	   file://defconfig"

SRC_URI_append = " \
           file://fixup-evm-cpufreq.diff;apply=yes \
           file://no-empty-flash-warnings.patch;apply=yes \
           file://no-cortex-deadlock.patch;apply=yes \
           file://read_die_ids.patch;apply=yes \
           file://fix-install.patch;apply=yes \
           file://musb-support-high-bandwidth.patch.eml;apply=yes \
           file://mru-fix-timings.diff;apply=yes \
           file://mru-fix-display-panning.diff;apply=yes \
           file://mru-improve-pixclock-config.diff;apply=yes \
           file://mru-make-video-timings-selectable.diff;apply=yes \
           file://mru-enable-overlay-optimalization.diff;apply=yes \
           file://dvb-fix-dma.diff;apply=yes \
           file://0001-Removed-resolution-check-that-prevents-scaling-when.patch;apply=yes \
           file://0001-Implement-downsampling-with-debugs.patch;apply=yes \
           file://twl-asoc-fix-record.diff;apply=yes \
           file://tick-schedc-suppress-needless-timer-reprogramming.patch;apply=yes \
           file://0001-DSS-New-display-subsystem-driver-for-OMAP2-3.patch;apply=yes \
           file://0002-DSS-OMAPFB-fb-driver-for-new-display-subsystem.patch;apply=yes \
           file://0003-DSS-Add-generic-DVI-panel.patch;apply=yes \
           file://0004-DSS-support-for-Beagle-Board.patch;apply=yes \
           file://0005-DSS-Sharp-LS037V7DW01-LCD-Panel-driver.patch;apply=yes \
           file://0007-DSS-Support-for-OMAP3-EVM-board.patch;apply=yes \
           file://0008-DSS-Hacked-N810-support.patch;apply=yes \
           file://0009-DSS-OMAPFB-allocate-fbmem-only-for-fb0-or-if-spes.patch;apply=yes \
           file://0010-DSS-OMAPFB-remove-extra-omapfb_setup_overlay-call.patch;apply=yes \
           file://0011-DSS-OMAPFB-fix-GFX_SYNC-to-be-compatible-with-DSS1.patch;apply=yes \
           file://0014-DSS-fix-clk_get_usecount.patch;apply=yes \
           file://0001-ASoC-Add-support-for-OMAP3-EVM.patch;apply=yes \
           file://0001-This-merges-Steve-Kipisz-USB-EHCI-support.-He-star.patch;apply=yes \
           file://dss2.diff;apply=yes \
           file://register-all-OPPs.diff;apply=yes \
           file://add-cpufreq-for-omap3evm.diff;apply=yes \
           file://usbttyfix.patch;apply=yes \
           file://0124-leds-gpio-broken-with-current-git.patch;apply=yes \
"


SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
			     "

SRC_URI_append_omap3evm = " \
	file://evm-mcspi-ts.diff;apply=yes \
"

S = "${WORKDIR}/git"


module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"


