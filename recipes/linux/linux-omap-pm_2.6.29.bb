require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm|omap3-pandora|overo|omap3-touchbook"

SRCREV = "e63cf0710a4fb639d91d3e8b05aa485fbfa381b3"

PV = "2.6.29"
MACHINE_KERNEL_PR_append = "-pm2+gitr${SRCREV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/khilman/linux-omap-pm.git;protocol=git;branch=pm-2.6.29 \
	   file://defconfig"

SRC_URI_append = " \
           file://no-empty-flash-warnings.patch;apply=yes \
           file://no-cortex-deadlock.patch;apply=yes \
           file://read_die_ids.patch;apply=yes \
           file://fix-install.patch;apply=yes \
           file://0124-leds-gpio-broken-with-current-git.patch;apply=yes \
           file://ehci.patch;apply=yes \
           file://dss2/0001-Revert-gro-Fix-legacy-path-napi_complete-crash.patch;apply=yes \
           file://dss2/0002-OMAPFB-move-omapfb.h-to-include-linux.patch;apply=yes \
           file://dss2/0003-DSS2-OMAP2-3-Display-Subsystem-driver.patch;apply=yes \
           file://dss2/0004-DSS2-OMAP-framebuffer-driver.patch;apply=yes \
           file://dss2/0005-DSS2-Add-panel-drivers.patch;apply=yes \
           file://dss2/0006-DSS2-HACK-Add-DSS2-support-for-N800.patch;apply=yes \
           file://dss2/0007-DSS2-Add-DSS2-support-for-SDP-Beagle-Overo-EVM.patch;apply=yes \
           file://dss2/0008-DSS2-Add-function-to-display-object-to-get-the-back.patch;apply=yes \
           file://dss2/0009-DSS2-Add-acx565akm-panel.patch;apply=yes \
           file://dss2/0010-DSS2-Small-VRFB-context-allocation-bug-fixed.patch;apply=yes \
           file://dss2/0011-DSS2-Allocated-memory-for-Color-Look-up-table.patch;apply=yes \
           file://dss2/0012-DSS2-Fix-DMA-rotation.patch;apply=yes \
           file://dss2/0013-DSS2-Verify-that-overlay-paddr-0.patch;apply=yes \
           file://dss2/0014-DSS2-Add-function-to-get-DSS-logic-clock-rate.patch;apply=yes \
           file://dss2/0015-DSS2-DSI-calculate-VP_CLK_RATIO-properly.patch;apply=yes \
           file://dss2/0016-DSS2-DSI-improve-packet-len-calculation.patch;apply=yes \
           file://dss2/0017-DSS2-Disable-video-planes-on-sync-lost-error.patch;apply=yes \
           file://dss2/0018-DSS2-check-for-ovl-paddr-only-when-enabling.patch;apply=yes \
           file://dss2/0019-DSS2-Check-fclk-limits-when-configuring-video-plane.patch;apply=yes \
           file://dss2/0020-DSS2-Check-scaling-limits-against-proper-values.patch;apply=yes \
           file://dss2/0021-DSS2-Add-venc-register-dump.patch;apply=yes \
           file://dss2/0022-DSS2-FB-remove-unused-var-warning.patch;apply=yes \
           file://dss2/0023-DSS2-pass-the-default-FB-color-format-through-board.patch;apply=yes \
           file://dss2/0024-DSS2-Beagle-Use-gpio_set_value.patch;apply=yes \
           file://dss2/0025-DSS2-VRFB-Macro-for-calculating-base-address-of-th.patch;apply=yes \
           file://dss2/0026-DSS2-DSI-sidlemode-to-noidle-while-sending-frame.patch;apply=yes \
           file://dss2/0027-DSS2-VRFB-rotation-and-mirroring-implemented.patch;apply=yes \
           file://dss2/0028-DSS2-OMAPFB-Added-support-for-the-YUV-VRFB-rotatio.patch;apply=yes \
           file://dss2/0029-DSS2-OMAPFB-Set-line_length-correctly-for-YUV-with.patch;apply=yes \
           file://dss2/0030-DSS2-dispc_get_trans_key-was-returning-wrong-key-ty.patch;apply=yes \
           file://dss2/0031-DSS2-do-bootmem-reserve-for-exclusive-access.patch;apply=yes \
           file://dss2/0032-DSS2-Fix-DISPC_VID_FIR-value-for-omap34xx.patch;apply=yes \
           file://dss2/0033-DSS2-Prefer-3-tap-filter.patch;apply=yes \
           file://dss2/0034-DSS2-VRAM-improve-omap_vram_add_region.patch;apply=yes \
           file://dss2/0035-DSS2-Added-the-function-pointer-for-getting-default.patch;apply=yes \
           file://dss2/0036-DSS2-Added-support-for-setting-and-querying-alpha-b.patch;apply=yes \
           file://dss2/0037-DSS2-Added-support-for-querying-color-keying.patch;apply=yes \
           file://dss2/0038-DSS2-OMAPFB-Some-color-keying-pointerd-renamed-in-D.patch;apply=yes \
           file://dss2/0039-DSS2-Add-sysfs-entry-to-for-the-alpha-blending-supp.patch;apply=yes \
           file://dss2/0040-DSS2-Provided-proper-exclusion-for-destination-colo.patch;apply=yes \
           file://dss2/0041-DSS2-Disable-vertical-offset-with-fieldmode.patch;apply=yes \
           file://dss2/0042-DSS2-Don-t-enable-fieldmode-automatically.patch;apply=yes \
           file://dss2/0043-DSS2-Swap-field-0-and-field-1-registers.patch;apply=yes \
           file://dss2/0044-DSS2-add-sysfs-entry-for-seting-the-rotate-type.patch;apply=yes \
           file://dss2/0045-DSS2-Fixed-line-endings-from-to.patch;apply=yes \
           file://dss2/0046-DSS2-DSI-decrease-sync-timeout-from-60s-to-2s.patch;apply=yes \
           file://dss2/0047-DSS2-fix-return-value-for-rotate_type-sysfs-functio.patch;apply=yes \
           file://dss2/0048-OMAP2-3-DMA-implement-trans-copy-and-const-fill.patch;apply=yes \
           file://dss2/0049-DSS2-VRAM-clear-allocated-area-with-DMA.patch;apply=yes \
           file://dss2/0050-DSS2-OMAPFB-remove-fb-clearing-code.patch;apply=yes \
           file://dss2/0051-DSS2-VRAM-use-debugfs-not-procfs.patch;apply=yes \
           file://dss2/0052-DSS2-VRAM-fix-section-mismatch-warning.patch;apply=yes \
           file://dss2/0053-DSS2-disable-LCD-DIGIT-before-resetting-DSS.patch;apply=yes \
           file://dss2/0054-DSS2-DSI-more-error-handling.patch;apply=yes \
           file://dss2/0055-DSS2-Added-global-alpha-support.patch;apply=yes \
           file://dss2/0056-DSS2-Rotation-attrs-for-YUV-need-not-to-be-reversed.patch;apply=yes \
           file://dss2/0057-DSS2-Documentation-update-for-new-sysfs-entries-in.patch;apply=yes \
           file://dss2/0058-DSS2-Don-t-touch-plane-coordinates-when-changing-fb.patch;apply=yes \
           file://dss2/0059-DSS2-DSI-configure-ENTER-EXIT_HS_MODE_LATENCY.patch;apply=yes \
           file://dss2/0060-DSS2-Avoid-div-by-zero-when-calculating-required-fc.patch;apply=yes \
           file://dss2/0061-DSS2-VRFB-save-restore-context.patch;apply=yes \
           file://dss2/0062-DSS2-VRAM-Fix-indentation.patch;apply=yes \
           file://dss2/0063-DSS2-fix-the-usage-of-get_last_off_on_transaction_i.patch;apply=yes \
           file://dss2/0064-VRFB-fix-debug-messages.patch;apply=yes \
           file://dss2/0065-VRFB-add-suspend-resume-functionality.patch;apply=yes \
           file://dss2/0066-DSS2-DSI-tune-the-timings-to-be-more-relaxed.patch;apply=yes \
           file://dss2/0067-DSS2-VRFB-don-t-WARN-when-releasing-inactive-ctx.patch;apply=yes \
           file://dss2/0068-DSS2-Swap-field-offset-values-w-VRFB-rotation.patch;apply=yes \
           file://dss2/0069-DSS2-OMAP3EVM-Added-DSI-powerup-and-powerdown-func.patch;apply=yes \
           file://dss2/0070-DSS2-fix-irq1.diff;apply=yes \
           file://dss2/0071-DSS2-fix-irq2.diff;apply=yes \
           file://dss2/merge-fixups.diff;apply=yes \
           file://overo-cpufreq.diff;apply=yes \
           file://register-all-OPPs.diff;apply=yes \
           file://isp/v4l/0001-V4L2-Add-COLORFX-user-control.patch;apply=yes \
           file://isp/v4l/0002-V4L-Int-if-v4l2_int_device_try_attach_all-requires.patch;apply=yes \
           file://isp/v4l/0003-V4L-Int-if-Dummy-slave.patch;apply=yes \
           file://isp/v4l/0004-V4L-int-device-add-support-for-VIDIOC_QUERYMENU.patch;apply=yes \
           file://isp/v4l/0005-V4L-Int-if-Add-vidioc_int_querycap.patch;apply=yes \
           file://isp/iommu/0001-omap-iommu-tlb-and-pagetable-primitives.patch;apply=yes \
           file://isp/iommu/0002-omap-iommu-omap2-architecture-specific-functions.patch;apply=yes \
           file://isp/iommu/0003-omap-iommu-omap3-iommu-device-registration.patch;apply=yes \
           file://isp/iommu/0004-omap-iommu-simple-virtual-address-space-management.patch;apply=yes \
           file://isp/iommu/0005-omap-iommu-entries-for-Kconfig-and-Makefile.patch;apply=yes \
           file://isp/iommu/0006-omap-iommu-Don-t-try-BUG_ON-in_interrupt.patch;apply=yes \
           file://isp/iommu/0007-omap-iommu-We-support-chained-scatterlists-probabl.patch;apply=yes \
           file://isp/iommu/0008-omap2-iommu-entries-for-Kconfig-and-Makefile.patch;apply=yes \
           file://isp/omap3camera/0001-omap3isp-Add-ISP-main-driver-and-register-definitio.patch;apply=yes \
           file://isp/omap3camera/0002-omap3isp-Add-ISP-MMU-wrapper.patch;apply=yes \
           file://isp/omap3camera/0003-omap3isp-Add-userspace-header.patch;apply=yes \
           file://isp/omap3camera/0004-omap3isp-Add-ISP-frontend-CCDC.patch;apply=yes \
           file://isp/omap3camera/0005-omap3isp-Add-ISP-backend-PRV-and-RSZ.patch;apply=yes \
           file://isp/omap3camera/0006-omap3isp-Add-statistics-collection-modules-H3A-and.patch;apply=yes \
           file://isp/omap3camera/0007-omap3isp-Add-CSI2-interface-support.patch;apply=yes \
           file://isp/omap3camera/0008-omap3isp-Add-ISP-tables.patch;apply=yes \
           file://isp/omap3camera/0009-omap34xxcam-Add-camera-driver.patch;apply=yes \
           file://isp/resizer/0023-OMAP-Resizer-Basic-Resizer-refreshed-with-latest-gi.patch;apply=yes \
           file://isp/resizer/0024-OMAP3-Resizer-V4L2-buf-layer-issues-fixed.patch;apply=yes \
           file://isp/resizer/0025-OMAP3-Resizer-Build-issues-fixed.patch;apply=yes \
           file://modedb-hd720.patch;apply=yes \
           file://0001-implement-TIF_RESTORE_SIGMASK-support-and-enable-the.patch;apply=yes \
           file://vfp/02-vfp-ptrace.patch;apply=yes \
           file://vfp/03-vfp-corruption.patch;apply=yes \
           file://vfp/04-vfp-threads.patch;apply=yes \
           file://vfp/05-vfp-signal-handlers.patch;apply=yes \
           file://arch-has-holes.diff;apply=yes \
           file://musb/0001-USB-musb-only-turn-off-vbus-in-OTG-hosts.patch;apply=yes \
           file://musb/0002-USB-composite-avoid-inconsistent-lock-state.patch;apply=yes \
           file://musb/0003-USB-musb-NAK-timeout-scheme-on-bulk-RX-endpoint.patch;apply=yes \
           file://musb/0004-USB-musb-rewrite-host-periodic-endpoint-allocation.patch;apply=yes \
           file://musb/0005-USB-TWL-disable-VUSB-regulators-when-cable-unplugg.patch;apply=yes \
           file://musb/0006-USB-gadget-composite-device-level-suspend-resume-h.patch;apply=yes \
           file://musb/0007-usb-gadget-fix-ethernet-link-reports-to-ethtool.patch;apply=yes \
           file://musb/0008-usb-musb_host-minor-enqueue-locking-fix-v2.patch;apply=yes \
           file://musb/0009-usb-musb_host-fix-ep0-fifo-flushing.patch;apply=yes \
           file://musb/0010-musb-sanitize-clearing-TXCSR-DMA-bits-take-2.patch;apply=yes \
           file://musb/0011-musb-fix-isochronous-TXDMA-take-2.patch;apply=yes \
           file://musb/0012-musb-fix-possible-panic-while-resuming.patch;apply=yes \
           file://musb/0013-musb_host-refactor-musb_save_toggle-take-2.patch;apply=yes \
           file://musb/0014-musb_gadget-suppress-parasitic-TX-interrupts-with.patch;apply=yes \
           file://musb/0015-musb_gadget-fix-unhandled-endpoint-0-IRQs.patch;apply=yes \
           file://musb/0016-musb_host-factor-out-musb_ep_-get-set-_qh.patch;apply=yes \
           file://musb/0017-musb_host-refactor-URB-giveback.patch;apply=yes \
           file://musb/0018-musb-split-out-CPPI-interrupt-handler.patch;apply=yes \
           file://musb/0019-musb_host-simplify-check-for-active-URB.patch;apply=yes \
           file://musb/0020-musb_host-streamline-musb_cleanup_urb-calls.patch;apply=yes \
           file://musb/0021-twl4030-usb-fix-minor-reporting-goofage.patch;apply=yes \
           file://musb/0022-musb-use-dma-mode-1-for-TX-if-transfer-size-equals.patch;apply=yes \
           file://musb/0023-musb-add-high-bandwidth-ISO-support.patch;apply=yes \
           file://musb/0024-USB-otg-adding-nop-usb-transceiver.patch;apply=yes \
           file://musb/0025-nop-usb-xceiv-behave-when-linked-as-a-module.patch;apply=yes \
           file://musb/0026-musb-proper-hookup-to-transceiver-drivers.patch;apply=yes \
           file://musb/0027-musb-otg-timer-cleanup.patch;apply=yes \
           file://musb/0028-musb-make-initial-HNP-roleswitch-work-v2.patch;apply=yes \
           file://musb/0029-musb-support-disconnect-after-HNP-roleswitch.patch;apply=yes \
           file://cache/l1cache-shift.patch;apply=yes \
           file://cache/copy-page-tweak.patch;apply=yes \
"


SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
                               file://tincantools-puppy.diff;apply=yes \
                               file://tincantools-zippy.diff;apply=yes \
"

SRC_URI_append_omap3-touchbook = " file://logo_linux_clut224.ppm \
                                           file://../beagleboard/beagle-asoc.patch;apply=yes \
           file://accelerometer-mma7455l.patch;apply=yes \
           file://accelerometer-touchscreen-mux-spi.patch;apply=yes \
           file://touchscreen-ads7846-export-settings.patch;apply=yes \
           file://touchscreen-ads7846-rotation-fixed.patch;apply=yes \
           file://dspbridge.patch;apply=yes \
           file://battery2-bq27200-no-error-message.patch;apply=yes \
           file://sound-headphone-detection.patch;apply=yes \
           file://dss2-fix-XY-coordinates-when-rotating.patch;apply=yes \
           file://battery1-tps65950-charging-management-1.patch;apply=yes \
           file://dss2-fix-scaling-when-rotating.patch;apply=yes \
           file://dss2-export-status.patch;apply=yes \
           file://usb-otg-pc-connection.patch;apply=yes \
           file://battery1-tps65950-charging-management-2.patch;apply=yes \
           file://battery1-tps65950-charging-management-3.patch;apply=yes \
           file://memory-move-malloc-end.patch;apply=yes \
           file://aufs-1.patch;apply=yes \
           file://aufs-2.patch;apply=yes \
           file://aufs-3.patch;apply=yes \
           file://aufs-squashfs-mount-to-avoid-initramfs.patch;apply=yes \
           file://screen-backlight-accessible-by-user.patch;apply=yes \
           file://dss2-blank-rotate-accessible-by-user.patch;apply=yes \
           file://boot-no-power-message.patch;apply=yes \
           file://usb-lower-current-consumption-upon-insertion.patch;apply=yes \
           file://battery2-bq27200-gpio-charged.patch;apply=yes \
           file://keyboard-special-keys.patch;apply=yes \
           file://dss2-fix-rotation-offsets.patch;apply=yes \
           file://touchbook-config.patch;apply=yes \
           file://board-omap3touchbook.c \
#           file://boot-trace-for-optimization.patch;apply=yes \
           file://touchbook-sound.diff;apply=yes \
"

SRC_URI_append_omap3evm = " \
	file://evm-mcspi-ts.diff;apply=yes \
"

S = "${WORKDIR}/git"

do_configure_prepend_omap3-touchbook() {
        cp ${WORKDIR}/board-omap3touchbook.c ${S}/arch/arm/mach-omap2
}

do_install_append() {
        install -d ${D}/boot
        install -m 0644 Documentation/arm/OMAP/DSS ${D}/boot || true
}

PACKAGES =+ "omap-dss-doc"
FILES_omap-dss-doc = "/boot/DSS"

module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"


