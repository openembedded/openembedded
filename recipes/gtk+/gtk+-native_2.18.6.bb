
require gtk+_${PV}.bb

inherit native

DEPENDS += "atk-native pango-native cairo-native"
PROVIDES = "gtk+-native"

EXTRA_OECONF += "--without-libtiff --disable-modules"


