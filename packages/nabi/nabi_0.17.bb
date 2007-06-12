DESCRIPTION = "Nabi is an easy and powerful GNU XIM for the Korean language"
HOMEPAGE = "http://nabi.kldp.net/"
SECTION = "x11/input"
LICENSE = "GPL"
DEPENDS = "gtk+ libhangul"

SRC_URI = "http://kldp.net/frs/download.php/3742/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig
