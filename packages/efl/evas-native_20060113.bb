include evas-fb_${PV}.bb
inherit native
DEPENDS = "freetype-native libpng-native jpeg-native eet-native"
PROVIDES = "evas-native"
EXTRA_OECONF += "--enable-buffer"