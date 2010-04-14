DESCRIPTION = "Qxmp is a Qt4 media player based on MPlayer"
LICENSE = "GPL"
SECTION = "x11/multimedia"
HOMEPAGE = "http://www.xm1math.net/qxmp/index.html"
RDEPENDS = "mplayer"

SRC_URI = "http://www.xm1math.net/qxmp/qxmp-${PV}.tar.bz2"

inherit qt4x11

do_install() {
	install -d ${D}${bindir}
	install -m 0755 qxmp ${D}${bindir}
}

SRC_URI[md5sum] = "9eb52b5b6c1dda6ff96790acb9915da8"
SRC_URI[sha256sum] = "285be4b83819c4bf24b2db1e120a9c8e1756863f49aa631acf09bbbae1e04709"
