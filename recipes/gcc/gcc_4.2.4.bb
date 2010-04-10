PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-package-target.inc

SRC_URI_append = "file://fortran-cross-compile-hack.patch;patch=1"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR}"


SRC_URI[md5sum] = "d79f553e7916ea21c556329eacfeaa16"
SRC_URI[sha256sum] = "afba845e2d38547a63bd3976e90245c81ea176786f9e6966339c6d3761f1133a"
