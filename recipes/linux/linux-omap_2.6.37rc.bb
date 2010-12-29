require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(beagleboard|overo|omap3evm|omap3-touchbook|usrp-e1xx)"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.36+2.6.37-rc7"
MACHINE_KERNEL_PR_append = "c+gitr${SRCREV}"
SRCREV = "7b6b2e84ada1eca268eac17a90f93fc6145f6146"

FILESPATHPKG_prepend = "linux-omap-2.6.37rc:"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
                  file://0001-ARM-OMAP-Power-on-EHCI-serial-camera-and-DVI-on-beag.patch \
                  file://0002-omap-Beagle-detect-new-xM-revision-B.patch \
                  file://0003-ARM-OMAP-beagleboard-Add-infrastructure-to-do-fixups.patch \
                  file://0004-ARM-OMAP-beagleboard-pre-export-GPIOs-to-userspace-w.patch \
                  file://0005-modedb.c-add-proper-720p60-mode.patch \
                  file://0006-mmc-don-t-display-single-block-read-console-messages.patch \
                  file://0007-MTD-silence-ecc-errors-on-mtdblock0.patch \
                  file://0008-Miracle-patch.patch \
                  file://0009-ARM-OMAP-add-omap_rev_-macros.patch \
                  file://0010-OMAP-DSS2-enable-hsclk-in-dsi_pll_init-for-OMAP36XX.patch \
                  file://0011-omap3-beagleboard-add-WIP-support-for-beagleboardtoy.patch \
                  file://0012-drivers-net-smsc911x-return-ENODEV-if-device-is-not-.patch \
                  file://0013-drivers-input-touchscreen-ads7846-return-ENODEV-if-d.patch \
                  file://0014-ASoC-enable-audio-capture-by-default-for-twl4030.patch \
                  file://0015-MFD-enable-madc-clock.patch \
                  file://0016-MFD-add-twl4030-madc-driver.patch \
                  file://0017-ARM-OMAP-Add-twl4030-madc-support-to-Overo.patch \
                  file://0018-ARM-OMAP-Add-twl4030-madc-support-to-Beagle.patch \
                  file://0019-OMAP-DSS2-Add-support-for-Samsung-LTE430WQ-F0C-panel.patch \
                  file://0020-OMAP-DSS2-Add-support-for-LG-Philips-LB035Q02-panel.patch \
                  file://0021-OMAP-DSS2-add-bootarg-for-selecting-svideo-or-compos.patch \
                  file://0022-ARM-OMAP2-mmc-twl4030-move-clock-input-selection-pri.patch \
                  file://0023-RTC-add-support-for-backup-battery-recharge.patch \
                  file://0024-ARM-OMAP-automatically-set-musb-mode-in-platform-dat.patch \
                  file://0025-OMAP-DSS2-check-for-both-cpu-type-and-revision-rathe.patch \
                  file://0026-OMAP-DSS2-Add-DSS2-support-for-Overo.patch \
"

SRC_URI_append_usrp-e1xx = "\
                  file://0027-Add-defines-to-set-config-options-in-GPMC-per-CS-con.patch \
                  file://0028-Add-functions-to-dma.c-to-set-address-and-length-for.patch \
                  file://0029-usrp-embedded-Add-driver-for-USRP-Embedded-FPGA-inte.patch \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

