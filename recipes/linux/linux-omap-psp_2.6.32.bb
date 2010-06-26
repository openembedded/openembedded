require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beagleboard|omap3evm|am3517-evm|dm3730-am3715-evm|omap3-touchbook|overo"

# This is the v2.6.32_OMAPPSP_03.00.01.06 branch
SRCREV = "a6bad4464f985fdd3bed72e1b82dcbfc004d7869"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "+gitr${SRCREV}"

SRC_URI = "git://arago-project.org/git/people/sriram/ti-psp-omap.git;protocol=git;branch=master \
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
           file://defconfig"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
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

