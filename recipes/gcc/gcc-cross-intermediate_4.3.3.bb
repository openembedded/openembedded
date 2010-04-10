require gcc-cross_${PV}.bb
require gcc-cross-intermediate.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += " --disable-libmudflap \
		  --disable-libgomp \
		  --disable-libssp"

SRC_URI[md5sum] = "cc3c5565fdb9ab87a05ddb106ba0bd1f"
SRC_URI[sha256sum] = "309f614a3c7fee88edc4928ff17185a19533949a1642ccf776e87d86303704de"
