require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

EXTRA_OECONF += "  --disable-libgomp \
                --disable-libmudflap \
		--disable-libssp"
