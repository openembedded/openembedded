require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(beagleboard|overo|omap3evm|omap3-touchbook|usrp-e1xx)"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.36+2.6.37-rc8"
MACHINE_KERNEL_PR_append = "a+gitr${SRCREV}"
SRCREV = "fa3b4e23ec20cfc944db7cc2b30b0d82c20e4472"

FILESPATHPKG_prepend = "linux-omap-2.6.37rc:"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
                  file://base/0001-ARM-OMAP-Power-on-EHCI-serial-camera-and-DVI-on-beag.patch \
                  file://base/0002-omap-Beagle-detect-new-xM-revision-B.patch \
                  file://base/0003-ARM-OMAP-beagleboard-Add-infrastructure-to-do-fixups.patch \
                  file://base/0004-ARM-OMAP-beagleboard-pre-export-GPIOs-to-userspace-w.patch \
                  file://base/0005-modedb.c-add-proper-720p60-mode.patch \
                  file://base/0006-mmc-don-t-display-single-block-read-console-messages.patch \
                  file://base/0007-MTD-silence-ecc-errors-on-mtdblock0.patch \
                  file://base/0008-Miracle-patch.patch \
                  file://base/0009-ARM-OMAP-add-omap_rev_-macros.patch \
                  file://base/0010-OMAP-DSS2-enable-hsclk-in-dsi_pll_init-for-OMAP36XX.patch \
                  file://base/0011-omap3-beagleboard-add-WIP-support-for-beagleboardtoy.patch \
                  file://base/0012-drivers-net-smsc911x-return-ENODEV-if-device-is-not-.patch \
                  file://base/0013-drivers-input-touchscreen-ads7846-return-ENODEV-if-d.patch \
                  file://base/0014-ASoC-enable-audio-capture-by-default-for-twl4030.patch \
                  file://base/0015-MFD-enable-madc-clock.patch \
                  file://base/0016-MFD-add-twl4030-madc-driver.patch \
                  file://base/0017-ARM-OMAP-Add-twl4030-madc-support-to-Overo.patch \
                  file://base/0018-ARM-OMAP-Add-twl4030-madc-support-to-Beagle.patch \
                  file://base/0019-OMAP-DSS2-Add-support-for-Samsung-LTE430WQ-F0C-panel.patch \
                  file://base/0020-OMAP-DSS2-Add-support-for-LG-Philips-LB035Q02-panel.patch \
                  file://base/0021-OMAP-DSS2-add-bootarg-for-selecting-svideo-or-compos.patch \
                  file://base/0022-ARM-OMAP2-mmc-twl4030-move-clock-input-selection-pri.patch \
                  file://base/0023-RTC-add-support-for-backup-battery-recharge.patch \
                  file://base/0024-ARM-OMAP-automatically-set-musb-mode-in-platform-dat.patch \
                  file://base/0025-OMAP-DSS2-check-for-both-cpu-type-and-revision-rathe.patch \
                  file://base/0026-OMAP-DSS2-Add-DSS2-support-for-Overo.patch \
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
                  \
                  file://dvfs/0001-omap3-add-support-for-720MHz-MPU-OPP.patch \
                  file://dvfs/0002-OMAP35x-Add-support-for-720MHz-part.patch \
                  file://dvfs/0003-OMAP3-beagle-C4-enable-upto-720MHz-OPP.patch \
                  file://dvfs/0004-OMAP3-Overo-Tide-enable-upto-720MHz-OPP.patch \
                 "

SRC_URI_append_usrp-e1xx = "\
                  file://usrp/0001-Add-defines-to-set-config-options-in-GPMC-per-CS-con.patch \
                  file://usrp/0002-Add-functions-to-dma.c-to-set-address-and-length-for.patch \
                  file://usrp/0003-usrp-embedded-Add-driver-for-USRP-Embedded-FPGA-inte.patch \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"
