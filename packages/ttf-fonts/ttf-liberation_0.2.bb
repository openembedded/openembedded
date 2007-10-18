DESCRIPTION = "Liberation fonts - TTF Version"
LICENSE = "Liberation"
HOMEPAGE = "https://www.redhat.com/promo/fonts/"

require ttf.inc

SRC_URI = "http://www.redhat.com/f/fonts/liberation-fonts-ttf-3.tar.gz"
S = "${WORKDIR}/liberation-fonts-${PV}"

PACKAGES = "ttf-liberation-mono ttf-liberation-sans ttf-liberation-serif"
FILES_ttf-liberation-mono  = "${datadir}/fonts/truetype/*Mono*"
FILES_ttf-liberation-sans  = "${datadir}/fonts/truetype/*Sans*"
FILES_ttf-liberation-serif = "${datadir}/fonts/truetype/*Serif*"
