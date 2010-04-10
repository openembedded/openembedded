DESCRIPTION = "Yet another X Wallpaper Utility"
DEPENDS += "imlib2 freetype zlib virtual/libx11 libxext"
RDEPENDS += "imlib2-loaders"
LICENSE = "GPL"

SRC_URI = "http://thegraveyard.org/files/hsetroot-${PV}.tar.gz \
           file://pkgconfigize-imlib.patch;patch=1"

inherit autotools


SRC_URI[md5sum] = "f599770a6411dcfe216c37b280fad9bc"
SRC_URI[sha256sum] = "d6712d330b31122c077bfc712ec4e213abe1fe71ab24b9150ae2774ca3154fd7"
