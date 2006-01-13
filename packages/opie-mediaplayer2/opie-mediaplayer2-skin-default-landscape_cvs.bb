DESCRIPTION = "Skin for opie-mediaplayer2"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Team Opie <opie@handhelds.org>"
# Remove the dash below when 1.2.1 changes in PV
PV = "1.2.1+cvs-${SRCDATE}"
APPNAME = "opieplayer2"

RPROVIDES = "opie-mediaplayer2-skin"

SRC_URI = "${HANDHELDS_CVS};module=opie/pics"

FILES_${PN} = "${palmtopdir}/pics/${APPNAME}/skins/default_landscape/*.png"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/default_landscape/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/skins/default_landscape/*.png ${D}${palmtopdir}/pics/${APPNAME}/skins/default_landscape/
}
