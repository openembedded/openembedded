PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-cross-sdk.inc

SRC_URI += 'file://sdk-libstdc++-includes.patch'

do_compile_prepend () {
	mkdir -p gcc
	ln -s ${STAGING_DIR_NATIVE}${prefix_native}/bin/${TARGET_PREFIX}as gcc/as 
	ln -s ${STAGING_DIR_NATIVE}${prefix_native}/bin/${TARGET_PREFIX}ld gcc/ld
}

