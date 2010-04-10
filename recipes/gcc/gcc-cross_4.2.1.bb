PR = "r21"

require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_DIR_TARGET}${target_includedir}"

SRC_URI[md5sum] = "cba410e6ff70f7d7f4be7a0267707fd0"
SRC_URI[sha256sum] = "ca0a12695b3bccfa8628509e08cb9ed7d8ed48deff0a299e4cb8de87d2c1fced"
