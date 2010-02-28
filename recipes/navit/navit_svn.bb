require navit.inc

PV = "0.1.0+svnr${SRCPV}"
PR = "${INC_PR}.5"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "1"

S = "${WORKDIR}/navit"

# override navit.inc RRECOMMENDS, we only suggest a text2speech app
RRECOMMENDS = "gpsd"
RSUGGESTS   = "flite espeak

DEPENDS_shr += " librsvg-native"
RDEPENDS = " navit-icons"
EXTRA_OECONF += " --enable-svg2png-scaling-flag=32 --disable-speech-speech-dispatcher --enable-cache-size=20971520"

SRC_URI = "svn://anonymous@navit.svn.sourceforge.net/svnroot/navit/trunk;module=navit;proto=https"

EXTRA_AUTORECONF = " -I m4"

FILES_${PN} += " ${datadir}/dbus-1/services/ "

CONFFILES_${PN} += "${datadir}/navit/navit.default.xml \
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

#Second launcher for shr
SRC_URI_append_shr = "file://navitD.desktop \
                      file://navitD.png \
                     "

DEPENDS_append_shr = " gypsy"
RDEPENDS_append_shr = " fsoraw"

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
