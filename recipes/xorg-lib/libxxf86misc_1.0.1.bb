require xorg-lib-common.inc

DESCRIPTION = "X11 XFree86 miscellaneous extension library"
DEPENDS += "libxext xf86miscproto"
PROVIDES = "xxf86misc"
PR = "r1"
PE = "1"

XORG_PN = "libXxf86misc"

SRC_URI[archive.md5sum] = "7cee0df63903cef7f7a3fb68cdd99eef"
SRC_URI[archive.sha256sum] = "2122d67d49aaa06eeaeb3db173ea8a7048f3b52665e5135874bc5cadada91289"
