require ttf.inc

DESCRIPTION = "Liberation fonts - TTF Version"
HOMEPAGE = "https://www.redhat.com/promo/fonts/"
LICENSE = "Liberation"
PR = "r3"

SRC_URI = "http://fedorahosted.org/liberation-fonts/export/807b6dfd069b998cd9b4d3158da98817ef23c79d/F-9/liberation-fonts-ttf-3.tar.gz"
S = "${WORKDIR}/liberation-fonts-${PV}"

PACKAGES = "${PN}-dbg ttf-liberation-mono ttf-liberation-sans ttf-liberation-serif"
RRECOMMENDS_${PN}-dbg = ""

FILES_ttf-liberation-mono  = "${datadir}/fonts/truetype/*Mono*"
FILES_ttf-liberation-sans  = "${datadir}/fonts/truetype/*Sans*"
FILES_ttf-liberation-serif = "${datadir}/fonts/truetype/*Serif*"
