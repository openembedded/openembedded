require libice_${PV}.bb

DEPENDS = "libx11-native xproto-native xtrans-native"
PROVIDES = "ice-native"

inherit native

XORG_PN = "libICE"

SRC_URI[archive.md5sum] = "4ab4e67e0b8845aa201e984153087f4a"
SRC_URI[archive.sha256sum] = "13055e2f4c645cbd135ce97a7974a5866f9ba3ed8988e686b552f55c30514f04"
