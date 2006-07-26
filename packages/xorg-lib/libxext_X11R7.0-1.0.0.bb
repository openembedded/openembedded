include xorg-lib-common.inc

DESCRIPTION = "X Server Extension library"
PRIORITY = "optional"

DEPENDS += " xproto virtual/x11 xextproto libxau"
PROVIDES = "xext"

XORG_PN = "libXext"

