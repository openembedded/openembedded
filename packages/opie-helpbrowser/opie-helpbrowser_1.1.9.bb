DESCRIPTION = "Opie Help Browser"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "helpbrowser"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/apps/${APPNAME} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
    install -d ${D}/${palmtopdir}/pics/${APPNAME}/
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}/${palmtopdir}/pics/${APPNAME}/
}
