DESCRIPTION = "A VNC Viewer"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "keypebble"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/pics/vnc
	install -m 0644 ${WORKDIR}/pics/vnc/*.* ${D}${palmtopdir}/pics/vnc/
}

