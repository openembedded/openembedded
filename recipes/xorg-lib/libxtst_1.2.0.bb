require xorg-lib-common.inc
DESCRIPTION = "X Test Extension: client side library"
DEPENDS += "libxext recordproto inputproto libxi"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "7c592c72da6676f8b0aeec9133b81686"
SRC_URI[archive.sha256sum] = "7a2e0912b521f6bd8c392189874ba4a3b8168b0bba4c2143e073de53d8e85408"

XORG_PN = "libXtst"
