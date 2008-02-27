require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- NSC display driver"
DEPENDS += " xf86dgaproto"
PE = "1"

# This driver is broken because it's seldom updated. It compiles
# but fails to communicate with the card without this deprecated define.
EXTRA_OEMAKE += "CFLAGS+=-DXFree86Server"
