DESCRIPTION = "Screen is a full-screen window manager \
that multiplexes a physical terminal between several \
processes, typically interactive shells."
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "ncurses"
PR = "r1"

SRC_URI = "${GNU_MIRROR}/screen/screen-${PV}.tar.gz \
           file://cross-compile.patch;patch=1 \
           file://configure.patch;patch=1 \
           file://sched.patch;patch=1 \
           file://no-stropts.patch;patch=1 \
           file://no-utempter.patch;patch=1 \
	  "

inherit autotools

EXTRA_OECONF = "--with-pty-mode=0620 --with-pty-group=5"
