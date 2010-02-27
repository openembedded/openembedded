PR = "${INC_PR}.3"

inherit sdk

require gcc-${PV}.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc

EXTRA_OECONF += "--disable-libunwind-exceptions --enable-libssp \
		--enable-libgomp --disable-libmudflap"
