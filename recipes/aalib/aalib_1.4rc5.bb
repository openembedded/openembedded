DEPENDS = "ncurses"
DESCRIPTION = "An ASCII art gfx library."
SECTION = "libs"
LICENSE="LGPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/aa-project/aalib-${PV}.tar.gz \
	   file://configure.patch;patch=1"
S = "${WORKDIR}/aalib-1.4.0"

inherit autotools

EXTRA_OECONF = '--without-x11-driver --without-slang-driver \
		--with-curses-driver --without-gpm \
		--without-x --with-ncurses=${STAGING_LIBDIR}/..'

do_stage() {
    oe_libinstall -a -so -C src libaa ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/
	install -m 0644 src/*.h ${STAGING_INCDIR}/
}
