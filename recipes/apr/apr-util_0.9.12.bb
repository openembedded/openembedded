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

SRC_URI[md5sum] = "8e9cc71a1303b67b3278fbeab9799f2e"
SRC_URI[sha256sum] = "5768fcc4d38fa6f811b0a89e2ef450d0f52688ff9263e548819adb096fbfc9c3"
