require mpfr.inc

DEPENDS = "gmp"
PV = "0.0+svn${SRCDATE}"
PR = "r3"

SRC_URI = "svn://scm.gforge.inria.fr/svn/mpfr;module=trunk"
S = "${WORKDIR}/trunk"

do_stage() {
	autotools_stage_all
}
