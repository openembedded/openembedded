require libxau_${PV}.bb

DEPENDS = "xproto-native util-macros-native"
PROVIDES = ""
FILE_PR = "r1"

XORG_PN = "libXau"

inherit native
