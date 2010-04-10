require gcc-cross_${PV}.bb
require gcc-cross-intermediate.inc

EXTRA_OECONF += "--disable-libmudflap --disable-libgomp \
		--disable-libssp"

SRC_URI[md5sum] = "ef2a4d9991b3644115456ea05b2b8163"
SRC_URI[sha256sum] = "5df9a267091eea09179651ad2a2302fe99f780ac7e598278e7f47b2339fa2e80"
