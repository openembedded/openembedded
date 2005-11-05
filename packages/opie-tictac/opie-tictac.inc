DESCRIPTION = "Tic Tac Toe game."
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "tictac"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libtictac.so* bin/tictac apps/Games/tictac.desktop pics/tictac
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

