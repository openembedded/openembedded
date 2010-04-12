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
    cp -pPR ${WORKDIR}/pics ${D}${palmtopdir}
    cp -pPR ${WORKDIR}/share/apps/kstars ${D}${palmtopdir}/share/apps/
}

SRC_URI[md5sum] = "ae02647516a4a5c47674316ef8343c11"
SRC_URI[sha256sum] = "650f0b3ae4d30282b191e456ebf2679a4ec549da83f69667bd4396bad9abf9f5"
