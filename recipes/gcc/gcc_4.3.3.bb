PR = "${INC_PR}.1"
require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-package-target.inc

# Gcc 4.3.3 installs crt* in a '4.3.1' dir....
FILES_${PN} += "\
        ${gcclibdir}/${TARGET_SYS}/*/*.o \
"

SRC_URI_append = "file://fortran-cross-compile-hack.patch;patch=1"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR}"

SRC_URI[md5sum] = "cc3c5565fdb9ab87a05ddb106ba0bd1f"
SRC_URI[sha256sum] = "309f614a3c7fee88edc4928ff17185a19533949a1642ccf776e87d86303704de"
