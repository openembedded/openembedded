require oprofile.inc

PV = "0.9.3+cvs${SRCDATE}"
PR = "r2"

RDEPENDS += "binutils-symlinks"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://anonymous@oprofile.cvs.sourceforge.net/cvsroot/oprofile;module=oprofile \
           file://opstart.patch;patch=1 \
	   file://acinclude.m4"

S = "${WORKDIR}/oprofile"
