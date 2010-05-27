require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beagleboard"

DEFAULT_PREFERENCE = "-1"

SRCREV = "7c5cb7862d32cb344be7831d466535d5255e35ac"

PV = "2.6.30+2.6.31rc1-pm1+gitr${SRCREV}"

FILESPATHPKG_prepend = "linux-omap-pm-2.6.31:"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/khilman/linux-omap-pm.git;protocol=git;branch=pm \
	   file://defconfig"

SRC_URI_append = " \
           file://no-empty-flash-warnings.patch \
           file://no-cortex-deadlock.patch \
           file://read_die_ids.patch \
           file://fix-install.patch \
           file://fix-musb-oops.diff \
           file://fix-mtd.diff \
           file://ehci.patch \
           file://dss2/0001-OMAPFB-move-omapfb.h-to-include-linux.patch \
           file://dss2/0002-DSS2-OMAP2-3-Display-Subsystem-driver.patch \
           file://dss2/0003-DSS2-OMAP-framebuffer-driver.patch \
           file://dss2/0004-DSS2-Add-panel-drivers.patch \
           file://dss2/0005-DSS2-HACK-Add-DSS2-support-for-N800.patch \
           file://dss2/0006-DSS2-Add-DSS2-support-for-SDP-Beagle-Overo-EVM.patch \
           file://dss2/0007-DSS2-Add-function-to-display-object-to-get-the-back.patch \
           file://dss2/0008-DSS2-Add-acx565akm-panel.patch \
           file://dss2/0009-DSS2-Small-VRFB-context-allocation-bug-fixed.patch \
           file://dss2/0010-DSS2-Allocated-memory-for-Color-Look-up-table.patch \
           file://dss2/0011-DSS2-Fix-DMA-rotation.patch \
           file://dss2/0012-DSS2-Verify-that-overlay-paddr-0.patch \
           file://dss2/0013-DSS2-Add-function-to-get-DSS-logic-clock-rate.patch \
           file://dss2/0014-DSS2-DSI-calculate-VP_CLK_RATIO-properly.patch \
           file://dss2/0015-DSS2-DSI-improve-packet-len-calculation.patch \
           file://dss2/0016-DSS2-Disable-video-planes-on-sync-lost-error.patch \
           file://dss2/0017-DSS2-check-for-ovl-paddr-only-when-enabling.patch \
           file://dss2/0018-DSS2-Check-fclk-limits-when-configuring-video-plane.patch \
           file://dss2/0019-DSS2-Check-scaling-limits-against-proper-values.patch \
           file://dss2/0020-DSS2-Add-venc-register-dump.patch \
           file://dss2/0021-DSS2-FB-remove-unused-var-warning.patch \
           file://dss2/0022-DSS2-pass-the-default-FB-color-format-through-board.patch \
           file://dss2/0023-DSS2-Beagle-Use-gpio_set_value.patch \
           file://dss2/0024-DSS2-VRFB-Macro-for-calculating-base-address-of-th.patch \
           file://dss2/0025-DSS2-DSI-sidlemode-to-noidle-while-sending-frame.patch \
           file://dss2/0026-DSS2-VRFB-rotation-and-mirroring-implemented.patch \
           file://dss2/0027-DSS2-OMAPFB-Added-support-for-the-YUV-VRFB-rotatio.patch \
           file://dss2/0028-DSS2-OMAPFB-Set-line_length-correctly-for-YUV-with.patch \
           file://dss2/0029-DSS2-dispc_get_trans_key-was-returning-wrong-key-ty.patch \
           file://dss2/0030-DSS2-do-bootmem-reserve-for-exclusive-access.patch \
           file://dss2/0031-DSS2-Fix-DISPC_VID_FIR-value-for-omap34xx.patch \
           file://dss2/0032-DSS2-Prefer-3-tap-filter.patch \
           file://dss2/0033-DSS2-VRAM-improve-omap_vram_add_region.patch \
           file://dss2/0034-DSS2-Added-the-function-pointer-for-getting-default.patch \
           file://dss2/0035-DSS2-Added-support-for-setting-and-querying-alpha-b.patch \
           file://dss2/0036-DSS2-Added-support-for-querying-color-keying.patch \
           file://dss2/0037-DSS2-OMAPFB-Some-color-keying-pointerd-renamed-in-D.patch \
           file://dss2/0038-DSS2-Add-sysfs-entry-to-for-the-alpha-blending-supp.patch \
           file://dss2/0039-DSS2-Provided-proper-exclusion-for-destination-colo.patch \
           file://dss2/0040-DSS2-Disable-vertical-offset-with-fieldmode.patch \
           file://dss2/0041-DSS2-Don-t-enable-fieldmode-automatically.patch \
           file://dss2/0042-DSS2-Swap-field-0-and-field-1-registers.patch \
           file://dss2/0043-DSS2-add-sysfs-entry-for-seting-the-rotate-type.patch \
           file://dss2/0044-DSS2-Fixed-line-endings-from-to.patch \
           file://dss2/0045-DSS2-DSI-decrease-sync-timeout-from-60s-to-2s.patch \
           file://dss2/0046-DSS2-fix-return-value-for-rotate_type-sysfs-functio.patch \
           file://dss2/0047-DSS2-VRAM-clear-allocated-area-with-DMA.patch \
           file://dss2/0048-DSS2-OMAPFB-remove-fb-clearing-code.patch \
           file://dss2/0049-DSS2-VRAM-use-debugfs-not-procfs.patch \
           file://dss2/0050-DSS2-VRAM-fix-section-mismatch-warning.patch \
           file://dss2/0051-DSS2-disable-LCD-DIGIT-before-resetting-DSS.patch \
           file://dss2/0052-DSS2-DSI-more-error-handling.patch \
           file://dss2/0053-DSS2-Added-global-alpha-support.patch \
           file://dss2/0054-DSS2-Rotation-attrs-for-YUV-need-not-to-be-reversed.patch \
           file://dss2/0055-DSS2-Documentation-update-for-new-sysfs-entries-in.patch \
           file://dss2/0056-DSS2-Don-t-touch-plane-coordinates-when-changing-fb.patch \
           file://dss2/0057-DSS2-DSI-configure-ENTER-EXIT_HS_MODE_LATENCY.patch \
           file://dss2/0058-DSS2-Avoid-div-by-zero-when-calculating-required-fc.patch \
           file://dss2/0059-DSS2-VRFB-save-restore-context.patch \
           file://dss2/0060-DSS2-VRAM-Fix-indentation.patch \
           file://dss2/0061-DSS2-fix-the-usage-of-get_last_off_on_transaction_i.patch \
           file://dss2/0062-VRFB-fix-debug-messages.patch \
           file://dss2/0063-VRFB-add-suspend-resume-functionality.patch \
           file://dss2/0064-DSS2-DSI-tune-the-timings-to-be-more-relaxed.patch \
           file://dss2/0065-DSS2-VRFB-don-t-WARN-when-releasing-inactive-ctx.patch \
           file://dss2/0066-DSS2-Swap-field-offset-values-w-VRFB-rotation.patch \
           file://dss2/0067-DSS2-OMAP3EVM-Added-DSI-powerup-and-powerdown-func.patch \
           file://dss2/0068-DSS2-DSI-Improve-perf-measurement-output.patch \
           file://dss2/0069-DSS2-DSI-Add-support-for-external-TE-signal.patch \
           file://dss2/0070-DSS2-DSI-Fix-LP-clock.patch \
           file://dss2/0071-DSS2-Do-not-swap-xres-yres-or-change-rotation-in-ch.patch \
           file://dss2/0072-DSS2-Allow-independent-rotation-for-each-plane.patch \
           file://dss2/0073-DSS2-DISPC-fix-irq-handling-locking.patch \
           file://dss2/0074-DSS2-DISPC-clear-irqstatus-for-newly-enabled-irqs.patch \
           file://dss2/0075-DSS2-Add-WSS-support.patch \
           file://dss2/0076-DSS2-Fix-PAL-NTSC-timings.patch \
           file://dss2/0077-DSS2-Add-venc-debugfs-file.patch \
           file://dss2/0078-DSS2-Enable-replication-logic-feature.patch \
           file://dss2/0079-DSS2-support-for-querying-the-supported-overlay-col.patch \
           file://dss2/0080-DSS2-fix-uninitialized-var-in-OMAPFB_GET_CAPS-IOCTL.patch \
           file://dss2/0081-DSS2-Reset-WSS-data-only-when-changing-TV-standard.patch \
           file://dss2/0082-DSS2-DSI-implement-timeout-for-DSI-transfer.patch \
           file://dss2/0083-DSS2-DSI-reset-perf-frame-counter-when-starting-au.patch \
           file://dss2/0084-DSS2-DSI-Implement-DSI-bus-lock.patch \
           file://dss2/0085-DSS2-OMAPFB-omapfb_get_ovl_colormode-to-static.patch \
           file://dss2/0086-DSS2-VRFB-make-vrfb_hw_context-static.patch \
           file://dss2/0087-DSS2-new-device-driver-model.patch \
           file://dss2/0088-DSS2-Board-file-changes-for-new-device-model.patch \
           file://dss2/0089-DSS2-Panel-driver-changes-for-new-device-model.patch \
           file://dss2/0090-DSS2-VENC-venc-uses-regulator-framework.patch \
           file://dss2/0091-DSS2-DSI-Use-regulator-framework.patch \
           file://dss2/0092-DSS2-SDP-regulators-for-VDAC-DSI.patch \
           file://dss2/0093-DSS2-Sharp-panel-use-regulator-fw.patch \
           file://dss2/0094-DSS2-Beagle-regulators-for-VDAC-DSI.patch \
           file://dss2/0095-DSS2-Fix-checkpatch-complaints.patch \
           file://dss2/0096-DSS2-Overo-add-vdac-dsi-regulators-fix-panel-name.patch \
           file://dss2/0097-DSS2-implement-overlay_manager_info.patch \
           file://dss2/0098-DSS2-use-sysfs_streq-to-compare-display-names.patch \
           file://dss2/0099-DSS2-Implement-function-to-verify-lcd-timings.patch \
           file://dss2/0100-DSS2-Remove-non-existing-dsi-power-funcs-from-dss.h.patch \
           file://dss2/0101-DSS2-move-to_dss_driver-and-to_dss_device-to-pu.patch \
           file://dss2/0102-DSS2-CLK-change-omapfb-omapdss-in-clock-framewo.patch \
           file://dss2/0103-DSS2-Use-clkdev.patch \
           file://dss2/0104-DSS2-Fix-documentation.patch \
           file://dss2/0105-DSS2-OMAPFB-first-set-TE-then-update-mode.patch \
           file://dss2/0106-DSS2-OMAPFB-Disable-forced-display-update-on-fb-cl.patch \
           file://dss2/0107-DSS2-DSI-use-INIT_COMPLETION-not-init_completion.patch \
           file://dss2/0108-DSS2-DSI-Rewrite-of-the-DSI-update-and-cmd-queue.patch \
           file://dss2/0109-DSS2-let-init_display-return-an-error-code.patch \
           file://dss2/0110-DSS2-isolate-the-SDI-pads-when-SDI-is-disabled.patch \
           file://dss2/0111-DSS2-Fix-bottom-field-initial-starting-line.patch \
           file://dss2/0112-DSS2-Correctly-determine-if-an-interlaced-display-i.patch \
           file://dss2/0113-DSS2-Fix-omapfb-framebuffer-name.patch \
           file://dss2/0114-DSS2-Overo-update-defconfig-to-lighter-one.patch \
           file://dss2/0115-DSS2-SDI-make-sdi_pads-static.patch \
           file://dss2/0116-DSS2-Fix-default_color-sysfs-output.patch \
           file://dss2/0117-DSS2-Locking-for-VRFB.patch \
           file://dss2/0118-DSS2-DISPC-fix-locking-issue-with-irq-handling.patch \
           file://dss2/0119-DSS2-OMAPFB-remove-unneeded-locks.patch \
           file://dss2/0120-DSS2-DISPC-configuration-management.patch \
           file://dss2/0121-DSS2-VRFB-clean-up-BUG-calls.patch \
           file://dss2/0122-DSS2-OMAPFB-don-t-fail-even-if-default-display-doe.patch \
           file://dss2/0123-DSS2-DSI-Fix-external-TE-wait.patch \
           file://dss2/0124-DSS2-DSI-Increase-framedone-timeout-to-1s.patch \
           file://dss2/0125-DSS2-VRAM-Add-function-to-get-free-vram-info.patch \
           file://dss2/0126-DSS2-OMAPFB-implement-OMAPFB_GET_VRAM_INFO-ioctl.patch \
           file://dss2/0127-DSS2-DSI-increase-dsi-thread-priority.patch \
           file://dss2/0128-DSS2-DSI-check-bus_lock-in-send_bta.patch \
           file://dss2/0129-DSS2-DSI-export-dsi_vc_send_bta_sync.patch \
           file://dss2/0130-DSS2-DSI-clear-BTA-irq-before-enabling-it.patch \
           file://dss2/0131-DSS2-DSI-check-dsi_set_te-return-value.patch \
           file://dss2/0132-DSS2-DSI-use-only-1-VC.-Fixes-to-TE.patch \
           file://dss2/0133-DSS2-VRAM-Remove-unused-defines.patch \
           file://dss2/0134-DSS2-VENC-Add-invert_polarity-flag.patch \
           file://dss2/0135-DSS2-VRAM-Add-defines-for-VRAM-types.patch \
           file://dss2/0136-DSS2-VRAM-separate-VRAM-setup-from-the-old-fb-vram.patch \
           file://dss2/0137-DSS2-VRFB-Update-license-information.patch \
           file://dss2/0138-DSS2-VRAM-Update-license-information.patch \
           file://dss2/0139-DSS2-VRFB-use-pr_-instead-of-printk.patch \
           file://dss2/0140-DSS2-VRAM-Change-CONFIG_OMAP2_DSS_VRAM_SIZE-name.patch \
           file://dss2/0141-DSS2-VRAM-add-CONFIG_OMAP2_VRAM-flag.patch \
           file://dss2/0142-DSS2-VRFB-Add-CONFIG_OMAP2_VRFB-flag.patch \
           file://dss2/0143-DSS2-VRFB-VRAM-fix-checkpatch-warnings.patch \
           file://dss2/0144-DSS2-fixes-to-dss_omap_3430sdp_defconfig-to-make-it.patch \
           file://dss2/0145-DSS2-BEAGLE-get-DSS2-working-again-on-beagle.patch \
           file://dss2/0146-DSS2-change-include-asm-.-to-linux-.-in-oma.patch \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
           file://beagle-writable-uboot.diff \
			     "

SRC_URI_append_omap3evm = " \
	file://evm-mcspi-ts.diff \
"

S = "${WORKDIR}/git"


module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"

