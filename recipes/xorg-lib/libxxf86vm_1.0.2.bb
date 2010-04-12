require xorg-lib-common.inc

DESCRIPTION = "X11 XFree86 video mode extension library"
DEPENDS += "libxext xf86vidmodeproto"
PR = "r0"
PE = "1"

XORG_PN = "libXxf86vm"

SRC_URI[archive.md5sum] = "304d37bd0a10d9b58aa9b64469ad73e5"
SRC_URI[archive.sha256sum] = "3cb3c3c6552a4fbc686ba6c2dbeb6e4ba2a27103279908831d56363de73951de"
