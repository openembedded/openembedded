require libxfont_${PV}.bb

DEPENDS = "xproto-native zlib-native fontcacheproto-native fontsproto-native \
           libfontenc-native xtrans-native freetype-native util-macros-native"
PROVIDES = "${P} ${PF} ${PN}"
PE = "1"

# no need for patch used in libxfont
SRC_URI = "${XORG_MIRROR}/individual/lib/${XORG_PN}-${PV}.tar.bz2"

inherit native

SRC_URI[md5sum] = "d1d3fa170d74b066f1f23ca8574e7c90"
SRC_URI[sha256sum] = "07567b9880f28d1a404389c024a185419bfe81136aef3d9eda52407f34c3d3dd"
