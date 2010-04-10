PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-package-target.inc

SRC_URI_append = "file://fortran-cross-compile-hack.patch;patch=1"

ARCH_FLAGS_FOR_TARGET += "-isystem${STAGING_INCDIR}"


SRC_URI[md5sum] = "ef2a4d9991b3644115456ea05b2b8163"
SRC_URI[sha256sum] = "5df9a267091eea09179651ad2a2302fe99f780ac7e598278e7f47b2339fa2e80"
