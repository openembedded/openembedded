DEPENDS = "ncurses"
DESCRIPTION = "An ASCII art gfx library."
SECTION = "libs"
LICENSE="LGPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/aa-project/aalib-${PV}.tar.gz \
	   file://configure.patch;patch=1"
S = "${WORKDIR}/aalib-1.4.0"

inherit autotools 

EXTRA_OECONF = '--without-x11-driver --without-slang-driver \
		--with-curses-driver --without-gpm \
		--without-x --with-ncurses=${STAGING_LIBDIR}/..'
