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

SRC_URI[md5sum] = "70f5ac588a79e3c9901d5b34f58d896d"
SRC_URI[sha256sum] = "1126b6a7b585b3a178bfb7d559221779eb7eba12ce01bc9ca5896f6f9ee639de"
