require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omapzoom2"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_omapzoom2 = "1"

SRCREV = "1e5ddc5d409f25652fe99064f22c0aa75bc9b7b3"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.29"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://android.git.kernel.org/kernel/omap;branch=android-omap-2.6.29;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
"

S = "${WORKDIR}/git"

