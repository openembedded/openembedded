inherit sdk

require gcc-${PV}.inc
require gcc-cross-sdk.inc
PR = "${INC_PR}.2"

EXTRA_OECONF += "--disable-libunwind-exceptions --disable-libssp \
		--disable-libgomp --disable-libmudflap \
		--with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"
