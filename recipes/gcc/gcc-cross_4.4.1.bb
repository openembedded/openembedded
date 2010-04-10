require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc
PR = "${INC_PR}.1"

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF += " --disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_DIR_TARGET}${target_includedir}"

SRC_URI[md5sum] = "927eaac3d44b22f31f9c83df82f26436"
SRC_URI[sha256sum] = "cbefa9abd4adac0931e1b556072dcd8b32a360d4b95a94d7822c86bded803d5b"
