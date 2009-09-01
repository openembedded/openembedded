require libxext_${PV}.bb

DEPENDS = "libx11-native libxau-native xextproto-native"
PE = "1"

inherit native
