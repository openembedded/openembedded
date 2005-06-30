DESCRIPTION = "A image viewer"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libopiecore2 libopieui2 libopiemm2"
RDEPENDS = "opie-advancedfm-pics"
APPNAME = "opie-eye"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_configure_append() {
	cd slave && qmake -makefile -spec ${QMAKESPEC} slave.pro -after ${EXTRA_QMAKEVARS_POST}
}

do_compile_append() {
	cd slave && oe_runmake
}

do_install() {
	install -m 0755 opie-eye_slave ${D}${palmtopdir}/bin/
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

