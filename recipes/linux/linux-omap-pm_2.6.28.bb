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
           file://fixup-evm-cpufreq.diff \
           file://no-empty-flash-warnings.patch \
           file://no-cortex-deadlock.patch \
           file://read_die_ids.patch \
           file://fix-install.patch \
           file://musb-support-high-bandwidth.patch.eml;apply=yes \
           file://mru-fix-timings.diff \
           file://mru-fix-display-panning.diff \
           file://mru-improve-pixclock-config.diff \
           file://mru-make-video-timings-selectable.diff \
           file://mru-enable-overlay-optimalization.diff \
           file://dvb-fix-dma.diff \
           file://0001-Removed-resolution-check-that-prevents-scaling-when.patch \
           file://0001-Implement-downsampling-with-debugs.patch \
           file://twl-asoc-fix-record.diff \
           file://tick-schedc-suppress-needless-timer-reprogramming.patch \
           file://0001-DSS-New-display-subsystem-driver-for-OMAP2-3.patch \
           file://0002-DSS-OMAPFB-fb-driver-for-new-display-subsystem.patch \
           file://0003-DSS-Add-generic-DVI-panel.patch \
           file://0004-DSS-support-for-Beagle-Board.patch \
           file://0005-DSS-Sharp-LS037V7DW01-LCD-Panel-driver.patch \
           file://0007-DSS-Support-for-OMAP3-EVM-board.patch \
           file://0008-DSS-Hacked-N810-support.patch \
           file://0009-DSS-OMAPFB-allocate-fbmem-only-for-fb0-or-if-spes.patch \
           file://0010-DSS-OMAPFB-remove-extra-omapfb_setup_overlay-call.patch \
           file://0011-DSS-OMAPFB-fix-GFX_SYNC-to-be-compatible-with-DSS1.patch \
           file://0014-DSS-fix-clk_get_usecount.patch \
           file://0001-ASoC-Add-support-for-OMAP3-EVM.patch \
           file://0001-This-merges-Steve-Kipisz-USB-EHCI-support.-He-star.patch \
           file://dss2.diff \
           file://register-all-OPPs.diff \
           file://add-cpufreq-for-omap3evm.diff \
           file://usbttyfix.patch \
           file://0124-leds-gpio-broken-with-current-git.patch \
"


SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
			     "

SRC_URI_append_omap3evm = " \
	file://evm-mcspi-ts.diff \
"

S = "${WORKDIR}/git"


module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"


