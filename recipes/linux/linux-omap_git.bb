require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm|omap3-pandora|overo|omapzoom"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_omapzoom2 = "1"

SRCREV = "fd673394fa970fb82e4bc206e171c58995d0c2ba"

FILESPATHPKG_prepend = "linux-omap-2.6.31:"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.30+2.6.31-rc5+gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
"

S = "${WORKDIR}/git"

module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"

