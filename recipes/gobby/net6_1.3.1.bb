LICENSE = "LGPL"
HOMEPAGE = "http://darcs.0x539.de/trac/obby/cgi-bin/trac.cgi/wiki/"

DEPENDS = "libsigc++-2.0 gnutls"
inherit autotools pkgconfig

SRC_URI = "http://releases.0x539.de/${PN}/${P}.tar.gz"

do_stage() {
	install -d ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/net6
	install -m 644 inc/*.hpp ${STAGING_INCDIR}/net6
	install -m 755 .libs/*so* ${STAGING_LIBDIR}/
}
