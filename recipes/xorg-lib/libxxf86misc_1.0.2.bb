require xorg-lib-common.inc
DESCRIPTION = "X11 XFree86 miscellaneous extension library"
DEPENDS += "libxext xf86miscproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "51fed53e8de067d4b8666f75a0212400"
SRC_URI[archive.sha256sum] = "8e64b6b1bf34fcd112b1fd866d77e110b47794e825a996e4492c0ee408957cb3"

XORG_PN = "libXxf86misc"
