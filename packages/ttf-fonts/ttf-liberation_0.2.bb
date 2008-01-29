require ttf.inc

DESCRIPTION = "Liberation fonts - TTF Version"
HOMEPAGE = "https://www.redhat.com/promo/fonts/"
LICENSE = "Liberation"
PR = "r1"

SRC_URI = "http://www.redhat.com/f/fonts/liberation-fonts-ttf-3.tar.gz"
S = "${WORKDIR}/liberation-fonts-${PV}"

PACKAGES = "${PN}-dbg ttf-liberation-mono ttf-liberation-sans ttf-liberation-serif"
FILES_ttf-liberation-mono  = "${datadir}/fonts/truetype/*Mono*"
FILES_ttf-liberation-sans  = "${datadir}/fonts/truetype/*Sans*"
FILES_ttf-liberation-serif = "${datadir}/fonts/truetype/*Serif*"
