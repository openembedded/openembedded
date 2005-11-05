DESCRIPTION = "Checkers"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Walter Rawdanik"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Checkers.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/checkers_V1.0.5ern.tar.gz \
           file://checkers.patch;patch=1"

PV = "1.0.5ern"
S = "${WORKDIR}/checkers_V${PV}"
APPNAME = "checkers"
APPTYPE = "binary"
APPDESKTOP = "${S}"


do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	
}


inherit opie
