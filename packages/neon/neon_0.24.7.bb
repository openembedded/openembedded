inherit autotools

DEPENDS = "zlib libxml2 expat"
SECTION = "base"
LICENSE = "LGPL"
DESCRIPTION = "neon is an HTTP and WebDAV client library, with a C interface."
PR = "r1"

SRC_URI = "http://www.webdav.org/neon/neon-0.24.7.tar.gz \
	   file://no-func-checks.patch;patch=1"

EXTRA_OECONF = " --without-ssl --with-libxml2 --with-expat \
		 --enable-shared --enable-static"

do_stage () {
	autotools_stage_includes
	oe_libinstall -C src -so -a libneon ${STAGING_LIBDIR}/
}
