DESCRIPTION = "Tickypip levels from NetWalk Group"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "${PN}"
SRC_DISTRIBUTE_LICENSES += "${PN}"
AUTHOR = "NetWalk Group <netwalkgroup@hotmail.com>"
RDEPENDS = "tickypip"
PACKAGE_ARCH = "all"
PR = "r1"

SRC_URI = "http://ewi546.ewi.utwente.nl/mirror/hrw-oe-sources/tickypip-levels_${PV}.tar.bz2"

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
