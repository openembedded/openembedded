PR = "${INC_PR}.4"

inherit sdk

require gcc-${PV}.inc
require gcc-cross-sdk.inc

EXTRA_OECONF += "--disable-libunwind-exceptions --disable-libssp \
		--disable-libgomp --disable-libmudflap \
		--with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

