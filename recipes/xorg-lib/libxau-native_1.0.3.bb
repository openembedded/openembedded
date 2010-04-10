require libxau_${PV}.bb

DEPENDS = "xproto-native util-macros-native"
PROVIDES = ""
PR = "r1"

XORG_PN = "libXau"

inherit native

SRC_URI[archive.md5sum] = "75a9f2b85cd1617b5ca98c9095323853"
SRC_URI[archive.sha256sum] = "d6c30a88770a720e96e0bd7e13e0334f9ef60f1b475a92556764828005c19e3b"
