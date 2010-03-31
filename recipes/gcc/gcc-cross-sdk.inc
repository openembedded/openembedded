inherit sdk

DEPENDS = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-for-gcc ${NATIVEDEPS}"

require gcc-configure-sdk.inc
require gcc-package-sdk.inc

