DESCRIPTION = "X font library (used by the X server)."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "BSD-X"

DEPENDS = "xproto xtrans zlib libfontenc fontcacheproto fontsproto freetype"
PROVIDES = "xfont"

XORG_RELEASE = "X11R7.1"
XORG_PN = "libXfont"

include xorg-xlibs.inc
