require mpfr.inc

DEPENDS = "gmp"
PR = "r1"

SRC_URI = "http://www.mpfr.org/mpfr-${PV}/mpfr-${PV}.tar.bz2 \
           file://long-long-thumb.patch;patch=1 \
	   file://dont_use_mips_h_constraint.patch;patch=1 \
	  "
S = "${WORKDIR}/mpfr-${PV}"

do_stage() {
	autotools_stage_all
}
