DESCRIPTION = "tshark is the text based verion of wireshark - a popular network protocol analyzer"
HOMEPAGE = "http://www.ethereal.com"
SECTION = "network"
LICENSE = "GPL"
DEPENDS = "perl-native gnutls libpcap pcre expat"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
           file://use-our-lemon.patch;patch=1 \
	   file://no-host-includes.patch;patch=1"

S=${WORKDIR}/wireshark-${PV}

inherit autotools

EXTRA_OECONF = "--disable-wireshark"

do_compile_prepend() {
	${BUILD_CC} ${BUILD_CFLAGS} -o rdps rdps.c
	oe_runmake -C tools/lemon CC="${BUILD_CC} ${BUILD_CFLAGS}" LDFLAGS="${BUILD_LDFLAGS}"
}

