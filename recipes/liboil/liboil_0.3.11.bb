DESCRIPTION = "Liboil is a library of simple functions that are optimized for various CPUs."
HOMEPAGE = "http://liboil.freedesktop.org/"
LICENSE = "liboil"
PR ="r3"

DEPENDS = "glib-2.0"

SRC_URI = "http://liboil.freedesktop.org/download/${P}.tar.gz \
           file://ppc-detect-fpu.patch"

inherit autotools pkgconfig

SRC_URI[md5sum] = "65ce3266be385d0c7cd9a1157433332f"
SRC_URI[sha256sum] = "deb6530d40ecad2b849d68912500e6d03bab4ac63de7a97340d05af1d7cf0ad4"
