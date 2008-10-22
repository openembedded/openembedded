require cairo.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz \
file://stats.patch;patch=1;p=1"

PR = "r0"

