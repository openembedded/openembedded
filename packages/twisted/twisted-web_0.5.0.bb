DESCRIPTION = "Twisted web is a web server, and also provides basic HTTP \
client support. You may want to check out Nevow, a templating toolkit \
designed for twisted.web, and Twisted Web2, the next generation Twisted web server."

HOMEPAGE = "http://www.twistedmatrix.com"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "twisted-native"
RDEPENDS = "twisted"

SRC_URI = "http://tmrc.mit.edu/mirror/twisted/Web/0.5/TwistedWeb-${PV}.tar.bz2"

S = "${WORKDIR}/TwistedWeb-${PV}"

inherit distutils

