SECTION = "base"
include ipkg_${PV}.bb
inherit native

DEPENDS = "patcher-native libtool-native automake-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/ipkg-${PV}"
PROVIDES = ""
