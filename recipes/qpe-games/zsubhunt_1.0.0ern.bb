DESCRIPTION = "Sub Marine Hunt"
SECTION = "opie/games"
PRIORITY = "optional"
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
	install -d ${D}${palmtopdir}/apps/Games/
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/pics/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
}


inherit opie

SRC_URI[md5sum] = "7f1fee1e58d92fbe72ffee34078c6fa2"
SRC_URI[sha256sum] = "d31c51a3db059c564e77ee8776f441b3ea530089a7b48aa31a49d2ebf7bf9dc9"
