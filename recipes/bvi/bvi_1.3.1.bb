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

SRC_URI[md5sum] = "b9d77c57bda2e019207a1874d9bb4dea"
SRC_URI[sha256sum] = "c94dbfa293cbc61b8571d025e90fd1f06a34f8d4e5b11a59856bfc1f13014de3"
