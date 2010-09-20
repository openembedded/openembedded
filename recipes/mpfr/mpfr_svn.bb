require mpfr.inc

DEPENDS = "gmp"
PV = "0.0+svn${SRCDATE}"
PR = "${INC_PR}.0"

SRC_URI = "svn://scm.gforge.inria.fr/svn/mpfr;module=trunk"
S = "${WORKDIR}/trunk"

EXTRA_OECONF_append_virtclass-native = " --enable-static"
