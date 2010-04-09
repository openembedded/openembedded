require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beagleboard|omap3evm|am3517-evm|dm3730-am3715-evm|omap3-touchbook|overo"

# This is the v2.6.32_OMAPPSP_03.00.00.05 branch
SRCREV = "7b8926aa626991fa087b00f6bbc1fb6b0e8269b0"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "+gitr${SRCREV}"

SRC_URI = "git://arago-project.org/git/people/sriram/ti-psp-omap.git;protocol=git;branch=master \
           file://0001-board-omap3touchbook-make-it-build-against-TI-linux-.patch;patch=1 \
           file://0002-ARM-OMAP-add-support-for-TCT-Zippy-to-Beagle-board-f.patch;patch=1 \
           file://0003-ARM-OMAP-Make-beagle-u-boot-partition-writable.patch;patch=1 \
           file://0004-board-omap3-beagle-add-DSS2-support.patch;patch=1 \
           file://0005-beagleboard-omap3_-foo-_rate_table-omap35x_-foo-_rat.patch;patch=1 \
           file://0006-board-omap3beagle-prepare-for-DM3730-based-Beagleboa.patch;patch=1 \
           file://0007-mt9t111-first-stab-at-merging-sensor-driver-based-on.patch;patch=1 \
           file://0008-board-omap3beagle-ugly-copy-paste-job-to-get-mt9p111.patch;patch=1 \
           file://0009-board-omap3beagle-turn-on-power-to-camera-on-boot-an.patch;patch=1 \
           file://0010-board-omap3beagle-update-omap34xxcam-to-more-recent-.patch;patch=1 \
           file://0011-ASoC-enable-audio-capture-by-default-for-twl4030.patch;patch=1 \
           file://0012-MTD-NAND-omap2-proper-fix-for-subpage-read-ECC-error.patch;patch=1 \
           file://0013-OMAP3630-DSS2-Enable-Pre-Multiplied-Alpha-Support.patch;patch=1 \
           file://0014-DSS2-add-bootarg-for-selecting-svideo-or-composite-f.patch;patch=1 \
           file://0015-ISP-add-some-more-from-Leopard-imaging-patch.patch;patch=1 \
           file://0016-ARM-OMAP-Overo-Add-support-for-second-ethernet-port.patch;patch=1 \
           file://0017-drivers-net-smsc911x-return-ENODEV-if-device-is-not-.patch;patch=1 \
           file://0018-drivers-input-touchscreen-ads7846-return-ENODEV-if-d.patch;patch=1 \
           file://0019-drivers-mfd-add-twl4030-madc-driver.patch;patch=1 \
           file://0020-ARM-OMAP-Add-missing-twl4030-madc-header-file.patch;patch=1 \
           file://0021-ARM-OMAP-Add-twl4030-madc-support-to-Overo.patch;patch=1 \
           file://0022-ARM-OMAP-Add-twl4030-madc-support-to-Beagle.patch;patch=1 \
           file://0023-netdev-rt73usb-add-vendor-device-ID-for-Ceiva-Wirele.patch;patch=1 \
           file://0024-mmc-don-t-display-single-block-read-console-messages.patch;patch=1 \
           file://0025-ARM-OMAP2-mmc-twl4030-move-clock-input-selection-pri.patch;patch=1 \
           file://0026-board-overo-add-PM-code-and-sync-with-http-www.sakom.patch;patch=1 \
           file://0027-twl4030-madc-adjust-for-twl4030-twl-api-changes.patch;patch=1 \
           file://0028-OMAP-DSS2-Re-add-support-for-Samsung-lte430wq-f0c-pa.patch;patch=1 \
           file://0029-OMAP-DSS2-Add-support-for-LG-Philips-LB035Q02-panel.patch;patch=1 \
           file://0030-Fix-for-bus-width-which-improves-SD-card-s-peformanc.patch;patch=1 \
           file://0031-ARM-VFP-add-support-to-sync-the-VFP-state-of-the-cur.patch;patch=1 \
           file://0032-ARM-VFP-preserve-the-HW-context-when-calling-signal-.patch;patch=1 \
           file://0033-Switch-SGX-clocks-to-200MHz-on-DM37xx-OMAP36xx.patch;patch=1 \
           file://0034-modedb.c-add-proper-720p60-mode.patch;patch=1 \
           file://0035-RTC-add-support-for-backup-battery-recharge.patch;patch=1 \
           file://0036-ARM-Add-prompt-for-CONFIG_ALIGNMENT_TRAP.patch;patch=1 \
           file://0037-ARM-Print-warning-on-alignment-trap-in-kernel-mode.patch;patch=1 \
           file://0038-ARM-Expose-some-CPU-control-registers-via-sysfs.patch;patch=1 \
           file://0039-ARM-Add-option-to-allow-userspace-PLE-access.patch;patch=1 \
           file://0040-ARM-Add-option-to-allow-userspace-access-to-performa.patch;patch=1 \
           file://0041-ARM-Expose-some-PMON-registers-through-sysfs.patch;patch=1 \
           file://0042-musb-allow-host-io-without-gadget-module.patch;patch=1 \
           file://defconfig"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

SRC_URI_append_omap3-touchbook = " \
                                  file://0001-ARM-OMAP-add-spi-platform-devices.patch;patch=1 \
                                  file://0002-MMA7455L-accelerometer-driver.patch;patch=1 \
                                  file://0003-bq27x00_battery-remove-error-message-output.patch;patch=1 \
                                  file://0004-bq27x00_battery-add-charged-gpio.patch;patch=1 \
                                  file://0005-adf7846-add-more-debugging.patch;patch=1 \
                                  file://0006-ads7846-read-max-mix-x-y-from-pdata.patch;patch=1 \
                                  file://0007-ads7846-add-settling-delay-to-pdata.patch;patch=1 \
                                  file://0008-DSS2-OMAPFB-Translate-X-Y-coordinates-for-the-video-.patch;patch=1 \
                                  file://0009-DSS2-fix-rotation-offsets.patch;patch=1 \
                                  file://0010-DSS2-Fix-scaling-checks-when-rotation-is-90-or-270-d.patch;patch=1 \
                                  file://0011-add-touchbook-hid-driver.patch;patch=1 \
                                  file://0012-Make-backlight-controls-accessible-to-users.patch;patch=1 \
                                  file://0013-ads7846-don-t-error-out-when-there-s-no-pendown-gpio.patch;patch=1 \
                                  file://0014-ASoC-add-driver-for-omap3-touchbook.patch;patch=1 \
                                  file://0015-backlight-add-PWM-support.patch;patch=1 \
                                  file://0016-ARM-OMAP-omap3-touchbook-update-boardfile.patch;patch=1 \
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

