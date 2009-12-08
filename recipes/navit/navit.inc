DESCRIPTION = "Navit is a car navigation system with routing engine."
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS = "glib-2.0 gtk+"
RRECOMMENDS = "gpsd speechd flite"

PE = "1"
INC_PR = "r4"

inherit autotools

EXTRA_OECONF = "--disable-binding-python --disable-gui-sdl --disable-samplemap --enable-avoid-float --enable-avoid-unaligned"

PACKAGES = "${PN}-dbg ${PN}-dev ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN} += "${libdir}/${PN}/*/*.so"
FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug"

SRC_URI_append = " \
                  file://navit.desktop \
                  file://navit.png \
	  	 "

do_install_append() {
        install -d ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/navit.desktop ${D}${datadir}/applications/
        install -d ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/navit.png ${D}${datadir}/pixmaps/

	rm ${D}${libdir}/${PN}/*/*.la
}
