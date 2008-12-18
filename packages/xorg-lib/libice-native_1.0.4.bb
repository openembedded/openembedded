require libice_${PV}.bb

inherit native

DEPENDS += "libx11-native xproto-native xtrans-native"

XORG_PN = "libICE"
