require xorg-lib-common.inc

DESCRIPTION = "X11 Xinerama extension library"
DEPENDS += "libxext xineramaproto"
PROVIDES = "xinerama"
PR = "r3"
PE = "1"

XORG_PN = "libXinerama"

SRC_URI[archive.md5sum] = "cd9f7c46439ac40e0517a302d2434d2c"
SRC_URI[archive.sha256sum] = "07b3564cd56154c20580b56230b7a95d74fe6582c80cedf0550d8d7955181219"
