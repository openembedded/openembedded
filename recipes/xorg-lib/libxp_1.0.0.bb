require xorg-lib-common.inc
DESCRIPTION = "X Printing Extension (Xprint) client library"
DEPENDS += "libxext libxau printproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "0f4ac39108c1ae8c443cdfac259b58fa"
SRC_URI[archive.sha256sum] = "7e64b1550ce85b05762e960459ac676a0406c786756b200ff29c57f84bce9cae"

CFLAGS_append += " -I ${S}/include/X11/XprintUtil -I ${S}/include/X11/extensions"

XORG_PN = "libXp"
