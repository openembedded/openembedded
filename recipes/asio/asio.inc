DESCRIPTION = "Asio"
HOMEPAGE = "http://asio.sf.net/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "Boost Software License"

INC_PR = "r1"

DEPENDS = "boost"

SRC_URI = "${SOURCEFORGE_MIRROR}/asio/${PN}-${PV}.tar.bz2"

inherit autotools

