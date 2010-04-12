require xorg-lib-common.inc

DESCRIPTION = "X11 Font Services library"
DEPENDS += "xproto fontsproto xtrans"
PR = "r1"
PE = "1"

XORG_PN = "libFS"

SRC_URI[archive.md5sum] = "dfd5de47e232db0891410bec8ee6707b"
SRC_URI[archive.sha256sum] = "2f18f9fa0e18a3eab3c154ba820ad64b5c6ee364e147524055a553a130ccfdde"
