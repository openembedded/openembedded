require xorg-lib-common.inc
DESCRIPTION = "X11 font rasterisation library"
LICENSE = "BSD-X"
DEPENDS += "freetype fontcacheproto xtrans fontsproto libfontenc"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "4f2bed2a2be82e90a51a24bb3a22cdf0"
SRC_URI[archive.sha256sum] = "112bfc30820b98deec4c9914536c5aa2f8b5162bd2b0bdb342343168e06f7679"

# disable docs
EXTRA_OECONF += " --disable-devel-docs "

BBCLASSEXTEND = "native"

XORG_PN = "libXfont"
