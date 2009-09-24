require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omapzoom2"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_omapzoom2 = "1"

LOBRANCH?= "master"

SRCREV = "02b2ce47a93e32f3b4e26662d78a0f31a6ac37ab"
OEV = "oe1"
PE = "1"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.30+2.6.31-rc7-${OEV}"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-omap3.git;branch=${LOBRANCH};protocol=git \
	   file://defconfig"

SRC_URI_append = " \
"

S = "${WORKDIR}/git"

