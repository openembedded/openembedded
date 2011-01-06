PR = "${INC_PR}.1"
require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-package-target.inc

# Gcc 4.3.3 installs crt* in a '4.3.1' dir....
FILES_${PN} += "\
        ${gcclibdir}/${TARGET_SYS}/*/*.o \
	${libexecdir}/gcc/${TARGET_SYS}/${BINV}/lto1 \
	${libexecdir}/gcc/${TARGET_SYS}/${BINV}/lto-wrapper \
"

SRC_URI += "file://fortran-cross-compile-hack.patch"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR}"
