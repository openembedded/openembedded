DESCRIPTION = "GNU Netcat"
HOMEPAGE = "http://netcat.sourceforge.net"
SECTION = "console/network"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/netcat/netcat-${PV}.tar.bz2"

inherit autotools
