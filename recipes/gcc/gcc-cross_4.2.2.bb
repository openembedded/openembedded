PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_DIR_TARGET}${target_includedir}"

SRC_URI[md5sum] = "7ae33781417a35a2eb03ee098a9f4490"
SRC_URI[sha256sum] = "673b85d780a082c014ded4ac11f8269a3fe893b4dbb584d65b8602d50b3872b1"
