require libxt_${PV}.bb

inherit native

DEPENDS = "libx11-native libsm-native kbproto-native"

XORG_PN = "libXt"
