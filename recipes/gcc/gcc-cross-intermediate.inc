DEPENDS = "virtual/${TARGET_PREFIX}binutils"
DEPENDS += "virtual/${TARGET_PREFIX}libc-initial"
PROVIDES = "virtual/${TARGET_PREFIX}gcc-intermediate"
PACKAGES = ""

# This is intended to be a -very- basic config
# sysroot is needed in case we use libc-initial
EXTRA_OECONF = "--with-local-prefix=${STAGING_DIR_TARGET}${target_prefix} \
		--enable-shared \
		--disable-multilib \
		--disable-threads \
		--enable-languages=c \
		--enable-target-optspace \
		--program-prefix=${TARGET_PREFIX} \
		--with-sysroot=${STAGING_DIR_TARGET} \
		--with-build-sysroot=${STAGING_DIR_TARGET} \
		${@get_gcc_fpu_setting(bb, d)} \
		${@get_gcc_mips_plt_setting(bb, d)}"

do_stage_append () {
	# get rid of dummy libc.so
	if [ -z "`file ${STAGING_DIR_TARGET}${target_libdir}/libc.so | grep "ASCII C program text"`" ]; then
		rm -rf ${STAGING_DIR_TARGET}${target_libdir}/libc.so
	fi
}

do_install () {
	:
}
