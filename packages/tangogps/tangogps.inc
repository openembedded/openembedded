DESCRIPTION = "A lightweight and fast mapping application"
LICENSE = "GPLv2"
SECTION = "x11/applications"
PRIORITY = "optional"
DEPENDS = "curl gtk+ gconf gypsy"

SRC_URI = "http://www.tangogps.org/downloads/tangogps-${PV}.tar.gz"
S = "${WORKDIR}/tangogps-${PV}"

inherit autotools
