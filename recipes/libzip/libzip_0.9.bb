DESCRIPTION = "C library for reading, creating, and modifying zip archives"
SECTION = "libs"
HOMEPAGE = "http://www.nih.at/libzip"
LICENSE = "BSD"
DEPENDS = "zlib"

SRC_URI = "http://www.nih.at/${PN}/${PN}-${PV}.tar.bz2"

inherit autotools

do_stage() {
	autotools_stage_all
}
