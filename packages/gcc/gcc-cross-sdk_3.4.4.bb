require gcc-${PV}.inc
require gcc-package-target.inc
PR = "r3"

inherit sdk

DEPENDS = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-for-gcc"
PACKAGES = "${PN}"

require gcc3-build-sdk.inc
require gcc-package-sdk.inc
