DESCRIPTION = "Skin for opie-mediaplayer2"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "opieplayer2"
RPROVIDES_${PN} = "opie-mediaplayer2-skin"

OPIE_SRCREV ?= "8c3beef263bc9c34443eacfc821e99813e17554f"
OPIE_GIT_PV ?= "1.2.4+gitr${OPIE_SRCREV}"

PV = "${OPIE_GIT_PV}"
PR = "r4"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=pics"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/default/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/skins/default/*.png ${D}${palmtopdir}/pics/${APPNAME}/skins/default/
}

FILES_${PN} = "${palmtopdir}/pics/${APPNAME}/skins/default/*.png"
