DESCRIPTION = "Skin for opie-mediaplayer2"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Team Opie <opie@handhelds.org>"
PV = "1.2.1+cvs-${CVSDATE}"
APPNAME = "opieplayer2"

RPROVIDES = "opie-mediaplayer2-skin"

SRC_URI = "${HANDHELDS_CVS};module=opie/pics"

FILES_${PN} = "${palmtopdir}/pics/${APPNAME}/skins/Pod/*.png"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/Pod/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/skins/Pod/*.png ${D}${palmtopdir}/pics/${APPNAME}/skins/Pod/
}
