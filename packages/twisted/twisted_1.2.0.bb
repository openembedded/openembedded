DESCRIPTION = "Twisted is an event-driven networking framework written in \
Python and licensed under the LGPL. \ Twisted supports TCP, UDP, SSL/TLS, \
multicast, Unix sockets, a large number of protocols (including HTTP, NNTP, \
IMAP, SSH, IRC, FTP, and others), and much more."
HOMEPAGE = "http://www.twistedmatrix.com"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "LGPL"
RDEPENDS = "python-core"
PR = "r1"

SRC_URI = "http://tmrc.mit.edu/mirror/twisted/old/Twisted-${PV}.tar.bz2"
S = "${WORKDIR}/Twisted-${PV}"

inherit distutils

FILES_${PN}-dbg += "${libdir}/python2.4/site-packages/twisted/protocols/.debug"
FILES_${PN}-dbg += "${libdir}/python2.4/site-packages/twisted/runner/.debug"
FILES_${PN}-dbg += "${libdir}/python2.4/site-packages/twisted/spread/.debug"
