DESCRIPTION = "Simple dialpad keyboard"
SECTION = "x11"
LICENSE = "GPLv2"
DEPENDS = "ecore evas edje libfakekey"
PV = "0.1.4+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://svn.om.vptt.ch/trunk/;proto=http;module=bubble-keyboard"
S = "${WORKDIR}/bubble-keyboard"

inherit autotools pkgconfig
