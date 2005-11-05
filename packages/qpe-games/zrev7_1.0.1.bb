DESCRIPTION = "Reversi"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Mario Weilguni"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-ZRev7.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/zrev7_V1.0.1.tar.gz \
           file://zrev.patch;patch=1"

PV = "1.0.1"
S = "${WORKDIR}/zrev7_V${PV}"

APPNAME = "zrev7"
APPTYPE = "binary"



do_compile_prepend() {
	oe_runmake -C images	
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
}


inherit opie
