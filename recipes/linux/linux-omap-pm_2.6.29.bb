require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm|omap3-pandora|overo"

SRCREV = "9c133058b929e738e6f28cb99e99c7fb5b35c59a"

PV = "2.6.29"
MACHINE_KERNEL_PR_append = "-pm2+gitr${SRCREV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/khilman/linux-omap-pm.git;protocol=git;branch=pm-2.6.29 \
	   file://defconfig"

SRC_URI_append = " \
           file://no-empty-flash-warnings.patch;patch=1 \
           file://no-cortex-deadlock.patch;patch=1 \
           file://read_die_ids.patch;patch=1 \
           file://fix-install.patch;patch=1 \
           file://0124-leds-gpio-broken-with-current-git.patch;patch=1 \
           file://ehci.patch;patch=1 \
           file://dss2/0001-Revert-gro-Fix-legacy-path-napi_complete-crash.patch;patch=1 \
           file://dss2/0002-OMAPFB-move-omapfb.h-to-include-linux.patch;patch=1 \
           file://dss2/0003-DSS2-OMAP2-3-Display-Subsystem-driver.patch;patch=1 \
           file://dss2/0004-DSS2-OMAP-framebuffer-driver.patch;patch=1 \
           file://dss2/0005-DSS2-Add-panel-drivers.patch;patch=1 \
           file://dss2/0006-DSS2-HACK-Add-DSS2-support-for-N800.patch;patch=1 \
           file://dss2/0007-DSS2-Add-DSS2-support-for-SDP-Beagle-Overo-EVM.patch;patch=1 \
           file://dss2/0008-DSS2-Add-function-to-display-object-to-get-the-back.patch;patch=1 \
           file://dss2/0009-DSS2-Add-acx565akm-panel.patch;patch=1 \
           file://dss2/0010-DSS2-Small-VRFB-context-allocation-bug-fixed.patch;patch=1 \
           file://dss2/0011-DSS2-Allocated-memory-for-Color-Look-up-table.patch;patch=1 \
           file://dss2/0012-DSS2-Fix-DMA-rotation.patch;patch=1 \
           file://dss2/0013-DSS2-Verify-that-overlay-paddr-0.patch;patch=1 \
           file://dss2/0014-DSS2-Add-function-to-get-DSS-logic-clock-rate.patch;patch=1 \
           file://dss2/0015-DSS2-DSI-calculate-VP_CLK_RATIO-properly.patch;patch=1 \
           file://dss2/0016-DSS2-DSI-improve-packet-len-calculation.patch;patch=1 \
           file://dss2/0017-DSS2-Disable-video-planes-on-sync-lost-error.patch;patch=1 \
           file://dss2/0018-DSS2-check-for-ovl-paddr-only-when-enabling.patch;patch=1 \
           file://dss2/0019-DSS2-Check-fclk-limits-when-configuring-video-plane.patch;patch=1 \
           file://dss2/0020-DSS2-Check-scaling-limits-against-proper-values.patch;patch=1 \
           file://dss2/0021-DSS2-Add-venc-register-dump.patch;patch=1 \
           file://dss2/0022-DSS2-FB-remove-unused-var-warning.patch;patch=1 \
           file://dss2/0023-DSS2-pass-the-default-FB-color-format-through-board.patch;patch=1 \
           file://dss2/0024-DSS2-Beagle-Use-gpio_set_value.patch;patch=1 \
           file://dss2/0025-DSS2-VRFB-Macro-for-calculating-base-address-of-th.patch;patch=1 \
           file://dss2/0026-DSS2-DSI-sidlemode-to-noidle-while-sending-frame.patch;patch=1 \
           file://dss2/0027-DSS2-VRFB-rotation-and-mirroring-implemented.patch;patch=1 \
           file://dss2/0028-DSS2-OMAPFB-Added-support-for-the-YUV-VRFB-rotatio.patch;patch=1 \
           file://dss2/0029-DSS2-OMAPFB-Set-line_length-correctly-for-YUV-with.patch;patch=1 \
           file://dss2/0030-DSS2-dispc_get_trans_key-was-returning-wrong-key-ty.patch;patch=1 \
           file://dss2/0031-DSS2-do-bootmem-reserve-for-exclusive-access.patch;patch=1 \
           file://dss2/0032-DSS2-Fix-DISPC_VID_FIR-value-for-omap34xx.patch;patch=1 \
           file://dss2/0033-DSS2-Prefer-3-tap-filter.patch;patch=1 \
           file://dss2/0034-DSS2-VRAM-improve-omap_vram_add_region.patch;patch=1 \
           file://dss2/0035-DSS2-Added-the-function-pointer-for-getting-default.patch;patch=1 \
           file://dss2/0036-DSS2-Added-support-for-setting-and-querying-alpha-b.patch;patch=1 \
           file://dss2/0037-DSS2-Added-support-for-querying-color-keying.patch;patch=1 \
           file://dss2/0038-DSS2-OMAPFB-Some-color-keying-pointerd-renamed-in-D.patch;patch=1 \
           file://dss2/0039-DSS2-Add-sysfs-entry-to-for-the-alpha-blending-supp.patch;patch=1 \
           file://dss2/0040-DSS2-Provided-proper-exclusion-for-destination-colo.patch;patch=1 \
           file://dss2/0041-DSS2-Disable-vertical-offset-with-fieldmode.patch;patch=1 \
           file://dss2/0042-DSS2-Don-t-enable-fieldmode-automatically.patch;patch=1 \
           file://dss2/0043-DSS2-Swap-field-0-and-field-1-registers.patch;patch=1 \
           file://dss2/0044-DSS2-add-sysfs-entry-for-seting-the-rotate-type.patch;patch=1 \
           file://dss2/0045-DSS2-Fixed-line-endings-from-to.patch;patch=1 \
           file://dss2/0046-DSS2-DSI-decrease-sync-timeout-from-60s-to-2s.patch;patch=1 \
           file://dss2/0047-DSS2-fix-return-value-for-rotate_type-sysfs-functio.patch;patch=1 \
           file://dss2/0048-OMAP2-3-DMA-implement-trans-copy-and-const-fill.patch;patch=1 \
           file://dss2/0049-DSS2-VRAM-clear-allocated-area-with-DMA.patch;patch=1 \
           file://dss2/0050-DSS2-OMAPFB-remove-fb-clearing-code.patch;patch=1 \
           file://dss2/0051-DSS2-VRAM-use-debugfs-not-procfs.patch;patch=1 \
           file://dss2/0052-DSS2-VRAM-fix-section-mismatch-warning.patch;patch=1 \
           file://dss2/0053-DSS2-disable-LCD-DIGIT-before-resetting-DSS.patch;patch=1 \
           file://dss2/0054-DSS2-DSI-more-error-handling.patch;patch=1 \
           file://dss2/0055-DSS2-Added-global-alpha-support.patch;patch=1 \
           file://dss2/0056-DSS2-Rotation-attrs-for-YUV-need-not-to-be-reversed.patch;patch=1 \
           file://dss2/0057-DSS2-Documentation-update-for-new-sysfs-entries-in.patch;patch=1 \
           file://dss2/0058-DSS2-Don-t-touch-plane-coordinates-when-changing-fb.patch;patch=1 \
           file://dss2/0059-DSS2-DSI-configure-ENTER-EXIT_HS_MODE_LATENCY.patch;patch=1 \
           file://dss2/0060-DSS2-Avoid-div-by-zero-when-calculating-required-fc.patch;patch=1 \
           file://dss2/0061-DSS2-VRFB-save-restore-context.patch;patch=1 \
           file://dss2/0062-DSS2-VRAM-Fix-indentation.patch;patch=1 \
           file://dss2/0063-DSS2-fix-the-usage-of-get_last_off_on_transaction_i.patch;patch=1 \
           file://dss2/0064-VRFB-fix-debug-messages.patch;patch=1 \
           file://dss2/0065-VRFB-add-suspend-resume-functionality.patch;patch=1 \
           file://dss2/0066-DSS2-DSI-tune-the-timings-to-be-more-relaxed.patch;patch=1 \
           file://dss2/0067-DSS2-VRFB-don-t-WARN-when-releasing-inactive-ctx.patch;patch=1 \
           file://dss2/0068-DSS2-Swap-field-offset-values-w-VRFB-rotation.patch;patch=1 \
           file://dss2/0069-DSS2-OMAP3EVM-Added-DSI-powerup-and-powerdown-func.patch;patch=1 \
           file://dss2/0070-DSS2-fix-irq1.diff;patch=1 \
           file://dss2/0071-DSS2-fix-irq2.diff;patch=1 \
           file://dss2/merge-fixups.diff;patch=1 \
           file://overo-cpufreq.diff;patch=1 \
           file://register-all-OPPs.diff;patch=1 \
           file://fix-audio-capture.patch;patch=1 \
"


SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
			     "

SRC_URI_append_omap3evm = " \
	file://evm-mcspi-ts.diff;patch=1 \
"

S = "${WORKDIR}/git"


module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"


