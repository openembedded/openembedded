inherit native
require mkfontscale_${PV}.bb

DEPENDS = "libx11-native libfontenc-native freetype-native"

S="${WORKDIR}/mkfontscale-${PV}"
XORG_PN="mkfontscale"
