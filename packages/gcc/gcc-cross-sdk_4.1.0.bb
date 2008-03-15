PR = "r2"

inherit sdk

require gcc-${PV}.inc
require gcc4-build-sdk.inc
require gcc-package-sdk.inc

DEPENDS = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-for-gcc gmp-native mpfr-native"