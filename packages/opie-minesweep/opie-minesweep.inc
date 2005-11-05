DESCRIPTION = "Game: find the mines"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "minesweep"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libminesweep.so* bin/minesweep apps/Games/minesweep.desktop pics/minesweep
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

