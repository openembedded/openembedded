DESCRIPTION = "A library for accessing a CDDB server"
HOMEPAGE = "http://libcddb.sourceforge.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL-2"
MAINTAINER = "Andreas Frisch <andreas.frisch@multimedia-labs.de>"

SRC_URI = "http://downloads.sourceforge.net/${PN}/${PN}-${PV}.tar.bz2\
	    file://${P}-configure-realloc.patch;patch=1\
	    file://${P}-asneeded-nonglibc.patch;patch=1"

#EXTRA_OECONF = "--without-cdio --without-iconv"

inherit autotools pkgconfig

DEPEND="doc? ( app-doc/doxygen )"

do_stage () {
	oe_libinstall -so -C lib libcddb ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/cddb
	install -m 0644  ${S}/include/cddb/*.h ${STAGING_INCDIR}/cddb
}