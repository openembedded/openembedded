DESCRIPTION = "Opie Checkbook"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "checkbook"

# cvsdate of checkbook 0.8.0 is 20050101
CVSDATE = "20050101"
SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/${APPNAME} \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
    install -d ${D}${palmtopdir}/pics/${APPNAME}/
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}
