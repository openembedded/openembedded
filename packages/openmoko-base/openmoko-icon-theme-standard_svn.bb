DESCRIPTION = "Standard Gtk+ icon theme for the OpenMoko distribution"
SECTION = "openmoko/base"
PV = "0.0+svn${SRCDATE}"
PR = "r0"

inherit openmoko-base autotools

SRC_URI = "${OPENMOKO_MIRROR}/src/target/${OPENMOKO_RELEASE}/artwork;module=icons;proto=http"
S = "${WORKDIR}/icons"

PACKAGE_ARCH = "all"
