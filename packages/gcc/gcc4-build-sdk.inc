USE_NLS = '${@base_conditional( "TARGET_OS", "linux-uclibc", "no", "", d )}'
USE_NLS = '${@base_conditional( "TARGET_OS", "linux-uclibcgnueabi", "no", "", d )}'

EXTRA_OECONF += "--with-sysroot=${prefix}/${TARGET_SYS} --with-build-sysroot=${STAGING_DIR_TARGET}"

do_configure () {
       # Hack to be removed when staging layout matches the target layout
       if [ ! -e ${STAGING_DIR_TARGET}/usr ]; then
           ln -s ${STAGING_DIR_TARGET} ${STAGING_DIR_TARGET}/usr
       fi
       (cd ${S} && gnu-configize) || die "failure running gnu-configize"
       (cd ${S}/libstdc++-v3 && autoreconf)
       oe_runconf
}

do_compile () {
	export CC="${BUILD_CC}"
	export AR_FOR_TARGET="${TARGET_SYS}-ar"
	export RANLIB_FOR_TARGET="${TARGET_SYS}-ranlib"
	export LD_FOR_TARGET="${TARGET_SYS}-ld"
	export NM_FOR_TARGET="${TARGET_SYS}-nm"
	export CC_FOR_TARGET="${CCACHE} ${TARGET_SYS}-gcc ${TARGET_CC_ARCH}"
	oe_runmake
}
