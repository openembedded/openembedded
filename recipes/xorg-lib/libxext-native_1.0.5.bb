require libxext_${PV}.bb

PROVIDES = ""

DEPENDS = "libx11-native libxau-native xextproto-native"
PE = "1"

inherit native

SRC_URI[archive.md5sum] = "aa11d859cc8e9a0bad3bb55e1666547b"
SRC_URI[archive.sha256sum] = "1280af98466cb4484a89858ede3347ba9d7785baeb80b11f2066142dc2317d97"
