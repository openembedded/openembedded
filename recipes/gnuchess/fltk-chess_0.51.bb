DESCRIPTION = "fltk-chess is a frontend for the Gnuchess chess playing engine."
AUTHOR = "Andreas Holzer <a.holzer@cheese.at>"
SECTION = "x11/games"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "fltk"
RDEPENDS = "gnuchess"


SRC_URI = "http://members.cheese.at/woody/zaurus/src/fltk-chess-${PV}.tgz"
S = "${WORKDIR}/fltk-chess/"


do_compile() {
        `fltk-config --cxx --cxxflags --ldflags --use-images` -o fltk-chess \
         fltk-chess.cxx
}

do_install() {
        install -d ${D}${bindir}
        install -d ${D}${datadir}/pixmaps/fltk-chess/
        install -d ${D}${datadir}/applications/
        install -m 0755 ${S}/fltk-chess ${D}${bindir}
        install -m 0644 ${S}/bitmaps/*.pnx ${D}${datadir}/pixmaps/fltk-chess/
        install -m 0644 ${S}/bitmaps/{user,computer}.png \
                ${D}${datadir}/pixmaps/fltk-chess/
        install -m 0644 ${S}/bitmaps/fltk-chess.png  ${D}${datadir}/pixmaps/
        install -m 0644 ${S}/fltk-chess.desktop  ${D}${datadir}/applications/
}

SRC_URI[md5sum] = "df1f73bdf32f30923d9a2a5717a70913"
SRC_URI[sha256sum] = "3fffcaf0653c13b249931f76b12119dce8a5b01df056e4b5444f150fec1d5311"
