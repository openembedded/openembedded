DESCRIPTION = "Skin for opie-mediaplayer2"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "opieplayer2"
RPROVIDES_${PN} = "opie-mediaplayer2-skin"
PR = "r2"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2"

FILES_${PN} = "${palmtopdir}/pics/${APPNAME}/skins/Pod/*.png"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/Pod/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/skins/Pod/*.png ${D}${palmtopdir}/pics/${APPNAME}/skins/Pod/
}
