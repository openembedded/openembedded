DESCRIPTION = "Screen is a full-screen window manager \
that multiplexes a physical terminal between several \
processes, typically interactive shells."
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "ncurses"
PR = "r1"

SRC_URI = "${GNU_MIRROR}/screen/screen-${PV}.tar.gz \
           ${DEBIAN_MIRROR}/main/s/screen/screen_4.0.2-4.1.diff.gz;patch=1 \
           file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-pty-mode=0620 --with-pty-group=5"
