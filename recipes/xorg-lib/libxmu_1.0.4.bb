require xorg-lib-common.inc

DESCRIPTION = "X11 miscellaneous utility library"
DEPENDS += "libxt libxext"
PROVIDES = "xmu"
PR = "r1"
PE = "1"

XORG_PN = "libXmu"

LEAD_SONAME = "libXmu"

PACKAGES =+ "libxmuu libxmuu-dev"

FILES_libxmuu = "${libdir}/libXmuu.so.*"
FILES_libxmuu-dev = "${libdir}/libXmuu.so"

SRC_URI[archive.md5sum] = "fb372a5f3ab42b5ba16d7af4d833a0cb"
SRC_URI[archive.sha256sum] = "f83c00d6ed8f4c08effa9dcc2d7f1ff6f5a753f2b9fe1babda16618c2afa18f0"
