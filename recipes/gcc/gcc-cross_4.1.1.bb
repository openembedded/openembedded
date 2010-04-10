PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

SRC_URI[md5sum] = "ad9f97a4d04982ccf4fd67cb464879f3"
SRC_URI[sha256sum] = "985cbb23a486570a8783395a42a8689218f5218a0ccdd6bec590eef341367bb7"
