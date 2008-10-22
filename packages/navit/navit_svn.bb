require navit.inc

PV = "0.1.0+svnrev${SRCREV}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/navit"

SRC_URI = "svn://anonymous@navit.svn.sourceforge.net/svnroot/navit/trunk;module=navit;proto=https"

EXTRA_AUTORECONF = " -I m4"
