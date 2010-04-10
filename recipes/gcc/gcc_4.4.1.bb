require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-package-target.inc
PR = "${INC_PR}.1"

# GCC 4.4.0 installs crt* in a '4.4.0' dir....
FILES_${PN} += "\
        ${gcclibdir}/${TARGET_SYS}/*/*.o \
"

SRC_URI_append = "file://fortran-cross-compile-hack.patch;patch=1"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR}"

SRC_URI[md5sum] = "927eaac3d44b22f31f9c83df82f26436"
SRC_URI[sha256sum] = "cbefa9abd4adac0931e1b556072dcd8b32a360d4b95a94d7822c86bded803d5b"
