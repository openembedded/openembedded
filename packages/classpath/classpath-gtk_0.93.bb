require classpath.inc

DEPENDS = "glib-2.0 gtk+ cairo gconf libart-lgpl pango libxtst jikes-native zip-native"
RDEPENDS_${PN} = "classpath-common (>= ${PV})"
RCONFLICTS_${PN} = "classpath-minimal"

SRC_URI += "file://disable-automake-checks-v2.patch;patch=1"

EXTRA_OECONF = "--with-jikes --disable-plugin --disable-dssi"
