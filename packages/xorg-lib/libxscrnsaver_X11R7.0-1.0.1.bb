include xorg-lib-common.inc

DESCRIPTION = "X screen saver extension library."
LICENSE = "GPL"

DEPENDS += " virtual/x11 libxext xextproto scrnsaverproto"

XORG_PN = "libXScrnSaver"

PROVIDES = "libxss"
RREPLACES = "libxss"

#CFLAGS_append += " -I ${S}/include/X11/XprintUtil -I ${S}/include/X11/extensions"
