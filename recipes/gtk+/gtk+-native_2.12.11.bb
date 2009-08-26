
require gtk+_2.12.11.bb

inherit native

DEPENDS += "atk-native pango-native cairo-native"
PROVIDES = "gtk+-native"

EXTRA_OECONF += "--without-libtiff --disable-modules"

PR = "r1"

