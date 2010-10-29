require xorg-lib-common.inc
DESCRIPTION = "X11 Font Services library"
DEPENDS += "xproto fontsproto xtrans"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "8e68a3a6f3cac936042b240b20d1fb7d"
SRC_URI[archive.sha256sum] = "ab7af9754568af60b54be67c0966cb742ad7eb7ff73faa2c76e0b71c988f2419"

XORG_PN = "libFS"
