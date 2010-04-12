DESCRIPTION = "C++ library for serial port support."
SECTION = "libs"
LICENSE = "GPL"
HOMEPAGE = "http://libserial.sourceforge.net/mediawiki/index.php/Main_Page"

SRC_URI = "${SOURCEFORGE_MIRROR}/libserial/libserial-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "7a3766e354c31513ff6d7859a4b2c1b8"
SRC_URI[sha256sum] = "898012c30596bba605cdee76a80dd6a7a42506cc04d0137e23e2c40681573f03"
