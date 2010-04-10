DESCRIPTION = "ZIQ"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Bill Wetter"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-ZIQ.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/ziq_V1.1ern.tar.gz \
           file://ziq.patch;patch=1"

PV = "1.1ern"
PR = "r1"
S = "${WORKDIR}/ziq_V${PV}"


APPNAME = "ziq"
APPTYPE = "binary"
APPDESKTOP = "${S}"


do_install () {
	install -d ${D}${palmtopdir}/apps/Games/
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -d ${D}${palmtopdir}/apps/Games
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
}


inherit opie

SRC_URI[md5sum] = "f8c6b4b8b5b6f62ec9fc117e4b35fd53"
SRC_URI[sha256sum] = "995a52223365ec41ae72ef781bde2c8f2f34e0e5dd19e17245f5f354ac52fb8b"
