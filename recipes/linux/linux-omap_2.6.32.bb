require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm|omap3-pandora|overo|omapzoom|omapzoom2|omap4430-sdp"

DEFAULT_PREFERENCE = "-1"

SRCREV = "82f1d8f22f2c65e70206e40a6f17688bf64a892c"

FILESPATHPKG_prepend = "linux-omap-2.6.32:"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.31+2.6.32-rc8+gitr${SRCREV}"
#PV = "2.6.32"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
file://usb/ehci.patch;patch=1 \
"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"

