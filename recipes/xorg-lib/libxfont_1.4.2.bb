require xorg-lib-common.inc
DESCRIPTION = "X11 font rasterisation library"
LICENSE = "BSD-X"
DEPENDS += "freetype fontcacheproto xtrans fontsproto libfontenc"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "503911759734998f9235b926eed82eb8"
SRC_URI[archive.sha256sum] = "d05f5a8599cbfd29f683768b037a5a4b8c9065578e6ac4d6323e89ef604e495b"

# disable docs
EXTRA_OECONF += " --disable-devel-docs "

BBCLASSEXTEND = "native"

XORG_PN = "libXfont"
