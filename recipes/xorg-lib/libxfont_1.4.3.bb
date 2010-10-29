require xorg-lib-common.inc
DESCRIPTION = "X11 font rasterisation library"
LICENSE = "BSD-X"
DEPENDS += "freetype fontcacheproto xtrans fontsproto libfontenc"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "6fb689cfe13d8d9460f4abb5bd88588d"
SRC_URI[archive.sha256sum] = "f79245652901d20092092e942155d32b8dde15527637db3c09a1adc83672e9cc"

# disable docs
EXTRA_OECONF += " --disable-devel-docs "

BBCLASSEXTEND = "native"

XORG_PN = "libXfont"
