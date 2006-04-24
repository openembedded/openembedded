DESCRIPTION = "Clone of the classic Paradroid from C64 - SDL version."
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://freedroid.sourceforge.net/"
PR = "r2"

APPIMAGE = "${WORKDIR}/freedroid.png"

SRC_URI = "${SOURCEFORGE_MIRROR}/freedroid/freedroid-${PV}.tar.gz \
           file://freedroid.png"

inherit autotools sdl

do_compile() {
	oe_runmake pkgdatadir=${datadir}/freedroid
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 src/freedroid ${D}${bindir}
        install -d ${D}${datadir}/freedroid/
	cp -a graphics map sound ${D}${datadir}/freedroid/
}
