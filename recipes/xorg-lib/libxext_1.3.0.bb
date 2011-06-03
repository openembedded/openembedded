require xorg-lib-common.inc
DESCRIPTION = "X11 miscellaneous extension library"
DEPENDS += "xproto virtual/libx11 xextproto libxau"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "161d200b690ace818db1cc7537e70ba9"
SRC_URI[archive.sha256sum] = "e9daeb400855b9836e328500cec356b2769033174fc1b2be0df4a80f031debc0"

BBCLASSEXTEND = "native nativesdk"

XORG_PN = "libXext"
