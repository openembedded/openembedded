DESCRIPTION = "Tron"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Matthias Kiefer"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Tron.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/tron_V1.0.0.tar.gz \
           file://tron.patch;patch=1"

PV = "1.0.0"
S = "${WORKDIR}/tron_V${PV}"

APPNAME = "tron"
APPTYPE = "binary"
APPDESKTOP = "${S}"


do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

}


inherit opie

SRC_URI[md5sum] = "65e8a11836493aacae7b6d3895807efb"
SRC_URI[sha256sum] = "226cd1c59495349686d82250ff59f40319f3f7f469a3320b837ed3c344bec037"
