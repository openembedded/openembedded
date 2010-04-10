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

SRC_URI[md5sum] = "79ea8c9cfa4025e93fb12d98befd37b6"
SRC_URI[sha256sum] = "9d5e27f290bbb954d512f37912d39a94ae03536a7ba3ef4dacec4df5f2476f47"
