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

SRC_URI[md5sum] = "1094eee5062d9b9900c4b28bd68fb564"
SRC_URI[sha256sum] = "c6dc601e20bb43c94f5689f05bca8e8501af4cff9dd760afdb3d6998c6952c28"
