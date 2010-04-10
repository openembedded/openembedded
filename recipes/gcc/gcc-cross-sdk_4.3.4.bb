PR = "${INC_PR}.0"

inherit sdk

require gcc-${PV}.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += "--disable-libunwind-exceptions --disable-libssp \
		--disable-libgomp --disable-libmudflap \
		--with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

SRC_URI[md5sum] = "60df63222dbffd53ca11492a2545044f"
SRC_URI[sha256sum] = "e572453bdb74cc4ceebfab9ffb411d9678343dff5bf86e9338d42fdd0818aa65"
