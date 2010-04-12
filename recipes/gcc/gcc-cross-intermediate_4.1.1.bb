require gcc-cross_${PV}.bb
require gcc-cross-intermediate.inc

EXTRA_OECONF += "--disable-libmudflap \
		--disable-libunwind-exceptions \
		--disable-libssp"
