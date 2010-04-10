require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += " --disable-libmudflap \
		  --disable-libgomp \
		  --enable-decimal-float=no \
		  --disable-libssp"

SRC_URI[md5sum] = "4afa0290cc3a41ac8822666f1110de98"
SRC_URI[sha256sum] = "66596b80995f88cb66aaaf937598df7a9af10cc06799c3a7a64879e20b552fd5"
