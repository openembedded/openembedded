include ecore-fb_${PV}.bb
inherit native
DEPENDS = "curl-native edb-native eet-native evas-native freetype-native"

export CURL_CONFIG = "${STAGING_BINDIR}/curl-config-native"
export EVAS_CONFIG = "${STAGING_BINDIR}/evas-config-native"
export EDB_CONFIG = "${STAGING_BINDIR}/edb-config-native"
export EET_CONFIG = "${STAGING_BINDIR}/eet-config-native"
export FREETYPE_CONFIG = "${STAGING_BINDIR}/freetype-config-native"
