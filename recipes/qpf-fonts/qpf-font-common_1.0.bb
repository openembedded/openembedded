DESCRIPTION = "Common files for Qt/Embedded fonts"
LICENSE = "GPL QPL"
PR = "r4"

SRC_URI = "file://update-qtfontdir"
S = "${WORKDIR}/qt-${PV}"

do_install() {
	install -d ${D}${sbindir}/
	install -m 0755 ${WORKDIR}/update-qtfontdir ${D}${sbindir}/
	sed -i -e 's,@palmtopdir@,${palmtopdir},g' ${D}${sbindir}/update-qtfontdir
}

PACKAGE_ARCH = "all"
