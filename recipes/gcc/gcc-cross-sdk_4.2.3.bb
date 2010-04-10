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

SRC_URI[md5sum] = "ef2a4d9991b3644115456ea05b2b8163"
SRC_URI[sha256sum] = "5df9a267091eea09179651ad2a2302fe99f780ac7e598278e7f47b2339fa2e80"
