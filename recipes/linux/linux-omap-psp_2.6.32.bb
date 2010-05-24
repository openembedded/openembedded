require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beagleboard|omap3evm|am3517-evm|dm3730-am3715-evm|omap3-touchbook|overo"

# This is the v2.6.32_OMAPPSP_03.00.01.06 branch
SRCREV = "627293ad28604b22612f9a4a318f64cfab241e22"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "+gitr${SRCREV}"

SRC_URI = "git://arago-project.org/git/people/sriram/ti-psp-omap.git;protocol=git;branch=master \
           file://0001-Revert-omap3-beagle-Fix-compile-time-errors.patch;apply=yes \
           file://0002-board-omap3touchbook-make-it-build-against-TI-linux-.patch;apply=yes \
           file://0003-ARM-OMAP-add-support-for-TCT-Zippy-to-Beagle-board-f.patch;apply=yes \
           file://0004-ARM-OMAP-Make-beagle-u-boot-partition-writable.patch;apply=yes \
           file://0005-board-omap3-beagle-add-DSS2-support.patch;apply=yes \
           file://0006-board-omap3beagle-prepare-for-DM3730-based-Beagleboa.patch;apply=yes \
           file://0007-ARM-OMAP-beagleboard-Add-infrastructure-to-do-fixups.patch;apply=yes \
           file://0008-ARM-OMAP-beagleboard-pre-export-GPIOs-to-userspace-w.patch;apply=yes \
           file://0009-ARM-OMAP-beagleboard-initialize-ds1307-and-eeprom-on.patch;apply=yes \
           file://0010-ARM-OMAP-update-beagleboard-defconfig.patch;apply=yes \
           file://0011-ASoC-enable-audio-capture-by-default-for-twl4030.patch;apply=yes \
           file://0012-MTD-NAND-omap2-proper-fix-for-subpage-read-ECC-error.patch;apply=yes \
           file://0013-OMAP3630-DSS2-Enable-Pre-Multiplied-Alpha-Support.patch;apply=yes \
           file://0014-DSS2-add-bootarg-for-selecting-svideo-or-composite-f.patch;apply=yes \
           file://0015-ISP-add-some-more-from-Leopard-imaging-patch.patch;apply=yes \
           file://0016-ARM-OMAP-Overo-Add-support-for-second-ethernet-port.patch;apply=yes \
           file://0017-drivers-net-smsc911x-return-ENODEV-if-device-is-not-.patch;apply=yes \
           file://0018-drivers-input-touchscreen-ads7846-return-ENODEV-if-d.patch;apply=yes \
           file://0019-drivers-mfd-add-twl4030-madc-driver.patch;apply=yes \
           file://0020-ARM-OMAP-Add-missing-twl4030-madc-header-file.patch;apply=yes \
           file://0021-ARM-OMAP-Add-twl4030-madc-support-to-Overo.patch;apply=yes \
           file://0022-ARM-OMAP-Add-twl4030-madc-support-to-Beagle.patch;apply=yes \
           file://0023-netdev-rt73usb-add-vendor-device-ID-for-Ceiva-Wirele.patch;apply=yes \
           file://0024-mmc-don-t-display-single-block-read-console-messages.patch;apply=yes \
           file://0025-ARM-OMAP2-mmc-twl4030-move-clock-input-selection-pri.patch;apply=yes \
           file://0026-board-overo-add-PM-code-and-sync-with-http-www.sakom.patch;apply=yes \
           file://0027-twl4030-madc-adjust-for-twl4030-twl-api-changes.patch;apply=yes \
           file://0028-OMAP-DSS2-Re-add-support-for-Samsung-lte430wq-f0c-pa.patch;apply=yes \
           file://0029-OMAP-DSS2-Add-support-for-LG-Philips-LB035Q02-panel.patch;apply=yes \
           file://0030-Fix-for-bus-width-which-improves-SD-card-s-peformanc.patch;apply=yes \
           file://0031-ARM-VFP-add-support-to-sync-the-VFP-state-of-the-cur.patch;apply=yes \
           file://0032-ARM-VFP-preserve-the-HW-context-when-calling-signal-.patch;apply=yes \
           file://0033-Switch-SGX-clocks-to-200MHz-on-DM37xx-OMAP36xx.patch;apply=yes \
           file://0034-modedb.c-add-proper-720p60-mode.patch;apply=yes \
           file://0035-RTC-add-support-for-backup-battery-recharge.patch;apply=yes \
           file://0036-ARM-Add-prompt-for-CONFIG_ALIGNMENT_TRAP.patch;apply=yes \
           file://0037-ARM-Print-warning-on-alignment-trap-in-kernel-mode.patch;apply=yes \
           file://0038-ARM-Expose-some-CPU-control-registers-via-sysfs.patch;apply=yes \
           file://0039-ARM-Add-option-to-allow-userspace-PLE-access.patch;apply=yes \
           file://0040-ARM-Add-option-to-allow-userspace-access-to-performa.patch;apply=yes \
           file://0041-ARM-Expose-some-PMON-registers-through-sysfs.patch;apply=yes \
           file://0042-musb-allow-host-io-without-gadget-module.patch;apply=yes \
           file://0043-MTD-silence-ecc-errors-on-mtdblock0.patch;apply=yes \
           file://0044-ARM-OMAP-beagle-every-known-beagle-except-revB-uses-.patch;apply=yes \
           file://defconfig"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

SRC_URI_append_omap3-touchbook = " \
                                  file://0001-ARM-OMAP-add-spi-platform-devices.patch;apply=yes \
                                  file://0002-MMA7455L-accelerometer-driver.patch;apply=yes \
                                  file://0003-bq27x00_battery-remove-error-message-output.patch;apply=yes \
                                  file://0004-bq27x00_battery-add-charged-gpio.patch;apply=yes \
                                  file://0005-adf7846-add-more-debugging.patch;apply=yes \
                                  file://0006-ads7846-read-max-mix-x-y-from-pdata.patch;apply=yes \
                                  file://0007-ads7846-add-settling-delay-to-pdata.patch;apply=yes \
                                  file://0008-DSS2-OMAPFB-Translate-X-Y-coordinates-for-the-video-.patch;apply=yes \
                                  file://0009-DSS2-Fix-scaling-checks-when-rotation-is-90-or-270-d.patch;apply=yes \
                                  file://0010-add-touchbook-hid-driver.patch;apply=yes \
                                  file://0011-Make-backlight-controls-accessible-to-users.patch;apply=yes \
                                  file://0012-ads7846-don-t-error-out-when-there-s-no-pendown-gpio.patch;apply=yes \
                                  file://0013-ASoC-add-driver-for-omap3-touchbook.patch;apply=yes \
                                  file://0014-backlight-add-PWM-support.patch;apply=yes \
                                  file://0015-Forward-port-TWL4030-BCI-driver-from-2.6.29-to-2.6.3.patch;apply=yes \
                                  file://0016-ARM-OMAP-omap3-touchbook-update-boardfile.patch;apply=yes \
#                                 file://0017-ARM-OMAP-add-800MHz-OPP-and-remove-125MHz-one.patch;apply=yes \
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

