SECTION = "base"
include ipkg_${PV}.bb
inherit native

DEPENDS = "libtool-native automake-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/ipkg-${PV}"
PROVIDES = ""
