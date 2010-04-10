require libxfont_${PV}.bb

DEPENDS = "xproto-native zlib-native fontcacheproto-native fontsproto-native \
           libfontenc-native xtrans-native freetype-native util-macros-native"
PROVIDES = "${P} ${PF} ${PN}"
PE = "1"

# no need for patch used in libxfont
SRC_URI = "${XORG_MIRROR}/individual/lib/${XORG_PN}-${PV}.tar.bz2"

inherit native

SRC_URI[md5sum] = "4f2bed2a2be82e90a51a24bb3a22cdf0"
SRC_URI[sha256sum] = "112bfc30820b98deec4c9914536c5aa2f8b5162bd2b0bdb342343168e06f7679"
