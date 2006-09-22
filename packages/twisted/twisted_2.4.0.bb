DESCRIPTION = "Twisted is an event-driven networking framework written in Python and licensed under the LGPL. \
Twisted supports TCP, UDP, SSL/TLS, multicast, Unix sockets, a large number of protocols                   \
(including HTTP, NNTP, IMAP, SSH, IRC, FTP, and others), and much more."
HOMEPAGE = "http://www.twistedmatrix.com"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "zope-interface-native zope-interface python-crypto twisted-native"
RDEPENDS = "python-core zope-interface python-pickle python-fcntl python-crypto"

SRC_URI = "http://tmrc.mit.edu/mirror/twisted/Twisted/2.4/Twisted-${PV}.tar.bz2"

S = "${WORKDIR}/Twisted-${PV}"

inherit distutils

do_compile_prepend() {
	export PYTHONPATH=${S}/TwistedCore-${PV}
}

do_install_prepend() {
	export PYTHONPATH=${S}/TwistedCore-${PV}
}
