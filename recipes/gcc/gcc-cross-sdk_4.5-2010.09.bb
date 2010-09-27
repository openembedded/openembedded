PR = "r4"

inherit sdk

require gcc-${PV}.inc
require gcc-cross-sdk.inc

EXTRA_OECONF += " --disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native} --with-system-zlib"

