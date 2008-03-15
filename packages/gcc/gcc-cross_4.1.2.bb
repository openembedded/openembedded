PR = "r14"

require gcc-${PV}.inc
require gcc-package-target.inc
require gcc-cross4.inc
require gcc3-build-cross.inc
require gcc-package-cross.inc

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF_append_avr32= "  --disable-libmudflap "

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${layout_exec_prefix}"
