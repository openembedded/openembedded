DESCRIPTION = "Opie Oxygen"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "oxygen"

TAG = "v1_1_7"
SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/apps/${APPNAME} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/share \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
    install -d ${D}/${palmtopdir}/pics/${APPNAME}/
    install -d ${D}/${palmtopdir}/share/oxygen/
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}/${palmtopdir}/pics/${APPNAME}/
    install -m 0644 ${WORKDIR}/share/oxygen/*o* ${D}/${palmtopdir}/share/oxygen/
}
