DESCRIPTION = "Clock and stop-watch"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "clock"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/tools/clock \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libclock.so* bin/clock apps/Applications/clock.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}


