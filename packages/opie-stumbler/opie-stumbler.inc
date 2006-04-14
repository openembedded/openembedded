DESCRIPTION = "A Wireless Network Scanner"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Team Opie <opie@handhelds.org>"
RRECOMMENDS = "manufacturers"
APPNAME = "opiestumbler"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/
	install -m 0644 ${WORKDIR}/opiestumbler.png ${D}${palmtopdir}/pics/
}
