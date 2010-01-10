require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

FILESPATHPKG_prepend = "${PN}-2.6.32:"

COMPATIBLE_MACHINE = "omapzoom2"

DEFAULT_PREFERENCE = "-1"
#DEFAULT_PREFERENCE_omapzoom2 = "1"

LOBRANCH?= "master"

SRCREV = "69eb2b26cc8b4d0a0db963a100c02d1acbfd90eb"
OEV = "oe1"
PE = "1"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.31+2.6.32-rc7-${OEV}"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-omap3.git;branch=${LOBRANCH};protocol=http \
	   file://defconfig"

SRC_URI_append = " \
"

S = "${WORKDIR}/git"

PACKAGES =+ "omap-dss-doc"
FILES_omap-dss-doc = "/boot/DSS"


