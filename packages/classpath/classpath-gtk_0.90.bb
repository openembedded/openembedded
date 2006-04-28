include classpath.inc

DEPENDS = "glib-2.0 gtk+ libart-lgpl pango libxtst jikes-native zip-native"
RDEPENDS_${PBN}-gtk = "${PBN}-common (>= ${PV})"
RCONFLICTS_${PBN}-gtk = "${PBN}-minimal"

EXTRA_OECONF = "--with-jikes"

PACKAGES = "${PBN}-dev ${PBN}-doc ${PBN}-common ${PBN}-examples ${PBN}-tools ${PN}"

FILES_${PBN}-doc = "${datadir}/info"
FILES_${PBN}-dev = "${includedir}"
FILES_${PN} = "${libdir}"
FILES_${PBN}-common = "${datadir}/${PBN}/glibj.zip"
FILES_${PBN}-examples = "${datadir}/${PBN}/examples"
FILES_${PBN}-tools = "${datadir}/${PBN}/tools"
