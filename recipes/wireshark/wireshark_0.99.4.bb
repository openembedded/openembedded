DESCRIPTION = "Ethereal is the world's most popular network protocol analyzer"
HOMEPAGE = "http://www.ethereal.com"
SECTION = "x11/network"
LICENSE = "GPL"
DEPENDS = "perl-native gtk+ gnutls libpcap pcre expat"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
           file://use-our-lemon.patch;patch=1 \
	   file://no-host-includes.patch;patch=1"

inherit autotools

do_compile_prepend() {
	${BUILD_CC} ${BUILD_CFLAGS} -o rdps rdps.c
	oe_runmake -C tools/lemon CC="${BUILD_CC} ${BUILD_CFLAGS}" LDFLAGS="${BUILD_LDFLAGS}"
}

FILES_${PN}-dbg += "${libdir}/wireshark/plugins/${PV}/.debug"


