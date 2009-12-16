require xorg-lib-common.inc

DESCRIPTION = "XFIXES Extension"
DEPENDS += " xextproto xproto zlib"
PROVIDES = "lbxutil"
PE = "1"

SRC_URI += "file://mkg3states-1.1.patch;patch=1"

export CC_FOR_BUILD = "gcc"
