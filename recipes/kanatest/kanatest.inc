DESCRIPTION = "Hiragana and Katakana drill tool"
HOMEPAGE = "http://clayo.org/kanatest/
SECTION = "gpe/games"
LICENSE = "GPL"
DEPENDS = "gtk+"

SRC_URI = "http://clayo.org/kanatest/${PN}-${PV}.tar.gz \
	file://${PN}.desktop"

inherit autotools gettext

CFLAGS += "-D_GNU_SOURCE"

do_install_append () {
	install -d ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/${PN}.desktop ${D}${datadir}/applications/${PN}.desktop
}

FILES_${PN} = "${bindir}/${PN} ${datadir}/${PN} ${datadir}/pixmaps ${datadir}/applications"
