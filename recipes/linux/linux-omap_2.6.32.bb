require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm|omap3-pandora|overo|omapzoom|omapzoom2|omap4430-sdp|cm-t35"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_cm-t35 = "1"

SRCREV = "6833f1a8cdcb65a370f898bde6b6af63f81962df"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.32"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
file://sctp-fix.patch;patch=1 \
file://cm-t35/0001-omap3-cm-t35-add-mux-initialization.patch;patch=1 \
file://cm-t35/0001-OMAP-DSS2-add-Toppoly-TDO35S-panel.patch;patch=1 \
file://cm-t35/0002-omap3-cm-t35-add-DSS2-display-support.patch;patch=1 \
file://cm-t35/0003-omap3-cm-t35-update-defconfig-for-DSS2.patch;patch=1 \
file://cm-t35/0006-omap3-cm-t35-update-defconfig.patch;patch=1 \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"

