require classpath.inc

DEPENDS = "glib-2.0 gtk+ cairo gconf libart-lgpl pango libxtst jikes-native zip-native"
RDEPENDS_${PN} = "classpath-common (>= ${PV})"
RCONFLICTS_${PN} = "classpath-minimal"

SRC_URI += "file://gconf_version.patch;patch=1"

EXTRA_OECONF = "--with-jikes --disable-plugin --disable-dssi"

PACKAGES = "classpath-dev classpath-doc classpath-common classpath-examples classpath-tools ${PN}"

FILES_classpath-doc = "${datadir}/info"
FILES_classpath-dev = "${includedir}"
FILES_${PN} = "${libdir} ${bindir}"
FILES_classpath-common = "${datadir}/classpath/glibj.zip"
FILES_classpath-examples = "${datadir}/classpath/examples"
FILES_classpath-tools = "${datadir}/classpath/tools.zip"
