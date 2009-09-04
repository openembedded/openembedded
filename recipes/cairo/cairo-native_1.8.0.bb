
require cairo_1.8.0.bb

inherit native

DEPENDS += "glib-2.0-native libpng-native libpixman-native libx11-native fontconfig-native"
PROVIDES = "cairo-native"

PR = "r0"

