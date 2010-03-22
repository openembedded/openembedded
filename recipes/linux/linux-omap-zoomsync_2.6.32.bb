require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

FILESPATHPKG_prepend = "${PN}-2.6.32:"

COMPATIBLE_MACHINE = "omapzoom2|omapzoom36x"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_omapzoom2 = "1"

SRCREV_omapzoom2 = "015cbaf1035cd9a61d33a27de2a22902555db3c5"

SRCREV_omapzoom36x = "2e3c681c6228de2a3f8fbb0cfbc940e7ea825a09"

OEV = "oe5"
PE = "1"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV_omapzoom2 = "2.6.32.7-${OEV}"
PV_omapzoom36x = "2.6.32-rc7-${OEV}"

PR_append = "+gitr${SRCREV}"

SRC_URI_omapzoom2 = "git://dev.omapzoom.org/pub/scm/integration/kernel-omap3.git;branch=master;protocol=git \
	   file://logo_linux_clut224.ppm \
	   file://defconfig"

SRC_URI_omapzoom36x = "git://dev.omapzoom.org/pub/scm/integration/kernel-omap3.git;branch=L23.I3.3;protocol=git \
	   file://logo_linux_clut224.ppm \
	   file://defconfig"

SRC_URI_append = " \
"

S = "${WORKDIR}/git"

PACKAGES =+ "omap-dss-doc"
FILES_omap-dss-doc = "/boot/DSS"


