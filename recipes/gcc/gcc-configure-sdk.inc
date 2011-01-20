require gcc-configure-common.inc

USE_NLS_libc-uclibc = 'no'

EXTRA_OECONF_PATHS = "--with-sysroot=${prefix}/${TARGET_SYS} \
                      --with-build-time-tools=${TOOLCHAIN_PATH}/${TARGET_SYS}/bin \
                      --with-build-sysroot=${STAGING_DIR_TARGET}"

#
# gcc-cross looks and finds these in ${exec_prefix} but we're not so lucky
# for the sdk. Hardcoding the paths ensures the build doesn't go canadian or worse.
#
export AR_FOR_TARGET = "${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/ar"
export AS_FOR_TARGET = "${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/as"
export DLLTOOL_FOR_TARGET = "${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/dlltool"
export LD_FOR_TARGET = "${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/ld"
export LIPO_FOR_TARGET = "${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/lipo"
export NM_FOR_TARGET = "${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/nm"
export OBJDUMP_FOR_TARGET = "${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/objdump"
export RANLIB_FOR_TARGET = "${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/ranlib"
export STRIP_FOR_TARGET = "${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/strip"
export WINDRES_FOR_TARGET = "${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/windres"

#
# We need to override this and make sure the compiler can find staging
#
export ARCH_FLAGS_FOR_TARGET = "--sysroot=${STAGING_DIR_TARGET}"

do_configure_prepend (){
        # Make sure we use GMP/MPFR statically
        sed -i 's/^\(HOST_GMPLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.tpl
        sed -i 's/^\(HOST_GMPLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.in
        sed -i 's/^\(HOST_PPLLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.tpl
        sed -i 's/^\(HOST_PPLLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.in
        sed -i 's/^\(HOST_LIBELFLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.tpl
        sed -i 's/^\(HOST_LIBELFLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.in
}

do_compile () {
	export CC="${BUILD_CC}"
	export CC_FOR_TARGET="${CCACHE} ${TARGET_SYS}-gcc ${TARGET_CC_ARCH}"
	base_do_compile
}
