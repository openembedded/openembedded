inherit native
DEPENDS = "zlib-native lzo-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/mtd-utils"

NATIVE_INSTALL_WORKS = "1"
