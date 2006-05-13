DESCRIPTION = "TeXmaker is a free cross-platform LaTeX editor"
HOMEPAGE = "http://www.xm1math.net/texmaker"
SECTION = "x11/apps"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"

SRC_URI = "http://www.xm1math.net/texmaker/texmaker-${PV}.tar.bz2"

inherit qmake qt4x11

do_install() {
	install -d ${D}${bindir}
	install -m 0755 texmaker ${D}${bindir}/texmaker
}

