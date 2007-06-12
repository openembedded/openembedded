require classpath.inc

DEPENDS = "glib-2.0 gtk+ libart-lgpl pango libxtst jikes-native zip-native"
RDEPENDS_${PN} = "${PN}-common (${PV})"
PR = "r2"

SRC_URI = "${GNU_MIRROR}/${PN}/${P}.tar.gz \
           file://disable-automake-checks.patch;patch=1"

EXTRA_OECONF = "--with-jikes"
