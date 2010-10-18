PACKAGE_ARCH = "${MACHINE_ARCH}"

# Allow staging into machine specific dir
BASEPKG_HOST_SYS = "${MULTIMACH_HOST_SYS}"

# Search archdir for shlibs instead of machine dir due to above BASEPKG_HOST_SYS
SHLIBSDIR = "${STAGING_DIR}/${BASE_PACKAGE_ARCH}${HOST_VENDOR}-${HOST_OS}/shlibs"

PKG_CONFIG_DIR = "${STAGING_DIR}/${BASE_PACKAGE_ARCH}${HOST_VENDOR}-${HOST_OS}/${libdir}/pkgconfig"
export PKG_CONFIG_PATH = "${PKG_CONFIG_DIR}:${STAGING_DATADIR}/pkgconfig"
PKG_CONFIG_PATH .= ":${STAGING_LIBDIR_NATIVE}/pkgconfig:${STAGING_DATADIR_NATIVE}/pkgconfig"

PACKAGE_STRIP = "no"

ALLOW_EMPTY_${PN} = "1"
ALLOW_EMPTY_${PN}-dev = "1"


