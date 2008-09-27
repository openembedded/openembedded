require ttf.inc

DESCRIPTION = "Sazanami Gothic/Mincho Japanese TrueType fonts"
DESCRIPTION_ttf-sazanami-gothic = "Sazanami Gothic Japanese TrueType font"
DESCRIPTION_ttf-sazanami-mincho = "Sazanami Mincho Japanese TrueType font"
AUTHOR = "Electronic Font Open Laboratory (/efont/)"
HOMEPAGE = "http://sourceforge.jp/projects/efont/"
LICENSE = "${PN}"
SRC_DISTRIBUTE_LICENSES += "${PN}"
RPROVIDES = "virtual/japanese-font"
PR = "r4"

SRC_URI = "http://download.sourceforge.jp/efont/10087/sazanami-20040629.tar.bz2"
S = "${WORKDIR}/sazanami-20040629"

PACKAGES = "${PN}-dbg ttf-sazanami-gothic ttf-sazanami-mincho"
RRECOMMENDS_${PN}-dbg = ""
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
