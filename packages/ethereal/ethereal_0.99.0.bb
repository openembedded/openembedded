DESCRIPTION = "Ethereal is the world's most popular network protocol analyzer"
HOMEPAGE = "http://www.ethereal.com"
SECTION = "x11/network"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"

DEPENDS = "perl-native ethereal-native gtk+ libpcap"

SRC_URI = "${SOURCEFORGE_MIRROR}/ethereal/ethereal-${PV}.tar.bz2 \
           file://use-our-lemon.patch;patch=1"
S = "${WORKDIR}/ethereal-${PV}"

inherit autotools

do_compile_prepend() {
	ln -sf ${STAGING_BINDIR}/ethereal-rdps rdps
	ln -sf ${STAGING_BINDIR}/ethereal-lemon tools/lemon/lemon
}
