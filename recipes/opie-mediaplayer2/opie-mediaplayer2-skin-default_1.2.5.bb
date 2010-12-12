DESCRIPTION = "Skin for opie-mediaplayer2"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "opieplayer2"
RPROVIDES_${PN} = "opie-mediaplayer2-skin"

OPIE_SRCREV ?= "8c3beef263bc9c34443eacfc821e99813e17554f"

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/default/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/skins/default/*.png ${D}${palmtopdir}/pics/${APPNAME}/skins/default/
}

FILES_${PN} = "${palmtopdir}/pics/${APPNAME}/skins/default/*.png"
