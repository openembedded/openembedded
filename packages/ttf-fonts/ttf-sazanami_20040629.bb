DESCRIPTION = "Sazanami Gothic/Mincho Japanese TrueType fonts"
DESCRIPTION_ttf-sazanami-gothic = "Sazanami Gothic Japanese TrueType font"
DESCRIPTION_ttf-sazanami-mincho = "Sazanami Mincho Japanese TrueType font"
MAINTAINER = "Philipp Zabel <philipp.zabel@gmail.com>"
LICENSE = "${PN}"
SRC_DISTRIBUTE_LICENSES += "${PN}"
AUTHOR = "Electronic Font Open Laboratory (/efont/)"
HOMEPAGE = "http://sourceforge.jp/projects/efont/"

SRC_URI = "http://download.sourceforge.jp/efont/10087/sazanami-20040629.tar.bz2"
S = "${WORKDIR}/sazanami-20040629"

include ttf.inc

PACKAGES = "ttf-sazanami-gothic ttf-sazanami-mincho"
FILES_ttf-sazanami-gothic = "${datadir}/fonts/truetype/sazanami-gothic.ttf \
			     ${datadir}/doc/ttf-sazanami-gothic/README"
FILES_ttf-sazanami-mincho = "${datadir}/fonts/truetype/sazanami-mincho.ttf \
			     ${datadir}/doc/ttf-sazanami-mincho/README"

do_install_append() {
	# README contains the redistribution license
	install -d ${D}${datadir}/doc/
	install -d ${D}${datadir}/doc/ttf-sazanami-gothic
	install -d ${D}${datadir}/doc/ttf-sazanami-mincho
	install -m 0644 ${S}/README ${D}${datadir}/doc/ttf-sazanami-gothic
	install -m 0644 ${S}/README ${D}${datadir}/doc/ttf-sazanami-mincho
}
