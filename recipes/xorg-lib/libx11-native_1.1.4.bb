require libx11_${PV}.bb

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libx11"

DEPENDS = "xproto-native xextproto-native libxau-native xtrans-native libxdmcp-native xcmiscproto-native xf86bigfontproto-native kbproto-native inputproto-native bigreqsproto-native util-macros-native"
PROVIDES = ""

inherit native

SRC_URI[archive.md5sum] = "1469a5a8aa8d288dce6f4c45d2f68dc3"
SRC_URI[archive.sha256sum] = "bdbd6d239435c1736f5c532b12e8078761db8db5f37ab3195fe11c3e5b692c1c"
