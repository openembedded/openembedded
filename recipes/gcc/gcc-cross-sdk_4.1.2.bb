PR = "${INC_PR}.2"

require gcc-${PV}.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc

EXTRA_OECONF += "--disable-libunwind-exceptions"
