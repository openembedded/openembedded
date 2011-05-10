require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "am3517-crane|beagleboard|omap3evm|am3517-evm|dm37x-evm|am37x-evm|omap3-touchbook|overo"

# This is on the master branch
SRCREV = "5fc29e7b2a76a64a739f857858ef0b98294aa155"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "c+gitr${SRCREV}"

SRC_URI = "git://arago-project.org/git/projects/linux-omap3.git;protocol=http;branch=master \
           file://0001-Added-Crane-Board-support.patch \
	   file://0001-Revert-omap3-beagle-Fix-compile-time-errors.patch \
           file://0002-board-omap3touchbook-make-it-build-against-TI-linux-.patch \
           file://0003-ARM-OMAP-add-support-for-TCT-Zippy-to-Beagle-board-f.patch \
           file://0004-ARM-OMAP-Make-beagle-u-boot-partition-writable.patch \
           file://0005-board-omap3-beagle-add-DSS2-support.patch \
           file://0006-board-omap3beagle-prepare-for-DM3730-based-Beagleboa.patch \
           file://0007-ARM-OMAP-beagleboard-Add-infrastructure-to-do-fixups.patch \
           file://0008-ARM-OMAP-beagleboard-pre-export-GPIOs-to-userspace-w.patch \
           file://0009-ARM-OMAP-beagleboard-initialize-ds1307-and-eeprom-on.patch \
           file://0010-ARM-OMAP-update-beagleboard-defconfig.patch \
           file://0011-ASoC-enable-audio-capture-by-default-for-twl4030.patch \
           file://0012-MTD-NAND-omap2-proper-fix-for-subpage-read-ECC-error.patch \
           file://0013-OMAP3630-DSS2-Enable-Pre-Multiplied-Alpha-Support.patch \
           file://0014-DSS2-add-bootarg-for-selecting-svideo-or-composite-f.patch \
           file://0015-ISP-add-some-more-from-Leopard-imaging-patch.patch \
           file://0016-ARM-OMAP-Overo-Add-support-for-second-ethernet-port.patch \
           file://0017-drivers-net-smsc911x-return-ENODEV-if-device-is-not-.patch \
           file://0018-drivers-input-touchscreen-ads7846-return-ENODEV-if-d.patch \
           file://0019-drivers-mfd-add-twl4030-madc-driver.patch \
           file://0020-ARM-OMAP-Add-missing-twl4030-madc-header-file.patch \
           file://0021-ARM-OMAP-Add-twl4030-madc-support-to-Overo.patch \
           file://0022-ARM-OMAP-Add-twl4030-madc-support-to-Beagle.patch \
           file://0023-netdev-rt73usb-add-vendor-device-ID-for-Ceiva-Wirele.patch \
           file://0024-mmc-don-t-display-single-block-read-console-messages.patch \
           file://0025-ARM-OMAP2-mmc-twl4030-move-clock-input-selection-pri.patch \
           file://0026-board-overo-add-PM-code-and-sync-with-http-www.sakom.patch \
           file://0027-twl4030-madc-adjust-for-twl4030-twl-api-changes.patch \
           file://0028-OMAP-DSS2-Re-add-support-for-Samsung-lte430wq-f0c-pa.patch \
           file://0029-OMAP-DSS2-Add-support-for-LG-Philips-LB035Q02-panel.patch \
           file://0030-Fix-for-bus-width-which-improves-SD-card-s-peformanc.patch \
           file://0031-ARM-VFP-add-support-to-sync-the-VFP-state-of-the-cur.patch \
           file://0032-ARM-VFP-preserve-the-HW-context-when-calling-signal-.patch \
           file://0033-Switch-SGX-clocks-to-200MHz-on-DM37xx-OMAP36xx.patch \
           file://0034-modedb.c-add-proper-720p60-mode.patch \
           file://0035-RTC-add-support-for-backup-battery-recharge.patch \
           file://0036-ARM-Add-prompt-for-CONFIG_ALIGNMENT_TRAP.patch \
           file://0037-ARM-Print-warning-on-alignment-trap-in-kernel-mode.patch \
           file://0038-ARM-Expose-some-CPU-control-registers-via-sysfs.patch \
           file://0039-ARM-Add-option-to-allow-userspace-PLE-access.patch \
           file://0040-ARM-Add-option-to-allow-userspace-access-to-performa.patch \
           file://0041-ARM-Expose-some-PMON-registers-through-sysfs.patch \
           file://0042-musb-allow-host-io-without-gadget-module.patch \
           file://0043-MTD-silence-ecc-errors-on-mtdblock0.patch \
           file://0044-ARM-OMAP-beagle-every-known-beagle-except-revB-uses-.patch \
           file://0045-ARM-OMAP-beagle-add-support-for-beagleFPGA-expansion.patch \
           file://cam/0001-mt9t111-first-stab-at-merging-sensor-driver-based-on.patch \
           file://cam/0002-mt9t111-Fix-all-checkpatch-errors.patch \
           file://cam/0003-mt9t111-Pass-v4l2_int_device-data.patch \
           file://cam/0004-omap3beagle-Add-camera-support.patch \
           file://cam/0005-TEMP-omap3beagle-camera-Add-defconfig.patch \
           file://cam/0006-omap3beagle-camera-Add-support-for-regulators.patch \
           file://cam/0007-TEMP-omap3beagle-cam-Enable-OMAP_MUX.patch \
           file://cam/0008-omap3beagle-camera-Fix-null-pointer-dereference.patch \
           file://cam/0009-Revert-TEMP-omap3beagle-cam-Enable-OMAP_MUX.patch \  
           file://cam/0010-omap3beagle-camera-Change-arch-late_initcall.patch \ 
           file://cam/0011-omap3beagle-camera-Move-i2c-registration-to-the-main.patch \
           file://cam/0012-ARM-OMAP3-make-camera-code-build-if-MT9T111-is-built.patch \
           file://cam/0013-DEBUG-omap3beagle-camera-Force-mode0-in-cam_xclka.patch \
           file://cam/0014-OMAP3-CLOCK-Add-capability-to-change-rate-of-dpll4_m.patch \
           file://cam/0015-Revert-DEBUG-omap3beagle-camera-Force-mode0-in-cam_x.patch \
           file://cam/0016-omap3beagle-camera-Fix-wrong-XCLKA-selection.patch \ 
           file://cam/0017-omap3isp-set-CAM_MCLK-to-172.8-MHz-allows-exact-9.6-.patch \
           file://cam/0018-Fix-Moved-MCLK-setting-to-the-board-file.patch \
           file://cam/0019-omap3isp-core-Do-smarter-MCLK-setting.patch \
           file://cam/0020-omap3beagle-camera-set-mclk-for-mt9t111.patch \
           file://cam/0021-mt9t111-Fix-max-supported-xclk.patch \
           file://cam/0022-omap3beagle-camera-Clarify-regulators-names.patch \
           file://cam/0023-omap3beagle-camera-Fix-powerup-sequence.patch \
           file://cam/0024-omap3beagle-camera-Change-vaux4-to-1.8v.patch \
           file://cam/0025-omap3beagle-camera-Rename-regulators-to-match-actual.patch \
           file://cam/0026-omap3beagle-camera-Complement-remainig-sensor-hw-con.patch \
           file://cam/0027-mt9t111-Fix-detect-function-retval-and-cleanup-print.patch \
           file://cam/0028-omap3beagle-camera-Set-padconf-settings-in-cam-init.patch \
           file://cam/0029-omap3beagle-camera-only-register-camera-driver-for-3.patch \
           file://cam/0030-WIP-mt9t111-Work-in-progress-for-camera-enablement.patch \
           file://cam/0031-BeagleXM-Cam-Add-support-for-MT9V113-VGA-Sensor.patch \
           file://cam/0032-MT9V113-Fixed-sensor-nitialization-issues.patch \
           file://cam/0033-mt9v113-Fix-wrong-active-widths.patch \
           file://cam/0034-omap3isp-Fix-Wrong-check-on-non-interlaced-sensor-on.patch \
           file://cam/0035-omap3isp-Fix-bad-YUV_BT-checks-in-datapath_config.patch \
           file://cam/0036-omap3isp-Set-vd_pol-to-0-by-default-on-all-cases.patch \
           file://cam/0037-omap3isp-ccdc-Set-datalines-to-10-for-YUV_SYNC.patch \
           file://cam/0038-omap3beagle-camera-Fix-parallel-i-f-settings.patch \
           file://cam/0039-omap3beagle-camera-Clean-up-Remove-unneccessary-code.patch \
           file://cam/0040-mt9v113-Clean-Up-Remove-unneccessary-code-printf.patch \
           file://cam/0041-MT9V113-Min-Max-clk-input-changed-as-per-the-spec.patch \
           file://cam/0042-omap3beagle-camera-Further-clode-cleanup.patch \
           file://cam/0043-mt9v113-Settings-from-Aptima-used-to-increase-FPS.patch \
           file://cam/0044-mt9v113-AE-param-tuned-to-get-28-30FPS.patch \
           file://cam/0045-omap3beagle-camera-Cleanup-of-boardfile.patch \
           file://cam/0046-omap3beagle-camera-Cleanup-regulator-usage.patch \
           file://cam/0047-omap3beagle-camera-Bring-back-mt9t111-support.patch \
           file://cam/0048-REMOVE-v4l2-Delete-MT9T111-sensor-driver.patch \
           file://cam/0049-V4L-DVB-13670-soc-camera-Add-mt9t112-camera-driver.patch \
           file://cam/0050-soc-camera-mt9t112-modify-exiting-conditions-from-st.patch \
           file://cam/0051-mt9t112-Migrate-from-soc_camera-to-v4l2-int-device.patch \
           file://cam/0052-mt9t112-Add-more-info-to-public-header.patch \
           file://cam/0053-mt9t112-Fix-null-pointer-kernel-bug.patch \
           file://cam/0054-DEBUG-omap3beagle-Add-MT9T112-to-defconfig.patch \
           file://cam/0055-omap3beagle-camera-Change-MT9T111-references-to-new-.patch \
           file://cam/0056-omap34xxcam-Fix-multi-pixel-format-negotiation.patch \
           file://cam/0057-SQUASH-omap3beagle-camera-Bring-back-mt9t111-support.patch \
           file://cam/0058-mt9t112-Do-init_camera-every-powerup.patch \
           file://cam/0059-omap3beagle-camera-Switch-flag-for-no-sensor-ISP.patch \
           file://cam/0060-mt9t112-Add-back-3MP-basesize.patch \
           file://cam/0061-mt9t112-Prepare-for-24MHz-EXTCLK-and-30-fps.patch \
           file://cam/0062-omap3beagle-camera-Prepare-24MHz-xclk-for-mt9t112.patch \
           file://cam/0063-mt9t112-Correct-register-settings-for-mt9t111-sensor.patch \
           file://cam/0064-mt9t112-Remove-smart-size-selection.patch \
           file://cam/0065-rtl8192su-remove-bogus-Kconfig-depend-on-PCI-and-add.patch \
           file://cam/0066-mt9t112-Add-Context-selection-to-configuration.patch \
           file://cam/0067-mt9t112-Disable-JPEG-in-Context-B.patch \
           file://cam/0068-mt9t112-Make-context-B-stream-unlimited-frames.patch \
           file://cam/0069-mt9t112-Fix-pll-p-dividers-abstraction.patch \
           file://cam/0070-mt9t112-Adjust-50-60Hz-flickering-settings.patch \
           file://cam/0071-mt9t112-Trigger-autofocus-at-the-end-of-context-swit.patch \
           file://cam/0072-omap3beagle-camera-Fix-dual-sensor-registration.patch \
           file://cam/0073-mt9v113-Fix-State-variable-handling.patch \
           file://cam/0074-Move-sensor-rest-to-after-applying-power.patch \
           file://cam/0075-omap3beagle-Add-camera-bootarg.patch \
           file://cam/5m03/0001-mt9p031-import-driver-from-https-github.com-Aptina-B.patch \
           file://0001-BeagleBoard-Adjust-USER-button-pin-for-xM.patch \
           file://0001-PSP-3.0.1.6-kernel-source-patched-with-OCF-Linux.patch \
           file://porches.patch \
           file://0001-OMAP3-craneboard-print-expansionboard-name-detected-.patch \
           file://0002-OMAP3-craneboard-add-support-for-TinCanTools-Trainer.patch \
           file://0001-ARM-6329-1-wire-up-sys_accept4-on-ARM.patch \
           file://defconfig"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
           file://beagleboard-xmc/0001-omap-Beagle-revision-detection.patch \
           file://beagleboard-xmc/0002-omap-Beagle-only-Cx-boards-use-pin-23-for-write-prot.patch \
           file://beagleboard-xmc/0003-omap-Beagle-no-gpio_wp-pin-connection-on-xM.patch \
           file://beagleboard-xmc/0004-omap3-beaglexm-fix-EHCI-power-up-GPIO-dir.patch \
           file://beagleboard-xmc/0005-omap3-beaglexm-fix-DVI-reset-GPIO.patch \
           file://beagleboard-xmc/0006-omap3-beaglexm-fix-power-on-of-DVI.patch \
           file://beagleboard-xmc/0007-beagleboard-hack-in-support-from-xM-rev-C.patch \
           file://beagleboard-xmc/0008-omap3-beagle-cleaned-up-board-revision-conditions.patch \
           file://cam/5m03/0002-board-omap3beagle-import-li5m03-driver-from-https-gi.patch \
