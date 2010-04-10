PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF += "  --enable-cheaders=c_std --disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_DIR_TARGET}${target_includedir}"

SRC_URI[md5sum] = "4afa0290cc3a41ac8822666f1110de98"
SRC_URI[sha256sum] = "66596b80995f88cb66aaaf937598df7a9af10cc06799c3a7a64879e20b552fd5"
