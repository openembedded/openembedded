DESCRIPTION = "Opie embedded konsole"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = " libqtaux2"
APPNAME = "embeddedkonsole"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
    install -d ${D}${palmtopdir}/pics/konsole/
    install -m 0644 ${WORKDIR}/pics/konsole/*.png ${D}${palmtopdir}/pics/konsole/
}
