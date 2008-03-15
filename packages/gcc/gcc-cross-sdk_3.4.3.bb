require gcc-${PV}.inc
require gcc-package-target.inc
PR = "r1"

inherit sdk

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gcc-${PV}"

DEPENDS = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-for-gcc"
PACKAGES = "${PN}"

require gcc3-build-sdk.inc
require gcc-package-sdk.inc
