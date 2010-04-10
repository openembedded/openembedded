SECTION = "console/network"
DEPENDS = "adns"
DESCRIPTION = "HTTP Proxy Client is a set of libraries and scripts \
that provide transparent access to Internet via HTTP proxy tunnel \
for programs which use TCP/IP for communication. The tunnel is \
provided by the CONNECT method of HTTP proxy, and supports external \
DNS resolution."
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/httppc/httppc-${PV}.tar.gz \
	   file://install.patch;patch=1"

inherit autotools

SRC_URI[md5sum] = "365684629378365de02e127f4a085628"
SRC_URI[sha256sum] = "bedfd45364948a08ecaa212c5eda6667a83ac8bb547e2eb8478ade885898cad7"
