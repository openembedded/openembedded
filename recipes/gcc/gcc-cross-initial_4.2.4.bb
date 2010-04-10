require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

EXTRA_OECONF += "--disable-libmudflap --disable-libgomp \
		--disable-libssp"

SRC_URI[md5sum] = "d79f553e7916ea21c556329eacfeaa16"
SRC_URI[sha256sum] = "afba845e2d38547a63bd3976e90245c81ea176786f9e6966339c6d3761f1133a"
