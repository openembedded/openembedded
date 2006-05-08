DESCRIPTION = "X Window System miscellaneous utility library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "MIT"

DEPENDS = "libxt libxext util-macros"
PROVIDES = "xmu"

XORG_PN = "libXmu"

include xorg-xlibs.inc

PACKAGES =+ "libxmuu libxmuu-dev"

FILES_libxmuu = "${libdir}/libXmuu.so.*"
FILES_libxmuu-dev = "${libdir}/libXmuu.so"

LEAD_SONAME = "libXmu"
