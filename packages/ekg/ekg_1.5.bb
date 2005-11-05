DESCRIPTION = "gadu-gadu protocol instant messaging client"
DESCRIPTION_libgadu = "gadu-gadu protocol instant messaging libs"
MAINTAINER = "Maciej Swiniarski <luzik@gda.pl>"
LICENSE = "GPL"
HOMEPAGE = "http://dev.null.pl/ekg/"
SECTION = "console/network"

SRC_URI = "http://dev.null.pl/${PN}/${PN}-${PV}.tar.gz"

EXTRA_OECONF = "--enable-shared --without-c99-vsnprintf"

inherit autotools

PACKAGES =+ "libgadu"

FILES_${PN} = "${bindir}/${PN} ${datadir}/${PN}/* ${datadir}/${PN}/themes/*"

FILES_libgadu = "${libdir}/libgadu.so*"
