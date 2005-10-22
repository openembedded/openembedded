DESCRIPTION = "GNU Netcat"
HOMEPAGE = "http://netcat.sourceforge.net"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "console/networking"
PR = "r1"

# Note: ${SOURCEFORGE_MIRROR} wasn't working
SRC_URI = "http://osdn.dl.sourceforge.net/sourceforge/netcat/netcat-${PV}.tar.bz2"

inherit autotools
