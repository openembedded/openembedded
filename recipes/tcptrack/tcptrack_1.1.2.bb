SECTION = "console/network"
DESCRIPTION = "tcptrack is a packet sniffer, which passively watches for \
connections on a specified network interface, tracks their states, and lists \
them in a manner similar to the Unix 'top' command."
LICENSE = "LGPL"
DEPENDS = "ncurses libpcap"

SRC_URI = "http://www.rhythm.cx/~steve/devel/tcptrack/release/${PV}/source/tcptrack-${PV}.tar.gz \
	   file://macros.patch;patch=1"
S = "${WORKDIR}/tcptrack-${PV}"

inherit autotools

SRC_URI[md5sum] = "f27e025d9e69f36a7d8b679c047daba1"
SRC_URI[sha256sum] = "2bfbdd6df159c815b392cd99146df5a450c1a8ffab30a13fd34bced8ee33cda0"
