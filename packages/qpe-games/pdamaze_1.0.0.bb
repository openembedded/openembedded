DESCRIPTION = "PDA-Maze"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Bill Kendrick, Port by Rober Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-PDA-Maze.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/pdamaze_V1.0.0.tar.gz \
           file://Makefile.patch;patch=1"

PV = "1.0.0"
S = "${WORKDIR}/pdamaze_V${PV}"

APPNAME = "pdamaze"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_compile_prepend() {
	oe_runmake -C images	
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	
}

inherit opie



