require xorg-lib-common.inc

SRC_URI += "file://mkg3states-1.0.0.patch;patch=0"

DESCRIPTION = "XFIXES Extension"

DEPENDS += " xextproto xproto zlib"
PROVIDES = "lbxutil"
