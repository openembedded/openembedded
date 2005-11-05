DESCRIPTION = "Time Sleuth"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Dafydd Walters"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/applications-TimeSleuth.html"
PR = "r1"

SRC_URI = "http://handhelds.org/~zecke/oe_packages/timesleuth_V1.05ern.tar.gz "

PV = "1.05ern"
S = "${WORKDIR}/timesleuth_V${PV}"

APPNAME = "timesleuthqpe"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_install () {
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/
	
}

inherit opie
