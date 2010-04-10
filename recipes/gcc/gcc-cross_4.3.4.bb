PR = "${INC_PR}.0"
require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF += "  --enable-cheaders=c_std --disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_DIR_TARGET}${target_includedir}"

SRC_URI[md5sum] = "60df63222dbffd53ca11492a2545044f"
SRC_URI[sha256sum] = "e572453bdb74cc4ceebfab9ffb411d9678343dff5bf86e9338d42fdd0818aa65"
