LICENSE = "GPLv2"
SECTION = "x11/applications"
PRIORITY = "optional"
DESCRIPTION = "lightweight and fast mapping application"
DEPENDS = "curl gtk+ gconf gpsd"
RDEPENDS = "gpsd"

SRC_URI = "http://www.tangogps.org/downloads/${PN}-${PV}.tar.gz"

inherit autotools
