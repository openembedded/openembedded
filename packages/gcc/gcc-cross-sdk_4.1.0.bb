require gcc-${PV}.inc
PR = "r2"

inherit sdk

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gcc-${PV}"

DEPENDS = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-for-gcc"
PACKAGES = "${PN}"

require gcc4-build-sdk.inc
require gcc-package-sdk.inc
