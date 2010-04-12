DESCRIPTION = "Album Shaper strives to be the most friendly, easy to use, open source application for \
organizing, annotating, framing, enhancing, stylizing, and sharing your digital photos. \
Album Shaper embraces open formats like XML, JPEG, and XSLT, while supporting Windows, Mac OS X, and Unix \
users who speak a multitude of languages around the world."
HOMEPAGE = "http://albumshaper.sourceforge.net"
AUTHOR = "Will Stokes"
LICENSE = "GPL"
DEPENDS = "libxml2 libxslt jpeg"

SRC_URI = "${SOURCEFORGE_MIRROR}/albumshaper/albumshaper_${PV}.tar.bz2 \
           file://fixpaths.patch;patch=1"
S = "${WORKDIR}/albumshaper_2.1_src"

inherit qmake qt3x11

do_install() {
	oe_runmake install INSTALL_ROOT="${D}"
}

SRC_URI[md5sum] = "242c260c50fd774f2301dba66deb668b"
SRC_URI[sha256sum] = "67b43e51aa5afb22a7329fd78e9d17f489fceb4ac00d9861312993709739528e"
