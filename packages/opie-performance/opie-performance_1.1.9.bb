DESCRIPTION = "Graphics performance tester"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "performance"
APPTYPE = "binary"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/development/performance \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/performance apps/Applications/performance.desktop
#do_install() {
#        install -d ${D}${palmtopdir}/pics/${APPNAME}/
#        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
#}

