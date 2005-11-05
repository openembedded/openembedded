DESCRIPTION = "Qt/Embedded Fonts Common Files"
SECTION = "opie/fonts"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL QPL"
PR = "r2"

SRC_URI = "file://update-qtfontdir"
S = "${WORKDIR}/qt-${PV}"

do_install() {
	install -d ${D}${sbindir}/
	install -m 0755 ${WORKDIR}/update-qtfontdir ${D}${sbindir}/
}
