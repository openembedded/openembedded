PR = "${INC_PR}.3"

require gcc-${PV}.inc
require gcc-cross-sdk.inc

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

