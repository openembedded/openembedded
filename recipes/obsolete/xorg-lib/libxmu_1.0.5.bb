require xorg-lib-common.inc
DESCRIPTION = "X11 miscellaneous utility library"
DEPENDS += "libxt libxext"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "fc4d66be7a1a1eb474954728415e46d6"
SRC_URI[archive.sha256sum] = "0692b6b0ec1019cfaa8418020b1127bfb0975f5a579a0b1f9eb7fd8f2f7126d7"

PACKAGES =+ "libxmuu libxmuu-dev"

FILES_libxmuu = "${libdir}/libXmuu.so.*"
FILES_libxmuu-dev = "${libdir}/libXmuu.so"

LEAD_SONAME = "libXmu"

XORG_PN = "libXmu"
