SECTION = "x11/base"
include libx11_${PV}.bb
inherit native
DEPENDS = "xproto-native xextensions-native xau-native xtrans-native libxdmcp-native"
PROVIDES = ""
