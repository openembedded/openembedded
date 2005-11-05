DESCRIPTION = "Alien ShootOut"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Bill Kendrick"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Aliens.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/aliens_V1.0.0.tar.gz \
	   file://Makefile.patch;patch=1 \
           file://aliens.patch;patch=1"

PV = "1.0.0"
S = "${WORKDIR}/aliens_V${PV}"

APPNAME = "aliens"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_compile_prepend () {
	oe_runmake -C images
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	
}

inherit opie

