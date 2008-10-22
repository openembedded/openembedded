HOMEPAGE = "http://bvi.sourceforge.net/"
DESCRIPTION = "binary vi (binary file editor)"
SECTION = "console/utils"
DEPENDS = "ncurses"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/bvi/bvi-${PV}.src.tar.gz \
	   file://configure.patch;patch=1 \
	   file://compile.patch;patch=1 \
	   file://no-strip.patch;patch=1"

inherit autotools
