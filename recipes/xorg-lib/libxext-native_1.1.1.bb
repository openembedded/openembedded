require xorg-lib-common.inc

DESCRIPTION = "X11 miscellaneous extension library"
DEPENDS += "xproto-native libx11-native xextproto-native libxau-native util-macros-native"
PROVIDES = ""
PR = "r1"
PE = "1"

XORG_PN = "libXext"

inherit native 

