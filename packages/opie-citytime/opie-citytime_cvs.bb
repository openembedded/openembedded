DESCRIPTION = "Time-zone / world clock settings"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RRECOMMENDS = "timezones"
PV = "1.1.9+cvs-${CVSDATE}"

APPNAME = "citytime"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/settings/citytime \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

