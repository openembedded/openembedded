require xtrans_${PV}.bb

DEPENDS = "util-macros-native"
PE = "1"

XORG_PN = "xtrans"

SRC_URI = "${XORG_MIRROR}/individual/lib/${XORG_PN}-${PV}.tar.bz2"

inherit native

SRC_URI[md5sum] = "bb196907ea1e182dcb396eb22f7d2c1a"
SRC_URI[sha256sum] = "e1a3c4986f16a5fbca611d0547cc7499a1fa47ca2096593644037e2609363085"
