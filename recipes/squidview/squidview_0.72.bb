DESCRIPTION = "Interactive console program which monitors and displays squid logs"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "ncurses"
RDEPENDS = "squid"

S = "${WORKDIR}/squidview-${PV}"

SRC_URI = "http://www.rillion.net/squidview/squidview-${PV}.tar.gz"

inherit autotools
