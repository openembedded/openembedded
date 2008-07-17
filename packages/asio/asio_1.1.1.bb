DESCRIPTION = "Asio"
HOMEPAGE = "http://asio.sf.net/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "Boost Software License"

SRC_URI = "${SOURCEFORGE_MIRROR}/asio/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}	

