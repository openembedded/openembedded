require xorg-lib-common.inc

DESCRIPTION = "X11 Direct Graphics Access extension library"
DEPENDS += "libxext xf86dgaproto"
FILE_PR = "r1"
PE = "1"

XORG_PN = "libXxf86dga"
