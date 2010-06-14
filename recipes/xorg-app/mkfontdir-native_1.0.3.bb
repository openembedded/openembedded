inherit native

require mkfontdir_${PV}.bb

DEPENDS = "util-macros-native mkfontscale-native"

S = "${WORKDIR}/mkfontdir-${PV}"
XORG_PN = "mkfontdir"
