PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc

SRC_URI += 'file://sdk-libstdc++-includes.patch;patch=1'

do_compile_prepend () {
	mkdir -p gcc
	ln -s ${CROSS_DIR}/bin/${TARGET_PREFIX}as gcc/as 
	ln -s ${CROSS_DIR}/bin/${TARGET_PREFIX}ld gcc/ld
}

SRC_URI[md5sum] = "b594ff4ea4fbef4ba9220887de713dfe"
SRC_URI[sha256sum] = "3444179840638cb8664e8e53604900c4521d29d57785a5091202ee4937d8d0fd"
