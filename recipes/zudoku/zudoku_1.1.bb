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

SRC_URI[md5sum] = "8f8fd0e106c81897f0c8c3049dbf57de"
SRC_URI[sha256sum] = "42494c9c712caaf3ca96f8abf59aaeb0fb3dbd2076c21d8642ea4c6cd9a04900"
