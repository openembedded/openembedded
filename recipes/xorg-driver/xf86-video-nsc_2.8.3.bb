require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- NSC display driver"
DEPENDS += " xf86dgaproto"
PE = "1"

# This driver is broken because it's seldom updated. It compiles
# but fails to communicate with the card without this deprecated define.
EXTRA_OEMAKE += "CFLAGS+=-DXFree86Server"
SRC_URI[archive.md5sum] = "f3ffacdc9f19e00b66bdff71b6df9b4e"
SRC_URI[archive.sha256sum] = "e5c5a2021877b8975bee39c06096316324e04f1eac5261bc882b96353a8b1839"
