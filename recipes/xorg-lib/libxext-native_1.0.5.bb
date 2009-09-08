require libxext_${PV}.bb

PROVIDES = ""

DEPENDS = "libx11-native libxau-native xextproto-native"
PE = "1"

inherit native
