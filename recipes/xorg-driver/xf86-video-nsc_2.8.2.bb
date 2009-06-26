require xorg-driver-video.inc
PE = "1"

DEPENDS += " xf86dgaproto"

# This driver is broken because it's seldom updated. It compiles
# but fails to communicate with the card without this deprecated define.
EXTRA_OEMAKE += "CFLAGS+=-DXFree86Server"
