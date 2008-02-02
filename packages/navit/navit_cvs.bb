require navit.inc

PV = "0.0.4+cvs${SRCDATE}"
PR = "r5"

S = "${WORKDIR}/navit"

SRC_URI = "cvs://anonymous@navit.cvs.sourceforge.net/cvsroot/navit;module=navit"

EXTRA_AUTORECONF = " -I m4"

