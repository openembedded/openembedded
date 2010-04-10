PR = "${INC_PR}.1"

inherit sdk

require gcc-${PV}.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += "--disable-libunwind-exceptions --disable-libssp \
		--disable-libgomp --disable-libmudflap \
		--with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

SRC_URI[md5sum] = "4afa0290cc3a41ac8822666f1110de98"
SRC_URI[sha256sum] = "66596b80995f88cb66aaaf937598df7a9af10cc06799c3a7a64879e20b552fd5"
