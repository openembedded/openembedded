require xorg-lib-common.inc

DESCRIPTION = "X11 Input extension library"
DEPENDS += "libxext inputproto"
PR = "r1"
PE = "1"

XORG_PN = "libXi"

SRC_URI[archive.md5sum] = "8df4ece9bd1efb02c28acb2b6f485e09"
SRC_URI[archive.sha256sum] = "362b8c0c60386841063bd7e01afa72e37eb87ada6e64e539d960f88c780a944b"
