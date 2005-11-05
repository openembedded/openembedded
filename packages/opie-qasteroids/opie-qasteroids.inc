DESCRIPTION = "Game: shoot the asteroids"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "qasteroids"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libqasteroids.so* bin/qasteroids apps/Games/qasteroids.desktop pics/qasteroids/*
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

	for dir in bits  exhaust  missile  powerups  rock2  rock3  shield  ship
	do
	    install -d ${D}${palmtopdir}/pics/${APPNAME}/$dir/
	    install -m 0644 ${WORKDIR}/pics/${APPNAME}/$dir/*.png ${D}${palmtopdir}/pics/${APPNAME}/$dir/
	done
}

