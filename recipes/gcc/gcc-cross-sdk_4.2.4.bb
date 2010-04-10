PR = "${INC_PR}.2"

inherit sdk

require gcc-${PV}.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += "--disable-libunwind-exceptions --enable-libssp \
		--enable-libgomp --disable-libmudflap \
		--with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

SRC_URI[md5sum] = "d79f553e7916ea21c556329eacfeaa16"
SRC_URI[sha256sum] = "afba845e2d38547a63bd3976e90245c81ea176786f9e6966339c6d3761f1133a"
