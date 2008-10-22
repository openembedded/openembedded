PR = "r7"

require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${layout_exec_prefix}"
