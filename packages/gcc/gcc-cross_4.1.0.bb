PR = "r5"

require gcc-${PV}.inc
require gcc-cross4.inc
require gcc3-build-cross.inc
require gcc-package-cross.inc

EXTRA_OECONF += "--with-mpfr=${STAGING_DIR_NATIVE}${layout_exec_prefix}"
