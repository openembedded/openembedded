require xorg-lib-common.inc

DESCRIPTION = "X Printing Extension (Xprint) client library"
DEPENDS += "libxext libxau printproto"
PR = "r1"
PE = "1"

XORG_PN = "libXp"

CFLAGS_append += " -I ${S}/include/X11/XprintUtil -I ${S}/include/X11/extensions"

SRC_URI[archive.md5sum] = "0f4ac39108c1ae8c443cdfac259b58fa"
SRC_URI[archive.sha256sum] = "7e64b1550ce85b05762e960459ac676a0406c786756b200ff29c57f84bce9cae"
