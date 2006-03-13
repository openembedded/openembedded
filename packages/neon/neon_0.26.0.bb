DESCRIPTION = "neon is an HTTP and WebDAV client library, with a C interface."
SECTION = "base"
LICENSE = "LGPL"
DEPENDS = "zlib libxml2 expat time gnutls"

PR = "r0"

DEFAULT_PREFERENCES = "-1"

SRC_URI = "http://www.webdav.org/${PN}/${P}.tar.gz"

inherit autotools binconfig lib_package

EXTRA_OECONF = "--with-ssl=gnutls --with-libxml2 --with-expat --enable-shared"

do_stage () {
	autotools_stage_includes
	oe_libinstall -C src -so -a libneon ${STAGING_LIBDIR}/
}
