DESCRIPTION = "Tickypip levels from NetWalk Group"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "${PN}"
SRC_DISTRIBUTE_LICENSES += "${PN}"
AUTHOR = "NetWalk Group <netwalkgroup@hotmail.com>"
RDEPENDS = "tickypip"
PACKAGE_ARCH = "all"
PR = "r1"

SRC_URI = "http://www.openzaurus.org/download/3.5.4/sources/tickypip-levels_${PV}.tar.bz2"

S = "${WORKDIR}/"

#
# Authors response to LICENSE question:
#
# You may distribute them for free provide that you have links to our level
# packs in PalmGear.
#
# Packs available on PalmGear: Pak1, Pak3, Pak8, Pak9, Pak10
#
# URL: http://palmgear.com/index.cfm?fuseaction=software.developer&userID=862314499
#
# I also got permission to distribute rest of levelpacks which was available
# from Palm Gaming World:
# http://www.palmgamingworld.com/add-in/netwalk.shtml
#

do_install () {
	install -d ${D}${palmtopdir}/share/tickypip/levels
	install -m 0644 levels/* ${D}${palmtopdir}/share/tickypip/levels/
}

FILES_${PN} = "${palmtopdir}/"

SRC_URI[md5sum] = "cfdaae67b3d33351e37021cb0394153c"
SRC_URI[sha256sum] = "881109774a77e34c61fbf41a839fe02a95cb3e67a0218fe4aebc5e6999cbaa57"
