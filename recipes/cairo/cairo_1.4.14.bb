require cairo.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz \
file://0001-Fix-for-a-memory-leak-in-pixman.patch;patch=1;p=1"

PR = "r0"


SRC_URI[md5sum] = "e8c442ff821c0719a69508fecba9038f"
SRC_URI[sha256sum] = "8914f9c34a77bf9d908b0c617c2d7ffebdd6d1e855cfd367d2a1b3d677f22e3c"
