DESCRIPTION = "Screen is a full-screen window manager \
that multiplexes a physical terminal between several \
processes, typically interactive shells."
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "ncurses"
PR = "r2"

SRC_URI = "${GNU_MIRROR}/screen/screen-${PV}.tar.gz \
           file://screen_4.0.2-4.1sarge1.diff.gz;patch=1 \
           file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-pty-mode=0620 --with-pty-group=5"

SRC_URI[md5sum] = "ed68ea9b43d9fba0972cb017a24940a1"
SRC_URI[sha256sum] = "05d087656d232b38c82379dfc66bf526d08e75e1f4c626acea4a2dda1ebcc845"
