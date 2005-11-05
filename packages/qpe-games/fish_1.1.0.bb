DESCRIPTION = "Fish Amusement"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Robert Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Fish.html"



SRC_URI = "http://handhelds.org/~zecke/oe_packages/fish_V1.1.0.tar.gz \
           file://Makefile.patch;patch=1 \
           file://fish.patch;patch=1"

PV = "1.1.0"
S = "${WORKDIR}/fish_V${PV}"

APPNAME = "fish"
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
