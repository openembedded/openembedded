require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += " --disable-libmudflap \
		  --disable-libgomp \
		  --enable-decimal-float=no \
		  --disable-libssp"

SRC_URI[md5sum] = "5dfac5da961ecd5f227c3175859a486d"
SRC_URI[sha256sum] = "bfbf487731ad5dca37efe480a837417de071bd67e685d5c1df6a290707575165"
