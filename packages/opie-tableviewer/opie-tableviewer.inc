DESCRIPTION = "XML database browsers"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "tableviewer"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libtableviewer.so* bin/tableviewer apps/Applications/tableviewer.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

