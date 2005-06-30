SECTION = "libs"
include libpng_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libpng-${PV}"
DEPENDS = "zlib-native"
