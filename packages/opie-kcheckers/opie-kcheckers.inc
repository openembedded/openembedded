DESCRIPTION = "The game of Checkers"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "kcheckers"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libkcheckers.so* bin/kcheckers apps/Games/kcheckers.desktop pics/kcheckers
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.xpm ${D}${palmtopdir}/pics/${APPNAME}/
}

