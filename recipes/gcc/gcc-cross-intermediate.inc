DEPENDS = "virtual/${TARGET_PREFIX}binutils"
DEPENDS += "virtual/${TARGET_PREFIX}libc-initial"
DEPENDS_multilib = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-initial virtual/${TARGET_SYS_MULTILIB}-libc-initial"
PROVIDES = "virtual/${TARGET_PREFIX}gcc-intermediate"
PROVIDES_multilib = "virtual/${TARGET_PREFIX}gcc-intermediate virtual/${TARGET_SYS_MULTILIB}-gcc-intermediate"
PACKAGES = ""

# This is intended to be a -very- basic config
# sysroot is needed in case we use libc-initial
EXTRA_OECONF = "--with-local-prefix=${STAGING_DIR_TARGET}${layout_prefix} \
		--enable-shared \
		--disable-multilib \
		--disable-threads \
		--enable-languages=c \
		--enable-target-optspace \
		--program-prefix=${TARGET_PREFIX} \
		--with-sysroot=${STAGING_DIR_TARGET} \
		--with-build-sysroot=${STAGING_DIR_TARGET} \
		${@get_gcc_fpu_setting(bb, d)}"

EXTRA_OECONF_append_multilib = " --enable-multilib"

do_stage_append () {
	# get rid of dummy libc.so
	if [ -z "`file ${STAGING_DIR_TARGET}${layout_libdir}/libc.so | grep "ASCII C program text"`" ]; then
		rm -rf ${STAGING_DIR_TARGET}${layout_libdir}/libc.so
	fi
}

do_install () {
	:
}

do_install_multilib () {
	:
}
