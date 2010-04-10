PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_DIR_TARGET}${target_includedir}"

SRC_URI[md5sum] = "ef2a4d9991b3644115456ea05b2b8163"
SRC_URI[sha256sum] = "5df9a267091eea09179651ad2a2302fe99f780ac7e598278e7f47b2339fa2e80"
