DESCRIPTION = "The game of Checkers"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "kcheckers"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/games/kcheckers \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libkcheckers.so* bin/kcheckers apps/Games/kcheckers.desktop pics/kcheckers
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.xpm ${D}${palmtopdir}/pics/${APPNAME}/
}

