include xorg-lib-common.inc

DESCRIPTION = "X11 lbxkbui library"
LICENSE= "GPL"
PRIORITY = "optional"

DEPENDS += " virtual/x11 libxt libxkbfile"
PROVIDES = "xkbui"
