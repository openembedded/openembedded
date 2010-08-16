require xorg-lib-common.inc
DESCRIPTION = "X11 miscellaneous extension library"
DEPENDS += "xproto virtual/libx11 xextproto libxau libxdmcp"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "aa11d859cc8e9a0bad3bb55e1666547b"
SRC_URI[archive.sha256sum] = "1280af98466cb4484a89858ede3347ba9d7785baeb80b11f2066142dc2317d97"

BBCLASSEXTEND = "native nativesdk"

XORG_PN = "libXext"
