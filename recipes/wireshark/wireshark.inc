HOMEPAGE = "http://www.wireshark.org"
SECTION = "network"
LICENSE = "GPL"
DEPENDS = "perl-native gnutls libpcap pcre expat glib-2.0 net-snmp"

SRC_URI = "${SOURCEFORGE_MIRROR}/wireshark/wireshark-${PV}.tar.bz2 \
           file://use-our-lemon.patch \
           file://acinclude-net-snmp-fix.patch \
           file://libtool-fix.patch \
	   file://no-host-includes.patch"

S=${WORKDIR}/wireshark-${PV}

inherit autotools

do_compile_prepend() {
	${BUILD_CC} ${BUILD_CFLAGS} -o rdps rdps.c
	oe_runmake -C tools/lemon CC="${BUILD_CC} ${BUILD_CFLAGS}" LDFLAGS="${BUILD_LDFLAGS}"
}

