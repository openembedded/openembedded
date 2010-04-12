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

SRC_URI[md5sum] = "8352b619e04dcc73411a38b39dd855f6"
SRC_URI[sha256sum] = "d857f9df4a6cf50d0bc57dd11296dd1a8d1ac709442875ea4fcd757a89da8430"
