DESCRIPTION = "Gnuchess is a chess playing engine."
SECTION = "console"
PRIORITY = "optional"
MAINTAINER = "Andreas Holzer <a.holzer@cheese.at>"
LICENSE = "GPL"
SRC_URI = "http://members.cheese.at/woody/fltk-chess/gnuchess_5.02.tar.gz" 
S = "${WORKDIR}/chess-5.02/src"

inherit autotools

do_install() {
        install -D ${S}/gnuchess ${D}${bindir}/gnuchess
}
