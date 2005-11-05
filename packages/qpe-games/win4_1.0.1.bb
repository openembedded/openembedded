DESCRIPTION = "4 wins"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Anders Widell, Steve Dunham, Robert Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Win4.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/win4_V1.0.1.tar.gz \
           file://win4.patch;patch=1"

PV = "1.0.1"
S = "${WORKDIR}/win4_V${PV}"

APPNAME = "win4"
APPTYPE = "binary"
APPDESKTOP = "${S}"


do_compile_prepend() {
	oe_runmake -C images		
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
}


inherit opie
