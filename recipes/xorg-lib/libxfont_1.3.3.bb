require xorg-lib-common.inc
DESCRIPTION = "X11 font rasterisation library"
LICENSE = "BSD-X"
DEPENDS += "freetype fontcacheproto xtrans fontsproto libfontenc"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "4f174b9613f87cf00d731da428a1b194"
SRC_URI[archive.sha256sum] = "6171e6bca4bd6333611bd9c63cccc8e8e412d876c72097f0dddc490a9df51d5a"

BBCLASSEXTEND = "native"

XORG_PN = "libXfont"
