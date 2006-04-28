include classpath.inc

DEPENDS = "jikes-native zip-native"
RDEPENDS_${PBN}-minimal = "${PBN}-common (>= ${PV})"
RCONFLICTS_${PBN}-minimal = "${PBN}-gtk"

EXTRA_OECONF = "--with-jikes --without-x --with-glibj --disable-gtk-peer --disable-alsa"

PACKAGES = "${PBN}-dev ${PBN}-doc ${PBN}-common ${PBN}-examples ${PBN}-tools ${PN}"

FILES_${PBN}-doc = "${datadir}/info"
FILES_${PBN}-dev = "${includedir}"
FILES_${PN} = "${libdir}"
FILES_${PBN}-common = "${datadir}/${PBN}/glibj.zip"
FILES_${PBN}-examples = "${datadir}/${PBN}/examples"
FILES_${PBN}-tools = "${datadir}/${PBN}/tools"
