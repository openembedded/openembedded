DESCRIPTION = "Graphics performance tester"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "performance"

SRC_URI = "${HANDHELDS_CVS};module=opie/development/performance \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/performance apps/Applications/performance.desktop
#do_install() {
#        install -d ${D}${palmtopdir}/pics/${APPNAME}/
#        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
#}

