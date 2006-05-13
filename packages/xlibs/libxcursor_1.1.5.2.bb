DESCRIPTION = "X Cursor library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE= "BSD-X"

DEPENDS = "libxfixes"

XORG_PN = "libXcursor"

include xorg-xlibs.inc

FILES_${PN} += "${libdir}/libXcursor.so"
