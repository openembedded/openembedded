DESCRIPTION = "classic basic interpreter"
LICENSE = "GPLv2"
DEPENDS = "ncurses"

SRC_URI = "http://www.blassic.org/bin/blassic-${PV}.tgz"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-graphics=yes"


