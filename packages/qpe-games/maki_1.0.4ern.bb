DESCRIPTION = "Maki"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Henry So, Jr."
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Maki.html"



SRC_URI = "http://handhelds.org/~zecke/oe_packages/maki_V1.0.4ern.tar.gz \
	   file://maki.patch;patch=1"

PV = "1.0.4ern"
S = "${WORKDIR}/maki_V${PV}"

APPNAME = "maki"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	
}

inherit opie
