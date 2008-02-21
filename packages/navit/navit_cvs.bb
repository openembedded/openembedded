require navit.inc

PV = "0.1.0+cvs${SRCDATE}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/navit"

SRC_URI = "cvs://anonymous@navit.cvs.sourceforge.net/cvsroot/navit;module=navit"

EXTRA_AUTORECONF = " -I m4"

