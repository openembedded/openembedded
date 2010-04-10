PR = "${INC_PR}.1"
require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

EXTRA_OECONF += "  --enable-cheaders=c_std --disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_DIR_TARGET}${target_includedir}"

SRC_URI[md5sum] = "cc3c5565fdb9ab87a05ddb106ba0bd1f"
SRC_URI[sha256sum] = "309f614a3c7fee88edc4928ff17185a19533949a1642ccf776e87d86303704de"
