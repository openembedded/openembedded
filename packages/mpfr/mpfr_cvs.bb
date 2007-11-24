require mpfr.inc

DEPENDS = "gmp"
PV = "0.0+cvs${SRCDATE}"
PR = "r2"

SRC_URI = "cvs://cvs:@cvs-sop.inria.fr/CVS/spaces;module=mpfr;method=pserver"
S = "${WORKDIR}/mpfr"

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
