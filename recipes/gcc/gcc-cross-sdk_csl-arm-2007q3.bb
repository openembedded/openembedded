PR = "r3"

inherit sdk

require gcc-csl-arm-2007q3.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc

EXTRA_OECONF += " \
		--disable-multilib \
		--disable-libssp \
		--disable-libgomp \
		--disable-libunwind-exceptions \
		--disable-libmudflap \
		--with-mpfr=${STAGING_DIR_NATIVE}${prefix_native} \
		"

#We don't want i686 linux ending up in the CFLAGS_FOR_TARGET like this: -isystem/OE/angstrom-tmp/staging/i686-linux/usr/include
CFLAGS = ""
CXXFLAGS = ""
LDFLAGS = ""
