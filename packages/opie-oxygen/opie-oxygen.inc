DESCRIPTION = "Opie Oxygen"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "oxygen"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
    install -d ${D}${palmtopdir}/pics/${APPNAME}/
    install -d ${D}${palmtopdir}/share/oxygen/
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
    install -m 0644 ${WORKDIR}/share/oxygen/*o* ${D}${palmtopdir}/share/oxygen/
}
