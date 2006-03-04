DESCRIPTION = "Twisted.Web2 is the next generation Web Server Framework \
built with Twisted. Web2 is under active development and it's APIs should \
not be considered stable at this point. It is not a version of Twisted.Web \
and with that in mind compatibility is not of the highest concern, though \
the compatibility layer does support many but not all twisted.web resources."
HOMEPAGE = "http://www.twistedmatrix.com"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "twisted twisted-native"
RDEPENDS = "twisted python-netserver"

SRC_URI = "http://tmrc.mit.edu/mirror/twisted/Web2/TwistedWeb2-${PV}.tar.bz2"
S = "${WORKDIR}/TwistedWeb2-${PV}"

inherit distutils

