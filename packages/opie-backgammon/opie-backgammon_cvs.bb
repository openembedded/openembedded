DESCRIPTION = "Backgammon Game"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "backgammon"
APPTYPE = "binary"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/games/backgammon \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libbackgammon.so* bin/backgammon apps/Games/backgammon.desktop pics/backgammon help/en/html/backgammon.html
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

	for dir in boards dice odds pieces table
	do
		install -d ${D}${palmtopdir}/pics/${APPNAME}/$dir
		install -m 644 ${WORKDIR}/pics/${APPNAME}/$dir/*.png ${D}${palmtopdir}/pics/${APPNAME}/$dir
	done	
}

