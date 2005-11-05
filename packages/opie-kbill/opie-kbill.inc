DESCRIPTION = "The famous hit Bill game"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "kbill"
APPTYPE = "binary"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/kbill apps/Games/kbill.desktop pics/kbill/*
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/pixmaps
        install -d ${D}${palmtopdir}/pics/${APPNAME}/bitmaps
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/bitmaps/*.xbm ${D}${palmtopdir}/pics/${APPNAME}/bitmaps
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/pixmaps/*.xpm ${D}${palmtopdir}/pics/${APPNAME}/pixmaps
}

