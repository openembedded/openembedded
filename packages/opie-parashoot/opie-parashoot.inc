DESCRIPTION = "Game: shoot the parachutists"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "parashoot"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libparashoot.so* bin/parashoot apps/Games/parashoot.desktop pics/parashoot
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.xpm ${D}${palmtopdir}/pics/${APPNAME}/
}

