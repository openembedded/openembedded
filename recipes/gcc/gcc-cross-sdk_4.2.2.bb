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

SRC_URI[md5sum] = "7ae33781417a35a2eb03ee098a9f4490"
SRC_URI[sha256sum] = "673b85d780a082c014ded4ac11f8269a3fe893b4dbb584d65b8602d50b3872b1"
