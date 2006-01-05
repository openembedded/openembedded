DESCRIPTION = "Twisted is an event-driven networking framework written in Python and licensed under the LGPL. \
Twisted supports TCP, UDP, SSL/TLS, multicast, Unix sockets, a large number of protocols                   \
(including HTTP, NNTP, IMAP, SSH, IRC, FTP, and others), and much more."
HOMEPAGE = "http://www.twistedmatrix.com"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "zope-interfaces-native"
RDEPENDS = "python-core zope-interfaces python-pickle python-fcntl"

SRC_URI = "http://tmrc.mit.edu/mirror/twisted/Twisted/2.1/Twisted-${PV}.tar.bz2"

S = "${WORKDIR}/Twisted-${PV}"

inherit distutils

