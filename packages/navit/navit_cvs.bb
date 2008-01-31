require navit.inc

PV = "0.0.3+cvs${SRCDATE}"
PR = "r4"

S = "${WORKDIR}/navit"

SRC_URI = "cvs://anonymous@navit.cvs.sourceforge.net/cvsroot/navit;module=navit"

EXTRA_AUTORECONF = " -I m4"

