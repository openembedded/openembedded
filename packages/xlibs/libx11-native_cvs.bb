SECTION = "x11/base"
include libx11_cvs.bb
inherit native
DEPENDS = "xproto-native xextensions-native libxau-native xtrans-native libxdmcp-native"
PROVIDES = ""
