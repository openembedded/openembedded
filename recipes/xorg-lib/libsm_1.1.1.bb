require xorg-lib-common.inc

DESCRIPTION = "X11 Session management library"
PR = "r0"
DEPENDS += "libice xproto xtrans util-linux-ng"
PE = "1"

XORG_PN = "libSM"

SRC_URI[archive.md5sum] = "6889a455496aaaa65b1fa05fc518d179"
SRC_URI[archive.sha256sum] = "f50d184d8c6a031b3ff4f0d52efcfd4ffa811b0362b166a9ff9ba4c2e9aa7ce0"
