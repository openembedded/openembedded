PR = "r1"

require gcc-configure-cross.inc
require mingw-gcc_${PV}.bb

inherit canadian-cross

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/mingw-gcc-${PV}"

DEPENDS = "\
	virtual/${TARGET_PREFIX}binutils \
	virtual/${TARGET_PREFIX}libc-for-gcc \
"

PROVIDES = "virtual/${TARGET_PREFIX}gcc virtual/${TARGET_PREFIX}g++"

do_configure_prepend() {
	# ugly hack to come around the hardcoding of
	# -isystem ${build_tooldir}/include which ends up pointing at
	# $STAGING_DIR_SDK/$SDK_SYS/include
	install -d ${STAGING_DIR_SDK}/${SDK_SYS}
	ln -sf ${STAGING_DIR_SDK}${layout_includedir} \
		${STAGING_DIR_SDK}/${SDK_SYS}/include
	ln -sf ${STAGING_DIR_SDK}${layout_libdir} \
		${STAGING_DIR_SDK}/${SDK_SYS}/lib
}
