DESCRIPTION = "DVI Viewer for Opie/Qtopia"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www013.upp.so-net.ne.jp/hn43o/dviviewer/"
PR = "r1"

SRC_URI = "http://www013.upp.so-net.ne.jp/hn43o/dviviewer/dviviewer-${PV}.tar.gz"
S = "${WORKDIR}/dviviewer"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/bin \
		   ${D}${palmtopdir}/apps/Applications \
		   ${D}${palmtopdir}/pics
        install -D -m 755 dviviewer ${D}${palmtopdir}/bin/dviviewer
        install -D -m 644 dviviewer.desktop ${D}${palmtopdir}/Applications/dviviewer.desktop
        install -d ${D}${palmtopdir}/pics
        cp -pPR *.png ${D}${palmtopdir}/pics/
}

SRC_URI[md5sum] = "cc101da3b436607ee2265b5af5001484"
SRC_URI[sha256sum] = "ab7c305be32708c4ede670e13783b718e6a28e35b5495e6c42c31c35a8b512a6"
