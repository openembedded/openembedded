require xorg-lib-common.inc

DESCRIPTION = "X11 XFree86 video mode extension library"
DEPENDS += "libxext xf86vidmodeproto"
PR = "r1"
PE = "1"

XORG_PN = "libXxf86vm"

SRC_URI[archive.md5sum] = "8de1ca6c55aaad7d8cae19b4f0b3da32"
SRC_URI[archive.sha256sum] = "e08fc2c1611c422f751ed02810491b45bf7faa4207d762a11f11815263c9285a"
