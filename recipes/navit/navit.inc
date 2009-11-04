DESCRIPTION = "Navit is a car navigation system with routing engine."
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS = "glib-2.0 gtk+"
RRECOMMENDS = "gpsd espeak flite"

inherit autotools

EXTRA_OECONF = "--disable-binding-python --disable-gui-sdl --disable-samplemap --enable-avoid-float --enable-avoid-unaligned  --enable-svg2png-scaling-flag=32 --disable-speech-speech-dispatcher"

PACKAGES = "${PN}-dbg ${PN}-dev ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN} += "${libdir}/${PN}/*/*.so"
FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug"
FILES_${PN}-dev += "${libdir}/${PN}/*/*.la"

SRC_URI_append = " \
                  file://navit.desktop \
                  file://navit.launcher \
                  file://navit.png \
                  file://navit.service \
	  	 "
SRC_URI_append_shr = "file://use-fso-raw.patch;patch=1"
#                      file://fr-default-config.patch;patch=1"

DEPENDS_shr += "gypsy"
RDEPENDS_shr += "fsoraw"

do_install_append() {
        install -d ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/navit.desktop ${D}${datadir}/applications/
        install -d ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/navit.png ${D}${datadir}/pixmaps/
        install -d ${D}${datadir}/dbus-1/services/
        install -m 0644 ${WORKDIR}/navit.service ${D}${datadir}/dbus-1/services/

        mv ${D}${bindir}/navit ${D}${bindir}/navit.real
        install -m 0755 ${WORKDIR}/navit.launcher ${D}${bindir}/navit
}
