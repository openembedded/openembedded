require xorg-lib-common.inc

DESCRIPTION = "X11 XFree86 video mode extension library"
DEPENDS += "libxext xf86vidmodeproto"
PR = "r0"
PE = "1"

XORG_PN = "libXxf86vm"

SRC_URI[archive.md5sum] = "b431ad7084e1055fef99a9115237edd8"
SRC_URI[archive.sha256sum] = "7cc5e577b337c5267f4e65741f27229111ada8cb833e24b47713a683e8838de8"
