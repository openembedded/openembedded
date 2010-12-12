DESCRIPTION = "Skin for opie-mediaplayer2"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "opieplayer2"
RPROVIDES_${PN} = "opie-mediaplayer2-skin"
PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/techno/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/skins/techno/*.png ${D}${palmtopdir}/pics/${APPNAME}/skins/techno/
}

FILES_${PN} = "${palmtopdir}/pics/${APPNAME}/skins/techno/*.png"
