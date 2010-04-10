PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-package-target.inc

SRC_URI_append = "file://fortran-cross-compile-hack.patch;patch=1"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR}"

SRC_URI[md5sum] = "4afa0290cc3a41ac8822666f1110de98"
SRC_URI[sha256sum] = "66596b80995f88cb66aaaf937598df7a9af10cc06799c3a7a64879e20b552fd5"
