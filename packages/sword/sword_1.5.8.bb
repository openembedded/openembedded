DESCRIPTION = "The SWORD Project is an open source, cross-platform \
(Linux, Windows, Solaris, MacOSX etc.) API and library for \
Bible software with a constantly growing list of front-ends \
(GUI, textmode, web-based, etc.) and a library of over 200 text modules"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "curl"
PR ="r1"

SRC_URI = "http://www.crosswire.org/ftpmirror/pub/sword/source/v1.5/sword-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--without-clucene --with-curl"

do_stage() {
autotools_stage_all
}
