DESCRIPTION = "ZTappy"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Kart Bartel, Robert Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-ZTappy.html"



SRC_URI = "http://handhelds.org/~zecke/oe_packages/ztappy_V0.9.3ern.tar.gz "

PV = "0.9.3ern"
S = "${WORKDIR}/ztappy_V${PV}"


APPNAME = "ztappy"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/pics/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
}

inherit opie
