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

SRC_URI[md5sum] = "5dfac5da961ecd5f227c3175859a486d"
SRC_URI[sha256sum] = "bfbf487731ad5dca37efe480a837417de071bd67e685d5c1df6a290707575165"
