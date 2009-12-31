require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

DEPENDS += "gmp-native mpfr-native libmpc-native"

EXTRA_OECONF += " --disable-libmudflap \
		  --disable-libgomp \
		  --enable-decimal-float=no \
		  --disable-libssp"
