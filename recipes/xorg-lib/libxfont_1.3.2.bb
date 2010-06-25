require xorg-lib-common.inc
DESCRIPTION = "X11 font rasterisation library"
LICENSE = "BSD-X"
DEPENDS += "freetype fontcacheproto xtrans fontsproto libfontenc"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://no-scalable-crash.patch"
SRC_URI[archive.md5sum] = "64f510ebf9679f3a97a3d633cbee4f50"
SRC_URI[archive.sha256sum] = "c167cfd529b7c67f496ee0bed3c0b43e0107de0f689d387c1c0e23ef7cf3d2f2"

BBCLASSEXTEND = "native"

XORG_PN = "libXfont"
