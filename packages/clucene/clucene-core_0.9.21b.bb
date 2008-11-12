DESCRIPTION = "CLucene is a C++ port of Lucene: the high-performance, \
full-featured text search engine written in Java."
HOMEPAGE = "http://clucene.sf.net"
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "libtool"

SRC_URI = "${SOURCEFORGE_MIRROR}/clucene/clucene-core-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--disable-multithreading dps_static_const_type=2"

do_configure() {
	gnu-configize
	cp ${STAGING_DATADIR}/libtool/config.sub ${S}/config
	oe_runconf
}

do_stage() {
	autotools_stage_all
}

FILES_${PN}-dev += "${libdir}/CLucene"
