PACKAGE_ARCH = "${MACHINE_ARCH}"
BASEPKG_HOST_SYS = "${MULTIMACH_HOST_SYS}"
INHIBIT_PACKAGE_STRIP = "1"

ALLOW_EMPTY_${PN} = "1"
ALLOW_EMPTY_${PN}-dev = "1"

PACKAGES =+ "${PN}-sourcetree"
FILES_${PN}-sourcetree = "${installdir}/*-tree"
INSANE_SKIP_${PN}-sourcetree = "True"

