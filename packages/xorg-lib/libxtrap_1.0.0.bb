require xorg-lib-common.inc

DESCRIPTION = "X11 event trapping extension library"
DEPENDS += "libxt trapproto libxext"
FILE_PR = "r1"
PE = "1"

XORG_PN = "libXTrap"
