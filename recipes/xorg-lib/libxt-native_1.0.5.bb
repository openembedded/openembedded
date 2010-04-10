require libxt_${PV}.bb

DEPENDS = "libx11-native libsm-native kbproto-native"
PROVIDES = "xt-native"

inherit native

XORG_PN = "libXt"

SRC_URI[archive.md5sum] = "f3bdd67785ace8cd0b23249e9d8c9975"
SRC_URI[archive.sha256sum] = "43c472ada59a04428a463225cd4cd42cb81bc43eb687cc1890f2f1c81a3e9cf4"
