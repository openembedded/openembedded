require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += " --disable-libmudflap \
		  --disable-libgomp \
		  --enable-decimal-float=no \
		  --disable-libssp"

SRC_URI[md5sum] = "927eaac3d44b22f31f9c83df82f26436"
SRC_URI[sha256sum] = "cbefa9abd4adac0931e1b556072dcd8b32a360d4b95a94d7822c86bded803d5b"
