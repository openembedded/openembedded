DESCRIPTION = "Twisted is an event-driven networking framework written in Python and licensed under the LGPL. \
Twisted supports TCP, UDP, SSL/TLS, multicast, Unix sockets, a large number of protocols                   \
(including HTTP, NNTP, IMAP, SSH, IRC, FTP, and others), and much more."
HOMEPAGE = "http://www.twistedmatrix.com"
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "LGPL"
RDEPENDS = "python-core"

SRC_URI = "http://twisted.sourceforge.net/Twisted-${PV}.tar.bz2"
S = "${WORKDIR}/Twisted-${PV}"

inherit distutils

