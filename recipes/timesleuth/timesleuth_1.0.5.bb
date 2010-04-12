DESCRIPTION = "Time Sleuth"
SECTION = "opie/applications"
PRIORITY = "optional"
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

SRC_URI[md5sum] = "671e48a9ff01de9cd2853a353b8179cb"
SRC_URI[sha256sum] = "f353a33e59a35f2667a00ce60998a06fa25948676dcb4a59599cf6518bd02ca6"
