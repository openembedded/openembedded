include imlib2.inc
inherit native
DEPENDS = "freetype-native libpng-native jpeg-native"

export FREETYPE_CONFIG = "${STAGING_BINDIR}/freetype-config-native"

EXTRA_OECONF = "--disable-mmx \
                --without-x"
