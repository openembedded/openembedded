DESCRIPTION = "PowerTOP, a tool that helps you find what software is using the most power."
HOMEPAGE = "http://www.linuxpowertop.org/"
LICENSE = "GPLv2"
DEPENDS = "virtual/libintl ncurses"

PR = "r1"

SRC_URI = "http://www.lesswatts.org/projects/powertop/download/powertop-${PV}.tar.gz"

SRC_URI_append_armv7a = " file://omap.patch;patch=1;pnum=0"

CFLAGS += "${LDFLAGS}"
CFLAGS_append_beagleboard = " -DOMAP3"
CFLAGS_append_overo = " -DOMAP3"
CFLAGS_append_omap3evm = " -DOMAP3"
CFLAGS_append_omapzoom2 = " -DOMAP3"


do_configure() {
    # We do not build ncurses with wide char support
    sed -i -e "s/lncursesw/lncurses/" ${S}/Makefile
}

do_install() {
    oe_runmake install DESTDIR=${D}
}
