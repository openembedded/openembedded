PR = "r13"

require gcc-${PV}.inc
require gcc-package-target.inc
require gcc-cross.inc
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gcc-${PV}"
require gcc3-build-cross.inc
require gcc-package-cross.inc
