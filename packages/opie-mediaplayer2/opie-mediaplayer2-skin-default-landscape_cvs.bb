DESCRIPTION = "Skin for opie-mediaplayer2"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
PV = "1.2.2+cvs${SRCDATE}"
APPNAME = "opieplayer2"

RPROVIDES = "opie-mediaplayer2-skin"

SRC_URI = "${HANDHELDS_CVS};module=opie/pics"

FILES_${PN} = "${palmtopdir}/pics/${APPNAME}/skins/default_landscape/*.png"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/default_landscape/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/skins/default_landscape/*.png ${D}${palmtopdir}/pics/${APPNAME}/skins/default_landscape/
}
