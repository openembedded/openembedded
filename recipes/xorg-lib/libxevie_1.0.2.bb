require xorg-lib-common.inc

DESCRIPTION = "X11 EvIE extension library"
DEPENDS += "libxext evieext"
PR = "r1"
PE = "1"

XORG_PN = "libXevie"

SRC_URI[archive.md5sum] = "88e9bf535364e7c821ef4014fb1ca2dd"
SRC_URI[archive.sha256sum] = "ff70b81ad145932db2d206735cefcb698dadad241001df7ba6b97e8081d174da"
