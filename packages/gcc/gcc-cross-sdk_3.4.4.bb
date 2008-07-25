PR = "r5"

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
