DESCRIPTION = "Qt/Embedded Fonts Common Files"
SECTION = "opie/fonts"
PRIORITY = "optional"
LICENSE = "GPL QPL"
PR = "r3"

SRC_URI = "file://update-qtfontdir"
S = "${WORKDIR}/qt-${PV}"

do_install() {
	install -d ${D}${sbindir}/
	install -m 0755 ${WORKDIR}/update-qtfontdir ${D}${sbindir}/
	sed -i -e 's,@palmtopdir@,${palmtopdir},g' ${D}${sbindir}/update-qtfontdir
}
