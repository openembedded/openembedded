inherit native
require mkfontscale_1.0.4.bb

DEPENDS = "libx11-native libfontenc-native freetype-native"

S="${WORKDIR}/mkfontscale-${PV}"
XORG_PN="mkfontscale"
