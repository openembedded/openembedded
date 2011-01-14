DESCRIPTION = "GNU ZRTP C++"
HOMEPAGE = "http://www.gnutelephony.org/index.php/GNU_ZRTP"
LICENSE = "GPL"
DEPENDS = "ccrtp libgcrypt libgpg-error"

SRC_URI = "http://www.gnutelephony.org/dist/tarballs/libzrtpcpp-${PV}.tar.gz \
           file://fix-autotools-foo.patch"
SRC_URI[md5sum] = "48ab943615491fc45b886af3172b6d9d"
SRC_URI[sha256sum] = "a1d0ac304ae09f5ed55684721e11fdfd45b505d65b879aa730803310aa0ad3bb"

inherit pkgconfig autotools
