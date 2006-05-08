DESCRIPTION = "X Damage extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE= "BSD-X"

DEPENDS = "libx11 damageproto libxfixes xproto"
PROVIDES = "xdamage"

XORG_PN = "libXdamage"

include xorg-xlibs.inc
