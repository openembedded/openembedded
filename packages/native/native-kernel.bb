SECTION = "base"
COMPATIBLE_HOST = "${BUILD_SYS}"

PROVIDES = "virtual/kernel"

do_stage() {
	install -d ${STAGING_KERNEL_DIR}/include/
	install -m 0755 ${includedir}/linux/wireless.h ${STAGING_KERNEL_DIR}/include/wireless.h
	echo `uname -r` >${STAGING_KERNEL_DIR}/kernel-abiversion
	echo /usr/src/linux >${STAGING_KERNEL_DIR}/kernel-source
	echo >${STAGING_KERNEL_DIR}/kernel-ccsuffix
	echo >${STAGING_KERNEL_DIR}/kernel-ldsuffix
}
