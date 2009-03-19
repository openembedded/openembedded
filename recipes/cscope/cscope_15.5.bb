DEPENDS = "ncurses"
DESCRIPTION = "A text screen-based source browser."
SECTION = "console/utils"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/cscope/cscope-${PV}.tar.gz"

inherit autotools

do_compile () {
	oe_runmake 'LDFLAGS=${LDFLAGS}'
}
