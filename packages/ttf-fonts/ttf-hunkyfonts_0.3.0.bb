require ttf.inc

DESCRIPTION = "Hunky fonts - TTF Version"
HOMEPAGE = "http://sourceforge.net/projects/hunkyfonts"
LICENSE = "LGPL"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/hunkyfonts/hunkyfonts-${PV}.tar.bz2"

S = "${WORKDIR}/hunkyfonts-${PV}/TTF/"

PACKAGES = "${PN}-dbg ttf-hunky-sans ttf-hunky-serif"
RRECOMMENDS_${PN}-dbg = ""
FILES_ttf-hunky-sans = "${datadir}/fonts/truetype/HunkySans*.ttf"
FILES_ttf-hunky-serif = "${datadir}/fonts/truetype/HunkySerif*.ttf"
