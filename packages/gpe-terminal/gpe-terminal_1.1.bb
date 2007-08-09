DESCRIPTION = "GPE terminal wrapper"
SECTION = "gpe"
LICENSE = "GPL"
RRECOMMENDS = "rxvt-unicode"
PR = "r1"

SRC_URI = "file://${PN}.desktop file://${PN}.png"

do_install() {
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/${PN}.desktop ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/${PN}.png ${D}${datadir}/pixmaps/
}
