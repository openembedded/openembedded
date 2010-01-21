require libpng_${PV}.bb
require libpng-native.inc

PR = "r1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libpng-${PV}"
