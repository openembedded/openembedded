DESCRIPTION = "A lightweight C++ based library for XMLRPC applications"
HOMEPAGE = "http://ulxmlrpcpp.sf.net"
LICENSE = "LGPL"
SECTION = "libs"
DEPENDS = "expat"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/ulxmlrpcpp/ulxmlrpcpp-${PV}-src.tar.bz2 \
           file://disable-docs.patch;patch=1 \
           file://remove-local-includes.patch;patch=1"

inherit autotools

do_configure_append() {
	echo "#define ulxr_snprintf   snprintf" >>ulxmlrpcpp/ulxmlrpcpp.h
}

do_stage() {
	autotools_stage_all
}

LEAD_SONAME = "libulxmlrpcpp.so"
PACKAGES =+ "${PN}-examples ${PN}-contrib"
FILES_${PN}-examples = "${bindir}/*"
FILES_${PN}-contrib = "${libdir}/*contrib.so.*"

SRC_URI[md5sum] = "7c5d849d8d1cd9ccfb4b90350145d503"
SRC_URI[sha256sum] = "0d568ff00cd45f73f3634723f8cb453f8bc952760cad3829bcbca88378a2ed83"
