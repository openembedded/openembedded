PR = "r5"

inherit sdk

DEPENDS = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-for-gcc gmp-native mpfr-native"

require gcc-${PV}.inc
require gcc-package-target.inc
require gcc4-build-sdk.inc
require gcc-package-sdk.inc

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${layout_exec_prefix}"
