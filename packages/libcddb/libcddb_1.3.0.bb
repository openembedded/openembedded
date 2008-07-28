DESCRIPTION = "A library for accessing a CDDB server"
HOMEPAGE = "http://libcddb.sourceforge.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL-2"
MAINTAINER = "Andreas Frisch <andreas.frisch@multimedia-labs.de>"

SRC_URI = "http://downloads.sourceforge.net/${PN}/${PN}-${PV}.tar.bz2\
	    file://${P}-asneeded-nonglibc.patch;patch=1"

inherit autotools

DEPEND="doc? ( app-doc/doxygen )"
