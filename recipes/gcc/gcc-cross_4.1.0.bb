PR = "${INC_PR}.2"

require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

EXTRA_OECONF += "--disable-libunwind-exceptions"
