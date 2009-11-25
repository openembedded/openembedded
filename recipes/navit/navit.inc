DESCRIPTION = "Navit is a car navigation system with routing engine."
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS = "glib-2.0 gtk+"
RRECOMMENDS = "gpsd espeak flite"

PE = "1"
INC_PR = "r3"

inherit autotools

EXTRA_OECONF = "--disable-binding-python --disable-gui-sdl --disable-samplemap --enable-avoid-float --enable-avoid-unaligned  --enable-svg2png-scaling-flag=32 --disable-speech-speech-dispatcher"

PACKAGES = "${PN}-dbg ${PN}-dev ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN} += "${libdir}/${PN}/*/*.so ${datadir}/dbus-1/services/ ${datadir}/icons/*/*/apps/navit.png"
FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug"
FILES_${PN}-dev += "${libdir}/${PN}/*/*.la"

SRC_URI_append = " \
                  file://navit.desktop \
                  file://navit.png \
	  	 "
SRC_URI_append_shr = "file://navitD.desktop \
                      file://navitD.png \
                     "

DEPENDS_append_shr = " gypsy"
RDEPENDS_append_shr = " fsoraw"

do_install_append() {
        install -d ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/navit.desktop ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/navitD.desktop ${D}${datadir}/applications/

        install -d ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/navit.png ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/navitD.png ${D}${datadir}/pixmaps/

	#FIXME: don't install those in the first place, 
	#FIXME: rather then deleting post-install?
	rm ${D}${libdir}/${PN}/*/*.la
}
