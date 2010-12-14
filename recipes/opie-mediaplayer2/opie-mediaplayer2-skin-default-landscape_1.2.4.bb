DESCRIPTION = "Skin for opie-mediaplayer2"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "opieplayer2"
RPROVIDES_${PN} ="opie-mediaplayer2-skin"
PR = "r2"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"

FILES_${PN} = "${palmtopdir}/pics/${APPNAME}/skins/default_landscape/*.png"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/default_landscape/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/skins/default_landscape/*.png ${D}${palmtopdir}/pics/${APPNAME}/skins/default_landscape/
}
