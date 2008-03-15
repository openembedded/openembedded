SECTION = "devel"
require gcc-${PV}.inc
require gcc-package-target.inc
require gcc-paths-cross.inc
inherit cross
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gcc-${PV}"

PR="r6"

DEPENDS = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-for-gcc"
PROVIDES = "virtual/${TARGET_PREFIX}gcc virtual/${TARGET_PREFIX}g++"

require gcc3-build-cross.inc
require gcc-package-cross.inc
