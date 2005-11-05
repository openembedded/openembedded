include imlib2.inc
inherit native
PROVIDES = "imlib2-native"
DEPENDS = "freetype-native libpng-native jpeg-native"

EXTRA_OECONF = "--disable-mmx \
                --without-x"
