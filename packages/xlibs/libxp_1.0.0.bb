DESCRIPTION = "X print extension library."
SECTION = "libs"
#MAINTAINER = ""
LICENSE = "MIT"

DEPENDS = "libx11 libxext xextproto libxau printproto"

XORG_PN = "libXp"

include xorg-xlibs.inc

CFLAGS_append += " -I ${S}/include/X11/XprintUtil -I ${S}/include/X11/extensions"
EXTRA_OECONF="--enable-malloc0returnsnull"
