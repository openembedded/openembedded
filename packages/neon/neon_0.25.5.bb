DESCRIPTION = "neon is an HTTP and WebDAV client library, with a C interface."
HOMEPAGE = "http://www.webdav.org/neon"
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "zlib libxml2 expat time"

PR = "r0"

SRC_URI = "http://be.lunar-linux.org/lunar/cache/neon-${PV}.tar.gz"

inherit autotools binconfig lib_package

EXTRA_OECONF = "--without-ssl --with-libxml2 --with-expat --enable-shared"

do_stage() {
	autotools_stage_all
}
