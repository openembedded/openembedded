require gcc-configure-common.inc

USE_NLS_libc-uclibc = 'no'
#
# We need to override this and make sure the compiler can find staging
#
export ARCH_FLAGS_FOR_TARGET = "--sysroot=${STAGING_DIR_TARGET}"

# Tools for build
export CC_FOR_BUILD="${BUILD_CC}"
export CFLAGS_FOR_BUILD="${BUILD_CFLAGS}"
export CPP_FOR_BUILD="${BUILD_CPP}"
export CPPFLAGS_FOR_BUILD="${BUILD_CPPFLAGS}"
export CXX_FOR_BUILD="${BUILD_CXX}"
export CXXFLAGS_FOR_BUILD="${BUILD_CXXFLAGS}"
export LD_FOR_BUILD="${BUILD_LD}"
export LDFLAGS_FOR_BUILD="${BUILD_LDFLAGS}"
export AS_FOR_BUILD="${BUILD_PREFIX}as"
export AR_FOR_BUILD="${BUILD_PREFIX}ar"
export NM_FOR_BUILD="${BUILD_PREFIX}nm"
export RANLIB_FOR_BUILD="${BUILD_PREFIX}ranlib"
export GCJ_FOR_BUILD="${BUILD_PREFIX}gcj"
export GFORTRAN_FOR_BUILD="${BUILD_PREFIX}gfortran"
export DLLTOOL_FOR_BUILD="${BUILD_PREFIX}dlltool"
export WINDRES_FOR_BUILD="${BUILD_PREFIX}windres"

# Tools for host
#CC
#CFLAGS
#CXX
#CXXFLAGS
#LD
LDFLAGS=""
#AS
#AR
#NM
#RANLIB
#GCJ
#GFORTRAN
export DLLTOOL="${HOST_PREFIX}dlltool"
export WINDRES="${HOST_PREFIX}windres"

# Tools for target
export CC_FOR_TARGET="${TARGET_CC}"
export CFLAGS_FOR_TARGET="${TARGET_CFLAGS}"
export CXX_FOR_TARGET="${TARGET_CXX}"
export CXXFLAGS_FOR_TARGET="${TARGET_CXXFLAGS}"
export LD_FOR_TARGET="${TARGET_LD}"
export LDFLAGS_FOR_TARGET="${TARGET_LDFLAGS}"
export AS_FOR_TARGET="${TARGET_PREFIX}as"
export AR_FOR_TARGET="${TARGET_PREFIX}ar"
export NM_FOR_TARGET="${TARGET_PREFIX}nm"
export RANLIB_FOR_TARGET="${TARGET_PREFIX}ranlib"
export GCJ_FOR_TARGET="${TARGET_PREFIX}gcj"
export GFORTRAN_FOR_TARGET="${TARGET_PREFIX}gfortran"
export DLLTOOL_FOR_TARGET="${TARGET_PREFIX}dlltool"
export WINDRES_FOR_TARGET="${TARGET_PREFIX}windres"

EXTRA_OECONF_DEP ?= ""

EXTRA_OECONF += ""
# On MinGW hosts we want to prepend a drive letter, in ${SDK_REALPATH_MINGW}
# to the sysroot path.
SYSROOT = "${@['${SDK_REALPATH}/${TARGET_SYS}', '${SDK_REALPATH_MINGW}${SDK_REALPATH}/${TARGET_SYS}'][bb.data.getVar('SDK_OS', d, 1) in ['mingw32', 'mingw64']]}"
EXTRA_OECONF_PATHS = " \
	--with-build-sysroot=${STAGING_DIR_TARGET} \
	--with-sysroot=${SYSROOT} \
"

do_configure () {
	# Work around Hardcoded path assumptions in gcc
        # Make sure we use GMP/MPFR statically
        sed -i 's/^\(HOST_GMPLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.tpl
        sed -i 's/^\(HOST_GMPLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.in
        sed -i 's/^\(HOST_PPLLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.tpl
        sed -i 's/^\(HOST_PPLLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.in
        sed -i 's/^\(HOST_LIBELFLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.tpl
        sed -i 's/^\(HOST_LIBELFLIBS =\) \(.*\)$/\1 -Wl,-Bstatic \2 -Wl,-Bdynamic/' ${S}/Makefile.in
	(cd ${S} && gnu-configize) || die "failure running gnu-configize"
	(cd ${S}/libstdc++-v3 && autoreconf)
	canadian_sdk_runconf
}

do_compile () {
	oe_runmake
}
