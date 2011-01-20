PR = "${INC_PR}.2"

require gcc-${PV}.inc
require gcc-cross4.inc

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch "

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"
