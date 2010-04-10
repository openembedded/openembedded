require libx11_${PV}.bb

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libx11"

DEPENDS = "xproto-native xextproto-native libxau-native xtrans-native libxdmcp-native xcmiscproto-native xf86bigfontproto-native kbproto-native inputproto-native bigreqsproto-native util-macros-native"
PROVIDES = ""

inherit native

#fake it here for the libtool mess
TARGET_PREFIX = "${TARGET_SYS}-"

SRC_URI[archive.md5sum] = "c6265b59ea2b594fd68e33f9125b4d20"
SRC_URI[archive.sha256sum] = "e4863cdf5d471763806e9bcae25ea47606a56cd91a5546a34c093aa3de181051"
