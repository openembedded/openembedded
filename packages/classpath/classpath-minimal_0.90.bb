require classpath.inc

DEPENDS = "jikes-native zip-native"
RDEPENDS_${PBN}-minimal = "${PBN}-common (>= ${PV})"
RCONFLICTS_${PBN}-minimal = "${PBN}-gtk"

SRC_URI += "file://disable-automake-checks.patch;patch=1"

EXTRA_OECONF = "--with-jikes --without-x --with-glibj --disable-gtk-peer --disable-alsa"
