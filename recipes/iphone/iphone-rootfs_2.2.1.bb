DESCRIPTION = "Staging iPhone root filesystem"
DEPENDS = "apple-csu iphone-sdks"
PROVIDES = "virtual/${TARGET_PREFIX}libc-for-gcc virtual/libc virtual/libiconv virtual/libintl libsegfault"

INHIBIT_DEFAULT_DEPS = "1"
EXCLUDE_FROM_SHLIBS = "1"
COMPATIBLE_MACHINE = "(iphone)"
# note: see iphone-sources script to get/generate the tarballs
SRC_URI = "file://iphone-rootfs-${PV}.tar.bz2"

FILES_${PN} += "/System ${layout_libdir}/*"

do_compile () {
	:
}

do_stage () {
	cp -apR ${S}/usr/lib/* ${STAGING_LIBDIR}/
	cp -apR ${S}/System ${STAGING_DIR_TARGET}/
	rm -rf ${STAGING_DIR_TARGET}/System/Library/Fonts
	rm -rf ${STAGING_DIR_TARGET}/System/Library/Audio
	rm -rf ${STAGING_DIR_TARGET}/System/Library/Caches
}
