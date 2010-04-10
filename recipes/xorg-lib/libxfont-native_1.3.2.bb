require libxfont_${PV}.bb

DEPENDS = "xproto-native zlib-native fontcacheproto-native fontsproto-native \
           libfontenc-native xtrans-native freetype-native util-macros-native"
PROVIDES = "${P} ${PF} ${PN}"
PE = "1"

# no need for patch used in libxfont
SRC_URI = "${XORG_MIRROR}/individual/lib/${XORG_PN}-${PV}.tar.bz2"

inherit native

SRC_URI[md5sum] = "64f510ebf9679f3a97a3d633cbee4f50"
SRC_URI[sha256sum] = "c167cfd529b7c67f496ee0bed3c0b43e0107de0f689d387c1c0e23ef7cf3d2f2"
