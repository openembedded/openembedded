require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "d6daf8d8cc5ccf90247def5551ee9c3e8555e848"

PV = "2.6.26"
#PV = "2.6.26+2.6.27-rc1+${PR}+git${SRCREV}"
PR = "r64"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append_beagleboard = " file://no-harry-potter.diff \
           file://0001-ASoC-OMAP-Add-basic-support-for-OMAP34xx-in-McBSP.patch \
	   file://0001-omap3-cpuidle.patch \ 
           file://0002-omap3-cpuidle.patch \
           file://timer-suppression.patch \
           file://ASoC-TWL4030-codec-driver.patch \
           file://ASoC-machine-driver-for-OMAP3-EVM.patch \
           file://ASoC-machine-driver-for_OMAP3-Beagle.patch \
           file://16bpp.patch \
           file://no-empty-flash-warnings.patch \
           file://logo_linux_clut224.ppm \
           file://oprofile-0.9.3.armv7.diff \
           file://01-fix-timing-print.diff \
           file://03-enable-overlay-opt.diff \
           file://04-use-pcd.diff \
           file://05-fix-display-panning.diff \
           file://06-ensure-fclk.diff \
           file://07-set-burst-size.diff \
           file://cache-display-fix.patch \
           file://mru-clocks1.diff \
           file://mru-clocks2.diff \
           file://mru-clocks3.diff \	
           file://4bitmmc.diff \
           file://no-cortex-deadlock.patch \
           file://01-make_tick_gptimer_configurable;apply=yes \
           file://read_die_ids.patch \
           file://omap23-pm-noop.eml;apply=yes \
           file://01-omappm-srf.eml;apply=yes \
           file://02-omappm-mpu-latency-modeling.eml;apply=yes \
           file://03-omappm-omap3srf.eml;apply=yes \
           file://04-omappm-srf-noop.eml;apply=yes \
           file://05-omappm-virtualclocks.eml;apply=yes \
           file://06-omappm-opp-resource-modeling.eml;apply=yes \
           file://07-omappm-srf-updates.eml;apply=yes \
           file://08-omappm-voltagescaling.eml;apply=yes \
           file://09-omappm-vdd2-scaling.eml;apply=yes \
           file://10-omappm-off-mode.eml;apply=yes \
           file://01-postrate-notifier.eml;apply=yes \
           file://02-postrate-notifier.eml;apply=yes \
           file://01-omap3-cpufreq.eml;apply=yes \
           file://01-beagle-cpufreq.diff \
           file://musb-dmafix.patch \ 
"

SRC_URI_append_omap3evm = " file://no-harry-potter.diff \
           file://0001-ASoC-OMAP-Add-basic-support-for-OMAP34xx-in-McBSP.patch \
           file://0001-omap3-cpuidle.patch \
           file://0002-omap3-cpuidle.patch \
           file://timer-suppression.patch \
           file://soc.patch \
           file://no-empty-flash-warnings.patch \
           file://touchscreen.patch \
"


COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard|omap3evm"


S = "${WORKDIR}/git"
