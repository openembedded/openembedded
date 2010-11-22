require xorg-lib-common.inc
DESCRIPTION = "X11 XFree86 miscellaneous extension library"
DEPENDS += "libxext xf86miscproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "6bc0bf78909fd71021c466c793d4385c"
SRC_URI[archive.sha256sum] = "563f4200862efd3334c33a669e0a0aae5bab31f3998db75b87a99a697cc26b5b"

XORG_PN = "libXxf86misc"
