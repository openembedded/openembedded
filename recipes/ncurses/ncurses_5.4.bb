PR = "r19"

SRC_URI = "${GNU_MIRROR}/ncurses/ncurses-${PV}.tar.gz \
           file://makefile_tweak.patch;patch=1 \
           file://use_ldflags.patch;patch=1 \
           file://visibility.patch;patch=1"
S = "${WORKDIR}/ncurses-${PV}"

require ncurses.inc

LEAD_SONAME = "libncurses.so.5"

SRC_URI[md5sum] = "069c8880072060373290a4fefff43520"
SRC_URI[sha256sum] = "5abce063cf431790f4e6a801a96c7eea0b33a41ecd0970f6312f52575c083b36"
