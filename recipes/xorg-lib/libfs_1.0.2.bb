require xorg-lib-common.inc

DESCRIPTION = "X11 Font Services library"
DEPENDS += "xproto fontsproto xtrans"
PE = "1"

XORG_PN = "libFS"

SRC_URI[archive.md5sum] = "ecf2d6a27da053500283e803efa2a808"
SRC_URI[archive.sha256sum] = "af2a5fe5eaa2b026e10bddb4e3f39976dc13deb5dbdc714abe1f016435ce3049"
