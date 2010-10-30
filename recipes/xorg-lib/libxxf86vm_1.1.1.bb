require xorg-lib-common.inc
DESCRIPTION = "X11 XFree86 video mode extension library"
DEPENDS += "libxext xf86vidmodeproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "34dc3df888c164378da89a7deeb245a0"
SRC_URI[archive.sha256sum] = "21cae9239aefd59353a4ddb0d6ed890402b681570ccd4bc977d80a75a020239e"

XORG_PN = "libXxf86vm"
