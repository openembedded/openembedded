DESCRIPTION = "Etk is an advanced widget toolkit based on the Enlightenment Foundation Libraries."
DEPENDS = "evas ecore edje"
LICENSE = "MIT"
PV = "0.1.0+cvs${SRCDATE}"
PR = "r1"

inherit efl_library

# TODO package engines seperatly (do_split_packages)

PACKAGES =+ "etk-engines"
FILES_${PN} = "${libdir}/libetk.so*"
FILES_${PN}-examples += "${bindir}"
FILES_${PN}-engines = "${libdir}/etk/engines/*.so ${datadir}"
FILES_${PN}-dev += "${libdir}/etk/engines/*.a ${libdir}/etk/engines/*.la"
FILES_${PN}-dbg += "${libdir}/etk/engines/.debug/"

RRECOMMENDS_${PN} = "${PN}-engines"
