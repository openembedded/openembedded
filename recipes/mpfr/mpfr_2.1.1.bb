require mpfr.inc

DEPENDS = "gmp"
PR = "r3"

SRC_URI = "http://www.mpfr.org/mpfr-${PV}/mpfr-${PV}.tar.bz2"
S = "${WORKDIR}/mpfr-${PV}"

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "843422d90349800ee721f6710d051c87"
SRC_URI[sha256sum] = "df551fb075d5e6d0824b74d231962cf0e104c43f646e233675d952ef3c03debc"
