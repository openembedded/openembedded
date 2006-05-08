DESCRIPTION = "A lightweight C++ based library for XMLRPC applications"
HOMEPAGE = "http://ulxmlrpcpp.sf.net"
LICENSE = "LGPL"
SECTION = "libs"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "expat"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/ulxmlrpcpp/ulxmlrpcpp-${PV}-src.tar.bz2 \
           file://disable-docs.patch;patch=1"

inherit autotools

do_configure_prepend() {
	install -d config
	touch config/lib-prefix.m4 config/lib-link.m4 config/lib-ld.m4
}

LEAD_SONAME = "libulxmlrpcpp.so"
PACKAGES =+ "${PN}-examples ${PN}-contrib"
FILES_${PN}-examples = "${bindir}"
FILES_${PN}-contrib = "${libdir}/*contrib*"

