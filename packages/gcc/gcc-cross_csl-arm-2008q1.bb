PR = "r0"

require gcc-csl-arm-2008q1.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${layout_exec_prefix}"

ARCH_FLAGS_FOR_TARGET += "-L${STAGING_DIR_TARGET}${layout_libdir} -isystem${STAGING_DIR_TARGET}${layout_includedir}"
