DESCRIPTION = "Sub Marine Hunt"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Kart Bartel, Robert Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-ZSubhunt.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/zsubhunt_V1.0.0ern.tar.gz "

PV = "1.0.0ern"
S = "${WORKDIR}/zsubhunt_V${PV}"


APPNAME = "zsubhunt"
APPTYPE = "binary"
APPDESKTOP = "${S}"


do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/pics/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
}


inherit opie
