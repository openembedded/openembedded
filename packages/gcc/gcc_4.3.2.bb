PR = "r4"
require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-package-target.inc

# Gcc 4.3.2 installs crt* in a '4.3.1' dir....
FILES_${PN} += "\
        ${gcclibdir}/${TARGET_SYS}/*/*.o \
"

SRC_URI_append = "file://fortran-cross-compile-hack.patch;patch=1"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR}"
