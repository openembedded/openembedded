PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-package-target.inc

SRC_URI_append = "file://fortran-cross-compile-hack.patch;patch=1"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR}"


SRC_URI[md5sum] = "7ae33781417a35a2eb03ee098a9f4490"
SRC_URI[sha256sum] = "673b85d780a082c014ded4ac11f8269a3fe893b4dbb584d65b8602d50b3872b1"
