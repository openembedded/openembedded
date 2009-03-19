DESCRIPTION = "a unit test framework for C"
LICENSE = "LGPL"
PRIORITY = "optional"
SECTION = "devel"

PR ="r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/check/check-${PV}.tar.gz"
S = "${WORKDIR}/check-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF += "--enable-plain-docdir"

do_stage() {

	install -m 0644 ${S}/src/check.h ${STAGING_INCDIR}/check.h
	oe_libinstall -a -C src libcheck ${STAGING_LIBDIR}
}

