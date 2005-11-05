DESCRIPTION = "Nime Mens Morris"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Dirk Farin, Port by Rober Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Nine-Mens-Morris.html"

SRC_URI = "http://handhelds.org/~zecke/oe_packages/nmm_V0.0.2.tar.gz \
           file://Makefile.patch;patch=1 \
	   file://nmm.patch;patch=1"

PV = "0.0.2"
S = "${WORKDIR}/nmm_V${PV}"

APPNAME = "nmm"
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

