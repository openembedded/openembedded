DESCRIPTION = "Skin for opie-mediaplayer2"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Team Opie <opie@handhelds.org>"
PV = "1.2.0+cvs-${CVSDATE}"
APPNAME = "opieplayer2"

RPROVIDES = "opie-mediaplayer2-skin"

SRC_URI = "${HANDHELDS_CVS};module=opie/pics"

FILES_${PN} = "${palmtopdir}/pics/${APPNAME}/skins/techno/*.png"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/techno/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/skins/techno/*.png ${D}${palmtopdir}/pics/${APPNAME}/skins/techno/
}
