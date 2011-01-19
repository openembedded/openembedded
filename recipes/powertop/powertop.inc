DESCRIPTION = "PowerTOP, a tool that helps you find what software is using the most power."
HOMEPAGE = "http://www.linuxpowertop.org/"
LICENSE = "GPLv2"
DEPENDS = "virtual/libintl ncurses"

INC_PR = "r3"

SRC_URI = "http://www.lesswatts.org/projects/powertop/download/powertop-${PV}.tar.gz \
	   file://ldflags.patch \
	  "

CFLAGS += "${LDFLAGS}"

do_configure() {
    # We do not build ncurses with wide char support
    # sed -i -e "s/lncursesw/lncurses/" ${S}/Makefile
    :
}

do_install() {
    oe_runmake install DESTDIR=${D}
}


LDFLAGS_append_libc-uclibc = " -lintl"
