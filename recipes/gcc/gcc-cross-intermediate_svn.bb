require gcc-cross_${PV}.bb
require gcc-cross-intermediate.inc

DEPENDS += "libmpc-native"

EXTRA_OECONF += " --disable-libmudflap \
		  --disable-libgomp \
		  --disable-libssp"
