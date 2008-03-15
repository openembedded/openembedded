require gcc-${PV}.inc
require gcc-package-target.inc
require gcc-cross.inc
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gcc-${PV}"
PR = "r10"

DEPENDS += "gmp-native mpfr-native"

# cross build
require gcc3-build-cross.inc
# cross packaging
require gcc-package-cross.inc