"

SRC_URI_append_omap3-touchbook = " \
                                  file://0001-ARM-OMAP-add-spi-platform-devices.patch \
                                  file://0002-MMA7455L-accelerometer-driver.patch \
                                  file://0003-bq27x00_battery-remove-error-message-output.patch \
                                  file://0004-bq27x00_battery-add-charged-gpio.patch \
                                  file://0005-adf7846-add-more-debugging.patch \
                                  file://0006-ads7846-read-max-mix-x-y-from-pdata.patch \
                                  file://0007-ads7846-add-settling-delay-to-pdata.patch \
                                  file://0008-DSS2-OMAPFB-Translate-X-Y-coordinates-for-the-video-.patch \
                                  file://0009-DSS2-Fix-scaling-checks-when-rotation-is-90-or-270-d.patch \
                                  file://0010-add-touchbook-hid-driver.patch \
                                  file://0011-Make-backlight-controls-accessible-to-users.patch \
                                  file://0012-ads7846-don-t-error-out-when-there-s-no-pendown-gpio.patch \
                                  file://0013-ASoC-add-driver-for-omap3-touchbook.patch \
                                  file://0014-backlight-add-PWM-support.patch \
                                  file://0015-Forward-port-TWL4030-BCI-driver-from-2.6.29-to-2.6.3.patch \
                                  file://0016-ARM-OMAP-omap3-touchbook-update-boardfile.patch \
#                                 file://0017-ARM-OMAP-add-800MHz-OPP-and-remove-125MHz-one.patch \
"

addtask quiltfixup before do_patch after do_unpack
do_quiltfixup() {
	rm ${S}/.pc -rf
}

S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}/boot
	install -m 0644 Documentation/arm/OMAP/DSS ${D}/boot/
}

PACKAGES =+ "omap-dss-doc"
FILES_omap-dss-doc = "/boot/DSS"

