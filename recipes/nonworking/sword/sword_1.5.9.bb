DESCRIPTION = "The SWORD Project is an open source, cross-platform \
(Linux, Windows, Solaris, MacOSX etc.) API and library for \
Bible software with a constantly growing list of front-ends \
(GUI, textmode, web-based, etc.) and a library of over 200 text modules"
SECTION = "libs"
HOMEPAGE = "http://www.e-sword.net/"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.crosswire.org/ftpmirror/pub/sword/source/v1.5/sword-${PV}.tar.gz \
           file://gcc-visibility.patch;patch=1"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--without-clucene --without-curl"

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "e1f1af8c2add8310d0bbcddc9af523b8"
SRC_URI[sha256sum] = "dd170431235cc419cbe6c40362640927a78dc93e082623709abe1310fe804481"
