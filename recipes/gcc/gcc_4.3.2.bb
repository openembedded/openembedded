PR = "${INC_PR}.1"
require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-package-target.inc

# Gcc 4.3.2 installs crt* in a '4.3.1' dir....
FILES_${PN} += "\
        ${gcclibdir}/${TARGET_SYS}/*/*.o \
"

SRC_URI_append = "file://fortran-cross-compile-hack.patch;patch=1"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR}"

SRC_URI[md5sum] = "5dfac5da961ecd5f227c3175859a486d"
SRC_URI[sha256sum] = "bfbf487731ad5dca37efe480a837417de071bd67e685d5c1df6a290707575165"
