require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(beagleboard|overo|omap3evm|omap3-touchbook|usrp-e1xx)"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.37"
MACHINE_KERNEL_PR_append = "a+gitr${SRCREV}"
SRCREV = "fa3b4e23ec20cfc944db7cc2b30b0d82c20e4472"

FILESPATHPKG_prepend = "linux-omap-2.6.37:"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
                  file://linus/0001-ARM-pxa-PXA_ESERIES-depends-on-FB_W100.patch \
                  file://linus/0002-ARM-smp-avoid-incrementing-mm_users-on-CPU-startup.patch \
                  file://linus/0003-ARM-get-rid-of-kmap_high_l1_vipt.patch \  
                  file://linus/0004-ARM-fix-cache-xsc3l2-after-stack-based-kmap_atomic.patch \
                  file://linus/0005-ARM-fix-cache-feroceon-l2-after-stack-based-kmap_ato.patch \
                  file://linus/0006-drm-i915-Set-the-required-VFMUNIT-clock-gating-disab.patch \
                  file://linus/0007-drm-i915-sdvo-Add-hdmi-connector-properties-after-in.patch \
                  file://linus/0008-drm-i915-intel_ips-When-i915-loads-after-IPS-make-IP.patch \
                  file://linus/0009-drm-i915-Verify-Ironlake-eDP-presence-on-DP_A-using-.patch \
                  file://linus/0010-ARM-6536-1-Add-missing-SZ_-32-64-128.patch \
                  file://linus/0011-ARM-6537-1-update-Nomadik-U300-and-Ux500-maintainers.patch \
                  file://linus/0012-ARM-6540-1-Stop-irqsoff-trace-on-return-to-user.patch \
                  file://linus/0013-ueagle-atm-fix-PHY-signal-initialization-race.patch \
                  file://linus/0014-ehea-Avoid-changing-vlan-flags.patch \
                  file://linus/0015-ppp-allow-disabling-multilink-protocol-ID-compressio.patch \
                  file://linus/0016-skfp-testing-the-wrong-variable-in-skfp_driver_init.patch \
                  file://linus/0017-ASoC-codecs-Add-missing-control_type-initialization.patch \
                  file://linus/0018-ASoC-codecs-max98088-Fix-register-cache-incoherency.patch \
                  file://linus/0019-ASoC-codecs-wm8523-Fix-register-cache-incoherency.patch \
                  file://linus/0020-ASoC-codecs-wm8741-Fix-register-cache-incoherency.patch \
                  file://linus/0021-ASoC-codecs-wm8904-Fix-register-cache-incoherency.patch \
                  file://linus/0022-ASoC-codecs-wm8955-Fix-register-cache-incoherency.patch \
                  file://linus/0023-ASoC-codecs-wm8962-Fix-register-cache-incoherency.patch \
                  file://linus/0024-ASoC-codecs-wm9090-Fix-register-cache-incoherency.patch \
                  file://linus/0025-ASoC-codecs-wm8753-Fix-register-cache-incoherency.patch \
                  file://linus/0026-KVM-MMU-Fix-incorrect-direct-gfn-for-unpaged-mode-sh.patch \
                  file://linus/0027-fix-freeing-user_struct-in-user-cache.patch \
                  file://linus/0028-spi-omap2_mcspi.c-Force-CS-to-be-in-inactive-state-a.patch \
                  file://linus/0029-kconfig-fix-undesirable-side-effect-of-adding-visibl.patch \
                  file://linus/0030-spi-m68knommu-Coldfire-QSPI-platform-support.patch \
                  file://linus/0031-sound-Prevent-buffer-overflow-in-OSS-load_mixer_volu.patch \
                  file://linus/0032-ALSA-hda-Use-LPIB-quirk-for-Dell-Inspiron-m101z-1120.patch \
                  file://linus/0033-Revert-drm-i915-bios-Reverse-order-of-100-120-Mhz-SS.patch \
                  file://linus/0034-drm-i915-dvo-Report-LVDS-attached-to-ch701x-as-conne.patch \
                  file://linus/0035-update-Documentation-filesystems-Locking.patch \
                  file://linus/0036-memcg-fix-wrong-VM_BUG_ON-in-try_charge-s-mm-owner-c.patch \
                  file://linus/0037-Revert-Staging-zram-work-around-oops-due-to-startup-.patch \
                  file://linus/0038-CAN-Use-inode-instead-of-kernel-address-for-proc-fil.patch \
                  file://linus/0039-ISDN-Gigaset-Fix-memory-leak-in-do_disconnect_req.patch \
                  file://linus/0040-Broadcom-CNIC-core-network-driver-fix-mem-leak-on-al.patch \
                  file://linus/0041-tg3-fix-return-value-check-in-tg3_read_vpd.patch \
                  file://linus/0042-starfire-Fix-dma_addr_t-size-test-for-MIPS.patch \
                  file://linus/0043-drivers-atm-atmtcp.c-add-missing-atm_dev_put.patch \
                  file://linus/0044-KVM-i8259-initialize-isr_ack.patch \
                  file://linus/0045-hwmon-s3c-hwmon-Fix-compilation.patch \
                  file://linus/0046-watchdog-Improve-initialisation-error-message-and-do.patch \
                  file://linus/0047-ARM-6605-1-Add-missing-include-asm-memory.h.patch \
                  file://linus/0048-mv_xor-fix-race-in-tasklet-function.patch \
                  file://linus/0049-dmaengine-provide-dummy-functions-for-DMA_ENGINE-n.patch \
                  file://linus/0050-cx25840-Prevent-device-probe-failure-due-to-volume-c.patch \
                  file://linus/0051-wm8775-Revert-changeset-fcb9757333-to-avoid-a-regres.patch \
                  file://linus/0052-em28xx-radio_fops-should-also-use-unlocked_ioctl.patch \
                  file://linus/0053-arch-x86-oprofile-op_model_amd.c-Perform-initialisat.patch \
                  file://linus/0054-perf-Fix-callchain-hit-bad-cast-on-ascii-display.patch \
                  file://linus/0055-ARM-it8152-add-IT8152_LAST_IRQ-definition-to-fix-bui.patch \
                  file://linus/0056-ARM-pxa-fix-page-table-corruption-on-resume.patch \
                  file://linus/0057-atl1-fix-oops-when-changing-tx-rx-ring-params.patch \
                  file://linus/0058-bridge-fix-br_multicast_ipv6_rcv-for-paged-skbs.patch \
                  file://linus/0059-name_to_dev_t-must-not-call-__init-code.patch \
                  file://linus/0060-bridge-stp-ensure-mac-header-is-set.patch \
                  file://linus/0061-ima-fix-add-LSM-rule-bug.patch \
                  file://linus/0062-arch-mn10300-kernel-irq.c-fix-build.patch \
                  file://linus/0063-remove-trim_fs-method-from-Documentation-filesystems.patch \
                  file://linus/0064-ipv4-route.c-respect-prefsrc-for-local-routes.patch \
                  file://linus/0065-Linux-2.6.37.patch \
                  \
                  file://base/0001-omap3-beaglexm-fix-EHCI-power-up-GPIO-dir.patch \
                  file://base/0002-omap3-beaglexm-fix-DVI-reset-GPIO.patch \
                  file://base/0003-omap3-beaglexm-fix-power-on-of-DVI.patch \
                  file://base/0004-omap-Beagle-detect-new-xM-revision-B.patch \
                  file://base/0005-ARM-OMAP-beagleboard-Add-infrastructure-to-do-fixups.patch \
                  file://base/0006-ARM-OMAP-beagleboard-pre-export-GPIOs-to-userspace-w.patch \
                  file://base/0007-modedb.c-add-proper-720p60-mode.patch \
                  file://base/0008-mmc-don-t-display-single-block-read-console-messages.patch \
                  file://base/0009-MTD-silence-ecc-errors-on-mtdblock0.patch \
                  file://base/0010-Miracle-patch.patch \
                  file://base/0011-ARM-OMAP-add-omap_rev_-macros.patch \
                  file://base/0012-OMAP-DSS2-enable-hsclk-in-dsi_pll_init-for-OMAP36XX.patch \
                  file://base/0013-omap3-beagleboard-add-WIP-support-for-beagleboardtoy.patch \
                  file://base/0014-drivers-net-smsc911x-return-ENODEV-if-device-is-not-.patch \
                  file://base/0015-drivers-input-touchscreen-ads7846-return-ENODEV-if-d.patch \
                  file://base/0016-ASoC-enable-audio-capture-by-default-for-twl4030.patch \
                  file://base/0017-MFD-enable-madc-clock.patch \
                  file://base/0018-MFD-add-twl4030-madc-driver.patch \
                  file://base/0019-ARM-OMAP-Add-twl4030-madc-support-to-Overo.patch \
                  file://base/0020-ARM-OMAP-Add-twl4030-madc-support-to-Beagle.patch \
                  file://base/0021-OMAP-DSS2-Add-support-for-Samsung-LTE430WQ-F0C-panel.patch \
                  file://base/0022-OMAP-DSS2-Add-support-for-LG-Philips-LB035Q02-panel.patch \
                  file://base/0023-OMAP-DSS2-add-bootarg-for-selecting-svideo-or-compos.patch \
                  file://base/0024-ARM-OMAP2-mmc-twl4030-move-clock-input-selection-pri.patch \
                  file://base/0025-RTC-add-support-for-backup-battery-recharge.patch \
                  file://base/0026-ARM-OMAP-automatically-set-musb-mode-in-platform-dat.patch \
                  file://base/0027-OMAP-DSS2-check-for-both-cpu-type-and-revision-rathe.patch \
                  file://base/0028-OMAP-DSS2-Add-DSS2-support-for-Overo.patch \
                  \
                  file://dvfs/0001-OMAP3-PM-Adding-T2-enabling-of-smartreflex.patch \
                  file://dvfs/0002-OMAP-CPUfreq-ensure-driver-initializes-after-cpufreq.patch \
                  file://dvfs/0003-OMAP-CPUfreq-ensure-policy-is-fully-initialized.patch \
                  file://dvfs/0004-OMAP3-PM-CPUFreq-driver-for-OMAP3.patch \
                  file://dvfs/0005-OMAP-PM-CPUFREQ-Fix-conditional-compilation.patch \
                  file://dvfs/0006-OMAP-Introduce-a-user-list-for-each-voltage-domain-i.patch \
                  file://dvfs/0007-OMAP-Introduce-API-in-the-OPP-layer-to-find-the-opp-.patch \
                  file://dvfs/0008-OMAP-Introduce-API-to-register-a-device-with-a-volta.patch \
                  file://dvfs/0009-OMAP-Introduce-device-specific-set-rate-and-get-rate.patch \
                  file://dvfs/0010-OMAP-Voltage-layer-changes-to-support-DVFS.patch \
                  file://dvfs/0011-OMAP-Introduce-dependent-voltage-domain-support.patch \
                  file://dvfs/0012-OMAP-Introduce-device-scale.patch \
                  file://dvfs/0013-OMAP-Disable-smartreflex-across-DVFS.patch \
                  file://dvfs/0014-OMAP3-Introduce-custom-set-rate-and-get-rate-APIs-fo.patch \
                  file://dvfs/0015-OMAP3-Update-cpufreq-driver-to-use-the-new-set_rate-.patch \
                  file://dvfs/0016-OMAP3-Introduce-voltage-domain-info-in-the-hwmod-str.patch \
                  file://dvfs/0017-OMAP3-Add-voltage-dependency-table-for-VDD1.patch \
                  file://dvfs/0018-omap3-4-opp-make-omapx_opp_init-non-static.patch \
                  file://dvfs/0019-OMAP3-beagle-xm-enable-upto-1GHz-OPP.patch \
                  file://dvfs/0020-omap3-Add-basic-support-for-720MHz-part.patch \
                  \
                  file://new/0001-OMAP-Enable-Magic-SysRq-on-serial-console-ttyOx.patch \
                  \
                  file://wl1271/0001-wl12xx-Read-MAC-address-from-NVS-file-on-HW-startup.patch \
                  file://wl1271/0002-wl1271-11n-Support-Add-Definitions.patch \
                  file://wl1271/0003-wl1271-11n-Support-ACX-Commands.patch \
                  file://wl1271/0004-wl1271-11n-Support-functionality-and-configuration-a.patch \
                  file://wl1271/0005-wl1271-set-wl-vif-only-if-add_interface-succeeded.patch \
                  file://wl1271/0006-wl12xx-Unset-bssid-filter-ssid-and-bssid-from-firmwa.patch \
                  file://wl1271/0007-drivers-media-radio-wl128x-FM-Driver-common-header-f.patch \
                  file://wl1271/0008-drivers-media-radio-wl128x-FM-Driver-V4L2-sources.patch \
                  file://wl1271/0009-drivers-media-radio-wl128x-FM-Driver-Common-sources.patch \
                  file://wl1271/0010-drivers-media-radio-wl128x-FM-driver-RX-sources.patch \
                  file://wl1271/0011-drivers-media-radio-wl128x-FM-driver-TX-sources.patch \
                  file://wl1271/0012-drivers-media-radio-wl128x-Kconfig-Makefile-for-wl12.patch \
                  file://wl1271/0013-drivers-media-radio-Update-Kconfig-and-Makefile-for-.patch \
                  file://wl1271/0014-drivers-misc-ti-st-change-protocol-parse-logic.patch \
                  file://wl1271/0015-Bluetooth-btwilink-driver.patch \
                  \
                  file://media/0001-v4l-Share-code-between-video_usercopy-and-video_ioct.patch \
                  file://media/0002-v4l-subdev-Don-t-require-core-operations.patch \
                  file://media/0003-v4l-subdev-Merge-v4l2_i2c_new_subdev_cfg-and-v4l2_i2.patch \
                  file://media/0004-v4l-subdev-Add-device-node-support.patch \
                  file://media/0005-v4l-subdev-Uninline-the-v4l2_subdev_init-function.patch \
                  file://media/0006-v4l-subdev-Control-ioctls-support.patch \
                  file://media/0007-v4l-subdev-Events-support.patch \
                  file://media/0008-media-Media-device-node-support.patch \
                  file://media/0009-media-Media-device.patch \
                  file://media/0010-media-Entities-pads-and-links.patch \
                  file://media/0011-media-Entity-graph-traversal.patch \
                  file://media/0012-media-Entity-use-count.patch \
                  file://media/0013-media-Media-device-information-query.patch \
                  file://media/0014-media-Entities-pads-and-links-enumeration.patch \
                  file://media/0015-media-Links-setup.patch \
                  file://media/0016-media-Pipelines-and-media-streams.patch \
                  file://media/0017-v4l-Add-a-media_device-pointer-to-the-v4l2_device-st.patch \
                  file://media/0018-v4l-Make-video_device-inherit-from-media_entity.patch \
                  file://media/0019-v4l-Make-v4l2_subdev-inherit-from-media_entity.patch \
                  file://media/0020-v4l-Move-the-media-v4l2-mediabus.h-header-to-include.patch \
                  file://media/0021-v4l-Replace-enums-with-fixed-sized-fields-in-public-.patch \
                  file://media/0022-v4l-Rename-V4L2_MBUS_FMT_GREY8_1X8-to-V4L2_MBUS_FMT_.patch \
                  file://media/0023-v4l-Group-media-bus-pixel-codes-by-types-and-sort-th.patch \
                  file://media/0024-v4l-Create-v4l2-subdev-file-handle-structure.patch \
                  file://media/0025-v4l-subdev-Add-a-new-file-operations-class.patch \
                  file://media/0026-v4l-v4l2_subdev-pad-level-operations.patch \
                  file://media/0028-v4l-v4l2_subdev-userspace-format-API.patch \
                  file://media/0029-v4l-v4l2_subdev-userspace-frame-interval-API.patch \
                  file://media/0030-v4l-v4l2_subdev-userspace-crop-API.patch \
                  file://media/0031-v4l-subdev-Generic-ioctl-support.patch \
                  file://media/0032-v4l-Add-subdev-sensor-g_skip_frames-operation.patch \
                  file://media/0033-v4l-Include-linux-videodev2.h-in-media-v4l2-ctrls.h.patch \
                  file://media/0034-v4l-Fix-a-use-before-set-in-the-control-framework.patch \
                  file://media/0035-v4l-Add-8-bit-YUYV-on-16-bit-bus-and-SGRBG10-media-b.patch \
                  file://media/0036-v4l-Add-remaining-RAW10-patterns-w-DPCM-pixel-code-v.patch \
                  file://media/0037-v4l-Add-missing-12-bits-bayer-media-bus-formats.patch \
                  file://media/0038-v4l-Add-12-bits-bayer-pixel-formats.patch \
                  file://media/0039-ARM-OMAP3-Update-Camera-ISP-definitions-for-OMAP3630.patch \
                  file://media/0040-omap3-Remove-unusued-ISP-CBUFF-resource.patch \
                  file://media/0041-omap3-Add-function-to-register-omap3isp-platform-dev.patch \
                  file://media/0042-omap2-Fix-camera-resources-for-multiomap.patch \
                  file://media/0043-OMAP3-ISP-driver.patch \
                  "

SRC_URI_append_usrp-e1xx = "\
                  file://usrp/0001-Add-defines-to-set-config-options-in-GPMC-per-CS-con.patch \
                  file://usrp/0002-Add-functions-to-dma.c-to-set-address-and-length-for.patch \
                  file://usrp/0003-usrp-embedded-Add-driver-for-USRP-Embedded-FPGA-inte.patch \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"
