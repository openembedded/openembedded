LICENSE = "LGPL"
HOMEPAGE = "http://darcs.0x539.de/trac/obby/cgi-bin/trac.cgi/wiki/"

DEPENDS = "net6 gtkmm gmp"
inherit autotools pkgconfig

SRC_URI = "http://releases.0x539.de/obby/obby-${PV}.tar.gz"

EXTRA_OECONF += " --with-libgmp-prefix=${STAGING_LIBDIR}"

do_stage() {
	install -d ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/obby
	install -d ${STAGING_INCDIR}/obby/serialise
	install -m 644 inc/*.hpp ${STAGING_INCDIR}/obby
	install -m 644 inc/serialise/*.hpp ${STAGING_INCDIR}/obby/serialise
	install -m 755 src/.libs/*so* ${STAGING_LIBDIR}/
}
