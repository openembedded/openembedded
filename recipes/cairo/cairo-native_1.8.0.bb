
require cairo_1.8.0.bb

inherit native

DEPENDS += "glib-2.0-native libpng-native pixman-native libx11-native fontconfig-native"
PROVIDES = "cairo-native"

PR = "r1"

SRC_URI[md5sum] = "4ea70ea87b47e92d318d4e7f5b940f47"
SRC_URI[sha256sum] = "827acee89ba3e8e762fbb23165cf8d455e7d95e1e50984e6882b2070a7f3abae"
