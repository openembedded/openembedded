require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc
PR = "${INC_PR}.1"

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF += " --disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_DIR_TARGET}${target_includedir}"

SRC_URI[md5sum] = "70f5ac588a79e3c9901d5b34f58d896d"
SRC_URI[sha256sum] = "1126b6a7b585b3a178bfb7d559221779eb7eba12ce01bc9ca5896f6f9ee639de"
