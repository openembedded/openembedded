DESCRIPTION = "Pairs"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Anders Widell, Steve Dunham, Robert Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Sokoban.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/sokoban_V1.3.8ern.tar.gz \
           file://sokoban.patch;patch=1"

PV = "1.3.8ern"
S = "${WORKDIR}/sokoban_V${PV}"

APPNAME = "sokoban"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_compile_prepend() {
	oe_runmake -C images	
	oe_runmake -C levels
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	
}

inherit opie

