require xorg-lib-common.inc
DESCRIPTION = "X11 Resize and Rotate extension library"
LICENSE = "BSD-X"
DEPENDS += "randrproto libxrender libxext"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "7785c3f7cff2735c94657e8f87ed8ad3"
SRC_URI[archive.sha256sum] = "62bba708649c04cbbc2f5de910942a01cc727b27225bc06169af8a89b957c661"

BBCLASSEXTEND = "nativesdk"

XORG_PN = "libXrandr"
