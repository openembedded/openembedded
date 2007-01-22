DESCRIPTION = "A Sudoku Game for Opie"
HOMEPAGE = "http://figlabs.com"
AUTHOR = "FigLabs"
LICENSE = "GPL"
SECTION = "opie/games"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"
PR = "r1"

SRC_URI = "http://www.vanille.de/mirror/zudoku-${PV}.tar.gz \
           file://zudoku.html \
           file://zudoku.desktop"

inherit opie

EXTRA_QMAKEVARS_POST += "TARGET=zudoku"
LDFLAGS += "-lstdc++"

do_install() {
	install -d ${D}${palmtopdir}/help/en/html
	install -m 0644 ${WORKDIR}/zudoku.html ${D}${palmtopdir}/help/en/html/
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 zudoku64x64.png ${D}${palmtopdir}/pics/zudoku.png
}
