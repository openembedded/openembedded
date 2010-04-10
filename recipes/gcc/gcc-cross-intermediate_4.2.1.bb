require gcc-cross_${PV}.bb
require gcc-cross-intermediate.inc

EXTRA_OECONF += "--disable-libmudflap --disable-libgomp \
		--disable-libssp"

SRC_URI[md5sum] = "cba410e6ff70f7d7f4be7a0267707fd0"
SRC_URI[sha256sum] = "ca0a12695b3bccfa8628509e08cb9ed7d8ed48deff0a299e4cb8de87d2c1fced"
