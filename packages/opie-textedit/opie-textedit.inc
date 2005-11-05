DESCRIPTION = "Opie Text Editor"
SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "textedit"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
    install -d ${D}${palmtopdir}/pics/${APPNAME}
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}
