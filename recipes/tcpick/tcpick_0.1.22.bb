DESCRIPTION = "Tcpick Tcp Stream Sniffer and Connection Tracker"
SECTION = "console/network"
PRIORITY = "required"
DEPENDS = "ncurses"
LICENSE = "GPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/tcpick/tcpick-${PV}.tar.gz"
S = "${WORKDIR}/tcpick-${PV}"

inherit autotools

SRC_URI[md5sum] = "77b991a686e83cb716fd241aaa6ea432"
SRC_URI[sha256sum] = "db19142fd2ca6218ead04fb3144b1640e2ad5a1c784a4e790c8816a37a79ac2e"
