require xorg-lib-common.inc
DESCRIPTION = "X Display Manager Control Protocol library"
DEPENDS += "xproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "762b6bbaff7b7d0831ddb4f072f939a5"
SRC_URI[archive.sha256sum] = "b8a0e9a3192a3afddb56eb1d7adf933e423b401b2a492975d776dc0423c10072"

BBCLASSEXTEND = "native nativesdk"

XORG_PN = "libXdmcp"
