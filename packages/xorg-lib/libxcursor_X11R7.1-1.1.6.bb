include xorg-lib-common.inc

DESCRIPTION = "X Cursor library"
LICENSE= "BSD-X"

DEPENDS += " libxrender libxfixes virtual/x11 fixesproto"

XORG_PN = "libXcursor"

FILES_${PN} += "${libdir}/libXcursor.so"
