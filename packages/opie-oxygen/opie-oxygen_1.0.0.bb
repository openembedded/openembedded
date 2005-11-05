DESCRIPTION = "Opie Oxygen"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "oxygen"
PR = "r0"

#cvsdate for 1.0.0 is 20050101
CVSDATE = "20050101"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/${APPNAME} \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/share \
           ${HANDHELDS_CVS};module=opie/apps"
S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
    install -d ${D}${palmtopdir}/pics/${APPNAME}/
    install -d ${D}${palmtopdir}/share/oxygen/
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
    install -m 0644 ${WORKDIR}/share/oxygen/*o* ${D}${palmtopdir}/share/oxygen/
}
