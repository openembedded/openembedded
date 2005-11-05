DESCRIPTION = "Opie Login Manager (similar to gdm, xdm or kdm)"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RRECOMMENDS = "opie-logoutapplet"
APPNAME = "opie-login"

BROKEN = 1

S = "${WORKDIR}/${APPNAME}"

inherit opie

EXTRA_QMAKEVARS_POST_append = " LIBS-=-lpam"
EXTRA_QMAKEVARS_POST_append = " DEFINES-=USEPAM"

do_install() {
	install -d ${D}${palmtopdir}/bin
	install -d ${D}${palmtopdir}/etc
	install -d ${D}${palmtopdir}/share/opie-login

	install -m 755 ${WORKDIR}/${PN}/opie-login ${D}${palmtopdir}/bin
	install -m 644 ${WORKDIR}/*-session ${D}${palmtopdir}/share/opie-login
	install -m 644 ${WORKDIR}/opie-login.conf ${D}${palmtopdir}/etc
}

do_configure() {
	install -d "${WORKDIR}/apps"
	ln -s "${WORKDIR}/calibrate" "${WORKDIR}/apps/calibrate"
	palmtop_do_configure
}
