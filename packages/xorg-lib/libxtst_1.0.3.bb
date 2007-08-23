require xorg-lib-common.inc

DESCRIPTION = "X Test Extension: client side library"
DEPENDS += "libxext recordproto inputproto"
PROVIDES = "xtst"
PR = "r0"
PE = "1"

XORG_PN = "libXtst"
