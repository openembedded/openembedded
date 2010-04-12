DESCRIPTION = "neon is an HTTP and WebDAV client library, with a C interface."
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "zlib libxml2 expat time gnutls"
PR = "r2"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.webdav.org/${PN}/${P}.tar.gz"

inherit autotools binconfig lib_package pkgconfig

EXTRA_OECONF = "--with-ssl=gnutls --with-libxml2 --with-expat --enable-shared"
EXTRA_AUTORECONF=" -I ${S}/macros "

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "076072f11c5278f4c4b7de189ea1506e"
SRC_URI[sha256sum] = "76472e51576b42bfc129e487ae7dd3a5e1f1f380105b422fc14ee408e3a881df"
