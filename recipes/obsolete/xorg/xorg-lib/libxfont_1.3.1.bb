require xorg-lib-common.inc
DESCRIPTION = "X11 font rasterisation library"
LICENSE = "BSD-X"
DEPENDS += "freetype fontcacheproto xtrans fontsproto libfontenc"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://no-scalable-crash.patch"
SRC_URI[archive.md5sum] = "b2f396b62633819bbdd9748383876e21"
SRC_URI[archive.sha256sum] = "dcfb7dc980a16ad98ac984b98321148864ea8b4637d3dd3773e483a14158a9b1"

BBCLASSEXTEND = "native"

XORG_PN = "libXfont"
