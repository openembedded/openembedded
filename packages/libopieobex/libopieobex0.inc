DESCRIPTION = "IrDA obex support library"
SECTION = "opie/libs"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "LGPL"
DEPENDS = "libopietooth1 opie-taskbar openobex-apps"
RDEPENDS = "openobex-apps"
APPNAME = "obex"

S = "${WORKDIR}/obex"

inherit opie

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/opietooth"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/ ${D}${palmtopdir}/plugins/obex/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	oe_libinstall -so libopieobex ${D}${palmtopdir}/plugins/obex/
}

FILES_${PN} = "${palmtopdir}/plugins/obex/ ${palmtopdir}/pics/obex/"
