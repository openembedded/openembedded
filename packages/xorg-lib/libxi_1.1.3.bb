require xorg-lib-common.inc

DESCRIPTION = "X11 Input extension library"
DEPENDS += "libxext inputproto"
FILE_PR = "r1"
PE = "1"

XORG_PN = "libXi"
