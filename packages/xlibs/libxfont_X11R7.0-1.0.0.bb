DESCRIPTION = "X font library (used by the X server)."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "BSD-X"

DEPENDS = "xproto xtrans zlib fontcacheproto fontsproto libfontenc freetype"
PROVIDES = "xfont"

XORG_PN = "libXfont"

include xorg-xlibs.inc
