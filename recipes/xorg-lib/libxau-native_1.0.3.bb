require libxau_${PV}.bb

DEPENDS = "xproto-native util-macros-native"
PROVIDES = ""
PR = "r1"

XORG_PN = "libXau"

inherit native
