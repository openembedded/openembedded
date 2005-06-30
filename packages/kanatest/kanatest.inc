SECTION = "gpe/games"
DESCRIPTION = "Hiragana and Katakana drill tool"
MAINTAINER = "Robert Marcano <robert@marcanoonline.com>"
LICENSE = "GPL"

DEPENDS = "gtk+"

FILES_${PN} = "${bindir}/${PN} ${datadir}/${PN} ${datadir}/pixmaps ${datadir}/applications"

inherit autotools gettext

do_install_append () {
	install -d ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/${PN}.desktop ${D}${datadir}/applications/${PN}.desktop
}
