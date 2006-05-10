DESCRIPTION = "Qxmp is a Qt4 media player based on MPlayer"
LICENSE = "GPL"
SECTION = "x11/multimedia"
HOMEPAGE = "http://www.xm1math.net/qxmp/index.html"
RDEPENDS = "mplayer"

SRC_URI = "http://www.xm1math.net/qxmp/qxmp-${PV}.tar.bz2"

inherit qmake qt4x11

do_install() {
	install -d ${D}${bindir}
	install -m 0755 qxmp ${D}${bindir}
}
