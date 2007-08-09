DESCRIPTION = "Yet another X Wallpaper Utility"
DEPENDS += "imlib2 freetype zlib virtual/libx11 libxext"
RDEPENDS += "imlib2-loaders"
LICENSE = "GPL"

SRC_URI = "http://thegraveyard.org/files/hsetroot-${PV}.tar.gz \
           file://pkgconfigize-imlib.patch;patch=1"

inherit autotools

