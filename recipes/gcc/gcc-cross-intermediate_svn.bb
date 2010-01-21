require gcc-cross_${PV}.bb
require gcc-cross-intermediate.inc

DEPENDS += "libmpc-native gmp-native mpfr-native"

EXTRA_OECONF += " --disable-libmudflap \
		  --disable-libgomp \
		  --disable-libssp"
