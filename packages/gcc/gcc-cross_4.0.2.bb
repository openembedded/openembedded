PR = "r10"

require gcc-${PV}.inc
require gcc-package-target.inc
require gcc-cross.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gcc-${PV}"

DEPENDS += "gmp-native mpfr-native"

require gcc3-build-cross.inc
require gcc-package-cross.inc
