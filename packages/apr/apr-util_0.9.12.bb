DESCRIPTION = "Apache Portable Runtime (APR) companion library"
SECTION = "libs"
DEPENDS = "apr expat gdbm"
MAINTAINER = "Mustafa Yuecel <yuecelm@ee.ethz.ch>"
LICENSE = "Apache"
HOMEPAGE = "http://apr.apache.org"
PR = "r0"

SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.gz \
           file://gen_uri_delims.patch;patch=1 \
           file://uri_delims.h"

EXTRA_OECONF = "--with-apr=${STAGING_BINDIR} --with-dbm=gdbm --with-gdbm=${STAGING_DIR}/${HOST_SYS} --with-expat=${STAGING_DIR}/${HOST_SYS}"

inherit autotools lib_package binconfig

do_configure() {
	cp ${S}/../uri_delims.h ${S}/uri/. 
	oe_runconf
}

do_stage() {
	autotools_stage_all
}
