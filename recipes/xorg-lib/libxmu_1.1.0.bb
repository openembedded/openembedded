require xorg-lib-common.inc
DESCRIPTION = "X11 miscellaneous utility library"
DEPENDS += "libxt libxext"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "6836883a0120e8346cf7f58dc42e465a"
SRC_URI[archive.sha256sum] = "0fa91f303b70decc1ef6201c88c8a5f0b4ecd68c6c88bdcc891ecd1a689d36ad"

PACKAGES =+ "libxmuu libxmuu-dev"

FILES_libxmuu = "${libdir}/libXmuu.so.*"
FILES_libxmuu-dev = "${libdir}/libXmuu.so"

LEAD_SONAME = "libXmu"

XORG_PN = "libXmu"
