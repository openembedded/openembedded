DESCRIPTION = "Apache Portable Runtime (APR) library"
SECTION = "libs"
LICENSE = "Apache"
HOMEPAGE = "http://apr.apache.org"
PR = "r1"

SRC_URI = "${APACHE_MIRROR}/apr/apr-${PV}.tar.bz2"

inherit autotools lib_package binconfig

do_configure() {
	oe_runconf
}

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "63fef787c263bd8025c6ab6a6cecdd01"
SRC_URI[sha256sum] = "cd1da2119dd812127ab6e6e8cbb954d9b74fe01ec744364ba79c9845865ffdaa"
