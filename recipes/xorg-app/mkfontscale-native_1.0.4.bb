inherit native
require mkfontscale_1.0.4.bb

DEPENDS = "libx11-native libfontenc-native freetype-native"

S="${WORKDIR}/mkfontscale-${PV}"
XORG_PN="mkfontscale"

SRC_URI[archive.md5sum] = "e5d7373c4266973b3b13aac5d1a4655b"
SRC_URI[archive.sha256sum] = "dc9b946cc23490c960fbca8b32e4bba4bc23ce404a8d7e1c0e916894c83b4227"
