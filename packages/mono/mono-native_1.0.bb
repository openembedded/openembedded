SECTION = "unknown"
include mono_${PV}.bb
S = "${WORKDIR}/mono-${PV}"
DEPENDS = "glib-2.0-native"

inherit native
