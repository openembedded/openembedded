DESCRIPTION = "The SWORD Project is an open source, cross-platform \
(Linux, Windows, Solaris, MacOSX etc.) API and library for \
Bible software with a constantly growing list of front-ends \
(GUI, textmode, web-based, etc.) and a library of over 200 text modules"
SECTION = "libs"
HOMEPAGE = "http://www.e-sword.net/"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.crosswire.org/ftpmirror/pub/sword/source/v1.5/sword-${PV}.tar.gz"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--without-clucene --without-curl"

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "4c920f2a3ee72040df8a8e105ad840df"
SRC_URI[sha256sum] = "5fb3f030e9395e23a48c02bde6bc81ad42b1c4056a011d9ee15c4c85110eb847"
