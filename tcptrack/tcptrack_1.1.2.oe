SECTION = "console/network"
DESCRIPTION = "tcptrack is a packet sniffer, which passively watches for \
connections on a specified network interface, tracks their states, and lists \
them in a manner similar to the Unix 'top' command."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "LGPL"
DEPENDS = "ncurses libpcap"

SRC_URI = "http://www.rhythm.cx/~steve/devel/tcptrack/release/${PV}/source/tcptrack-${PV}.tar.gz \
	   file://macros.patch;patch=1"
S = "${WORKDIR}/tcptrack-${PV}"

inherit autotools
