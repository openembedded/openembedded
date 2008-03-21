DESCRIPTION = "Etk is an advanced widget toolkit based on the Enlightenment Foundation Libraries."
DEPENDS = "evas ecore edje"
LICENSE = "MIT"
PV = "0.1.0.042+cvs${SRCDATE}"
PR = "r0"

inherit efl

# TODO package engines seperatly (do_split_packages)

PACKAGES =+ "etk-engines"
FILES_${PN} = "${libdir}/libetk.so*"
FILES_${PN}-examples += "${bindir}"
FILES_${PN}-engines = "${libdir}/etk/engines/*.so ${datadir}"
FILES_${PN}-dev += "${libdir}/etk/engines/*.a ${libdir}/etk/engines/*.la"
FILES_${PN}-dbg += "${libdir}/etk/engines/.debug/"

RRECOMMENDS_${PN} = "${PN}-engines"

PACKAGES += "etk-engines-software-x11"
FILES_${PN}-engines-software-x11 = "${libdir}/etk/engines/ecore_evas_software_x11.so"

#PACKAGES =+ "etk-engines-gl-x11"
#FILES_${PN}-engines-gl-x11 = "${libdir}/etk/engines/ecore_evas_gl_x11.so"

PACKAGES =+ "etk-engines-evas"
FILES_${PN}-engines-evas = "${libdir}/etk/engines/ecore_evas.so"

PACKAGES =+ "etk-engines-fb"
FILES_${PN}-engines-fb = "${libdir}/etk/engines/ecore_fb.so"

PACKAGES =+ "etk-engines-x11"
FILES_${PN}-engines-x11 = "${libdir}/etk/engines/ecore_evas_x11.so"

PACKAGES =+ "etk-engines-software-x11-16"
FILES_${PN}-engines-software-x11-16 = "${libdir}/etk/engines/ecore_evas_software_x11_16.so"
