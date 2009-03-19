DESCRIPTION = "C++ library for serial port support."
SECTION = "libs"
LICENSE = "GPL"
HOMEPAGE = "http://libserial.sourceforge.net/mediawiki/index.php/Main_Page"

SRC_URI = "${SOURCEFORGE_MIRROR}/libserial/libserial-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

