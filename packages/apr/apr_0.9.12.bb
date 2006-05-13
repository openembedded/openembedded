DESCRIPTION = "Apache Portable Runtime (APR) library"
SECTION = "libs"
MAINTAINER = "Mustafa Yuecel <yuecelm@ee.ethz.ch>"
LICENSE = "Apache"
HOMEPAGE = "http://apr.apache.org"
PR = "r0"

SRC_URI = "${APACHE_MIRROR}/apr/apr-${PV}.tar.bz2"

inherit autotools lib_package binconfig

do_configure() {
	oe_runconf
}

do_stage() {
	autotools_stage_all
}
