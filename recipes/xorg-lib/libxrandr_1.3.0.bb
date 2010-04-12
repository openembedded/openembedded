require xorg-lib-common.inc

DESCRIPTION = "X11 Resize and Rotate extension library"
LICENSE = "BSD-X"
DEPENDS += "randrproto libxrender libxext"
PR = "r0"
PE = "1"

XORG_PN = "libXrandr"

SRC_URI[archive.md5sum] = "68eb59c3b7524db6ffd78746ee893d1d"
SRC_URI[archive.sha256sum] = "5961ce0f77c5173a8208b3ed669ac01719f2bf4a10517ffa6c33a5e064802e78"
