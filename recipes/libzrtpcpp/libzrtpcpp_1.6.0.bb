DESCRIPTION = "GNU ZRTP C++"
HOMEPAGE = "http://www.gnutelephony.org/index.php/GNU_ZRTP"
LICENSE = "GPL"
DEPENDS = "ccrtp libgcrypt libgpg-error"

SRC_URI = "http://www.gnutelephony.org/dist/tarballs/libzrtpcpp-${PV}.tar.gz \
           file://fix-configure.patch"
SRC_URI[md5sum] = "6cec342f79ad5ec9497b26945c527b70"
SRC_URI[sha256sum] = "6b1ea1ed3413c0b4f0f5870632e69ca6e079ba34b6db58b723371fe148f64a9d"

inherit pkgconfig autotools
