require xorg-lib-common.inc

DESCRIPTION = "X11 Resource extension library"
DEPENDS += "libxext resourceproto"
FILE_PR = "r1"
PE = "1"

XORG_PN = "libXres"
