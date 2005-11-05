DESCRIPTION = "Game: crack the coloured code"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "mindbreaker"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libmindbreaker.so* bin/mindbreaker apps/Games/mindbreaker.desktop pics/mindbreaker
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

