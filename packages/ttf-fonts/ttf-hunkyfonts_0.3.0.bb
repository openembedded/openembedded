DESCRIPTION = "Hunky fonts - TTF Version"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "LGPL"
HOMEPAGE = "http://sourceforge.net/projects/hunkyfonts"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/hunkyfonts/hunkyfonts-${PV}.tar.bz2"

S = "${WORKDIR}/hunkyfonts-${PV}/TTF/"

include ttf.inc

PACKAGES = "ttf-hunky-sans ttf-hunky-serif"

FILES_ttf-hunky-sans = "${datadir}/fonts/truetype/HunkySans*.ttf"
FILES_ttf-hunky-serif = "${datadir}/fonts/truetype/HunkySerif*.ttf"
