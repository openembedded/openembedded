DESCRIPTION = "IrDA obex support library"
SECTION = "opie/libs"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "LGPL"
DEPENDS = "opie-taskbar"
RDEPENDS = "openobex-apps"
APPNAME = "obex"

S = "${WORKDIR}/obex"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/ ${D}${palmtopdir}/plugins/obex/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	oe_libinstall -so libopieobex ${D}${palmtopdir}/plugins/obex/
}

FILES_${PN} = "${palmtopdir}/plugins/obex/ ${palmtopdir}/pics/obex/"
