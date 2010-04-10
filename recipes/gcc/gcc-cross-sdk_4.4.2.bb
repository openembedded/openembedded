inherit sdk

require gcc-${PV}.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc
PR = "${INC_PR}.1"

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += "--disable-libunwind-exceptions --disable-libssp \
		--disable-libgomp --disable-libmudflap \
		--with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

SRC_URI[md5sum] = "70f5ac588a79e3c9901d5b34f58d896d"
SRC_URI[sha256sum] = "1126b6a7b585b3a178bfb7d559221779eb7eba12ce01bc9ca5896f6f9ee639de"
