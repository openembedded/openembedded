require libmpc.inc

DEPENDS = "gmp mpfr"

SRC_URI = "http://www.multiprecision.org/mpc/download/mpc-${PV}.tar.gz"
S = "${WORKDIR}/mpc-${PV}"

do_stage() {
	autotools_stage_all
}
