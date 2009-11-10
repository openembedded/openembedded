#
# Note this class is deprecated and replaced by nativesdk.bbclass
#

# Canadian native packages are built indirectly via dependency,
# no need for them to be a direct target of 'world'
EXCLUDE_FROM_WORLD = "1"

inherit canadian

PACKAGES = ""

BASE_PACKAGE_ARCH = "${SDK_ARCH}"
BASEPKG_HOST_SYS = "${SDK_ARCH}${SDK_VENDOR}-${SDK_OS}"
BASEPKG_TARGET_SYS = "${SDK_ARCH}${SDK_VENDOR}-${SDK_OS}"

HOST_ARCH = "${SDK_ARCH}"
HOST_VENDOR = "${SDK_VENDOR}"
HOST_OS = "${SDK_OS}"
HOST_PREFIX = "${SDK_PREFIX}"
HOST_CC_ARCH = "${SDK_CC_ARCH}"
HOST_EXEEXT = "${SDK_EXEEXT}"

TARGET_ARCH = "${SDK_ARCH}"
TARGET_VENDOR = "${SDK_VENDOR}"
TARGET_OS = "${SDK_OS}"
TARGET_PREFIX = "${SDK_PREFIX}"
TARGET_CC_ARCH = "${SDK_CC_ARCH}"
TARGET_EXEEXT = "${SDK_EXEEXT}"

CPPFLAGS = "${SDK_CPPFLAGS}"
CFLAGS = "${SDK_CFLAGS}"
CXXFLAGS = "${SDK_CFLAGS}"
LDFLAGS = "${SDK_LDFLAGS}"

# set the compiler as well. It could have been set to something else
export CC = "${CCACHE}${SDK_PREFIX}gcc ${HOST_CC_ARCH}"
export CXX = "${CCACHE}${SDK_PREFIX}g++ ${HOST_CC_ARCH}"
export F77 = "${CCACHE}${SDK_PREFIX}g77 ${HOST_CC_ARCH}"
export CPP = "${SDK_PREFIX}gcc -E"
export LD = "${SDK_PREFIX}ld"
#export CCLD = "${CC}"
export AR = "${SDK_PREFIX}ar"
export AS = "${SDK_PREFIX}as"
export RANLIB = "${SDK_PREFIX}ranlib"
export STRIP = "${SDK_PREFIX}strip"


# Change to place files in SDKPATH
prefix = "${SDKPATH}"
exec_prefix = "${SDKPATH}"
base_prefix = "${SDKPATH}"

export PKG_CONFIG_DIR = "${STAGING_DIR_HOST}${libdir}/pkgconfig"
export PKG_CONFIG_SYSROOT_DIR = "${STAGING_DIR_HOST}"

do_stage () {
        if [ "${INHIBIT_NATIVE_STAGE_INSTALL}" != "1" ]
        then
                if [ "${AUTOTOOLS_NATIVE_STAGE_INSTALL}" != "1" ]
                then
                        oe_runmake install
                else
                        autotools_stage_all
                fi
        fi
}

do_install () {
	:
}
