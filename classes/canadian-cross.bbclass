# Canadian cross packages are built indirectly via dependency,
# no need for them to be a direct target of 'world'
EXCLUDE_FROM_WORLD = "1"

inherit canadian

PACKAGES = ""

BASE_PACKAGE_ARCH = "${SDK_ARCH}"
BASEPKG_HOST_SYS = "${SDK_ARCH}${SDK_VENDOR}-${SDK_OS}"
BASEPKG_TARGET_SYS = "${SDK_ARCH}${SDK_VENDOR}-${SDK_OS}"

HOST_ARCH = "${BUILD_ARCH}"
HOST_VENDOR = "${BUILD_VENDOR}"
HOST_OS = "${BUILD_OS}"
HOST_PREFIX = "${BUILD_PREFIX}"
HOST_CC_ARCH = "${BUILD_CC_ARCH}"
HOST_EXEEXT = "${BUILD_EXEEXT}"

TARGET_ARCH = "${SDK_ARCH}"
TARGET_VENDOR = "${SDK_VENDOR}"
TARGET_OS = "${SDK_OS}"
TARGET_PREFIX = "${SDK_PREFIX}"
TARGET_CC_ARCH = "${SDK_CC_ARCH}"
TARGET_EXEEXT = "${SDK_EXEEXT}"

CPPFLAGS = "${BUILD_CPPFLAGS}"
CFLAGS = "${BUILD_CFLAGS}"
CXXFLAGS = "${BUILD_CFLAGS}"
LDFLAGS = "${BUILD_LDFLAGS}"

TOOLCHAIN_OPTIONS = ""

# Architecture dependent paths
bindir = "${exec_prefix}/bin"
sbindir = "${exec_prefix}/bin"
libexecdir = "${exec_prefix}/libexec"
libdir = "${exec_prefix}/lib"
includedir = "${exec_prefix}/include"
oldincludedir = "${exec_prefix}/include"

# Path prefixes
export base_prefix = "${STAGING_DIR_HOST}"
export prefix = "${STAGING_DIR_HOST}${layout_prefix}"
export exec_prefix = "${STAGING_DIR_HOST}${layout_exec_prefix}"

# Base paths
export base_bindir = "${STAGING_DIR_HOST}${layout_base_bindir}"
export base_sbindir = "${STAGING_DIR_HOST}${layout_base_sbindir}"
export base_libdir = "${STAGING_DIR_HOST}${layout_base_libdir}"

# Architecture independent paths
export datadir = "${STAGING_DIR_HOST}${layout_datadir}"
export sysconfdir = "${STAGING_DIR_HOST}${layout_sysconfdir}"
export sharedstatedir = "${STAGING_DIR_HOST}${layout_sharedstatedir}"
export localstatedir = "${STAGING_DIR_HOST}${layout_localstatedir}"
export infodir = "${STAGING_DIR_HOST}${layout_infodir}"
export mandir = "${STAGING_DIR_HOST}${layout_mandir}"
export docdir = "${STAGING_DIR_HOST}${layout_docdir}"
export servicedir = "${STAGING_DIR_HOST}${layout_servicedir}"

# Architecture dependent paths
export bindir = "${STAGING_DIR_HOST}${layout_bindir}"
export sbindir = "${STAGING_DIR_HOST}${layout_sbindir}"
export libexecdir = "${STAGING_DIR_HOST}${layout_libexecdir}"
export libdir = "${STAGING_DIR_HOST}${layout_libdir}"
export includedir = "${STAGING_DIR_HOST}${layout_includedir}"
export oldincludedir = "${STAGING_DIR_HOST}${layout_includedir}"

do_stage () {
	oe_runmake install
}

do_install () {
	:
}
