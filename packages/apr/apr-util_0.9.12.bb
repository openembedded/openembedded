DESCRIPTION = "Apache Portable Runtime (APR) companion library"
SECTION = "libs"
DEPENDS = "apr expat gdbm"
LICENSE = "Apache"
HOMEPAGE = "http://apr.apache.org"
PR = "r1"

SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.gz \
           file://gen_uri_delims.patch;patch=1 \
           file://uri_delims.h"

EXTRA_OECONF = "--with-apr=${STAGING_BINDIR_CROSS} --with-dbm=gdbm --with-gdbm=${STAGING_DIR_HOST}${layout_prefix} --with-expat=${STAGING_DIR_HOST}${layout_prefix}"

inherit autotools lib_package binconfig

do_configure() {
	cp ${S}/../uri_delims.h ${S}/uri/.
	oe_runconf
}

do_stage() {
	autotools_stage_all
}
