DESCRIPTION = "neon is an HTTP and WebDAV client library, with a C interface."
HOMEPAGE = "http://www.webdav.org/neon"
SECTION = "libs"
LICENSE = "LGPLv2+"
DEPENDS = "zlib libxml2 expat time gnutls"

PR = "r5"

SRC_URI = "http://www.webdav.org/${PN}/${P}.tar.gz \
           file://gnutls-force-and-detect.patch \
           file://gnutls-2.patch"

inherit autotools binconfig lib_package pkgconfig

EXTRA_OECONF = "--with-ssl=gnutls --with-libxml2 --with-expat --enable-shared --without-gssapi"
EXTRA_AUTORECONF=" -I ${S}/macros "

SRC_URI[md5sum] = "b5fdb71dd407f0a3de0f267d27c9ab17"
SRC_URI[sha256sum] = "b5513f88cb54c5f11e4c8348ee6c7ace9767b45c263c3a3ba8a5ce4e2b40a07a"
