require xorg-driver-video.inc
PE = "1"

DEPENDS += " xf86dgaproto"

# This driver is broken because it's seldom updated. It compiles
# but fails to communicate with the card without this deprecated define.
EXTRA_OEMAKE += "CFLAGS+=-DXFree86Server"
SRC_URI[archive.md5sum] = "1fbdd5e9b5508b032c0102f72d1e555c"
SRC_URI[archive.sha256sum] = "060493a9dcad81e8912381d2a8d14a3e32a34414296a089756868f3442103c8c"
