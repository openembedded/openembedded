DESCRIPTION = "Gnuchess is a chess playing engine."
SECTION = "console"
PRIORITY = "optional"
MAINTAINER = "Andreas Holzer <a.holzer@cheese.at>"
LICENSE = "GPL"
PR = "r1"
RSUGGESTS_${PN} = "xboard"
SRC_URI = "http://members.cheese.at/woody/fltk-chess/gnuchess_5.02.tar.gz \
           file://gnuchess.desktop \
           file://gnuchess.png \
           file://gnuchess.sh \
" 
S = "${WORKDIR}/chess-5.02/src"

inherit autotools

do_install() {
        install -d ${D}${bindir}
        install -d ${D}${datadir}/pixmaps/
        install -d ${D}${datadir}/applications/
        install -m 0755 ${WORKDIR}/gnuchess.sh ${D}${bindir}
        install -m 0644 ${WORKDIR}/gnuchess.png  ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/gnuchess.desktop  ${D}${datadir}/applications/
        install -D ${S}/gnuchess ${D}${bindir}/gnuchess
}
