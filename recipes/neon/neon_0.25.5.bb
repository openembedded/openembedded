DESCRIPTION = "neon is an HTTP and WebDAV client library, with a C interface."
HOMEPAGE = "http://www.webdav.org/neon"
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "zlib libxml2 expat time gnutls"

PR = "r4"

SRC_URI = "http://www.webdav.org/${PN}/${P}.tar.gz \
           file://gnutls-force-and-detect.patch;patch=1 \
           file://gnutls-2.patch;patch=1"

inherit autotools binconfig lib_package pkgconfig

EXTRA_OECONF = "--with-ssl=gnutls --with-libxml2 --with-expat --enable-shared"
EXTRA_AUTORECONF=" -I ${S}/macros "

do_stage() {
	autotools_stage_all
}
