require xorg-lib-common.inc

DESCRIPTION = "X11 Session management library"
PR = "r0"
DEPENDS += "libice xproto xtrans util-linux-ng"
PE = "1"

XORG_PN = "libSM"
