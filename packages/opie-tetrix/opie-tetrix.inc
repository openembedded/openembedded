DESCRIPTION = "Game: control falling blocks"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "tetrix"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libtetrix.so* bin/tetrix apps/Games/tetrix.desktop pics/tetrix/*
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

