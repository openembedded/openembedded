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

SRC_URI[archive.md5sum] = "b926b95b811ece3e19cd590db85ee615"
SRC_URI[archive.sha256sum] = "b56e308e36da8d9cb48433ddb81fd04e26b4f1c695586ac8106ac48a35466d66"
