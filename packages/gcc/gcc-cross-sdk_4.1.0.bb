require gcc-${PV}.inc
require gcc-package-target.inc
PR = "r2"

inherit sdk

DEPENDS = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-for-gcc"
PACKAGES = "${PN}"

require gcc4-build-sdk.inc
require gcc-package-sdk.inc
