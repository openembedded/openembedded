inherit native

require mkfontdir_1.0.4.bb

DEPENDS = "util-macros-native mkfontscale-native"

S = "${WORKDIR}/mkfontdir-${PV}"
XORG_PN = "mkfontdir"
