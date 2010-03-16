DEPENDS = "ncurses"
DESCRIPTION = "A text screen-based source browser."
SECTION = "console/utils"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/cscope/cscope-${PV}.tar.bz2;name=src"
SRC_URI[src.md5sum] = "da43987622ace8c36bbf14c15a350ec1"
SRC_URI[src.sha256sum] = "02638bcba790bc8b0562f28dbe789e61794415079d94a676efc287d18dc96037"

inherit autotools

do_compile () {
	oe_runmake 'LDFLAGS=${LDFLAGS}'
}
