require oprofile.inc

SRCDATE = "20080210"
PV = "0.9.4+cvs${SRCDATE}"
PR = "r4"

RDEPENDS_${PN} += "binutils-symlinks"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://anonymous@oprofile.cvs.sourceforge.net/cvsroot/oprofile;module=oprofile \
           file://opstart.patch \
	   file://acinclude.m4"

S = "${WORKDIR}/oprofile"
