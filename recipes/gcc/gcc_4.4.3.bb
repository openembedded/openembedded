require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-package-target.inc
PR = "${INC_PR}.1"

# GCC 4.4.x installs crt* in a '4.4.x' dir....
FILES_${PN} += "\
        ${gcclibdir}/${TARGET_SYS}/*/*.o \
"

SRC_URI_append = "file://fortran-cross-compile-hack.patch;patch=1"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR}"
