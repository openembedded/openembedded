include xorg-lib-common.inc

DESCRIPTION = "X font library (used by the X server)."
LICENSE= "BSD-X"
PRIORITY = "optional"

SRC_URI = "${XORG_MIRROR}/individual/lib/libXfont-1.2.0.tar.bz2"

DEPENDS += " freetype fontcacheproto zlib xproto xtrans fontsproto libfontenc"
PROVIDES = "xfont"

XORG_PN = "libXfont"

S = "${WORKDIR}/libXfont-1.2.0"
