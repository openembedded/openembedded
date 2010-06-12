require navit.inc

SRCREV = "3349"
PV = "0.1.99+svnr${SRCPV}"
PR = "${INC_PR}.8"

S = "${WORKDIR}/navit"

# override navit.inc RRECOMMENDS, we only suggest a text2speech app
RRECOMMENDS_${PN} = "gpsd ${PN}-dbus ${PN}-speech-cmdline ${PN}-gui-internal ${PN}-graphics-gtk"
RSUGGESTS_${PN} = "flite espeak ${PN}-speech-dbus ${PN}-gui-gtk ${PN}-gui-qml ${PN}-graphics-sdl ${PN}-maptool"

DEPENDS_shr += " gd librsvg-native"
RDEPENDS_${PN} = " navit-icons ${PN}-config "
DEPENDS_append_shr = " gypsy"
RDEPENDS_append_shr = " fsoraw"

EXTRA_OECONF += " --enable-svg2png-scaling-flag=32 --disable-speech-speech-dispatcher --enable-cache-size=20971520"

SRC_URI = "svn://anonymous@navit.svn.sourceforge.net/svnroot/navit/trunk;module=navit;proto=https"

EXTRA_AUTORECONF = " -I m4"

CONFFILES_${PN}-config += "${datadir}/navit/navit.default.xml \
                    ${datadir}/navit/navit.xml \
                    ${datadir}/navit/maps.xml \
                    ${datadir}/navit/osd.xml \
                    ${datadir}/navit/speech.xml \
                    ${datadir}/navit/plugins.xml \
                   "

SRC_URI += "file://navit.xml \
            file://maps.xml \
            file://osd.xml \
            file://speech.xml \
            file://plugins.xml \
           "

PACKAGES =+ "${PN}-maptool ${PN}-config ${PN}-dbus ${PN}-speech-cmdline ${PN}-speech-dbus ${PN}-gui-gtk ${PN}-gui-internal ${PN}-gui-qml ${PN}-graphics-sdl ${PN}-graphics-gtk"

FILES_${PN}-maptool = " ${bindir}/maptool "
FILES_${PN}-config = " ${datadir}/navit/*.xml "
FILES_${PN}-dbus = " ${datadir}/dbus-1/services/ ${libdir}/${PN}/binding/libbinding_dbus.so "
FILES_${PN}-speech-cmdline = " ${libdir}/${PN}/speech/libspeech_cmdline.so "
FILES_${PN}-speech-dbus = " ${libdir}/${PN}/speech/libspeech_dbus.so "
FILES_${PN}-gui-gtk = " ${libdir}/${PN}/gui/libgui_gtk.so "
FILES_${PN}-gui-qml = " ${libdir}/${PN}/gui/libgui_qml.so ${datadir}/navit/skins/ "
FILES_${PN}-gui-internal = " ${libdir}/${PN}/gui/libgui_internal.so "
FILES_${PN}-graphics-sdl = " ${libdir}/${PN}/graphics/libgraphics_sdl.so "
FILES_${PN}-graphics-gtk = " ${libdir}/${PN}/graphics/libgraphics_gtk_drawing_area.so "

#Second launcher for shr
SRC_URI_append_shr = "file://navitD.desktop \
                      file://navitD.png \
                     "

do_configure_prepend() {
  #Remove xpm building, replaced by icons in own package
  sed -i 's/\(.*SUBDIRS.*\) xpm\( \|$\)\(.*\)/\1\2\3/g' ${S}/navit/Makefile.am
}

do_install_append() {
        #Use split config
        mv ${D}${datadir}/navit/navit.xml ${D}${datadir}/navit/navit.default.xml
        install -m 0644 ${WORKDIR}/navit.xml ${D}${datadir}/navit/navit.xml
        install -m 0644 ${WORKDIR}/maps.xml ${D}${datadir}/navit/maps.xml
        install -m 0644 ${WORKDIR}/osd.xml ${D}${datadir}/navit/osd.xml
        install -m 0644 ${WORKDIR}/speech.xml ${D}${datadir}/navit/speech.xml
        install -m 0644 ${WORKDIR}/plugins.xml ${D}${datadir}/navit/plugins.xml
}

do_install_append_shr() {
        #Install second launcher for shr
        install -m 0644 ${WORKDIR}/navitD.desktop ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/navitD.png ${D}${datadir}/pixmaps/
}
