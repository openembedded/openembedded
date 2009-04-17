DESCRIPTION = "Navit is a car navigation system with routing engine."
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS = "glib-2.0 gtk+"
RRECOMMENDS = "gpsd speechd flite"

inherit autotools

EXTRA_OECONF = "--disable-binding-python --disable-gui-sdl --disable-samplemap --enable-avoid-float --enable-avoid-unaligned"

PACKAGES = "${PN}-dbg ${PN}-dev ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN} += "${libdir}/${PN}/*/*.so"
FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug"

SRC_URI_append = " \
                  file://navit.desktop \
                  file://navit.launcher \
                  file://navit.png \
	  	 "

do_install_append() {
        install -d ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/navit.desktop ${D}${datadir}/applications/
        install -d ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/navit.png ${D}${datadir}/pixmaps/

        mv ${D}${bindir}/navit ${D}${bindir}/navit.real
        install -m 0755 ${WORKDIR}/navit.launcher ${D}${bindir}/navit

	rm ${D}${libdir}/${PN}/*/*.la
}
