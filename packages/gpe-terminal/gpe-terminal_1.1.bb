SECTION = "gpe"
SRC_URI = "file://${PN}.desktop file://${PN}.png"
DESCRIPTION = "GPE terminal wrapper"
PV = "1.1"
LICENSE = "GPL"
do_install() {
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/${PN}.desktop ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/${PN}.png ${D}${datadir}/pixmaps/
}
