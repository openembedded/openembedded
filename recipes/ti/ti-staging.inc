PACKAGE_ARCH = "${MACHINE_ARCH}"

# Allow staging into machine specific dir
BASEPKG_HOST_SYS = "${MULTIMACH_HOST_SYS}"

# Search archdir for shlibs instead of machine dir due to above BASEPKG_HOST_SYS
SHLIBSDIR = "${STAGING_DIR}/${BASE_PACKAGE_ARCH}${HOST_VENDOR}-${HOST_OS}/shlibs"

INHIBIT_PACKAGE_STRIP = "1"

ALLOW_EMPTY_${PN} = "1"
ALLOW_EMPTY_${PN}-dev = "1"

PACKAGES =+ "${PN}-sourcetree"
FILES_${PN}-sourcetree = "${installdir}/*-tree"
INSANE_SKIP_${PN}-sourcetree = "True"

