DESCRIPTION = "Mahjongg"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Mario Weilguni, Port by Rober Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Mahjongg.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/mahjongg_V1.0.0.tar.gz \
           file://Makefile.patch;patch=1 \
	   file://mahjongg.patch;patch=1"


PV = "1.0.0"
S = "${WORKDIR}/mahjongg_V${PV}"

APPNAME = "mahjongg"
APPTYPE = "binary"
APPDESKTOP = "${S}"


do_compile_prepend() {
	oe_runmake -C images
	oe_runmake -C layouts
	oe_runmake -C tools
}


do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	
}

inherit opie
