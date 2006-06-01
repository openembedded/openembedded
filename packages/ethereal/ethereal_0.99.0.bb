DESCRIPTION = "Ethereal is the world's most popular network protocol analyzer"
HOMEPAGE = "http://www.ethereal.com"
SECTION = "x11/network"
LICENSE = "GPL"
DEPENDS = "perl-native gtk+ gnutls libpcap"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/ethereal/ethereal-${PV}.tar.bz2 \
           file://use-our-lemon.patch;patch=1"
S = "${WORKDIR}/ethereal-${PV}"

inherit autotools

do_compile_prepend() {
	${BUILD_CC} ${BUILD_CFLAGS} -o rdps rdps.c
	oe_runmake -C tools/lemon CC="${BUILD_CC} ${BUILD_CFLAGS}"
}

