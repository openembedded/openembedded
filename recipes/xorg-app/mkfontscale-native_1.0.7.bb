inherit native
require mkfontscale_${PV}.bb

DEPENDS = "libx11-native libfontenc-native freetype-native"

S="${WORKDIR}/mkfontscale-${PV}"
XORG_PN="mkfontscale"

SRC_URI[archive.md5sum] = "96ca346f185c0ab48e42bf5bb0375da5"
SRC_URI[archive.sha256sum] = "8306b229cca233216a6582cb1ff60af78e37c47d6412ac823d7d41c3d7de7127"
