DEPENDS = "virtual/${TARGET_PREFIX}binutils"
DEPENDS_multilib = "virtual/${TARGET_PREFIX}binutils"
PROVIDES = "virtual/${TARGET_PREFIX}gcc-initial"
PROVIDES_multilib = "virtual/${TARGET_PREFIX}gcc-initial virtual/${TARGET_SYS_MULTILIB}-gcc-initial"
PACKAGES = ""

# This is intended to be a -very- basic config
# sysroot is needed in case we use libc-initial
EXTRA_OECONF = "--with-local-prefix=${STAGING_DIR_TARGET}${layout_prefix} \
		--with-newlib \
		--without-headers \
		--disable-shared \
		--disable-threads \
		--disable-multilib \
		--disable-__cxa_atexit \
		--enable-languages=c \
		--enable-target-optspace \
		--program-prefix=${TARGET_PREFIX} \
		--with-sysroot=${STAGING_DIR_TARGET} \
		--with-build-sysroot=${STAGING_DIR_TARGET} \
		${@get_gcc_fpu_setting(bb, d)}"

EXTRA_OECONF_append_multilib = " --enable-multilib"

do_install () {
	:
}

do_install_multilib () {
	:
}
