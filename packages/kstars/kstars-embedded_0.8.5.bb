DESCRIPTION = "KDE Stars: The Universe, in your hands! QtE based Palmtop Environments Edition"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "kstars"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}/apps/Applications"
PR = "r1"

SRC_URI = "http://kstars.sourceforge.net/kstars-embedded-${PV}.tar.gz"
S = "${WORKDIR}/kstars"

inherit opie

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST += 'DEFINES+=I18N_NOOP='

do_install() {
    install -d ${D}${palmtopdir}/bin \
	       ${D}${palmtopdir}/pics/kstars \
	       ${D}${palmtopdir}/share/apps/kstars
    cp -a ${WORKDIR}/pics ${D}${palmtopdir}
    cp -a ${WORKDIR}/share/apps/kstars ${D}${palmtopdir}/share/apps/
}
