require xorg-lib-common.inc

DESCRIPTION = "X11 font rasterisation library"
LICENSE= "BSD-X"
DEPENDS += "freetype fontcacheproto xtrans fontsproto libfontenc"
PROVIDES = "xfont"
PE = "1"

#SRC_URI += "file://no-scalable-crash.patch;patch=1"

# disable docs
EXTRA_OECONF += " --disable-devel-docs "

XORG_PN = "libXfont"

SRC_URI[archive.md5sum] = "4f2bed2a2be82e90a51a24bb3a22cdf0"
SRC_URI[archive.sha256sum] = "112bfc30820b98deec4c9914536c5aa2f8b5162bd2b0bdb342343168e06f7679"
