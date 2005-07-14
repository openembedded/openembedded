DESCRIPTION = "A C library for multiple-precision floating-point \
	       computations with exact rounding"
LICENSE = "LGPL"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "libs"
PR = "r1"

DEPENDS = "gmp"

PV = "0.0cvs${CVSDATE}"
SRC_URI = "cvs://cvs:@cvs-sop.inria.fr/CVS/spaces;module=mpfr;method=pserver"
S = "${WORKDIR}/mpfr"

inherit autotools

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
