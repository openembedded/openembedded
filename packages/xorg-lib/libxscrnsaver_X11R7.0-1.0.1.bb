DESCRIPTION = "X screen saver extension library."
SECTION = "libs"
#MAINTAINER = ""
LICENSE = "GPL"

DEPENDS = "libx11 libxext xextproto scrnsaverproto"
PROVIDES = "libxss"
RREPLACES = "libxss"

XORG_PN = "libXScrnSaver"

include xorg-xlibs.inc

#CFLAGS_append += " -I ${S}/include/X11/XprintUtil -I ${S}/include/X11/extensions"
EXTRA_OECONF="--enable-malloc0returnsnull"
