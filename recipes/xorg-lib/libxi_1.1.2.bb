require xorg-lib-common.inc

DESCRIPTION = "X11 Input extension library"
DEPENDS += "libxext inputproto"
PR = "r1"
PE = "1"

XORG_PN = "libXi"

SRC_URI[archive.md5sum] = "9c4dd85f3e2a75bfb60bd288502bc288"
SRC_URI[archive.sha256sum] = "4deda13613f03e4524d3cf0ac14b9e20be5044d415cb8478713ecbe47f4de862"
