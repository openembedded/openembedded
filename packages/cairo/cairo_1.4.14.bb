require cairo.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz \
file://0001-Fix-for-a-memory-leak-in-pixman.patch;patch=1;p=1"

PR = "r0"

