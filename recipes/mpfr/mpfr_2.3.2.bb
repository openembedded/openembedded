require mpfr.inc

DEPENDS = "gmp"
PR = "r0"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.mpfr.org/mpfr-${PV}/mpfr-${PV}.tar.bz2"
S = "${WORKDIR}/mpfr-${PV}"

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "527147c097874340cb9cee0579dacf3b"
SRC_URI[sha256sum] = "18e078c996e182b7ceab32f2ab840e6a151b593e0cd5b83cb9d2960f212fba4c"
