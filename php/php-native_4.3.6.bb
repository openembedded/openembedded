SECTION = "console/network"
include php_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/php-${PV}"
DEPENDS = "zlib-native"
