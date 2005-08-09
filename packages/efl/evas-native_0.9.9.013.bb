include evas-fb_${PV}.bb
inherit native
DEPENDS = "freetype-native"

export EDB_CONFIG = "${STAGING_BINDIR}/edb-config-native"
export EET_CONFIG = "${STAGING_BINDIR}/eet-config-native"
export FREETYPE_CONFIG = "${STAGING_BINDIR}/freetype-config-native"
