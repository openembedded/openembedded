require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

FILESPATHPKG_prepend = "${PN}-2.6.32:"

COMPATIBLE_MACHINE = "omapzoom2|omapzoom36x"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_omapzoom2 = "1"
DEFAULT_PREFERENCE_omapzoom36x = "1"

SRCREV = "9925e5c0abf878314d98419320325470c9bbd03d"

OEV = "oe10"
PE = "2"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
PV = "2.6.32.7-${OEV}+gitr${SRCREV}"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-omap3.git;branch=master;protocol=git \
       file://0042-musb-allow-host-io-without-gadget-module.patch \
       file://rev.patch \
       file://logo_linux_clut224.ppm \
       file://defconfig"

S = "${WORKDIR}/git"

PACKAGES =+ "omap-dss-doc"
FILES_omap-dss-doc = "/boot/DSS"

