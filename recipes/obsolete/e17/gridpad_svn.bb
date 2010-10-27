DESCRIPTION = "Gridpad handstroke recognition"
SECTION = "x11"
LICENSE = "GPLv2"
DEPENDS = "ecore evas edje libfakekey"
PV = "2.0+svnr${SRCPV}"
PR = "r0"
SRCREV = "194"

SRC_URI = "svn://svn.om.vptt.ch/trunk/;proto=http;module=GridPad"
S = "${WORKDIR}/GridPad"

inherit autotools pkgconfig
