DESCRIPTION = "Gadu-Gadu protocol instant messaging client"
DESCRIPTION_libgadu = "gadu-gadu protocol instant messaging libs"
HOMEPAGE = "http://ekg.chmurka.net/"
SECTION = "console/network"
LICENSE = "GPL LGPL"

SRC_URI = "http://ekg.chmurka.net/${PN}-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--enable-shared --without-c99-vsnprintf"

PACKAGES =+ "libgadu"

FILES_${PN} = "${bindir}/${PN} ${datadir}/${PN}/* ${datadir}/${PN}/themes/*"
FILES_libgadu = "${libdir}/libgadu.so*"
