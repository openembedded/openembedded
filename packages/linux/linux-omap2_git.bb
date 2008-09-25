require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "d6daf8d8cc5ccf90247def5551ee9c3e8555e848"

PV = "2.6.26"
#PV = "2.6.26+2.6.27-rc1+${PR}+git${SRCREV}"
PR = "r64"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff;patch=1 \
           file://0001-ASoC-OMAP-Add-basic-support-for-OMAP34xx-in-McBSP.patch;patch=1 \
	   file://0001-omap3-cpuidle.patch;patch=1 \ 
           file://0002-omap3-cpuidle.patch;patch=1 \
           file://timer-suppression.patch;patch=1 \
           file://ASoC-TWL4030-codec-driver.patch;patch=1 \
           file://ASoC-machine-driver-for-OMAP3-EVM.patch;patch=1 \
           file://ASoC-machine-driver-for_OMAP3-Beagle.patch;patch=1 \
           file://16bpp.patch;patch=1 \
           file://no-empty-flash-warnings.patch;patch=1 \
           file://logo_linux_clut224.ppm \
           file://oprofile-0.9.3.armv7.diff;patch=1 \
           file://01-fix-timing-print.diff;patch=1 \
           file://03-enable-overlay-opt.diff;patch=1 \
           file://04-use-pcd.diff;patch=1 \
           file://05-fix-display-panning.diff;patch=1 \
           file://06-ensure-fclk.diff;patch=1 \
           file://07-set-burst-size.diff;patch=1 \
           file://cache-display-fix.patch;patch=1 \
           file://mru-clocks1.diff;patch=1 \
           file://mru-clocks2.diff;patch=1 \
           file://mru-clocks3.diff;patch=1 \	
           file://4bitmmc.diff;patch=1 \
           file://no-cortex-deadlock.patch;patch=1 \
           file://01-make_tick_gptimer_configurable;patch=1 \
           file://read_die_ids.patch;patch=1 \
           file://omap23-pm-noop.eml;patch=1 \
           file://01-omappm-srf.eml;patch=1 \
           file://02-omappm-mpu-latency-modeling.eml;patch=1 \
           file://03-omappm-omap3srf.eml;patch=1 \
           file://04-omappm-srf-noop.eml;patch=1 \
           file://05-omappm-virtualclocks.eml;patch=1 \
           file://06-omappm-opp-resource-modeling.eml;patch=1 \
           file://07-omappm-srf-updates.eml;patch=1 \
           file://08-omappm-voltagescaling.eml;patch=1 \
           file://09-omappm-vdd2-scaling.eml;patch=1 \
           file://10-omappm-off-mode.eml;patch=1 \
           file://01-postrate-notifier.eml;patch=1 \
           file://02-postrate-notifier.eml;patch=1 \
           file://01-omap3-cpufreq.eml;patch=1 \
           file://01-beagle-cpufreq.diff;patch=1 \
           file://musb-dmafix.patch;patch=1 \ 
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
