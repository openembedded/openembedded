DESCRIPTION = "Tcpick Tcp Stream Sniffer and Connection Tracker"
SECTION = "console/network"
PRIORITY = "required"
DEPENDS = "ncurses"
LICENSE = "GPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/tcpick/tcpick-${PV}.tar.gz"
S = "${WORKDIR}/tcpick-${PV}"

inherit autotools
