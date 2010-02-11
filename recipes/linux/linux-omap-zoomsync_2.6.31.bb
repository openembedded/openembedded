require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omapzoom2"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_omapzoom2 = "1"

LOBRANCH?= "master"

SRCREV = "da065810e5705b8ec32a9329ed10d31671df075a"
OEV = "oe3"
PE = "1"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.30+2.6.31-rc7-${OEV}"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-omap3.git;branch=${LOBRANCH};protocol=http \
	   file://logo_linux_clut224.ppm \
           file://defconfig"

SRC_URI_append = " \
"

S = "${WORKDIR}/git"

PACKAGES =+ "omap-dss-doc"
FILES_omap-dss-doc = "/boot/DSS"

