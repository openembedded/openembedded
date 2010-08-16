require xorg-lib-common.inc
DESCRIPTION = "X Test Extension: client side library"
DEPENDS += "libxext recordproto inputproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "032d5c1d3914fc0224837328c88aef96"
SRC_URI[archive.sha256sum] = "eef98ad3d35254384c3714cd63826fc2009f9b394f2b489718aba9be7be0a10b"

XORG_PN = "libXtst"
