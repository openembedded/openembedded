DESCRIPTION = "Tron"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
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
