require xorg-lib-common.inc

DESCRIPTION = "X11 font rasterisation library"
LICENSE= "BSD-X"
DEPENDS += "freetype fontcacheproto xtrans fontsproto libfontenc"
PROVIDES = "xfont"
PE = "1"

#SRC_URI += "file://no-scalable-crash.patch;patch=1"

XORG_PN = "libXfont"

SRC_URI[archive.md5sum] = "4f174b9613f87cf00d731da428a1b194"
SRC_URI[archive.sha256sum] = "6171e6bca4bd6333611bd9c63cccc8e8e412d876c72097f0dddc490a9df51d5a"
