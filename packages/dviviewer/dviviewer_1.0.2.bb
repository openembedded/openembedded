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
        cp -a *.png ${D}${palmtopdir}/pics/
}
