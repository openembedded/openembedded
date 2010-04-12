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

SRC_URI[md5sum] = "56b9f11c1eee5eed189a20183d7e06b0"
SRC_URI[sha256sum] = "23a8c3624122a3777bb4ac3be4a867fd0bed7f3aacb8f1d0b68fc459cfb035fc"
