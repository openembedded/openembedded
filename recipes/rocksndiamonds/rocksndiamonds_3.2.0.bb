DESCRIPTION = "Rocks'n'Diamonds - Boulderdash/Emerald Mine/Supaplex/Sokoban clone."
SECTION = "games"
LICENSE = "GPL"
HOMEPAGE = "http://www.artsoft.org/rocksndiamonds/"
AUTHOR = "Holger Schemel <info@artsoft.org>"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://artsoft.org/RELEASES/unix/rocksndiamonds/rocksndiamonds-${PV}.tar.gz \
	file://rocksndiamonds.png"

DEPENDS += "libsdl-net smpeg"

APPIMAGE = "../rocksndiamonds.png"
EXTRA_OEMAKE = "CC='${CC}' AR='${AR}' RANLIB='${RANLIB}' RO_GAME_DIR='${datadir}/${PN}' RW_GAME_DIR='${datadir}/${PN}'"

inherit sdl

do_install() {
	install -d ${D}${bindir}
	install -m 755 ${PN} ${D}${bindir}
	install -d ${D}${datadir}/${PN}
	cp -r graphics levels music scores sounds ${D}${datadir}/${PN}/
}


FILES_${PN} += "${bindir}/${PN} ${datadir}/${PN}"

SRC_URI[md5sum] = "0403e252fd978095e9546c0f10fa55ac"
SRC_URI[sha256sum] = "e85175ecbfc91623ec1f6b62fe2b23d69b00cc57482c9c4ddab275de6af60f99"
