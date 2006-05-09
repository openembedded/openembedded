DESCRIPTION = "Album Shaper strives to be the most friendly, easy to use, open source application for \
organizing, annotating, framing, enhancing, stylizing, and sharing your digital photos. \
Album Shaper embraces open formats like XML, JPEG, and XSLT, while supporting Windows, Mac OS X, and Unix \ 
users who speak a multitude of languages around the world."
HOMEPAGE = "http://albumshaper.sourceforge.net"
AUTHOR = "Will Stokes"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "libxml2 libxslt jpeg"

SRC_URI = "${SOURCEFORGE_MIRROR}/albumshaper/albumshaper_${PV}.tar.bz2 \
           file://fixpaths.patch;patch=1"
S = "${WORKDIR}/albumshaper_2.1_src"

inherit qmake qt3x11

do_install() {
	oe_runmake install INSTALL_ROOT="${D}"
}
