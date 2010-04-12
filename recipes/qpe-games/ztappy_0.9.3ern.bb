DESCRIPTION = "ZTappy"
SECTION = "opie/games"
PRIORITY = "optional"
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
	install -d ${D}${palmtopdir}/apps/Games/
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/pics/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
}

inherit opie

SRC_URI[md5sum] = "2c3881503615d86b78b89ad5f4ec675c"
SRC_URI[sha256sum] = "006c061dc031e711cc3ccccbb659ffb9b09b74ff3be6c5768aecd7297738b1c0"
