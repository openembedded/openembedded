require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm|omap3-pandora|overo|omapzoom|omapzoom2|omap4430-sdp|cm-t35"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_cm-t35 = "1"

SRCREV = "89c9eaeb92c97348dcabd6cb377b646c00855f6a"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.32"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
file://usb/ehci.patch;patch=1 \
file://usb/ehci-omap.c-mach-to-plat.diff;patch=1 \
file://cm-t35/0001-omap3-cm-t35-add-mux-initialization.patch;patch=1 \
file://cm-t35/0001-OMAP-DSS2-add-Toppoly-TDO35S-panel.patch;patch=1 \
file://cm-t35/0002-omap3-cm-t35-add-DSS2-display-support.patch;patch=1 \
file://cm-t35/0003-omap3-cm-t35-update-defconfig-for-DSS2.patch;patch=1 \
file://cm-t35/0004-omap3-cm-t35-add-cm-t35-mux-configs.patch;patch=1 \
file://cm-t35/0006-omap3-cm-t35-update-defconfig.patch;patch=1 \
file://cm-t35/0001-backlight-tdo24m-ensure-chip-select-changes-between-.patch;patch=1 \
file://0001-ARM-OMAP-Overo-Add-support-for-second-ethernet-po.patch;patch=1 \
file://0003-drivers-net-smsc911x-return-ENODEV-if-device-is-n.patch;patch=1 \
file://0004-drivers-input-touchscreen-ads7846-return-ENODEV.patch;patch=1 \
file://0005-ARM-OMAP-add-support-for-TCT-Zippy-to-Beagle-board.patch;patch=1 \
file://0006-ARM-OMAP-Make-beagle-u-boot-partition-writable.patch;patch=1 \
file://0007-ASoC-enable-audio-capture-by-default-for-twl4030.patch;patch=1 \
file://0009-MTD-NAND-omap2-proper-fix-for-subpage-read-ECC-error.patch;patch=1 \
file://madc/0009-drivers-mfd-add-twl4030-madc-driver.patch;patch=1 \
file://madc/0010-ARM-OMAP-Add-twl4030-madc-support-to-Overo.patch;patch=1 \
file://madc/0011-ARM-OMAP-Add-twl4030-madc-support-to-Beagle.patch;patch=1 \
file://madc/0013-ARM-OMAP-Add-missing-twl4030-madc-header-file.patch;patch=1 \
file://dss2/0012-OMAP-DSS2-Add-support-for-LG-Philips-LB035Q02-pane.patch;patch=1 \
file://dss2/0014-OMAP-DSS-Add-DSS2-support-for-Overo.patch;patch=1 \
file://dss2/0015-OMAP-DSS-Add-DSS2-support-for-Beagle.patch;patch=1 \
file://dss2/0016-video-add-timings-for-hd720.patch;patch=1 \
file://holes.patch;patch=1 \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"

