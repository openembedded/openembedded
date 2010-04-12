require xorg-lib-common.inc

DESCRIPTION = "X11 font rasterisation library"
LICENSE= "BSD-X"
DEPENDS += "freetype fontcacheproto xtrans fontsproto libfontenc"
PROVIDES = "xfont"
PR = "r2"
PE = "1"

SRC_URI += "file://no-scalable-crash.patch;patch=1 \
            file://builtinreaddirectory-no-side-effect.patch;patch=1"

XORG_PN = "libXfont"

SRC_URI[archive.md5sum] = "d1d3fa170d74b066f1f23ca8574e7c90"
SRC_URI[archive.sha256sum] = "07567b9880f28d1a404389c024a185419bfe81136aef3d9eda52407f34c3d3dd"
