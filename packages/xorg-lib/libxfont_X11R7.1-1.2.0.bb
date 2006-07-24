DESCRIPTION = "X font library (used by the X server)."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "BSD-X"

DEPENDS = "xproto xtrans zlib libfontenc fontcacheproto fontsproto freetype"
PROVIDES = "xfont"

XORG_PN = "libXfont"

include xorg-xlibs.inc

SRC_URI = "${XORG_MIRROR}/individual/lib/libXfont-1.2.0.tar.bz2"
S = "${WORKDIR}/${XORG_PN}-1.2.0"
